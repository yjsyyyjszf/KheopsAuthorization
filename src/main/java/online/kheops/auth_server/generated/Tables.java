/*
 * This file is generated by jOOQ.
 */
package online.kheops.auth_server.generated;


import javax.annotation.Generated;

import online.kheops.auth_server.generated.tables.AlbumSeries;
import online.kheops.auth_server.generated.tables.AlbumUser;
import online.kheops.auth_server.generated.tables.Albums;
import online.kheops.auth_server.generated.tables.Capabilities;
import online.kheops.auth_server.generated.tables.DicomSr;
import online.kheops.auth_server.generated.tables.Events;
import online.kheops.auth_server.generated.tables.Series;
import online.kheops.auth_server.generated.tables.Studies;
import online.kheops.auth_server.generated.tables.Users;
import online.kheops.auth_server.generated.tables.Version;


/**
 * Convenience access to all tables in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.album_series</code>.
     */
    public static final AlbumSeries ALBUM_SERIES = online.kheops.auth_server.generated.tables.AlbumSeries.ALBUM_SERIES;

    /**
     * The table <code>public.album_user</code>.
     */
    public static final AlbumUser ALBUM_USER = online.kheops.auth_server.generated.tables.AlbumUser.ALBUM_USER;

    /**
     * The table <code>public.albums</code>.
     */
    public static final Albums ALBUMS = online.kheops.auth_server.generated.tables.Albums.ALBUMS;

    /**
     * The table <code>public.capabilities</code>.
     */
    public static final Capabilities CAPABILITIES = online.kheops.auth_server.generated.tables.Capabilities.CAPABILITIES;

    /**
     * The table <code>public.dicom_sr</code>.
     */
    public static final DicomSr DICOM_SR = online.kheops.auth_server.generated.tables.DicomSr.DICOM_SR;

    /**
     * The table <code>public.events</code>.
     */
    public static final Events EVENTS = online.kheops.auth_server.generated.tables.Events.EVENTS;

    /**
     * The table <code>public.series</code>.
     */
    public static final Series SERIES = online.kheops.auth_server.generated.tables.Series.SERIES;

    /**
     * The table <code>public.studies</code>.
     */
    public static final Studies STUDIES = online.kheops.auth_server.generated.tables.Studies.STUDIES;

    /**
     * The table <code>public.users</code>.
     */
    public static final Users USERS = online.kheops.auth_server.generated.tables.Users.USERS;

    /**
     * The table <code>public.version</code>.
     */
    public static final Version VERSION = online.kheops.auth_server.generated.tables.Version.VERSION;
}
