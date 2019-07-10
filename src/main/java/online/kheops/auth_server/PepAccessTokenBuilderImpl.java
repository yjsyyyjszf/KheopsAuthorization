package online.kheops.auth_server;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import org.ietf.jgss.GSSException;
import org.ietf.jgss.Oid;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PepAccessTokenBuilderImpl extends PepAccessTokenBuilder {

    private static final String STUDY_UID = "study_uid";
    private static final String SERIES_UID = "series_uid";
    private static final String SERIES_ALL_ACCESS = "all_access";
    private static final String SUBJECT = "sub";
    private static final String ACTING_PARTY = "act";

    private Map<String, String> claims;
    private Algorithm algorithm;
    private long expiresIn;

    PepAccessTokenBuilderImpl(String secret) {
        claims = new HashMap<>();
        try {
            algorithm = Algorithm.HMAC256(secret);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Bad secret", e);
        }
    }

    @Override
    public PepAccessTokenBuilder withExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    @Override
    public PepAccessTokenBuilder withStudyUID(String studyUID) {
        validateUID(studyUID);
        claims.put(STUDY_UID, studyUID);
        return this;
    }

    @Override
    public PepAccessTokenBuilder withSeriesUID(String seriesUID) {
        validateUID(seriesUID);
        claims.put(SERIES_UID, seriesUID);
        return this;
    }

    @Override
    public PepAccessTokenBuilder withAllSeries() {
        claims.put(SERIES_UID, SERIES_ALL_ACCESS);
        return this;
    }

    @Override
    public PepAccessTokenBuilder withSubject(String subject) {
        claims.put(SUBJECT, subject);
        return this;
    }

    @Override
    public PepAccessTokenBuilder withActingParty(String actingParty) {
        if (actingParty == null) {
            claims.remove(ACTING_PARTY);
        } else {
            claims.put(ACTING_PARTY, actingParty);
        }
        return this;
    }

    @Override
    public String build() {
        if (!claims.containsKey(STUDY_UID)) {
            throw new IllegalStateException("Missing StudyUID");
        }
        if (!claims.containsKey(SERIES_UID)) {
            throw new IllegalStateException("Missing seriesUID");
        }
        if (!claims.containsKey(SUBJECT)) {
            throw new IllegalStateException("Missing Subject");
        }

        JWTCreator.Builder jwtBuilder = JWT.create().withIssuer("auth.kheops.online")
                .withAudience("dicom.kheops.online")
                .withClaim(STUDY_UID, claims.get(STUDY_UID))
                .withClaim(SERIES_UID, claims.get(SERIES_UID))
                .withSubject(claims.get(SUBJECT))
                .withExpiresAt(Date.from(Instant.now().plus(expiresIn != 0 ? expiresIn : 300, ChronoUnit.SECONDS)))
                .withNotBefore(new Date());

        if (claims.get(ACTING_PARTY) != null) {
            jwtBuilder.withClaim(ACTING_PARTY, claims.get(ACTING_PARTY));
        }

        return jwtBuilder.sign(algorithm);
    }

    private void validateUID(String uid) {
        try {
            new Oid(uid);
        } catch (GSSException exception) {
            throw new IllegalArgumentException(uid + " is not a valid UID");
        }
    }
}
