/*
 * This file is generated by jOOQ.
 */
package online.kheops.auth_server.generated.tables.records;


import java.sql.Timestamp;

import javax.annotation.Generated;

import online.kheops.auth_server.generated.tables.Capabilities;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record15;
import org.jooq.Row15;
import org.jooq.impl.UpdatableRecordImpl;


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
public class CapabilitiesRecord extends UpdatableRecordImpl<CapabilitiesRecord> implements Record15<Long, Timestamp, Timestamp, Timestamp, Timestamp, Timestamp, String, String, Boolean, Boolean, Long, String, Long, Long, Long> {

    private static final long serialVersionUID = 1959664;

    /**
     * Setter for <code>public.capabilities.pk</code>.
     */
    public void setPk(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.capabilities.pk</code>.
     */
    public Long getPk() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.capabilities.created_time</code>.
     */
    public void setCreatedTime(Timestamp value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.capabilities.created_time</code>.
     */
    public Timestamp getCreatedTime() {
        return (Timestamp) get(1);
    }

    /**
     * Setter for <code>public.capabilities.updated_time</code>.
     */
    public void setUpdatedTime(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.capabilities.updated_time</code>.
     */
    public Timestamp getUpdatedTime() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>public.capabilities.expiration_time</code>.
     */
    public void setExpirationTime(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.capabilities.expiration_time</code>.
     */
    public Timestamp getExpirationTime() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>public.capabilities.start_time</code>.
     */
    public void setStartTime(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.capabilities.start_time</code>.
     */
    public Timestamp getStartTime() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>public.capabilities.revoked_time</code>.
     */
    public void setRevokedTime(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.capabilities.revoked_time</code>.
     */
    public Timestamp getRevokedTime() {
        return (Timestamp) get(5);
    }

    /**
     * Setter for <code>public.capabilities.title</code>.
     */
    public void setTitle(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.capabilities.title</code>.
     */
    public String getTitle() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.capabilities.secret</code>.
     */
    public void setSecret(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.capabilities.secret</code>.
     */
    public String getSecret() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.capabilities.read_permission</code>.
     */
    public void setReadPermission(Boolean value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.capabilities.read_permission</code>.
     */
    public Boolean getReadPermission() {
        return (Boolean) get(8);
    }

    /**
     * Setter for <code>public.capabilities.write_permission</code>.
     */
    public void setWritePermission(Boolean value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.capabilities.write_permission</code>.
     */
    public Boolean getWritePermission() {
        return (Boolean) get(9);
    }

    /**
     * Setter for <code>public.capabilities.user_fk</code>.
     */
    public void setUserFk(Long value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.capabilities.user_fk</code>.
     */
    public Long getUserFk() {
        return (Long) get(10);
    }

    /**
     * Setter for <code>public.capabilities.scope_type</code>.
     */
    public void setScopeType(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.capabilities.scope_type</code>.
     */
    public String getScopeType() {
        return (String) get(11);
    }

    /**
     * Setter for <code>public.capabilities.album_fk</code>.
     */
    public void setAlbumFk(Long value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.capabilities.album_fk</code>.
     */
    public Long getAlbumFk() {
        return (Long) get(12);
    }

    /**
     * Setter for <code>public.capabilities.series_fk</code>.
     */
    public void setSeriesFk(Long value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.capabilities.series_fk</code>.
     */
    public Long getSeriesFk() {
        return (Long) get(13);
    }

    /**
     * Setter for <code>public.capabilities.study_fk</code>.
     */
    public void setStudyFk(Long value) {
        set(14, value);
    }

    /**
     * Getter for <code>public.capabilities.study_fk</code>.
     */
    public Long getStudyFk() {
        return (Long) get(14);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record15 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row15<Long, Timestamp, Timestamp, Timestamp, Timestamp, Timestamp, String, String, Boolean, Boolean, Long, String, Long, Long, Long> fieldsRow() {
        return (Row15) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row15<Long, Timestamp, Timestamp, Timestamp, Timestamp, Timestamp, String, String, Boolean, Boolean, Long, String, Long, Long, Long> valuesRow() {
        return (Row15) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Capabilities.CAPABILITIES.PK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field2() {
        return Capabilities.CAPABILITIES.CREATED_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return Capabilities.CAPABILITIES.UPDATED_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return Capabilities.CAPABILITIES.EXPIRATION_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return Capabilities.CAPABILITIES.START_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field6() {
        return Capabilities.CAPABILITIES.REVOKED_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Capabilities.CAPABILITIES.TITLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Capabilities.CAPABILITIES.SECRET;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field9() {
        return Capabilities.CAPABILITIES.READ_PERMISSION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field10() {
        return Capabilities.CAPABILITIES.WRITE_PERMISSION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field11() {
        return Capabilities.CAPABILITIES.USER_FK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field12() {
        return Capabilities.CAPABILITIES.SCOPE_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field13() {
        return Capabilities.CAPABILITIES.ALBUM_FK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field14() {
        return Capabilities.CAPABILITIES.SERIES_FK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field15() {
        return Capabilities.CAPABILITIES.STUDY_FK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getPk();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component2() {
        return getCreatedTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component3() {
        return getUpdatedTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component4() {
        return getExpirationTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component5() {
        return getStartTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component6() {
        return getRevokedTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getSecret();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component9() {
        return getReadPermission();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component10() {
        return getWritePermission();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component11() {
        return getUserFk();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component12() {
        return getScopeType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component13() {
        return getAlbumFk();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component14() {
        return getSeriesFk();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component15() {
        return getStudyFk();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getPk();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value2() {
        return getCreatedTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value3() {
        return getUpdatedTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value4() {
        return getExpirationTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getStartTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value6() {
        return getRevokedTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getSecret();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value9() {
        return getReadPermission();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value10() {
        return getWritePermission();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value11() {
        return getUserFk();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value12() {
        return getScopeType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value13() {
        return getAlbumFk();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value14() {
        return getSeriesFk();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value15() {
        return getStudyFk();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CapabilitiesRecord value1(Long value) {
        setPk(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CapabilitiesRecord value2(Timestamp value) {
        setCreatedTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CapabilitiesRecord value3(Timestamp value) {
        setUpdatedTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CapabilitiesRecord value4(Timestamp value) {
        setExpirationTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CapabilitiesRecord value5(Timestamp value) {
        setStartTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CapabilitiesRecord value6(Timestamp value) {
        setRevokedTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CapabilitiesRecord value7(String value) {
        setTitle(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CapabilitiesRecord value8(String value) {
        setSecret(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CapabilitiesRecord value9(Boolean value) {
        setReadPermission(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CapabilitiesRecord value10(Boolean value) {
        setWritePermission(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CapabilitiesRecord value11(Long value) {
        setUserFk(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CapabilitiesRecord value12(String value) {
        setScopeType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CapabilitiesRecord value13(Long value) {
        setAlbumFk(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CapabilitiesRecord value14(Long value) {
        setSeriesFk(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CapabilitiesRecord value15(Long value) {
        setStudyFk(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CapabilitiesRecord values(Long value1, Timestamp value2, Timestamp value3, Timestamp value4, Timestamp value5, Timestamp value6, String value7, String value8, Boolean value9, Boolean value10, Long value11, String value12, Long value13, Long value14, Long value15) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CapabilitiesRecord
     */
    public CapabilitiesRecord() {
        super(Capabilities.CAPABILITIES);
    }

    /**
     * Create a detached, initialised CapabilitiesRecord
     */
    public CapabilitiesRecord(Long pk, Timestamp createdTime, Timestamp updatedTime, Timestamp expirationTime, Timestamp startTime, Timestamp revokedTime, String title, String secret, Boolean readPermission, Boolean writePermission, Long userFk, String scopeType, Long albumFk, Long seriesFk, Long studyFk) {
        super(Capabilities.CAPABILITIES);

        set(0, pk);
        set(1, createdTime);
        set(2, updatedTime);
        set(3, expirationTime);
        set(4, startTime);
        set(5, revokedTime);
        set(6, title);
        set(7, secret);
        set(8, readPermission);
        set(9, writePermission);
        set(10, userFk);
        set(11, scopeType);
        set(12, albumFk);
        set(13, seriesFk);
        set(14, studyFk);
    }
}
