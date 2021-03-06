/*
 * This file is generated by jOOQ.
 */
package online.kheops.auth_server.generated.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import online.kheops.auth_server.generated.Indexes;
import online.kheops.auth_server.generated.Keys;
import online.kheops.auth_server.generated.Public;
import online.kheops.auth_server.generated.tables.records.AlbumSeriesRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
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
public class AlbumSeries extends TableImpl<AlbumSeriesRecord> {

    private static final long serialVersionUID = -1015162283;

    /**
     * The reference instance of <code>public.album_series</code>
     */
    public static final AlbumSeries ALBUM_SERIES = new AlbumSeries();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AlbumSeriesRecord> getRecordType() {
        return AlbumSeriesRecord.class;
    }

    /**
     * The column <code>public.album_series.pk</code>.
     */
    public final TableField<AlbumSeriesRecord, Long> PK = createField("pk", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.album_series.album_fk</code>.
     */
    public final TableField<AlbumSeriesRecord, Long> ALBUM_FK = createField("album_fk", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.album_series.series_fk</code>.
     */
    public final TableField<AlbumSeriesRecord, Long> SERIES_FK = createField("series_fk", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.album_series.favorite</code>.
     */
    public final TableField<AlbumSeriesRecord, Boolean> FAVORITE = createField("favorite", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * Create a <code>public.album_series</code> table reference
     */
    public AlbumSeries() {
        this(DSL.name("album_series"), null);
    }

    /**
     * Create an aliased <code>public.album_series</code> table reference
     */
    public AlbumSeries(String alias) {
        this(DSL.name(alias), ALBUM_SERIES);
    }

    /**
     * Create an aliased <code>public.album_series</code> table reference
     */
    public AlbumSeries(Name alias) {
        this(alias, ALBUM_SERIES);
    }

    private AlbumSeries(Name alias, Table<AlbumSeriesRecord> aliased) {
        this(alias, aliased, null);
    }

    private AlbumSeries(Name alias, Table<AlbumSeriesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> AlbumSeries(Table<O> child, ForeignKey<O, AlbumSeriesRecord> key) {
        super(child, key, ALBUM_SERIES);
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
        return Arrays.<Index>asList(Indexes.ALBUM_SERIES_ALBUM_FK_INDEX, Indexes.ALBUM_SERIES_PK, Indexes.ALBUM_SERIES_SERIES_FK_INDEX, Indexes.ALBUM_SERIES_UNIQUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<AlbumSeriesRecord> getPrimaryKey() {
        return Keys.ALBUM_SERIES_PK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<AlbumSeriesRecord>> getKeys() {
        return Arrays.<UniqueKey<AlbumSeriesRecord>>asList(Keys.ALBUM_SERIES_PK, Keys.ALBUM_SERIES_UNIQUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<AlbumSeriesRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<AlbumSeriesRecord, ?>>asList(Keys.ALBUM_SERIES__ALBUM_SERIES_ALBUM_FK_FKEY, Keys.ALBUM_SERIES__ALBUM_SERIES_SERIES_FK_FKEY);
    }

    public Albums albums() {
        return new Albums(this, Keys.ALBUM_SERIES__ALBUM_SERIES_ALBUM_FK_FKEY);
    }

    public Series series() {
        return new Series(this, Keys.ALBUM_SERIES__ALBUM_SERIES_SERIES_FK_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AlbumSeries as(String alias) {
        return new AlbumSeries(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AlbumSeries as(Name alias) {
        return new AlbumSeries(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public AlbumSeries rename(String name) {
        return new AlbumSeries(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public AlbumSeries rename(Name name) {
        return new AlbumSeries(name, null);
    }
}
