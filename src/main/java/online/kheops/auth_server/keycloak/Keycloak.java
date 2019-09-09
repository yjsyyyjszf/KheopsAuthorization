package online.kheops.auth_server.keycloak;

import online.kheops.auth_server.user.CacheUserName;
import online.kheops.auth_server.user.UserNotFoundException;
import online.kheops.auth_server.user.UserResponseBuilder;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.xml.bind.annotation.XmlElement;
import java.io.StringReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Keycloak {

    private static final Client CLIENT = ClientBuilder.newClient();

    private static final String USERS_PATH = "/users";

    private static URI usersUri;

    private static KeycloakToken token;

    private static Keycloak instance = null;

    private static CacheUserName cacheUserName;

    public static class UserRepresentation {
        @XmlElement(name = "email")
        private String email;
        @XmlElement(name = "firstName")
        private String firstName;
        @XmlElement(name = "lastName")
        private String lastName;
        @XmlElement(name = "username")
        private String username;
        @XmlElement(name = "id")
        private String id;

        public String getEmail() {
            return email;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getUsername() {
            return username;
        }

        public String getId() {
            return id;
        }
    }

    private Keycloak() throws KeycloakException{
        usersUri = UriBuilder.fromUri(KeycloakContextListener.getKeycloakAdminURI()).path(USERS_PATH).build();
        token = KeycloakToken.getInstance();
        cacheUserName = CacheUserName.getInstance();
    }

    public static Keycloak getInstance() throws KeycloakException{
        if(instance == null) {
            instance = new Keycloak();
        }
        return instance;
    }

    public UserRepresentation getUserRepresentation(String sub) throws UserNotFoundException, KeycloakException {
        final URI userUri = UriBuilder.fromUri(usersUri).path("/" + sub).build();
        try {
            return CLIENT.target(userUri)
                    .request()
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + token.getToken())
                    .get(UserRepresentation.class);
        } catch (ProcessingException | WebApplicationException e) {
            throw new UserNotFoundException("unable to find the userinfo", e);
        }
    }

    public UserResponseBuilder getUser(String user)
            throws UserNotFoundException, KeycloakException {

        if(user.contains("@")) {
            final Response response;
            final String userLowerCase = user.toLowerCase();
            try {
                response = ClientBuilder.newClient().target(usersUri).queryParam("email", userLowerCase).request().header(HttpHeaders.AUTHORIZATION, "Bearer "+token.getToken()).get();
            } catch (ProcessingException e) {
                throw new KeycloakException("Error during introspect token", e);
            }

            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                String output = response.readEntity(String.class);
                try(JsonReader jsonReader = Json.createReader(new StringReader(output))) {
                    JsonArray reply = jsonReader.readArray();
                    final KeycloakUsers keycloakUsers = new KeycloakUsers(reply);
                    if (keycloakUsers.size() > 0) {
                        final int index = keycloakUsers.verifyEmail(userLowerCase);
                        return new UserResponseBuilder().setEmail(keycloakUsers.getEmail(index)).setSub(keycloakUsers.getId(0));
                    } else {
                        throw new UserNotFoundException();
                    }
                }
            } else {
                throw new KeycloakException("Response status code: " + response.getStatus() + " with this url :" + response.getLocation());
            }
        } else {

            String userEmail = cacheUserName.getCachedValue(user);
            if (userEmail != null) {
                return new UserResponseBuilder().setEmail(userEmail).setSub(user);
            }

            final URI userUri = UriBuilder.fromUri(usersUri).path("/" + user).build();
            final Response response;
            try {
                String tokenString = token.getToken();
                Invocation.Builder builder = ClientBuilder.newClient().target(userUri).request().header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenString);
                response = builder.get();
            } catch (ProcessingException e) {
                throw new KeycloakException("Error during introspect token", e);
            }
            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                String output = response.readEntity(String.class);
                output = "[" + output + "]";
                try (JsonReader jsonReader = Json.createReader(new StringReader(output))) {
                    JsonArray reply = jsonReader.readArray();
                    final KeycloakUsers keycloakUser = new KeycloakUsers(reply);
                    if (keycloakUser.size() == 1) {
                        cacheUserName.cacheValue(keycloakUser.getId(0), keycloakUser.getEmail(0));
                        return new UserResponseBuilder().setEmail(keycloakUser.getEmail(0)).setSub(keycloakUser.getId(0));
                    } else {
                        throw new UserNotFoundException();
                    }
                } catch (Exception e) {
                    throw new KeycloakException("error during parsing response : " + output, e);
                }
            } else if (response.getStatus() == Response.Status.NOT_FOUND.getStatusCode()) {
                throw new UserNotFoundException();
            } else {
                try {
                    String responseString = response.readEntity(String.class);
                    throw new KeycloakException("Unsuccessful response from keycloak server, status:" + response.getStatus() + "\n" + responseString);
                } catch (ProcessingException e) {
                    throw new KeycloakException("Unsuccessful response from keycloak server, status:" + response.getStatus(), e);
                }
            }
        }
    }

    public List<UserResponseBuilder> getUsers(String find, Integer limit, Integer offset)
            throws KeycloakException {


        final Response response;
        final String findLowerCase = find.toLowerCase();
        try {
            response = ClientBuilder.newClient().target(usersUri)
                    .queryParam("email", findLowerCase)
                    .queryParam("first", offset).queryParam("max", limit)
                    .queryParam("briefRepresentation", "true")
                    .request().header(HttpHeaders.AUTHORIZATION, "Bearer "+token.getToken()).get();
        } catch (ProcessingException e) {
            throw new KeycloakException("Error during introspect token", e);
        }

        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            String output = response.readEntity(String.class);
            try(JsonReader jsonReader = Json.createReader(new StringReader(output))) {
                JsonArray reply = jsonReader.readArray();
                List<UserResponseBuilder> userResponseBuilders = new ArrayList<>();
                final KeycloakUsers keycloakUser = new KeycloakUsers(reply);
                for(int i = 0;i < keycloakUser.size(); i++) {
                    if(!keycloakUser.getEmail(i).startsWith("service-account-") && !keycloakUser.getEmail(i).endsWith("@placeholder.org")) {
                        userResponseBuilders.add(new UserResponseBuilder().setEmail(keycloakUser.getEmail(i)).setSub(keycloakUser.getId(i)));
                    }
                }
                return userResponseBuilders;
            }
        }


        throw new KeycloakException("ERROR:");
    }
}

