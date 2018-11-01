/*
 * This file is generated by jOOQ.
 */
package online.kheops.auth_server.generated.tables;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import online.kheops.auth_server.generated.Indexes;
import online.kheops.auth_server.generated.Keys;
import online.kheops.auth_server.generated.Public;
import online.kheops.auth_server.generated.tables.records.CapabilitiesRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Capabilities extends TableImpl<CapabilitiesRecord> {

    private static final long serialVersionUID = 153638598;

    /**
     * The reference instance of <code>public.capabilities</code>
     */
    public static final Capabilities CAPABILITIES = new Capabilities();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CapabilitiesRecord> getRecordType() {
        return CapabilitiesRecord.class;
    }

    /**
     * The column <code>public.capabilities.pk</code>.
     */
    public final TableField<CapabilitiesRecord, Long> PK = createField("pk", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('capabilities_pk_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.capabilities.created_time</code>.
     */
    public final TableField<CapabilitiesRecord, Timestamp> CREATED_TIME = createField("created_time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>public.capabilities.updated_time</code>.
     */
    public final TableField<CapabilitiesRecord, Timestamp> UPDATED_TIME = createField("updated_time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>public.capabilities.expiration_time</code>.
     */
    public final TableField<CapabilitiesRecord, Timestamp> EXPIRATION_TIME = createField("expiration_time", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>public.capabilities.start_time</code>.
     */
    public final TableField<CapabilitiesRecord, Timestamp> START_TIME = createField("start_time", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>public.capabilities.revoked_time</code>.
     */
    public final TableField<CapabilitiesRecord, Timestamp> REVOKED_TIME = createField("revoked_time", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>public.capabilities.title</code>.
     */
    public final TableField<CapabilitiesRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.capabilities.secret</code>.
     */
    public final TableField<CapabilitiesRecord, String> SECRET = createField("secret", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.capabilities.read_permission</code>.
     */
    public final TableField<CapabilitiesRecord, Boolean> READ_PERMISSION = createField("read_permission", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>public.capabilities.write_permission</code>.
     */
    public final TableField<CapabilitiesRecord, Boolean> WRITE_PERMISSION = createField("write_permission", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>public.capabilities.user_fk</code>.
     */
    public final TableField<CapabilitiesRecord, Long> USER_FK = createField("user_fk", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.capabilities.scope_type</code>.
     */
    public final TableField<CapabilitiesRecord, String> SCOPE_TYPE = createField("scope_type", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.capabilities.album_fk</code>.
     */
    public final TableField<CapabilitiesRecord, Long> ALBUM_FK = createField("album_fk", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.capabilities.series_fk</code>.
     */
    public final TableField<CapabilitiesRecord, Long> SERIES_FK = createField("series_fk", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.capabilities.study_fk</code>.
     */
    public final TableField<CapabilitiesRecord, Long> STUDY_FK = createField("study_fk", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * Create a <code>public.capabilities</code> table reference
     */
    public Capabilities() {
        this(DSL.name("capabilities"), null);
    }

    /**
     * Create an aliased <code>public.capabilities</code> table reference
     */
    public Capabilities(String alias) {
        this(DSL.name(alias), CAPABILITIES);
    }

    /**
     * Create an aliased <code>public.capabilities</code> table reference
     */
    public Capabilities(Name alias) {
        this(alias, CAPABILITIES);
    }

    private Capabilities(Name alias, Table<CapabilitiesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Capabilities(Name alias, Table<CapabilitiesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Capabilities(Table<O> child, ForeignKey<O, CapabilitiesRecord> key) {
        super(child, key, CAPABILITIES);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.CAPABILITIES_PK, Indexes.CAPABILITIES_SECRET_INDEX, Indexes.CAPABILITIES_SECRET_UNIQUE, Indexes.CAPABILITIES_USER_FK_INDEX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<CapabilitiesRecord, Long> getIdentity() {
        return Keys.IDENTITY_CAPABILITIES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CapabilitiesRecord> getPrimaryKey() {
        return Keys.CAPABILITIES_PK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CapabilitiesRecord>> getKeys() {
        return Arrays.<UniqueKey<CapabilitiesRecord>>asList(Keys.CAPABILITIES_PK, Keys.CAPABILITIES_SECRET_UNIQUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<CapabilitiesRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<CapabilitiesRecord, ?>>asList(Keys.CAPABILITIES__CAPABILITIES_USER_FK_FKEY, Keys.CAPABILITIES__CAPABILITIES_ALBUM_FK_FKEY, Keys.CAPABILITIES__CAPABILITIES_SERIES_FK_FKEY, Keys.CAPABILITIES__CAPABILITIES_STUDY_FK_FKEY);
    }

    public Users users() {
        return new Users(this, Keys.CAPABILITIES__CAPABILITIES_USER_FK_FKEY);
    }

    public Album album() {
        return new Album(this, Keys.CAPABILITIES__CAPABILITIES_ALBUM_FK_FKEY);
    }

    public Series series() {
        return new Series(this, Keys.CAPABILITIES__CAPABILITIES_SERIES_FK_FKEY);
    }

    public Studies studies() {
        return new Studies(this, Keys.CAPABILITIES__CAPABILITIES_STUDY_FK_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Capabilities as(String alias) {
        return new Capabilities(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Capabilities as(Name alias) {
        return new Capabilities(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Capabilities rename(String name) {
        return new Capabilities(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Capabilities rename(Name name) {
        return new Capabilities(name, null);
    }
}
