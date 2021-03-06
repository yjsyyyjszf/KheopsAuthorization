package online.kheops.auth_server.principal;

import online.kheops.auth_server.EntityManagerListener;
import online.kheops.auth_server.NotAlbumScopeTypeException;
import online.kheops.auth_server.accesstoken.AccessToken.TokenType;
import online.kheops.auth_server.album.UserNotMemberException;
import online.kheops.auth_server.capability.ScopeType;
import online.kheops.auth_server.entity.*;
import online.kheops.auth_server.series.SeriesNotFoundException;
import online.kheops.auth_server.study.StudyNotFoundException;
import online.kheops.auth_server.user.AlbumUserPermissions;
import online.kheops.auth_server.util.ErrorResponse;
import online.kheops.auth_server.util.KheopsLogBuilder;

import javax.persistence.EntityManager;
import java.util.Optional;

import static online.kheops.auth_server.album.Albums.*;
import static online.kheops.auth_server.series.Series.*;
import static online.kheops.auth_server.series.SeriesQueries.isOrphan;
import static online.kheops.auth_server.study.Studies.canAccessStudy;
import static online.kheops.auth_server.study.Studies.getStudy;


public class AlbumCapabilityPrincipal implements KheopsPrincipal, CapabilityPrincipal {
    private final Capability capability;
    private final User user;
    private final String originalToken;
    private final KheopsLogBuilder kheopsLogBuilder;

    private EntityManager em;

    public AlbumCapabilityPrincipal(Capability capability, User user, String originalToken) {
        this.capability = capability;
        this.user = user;
        this.em = EntityManagerListener.createEntityManager();
        this.originalToken = originalToken;

        kheopsLogBuilder = new KheopsLogBuilder()
                .provenance(this)
                .user(user.getSub())
                .albumScope(capability.getAlbum().getId())
                .tokenType(getTokenType());
    }

    @Override
    public String getName() {
        return user.getSub();
    }

    @Override
    public boolean hasUserAccess() { return false; }

    @Override
    public boolean hasSeriesViewAccess(String studyInstanceUID, String seriesInstanceUID) {
        this.em = EntityManagerListener.createEntityManager();
        try {
            if (capability.hasReadPermission()) {
                final AlbumUser albumUser = getAlbumUser(capability.getAlbum(), user, em);
                if (!albumUser.isAdmin()) { //the user who created the token is not longer an admin => normally the token should be removed
                    return false;
                }
                return canAccessSeries(capability.getAlbum(), studyInstanceUID, seriesInstanceUID, em);
            }
        } catch (UserNotMemberException e) {
            return false;
        } finally {
            em.close();
        }
        return false;
    }

    @Override
    public boolean hasStudyViewAccess(String studyInstanceUID) {
        this.em = EntityManagerListener.createEntityManager();
        try {
            final Study study = getStudy(studyInstanceUID, em);
            if (capability.hasReadPermission()) {
                final AlbumUser albumUser = getAlbumUser(capability.getAlbum(), user, em);
                if (!albumUser.isAdmin()) {
                    return false;
                }
                return canAccessStudy(capability.getAlbum(), study, em);
            }
        } catch (StudyNotFoundException | UserNotMemberException e) {
            return false;
        } finally {
            em.close();
        }
        return false;
    }

    @Override
    public boolean hasSeriesDeleteAccess(String studyInstanceUID, String seriesInstanceUID) {
        this.em = EntityManagerListener.createEntityManager();
        try {
            if (capability.hasReadPermission() && capability.hasWritePermission()) {
                final AlbumUser albumUser = getAlbumUser(capability.getAlbum(), user, em);
                if (!albumUser.isAdmin()) { //the user who created the token is not longer an admin => normally the token should be removed
                    return false;
                }
                return canAccessSeries(capability.getAlbum(), studyInstanceUID, seriesInstanceUID, em);
            }
        } catch (UserNotMemberException e) {
            return false;
        } finally {
            em.close();
        }
        return false;
    }

    @Override
    public boolean hasStudyDeleteAccess(String studyInstanceUID) {
        this.em = EntityManagerListener.createEntityManager();
        try {
            final Study study = getStudy(studyInstanceUID, em);
            if (capability.hasReadPermission() && capability.hasWritePermission()) {
                final AlbumUser albumUser = getAlbumUser(capability.getAlbum(), user, em);
                if (!albumUser.isAdmin()) {
                    return false;
                }
                return canAccessStudy(capability.getAlbum(), study, em);
            }
        } catch (StudyNotFoundException | UserNotMemberException e) {
            return false;
        } finally {
            em.close();
        }
        return false;
    }

    @Override
    public boolean hasSeriesShareAccess(String studyInstanceUID, String seriesInstanceUID) {
        this.em = EntityManagerListener.createEntityManager();
        try {
            if (capability.hasAppropriatePermission()) {
                final AlbumUser albumUser = getAlbumUser(capability.getAlbum(), user, em);
                if (!albumUser.isAdmin()) { //the user who created the token is not longer an admin => normally the token should be removed
                    return false;
                }
                return canAccessSeries(capability.getAlbum(), studyInstanceUID, seriesInstanceUID, em);
            }
        } catch (UserNotMemberException e) {
            return false;
        } finally {
            em.close();
        }
        return false;
    }

    @Override
    public boolean hasStudyShareAccess(String studyInstanceUID) {
        this.em = EntityManagerListener.createEntityManager();
        try {
            final Study study = getStudy(studyInstanceUID, em);
            if (capability.hasAppropriatePermission()) {
                final AlbumUser albumUser = getAlbumUser(capability.getAlbum(), user, em);
                if (!albumUser.isAdmin()) {
                    return false;
                }
                return canAccessStudy(capability.getAlbum(), study, em);
            }
        } catch (StudyNotFoundException | UserNotMemberException e) {
            return false;
        } finally {
            em.close();
        }
        return false;
    }

    @Override
    public boolean hasSeriesAddAccess(String studyInstanceUID, String seriesInstanceUID) {
        this.em = EntityManagerListener.createEntityManager();
        final User mergeUser = em.merge(user);
        try {
            Capability mergeCapability = em.merge(capability);

            final AlbumUser albumUser = getAlbumUser(capability.getAlbum(), mergeUser, em);
            if (!albumUser.isAdmin()) {
                return false;//if the creator of the token is no longer the admin of the album
            }
            final Series series;
            try {
                series = getSeries(studyInstanceUID, seriesInstanceUID, em);
            } catch (SeriesNotFoundException e) {
                //here the series not exist
                return capability.hasWritePermission();
            }
            if (isOrphan(series, em)) {
                return capability.hasWritePermission();
            }

            if(mergeCapability.getAlbum().containsSeries(series, em)) {
                return capability.hasWritePermission();
            }
        } catch (UserNotMemberException e) {
            return false;
        } finally {
            em.close();
        }
        return false;
    }

    @Override
    public boolean hasStudyAddAccess(String studyInstanceUID) {
        if (!canAccessStudy(capability.getAlbum(), studyInstanceUID)) {
            return capability.hasWritePermission();
        }
        return capability.hasAppropriatePermission();
    }

    @Override
    public boolean hasAlbumPermission(AlbumUserPermissions usersPermission, String albumId) {

        if (!this.hasAlbumAccess(albumId)) {
            return false;
        }

        this.em = EntityManagerListener.createEntityManager();
        try {
            final Album album = em.merge(capability.getAlbum());

            if (!albumId.equals(album.getId())) {
                return false;
            }

            return usersPermission.hasCapabilityPermission(capability);
        } finally {
            em.close();
        }
    }

    @Override
    public boolean hasAlbumAccess(String albumId) {
            return albumId.equals(capability.getAlbum().getId());
    }

    @Override
    public boolean hasInboxAccess() {
        return false;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public ScopeType getScope() {
        return ScopeType.valueOf(capability.getScopeType().toUpperCase());
    }

    @Override
    public String getAlbumID() throws NotAlbumScopeTypeException {
        if(getScope() == ScopeType.ALBUM) {
            return capability.getAlbum().getId();
        } else {
            final ErrorResponse errorResponse = new ErrorResponse.ErrorResponseBuilder()
                    .message("Error")
                    .detail("this token is not an token with album scope")
                    .build();
            throw new NotAlbumScopeTypeException(errorResponse);
        }
    }

    @Override
    public Optional<String> getCapabilityTokenId() {
        return Optional.of(capability.getId());
    }

    @Override
    public KheopsLogBuilder getKheopsLogBuilder() {
        return kheopsLogBuilder;
    }

    @Override
    public String toString() {
        return "[CapabilityPrincipal user:" + getUser() + " scope:" + getScope() + " hasUserAccess:" + hasUserAccess() + " hasInboxAccess:" + hasInboxAccess() + "]";
    }

    @Override
    public Optional<Capability> getCapability() { return Optional.ofNullable(capability); }

    private boolean linkAuthorization;
    @Override
    public void setLink(boolean linkAuthorization) {
        this.linkAuthorization = linkAuthorization;
    }

    @Override
    public boolean isLink() { return linkAuthorization;  }

    @Override
    public String getOriginalToken() {
        return originalToken;
    }

    private TokenType getTokenType() { return TokenType.ALBUM_CAPABILITY_TOKEN; }
}
