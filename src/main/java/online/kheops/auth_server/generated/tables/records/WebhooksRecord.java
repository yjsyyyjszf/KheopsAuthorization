/*
 * This file is generated by jOOQ.
 */
package online.kheops.auth_server.generated.tables.records;


import java.sql.Timestamp;

import javax.annotation.Generated;

import online.kheops.auth_server.generated.tables.Webhooks;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
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
public class WebhooksRecord extends UpdatableRecordImpl<WebhooksRecord> implements Record11<Long, String, String, String, Boolean, Timestamp, Long, String, Boolean, Boolean, Long> {

    private static final long serialVersionUID = 2072256719;

    /**
     * Setter for <code>public.webhooks.pk</code>.
     */
    public void setPk(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.webhooks.pk</code>.
     */
    public Long getPk() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.webhooks.id</code>.
     */
    public void setId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.webhooks.id</code>.
     */
    public String getId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.webhooks.name</code>.
     */
    public void setName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.webhooks.name</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.webhooks.url</code>.
     */
    public void setUrl(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.webhooks.url</code>.
     */
    public String getUrl() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.webhooks.enabled</code>.
     */
    public void setEnabled(Boolean value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.webhooks.enabled</code>.
     */
    public Boolean getEnabled() {
        return (Boolean) get(4);
    }

    /**
     * Setter for <code>public.webhooks.creation_time</code>.
     */
    public void setCreationTime(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.webhooks.creation_time</code>.
     */
    public Timestamp getCreationTime() {
        return (Timestamp) get(5);
    }

    /**
     * Setter for <code>public.webhooks.user_fk</code>.
     */
    public void setUserFk(Long value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.webhooks.user_fk</code>.
     */
    public Long getUserFk() {
        return (Long) get(6);
    }

    /**
     * Setter for <code>public.webhooks.secret</code>.
     */
    public void setSecret(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.webhooks.secret</code>.
     */
    public String getSecret() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.webhooks.new_series</code>.
     */
    public void setNewSeries(Boolean value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.webhooks.new_series</code>.
     */
    public Boolean getNewSeries() {
        return (Boolean) get(8);
    }

    /**
     * Setter for <code>public.webhooks.new_user</code>.
     */
    public void setNewUser(Boolean value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.webhooks.new_user</code>.
     */
    public Boolean getNewUser() {
        return (Boolean) get(9);
    }

    /**
     * Setter for <code>public.webhooks.album_fk</code>.
     */
    public void setAlbumFk(Long value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.webhooks.album_fk</code>.
     */
    public Long getAlbumFk() {
        return (Long) get(10);
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
    // Record11 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<Long, String, String, String, Boolean, Timestamp, Long, String, Boolean, Boolean, Long> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<Long, String, String, String, Boolean, Timestamp, Long, String, Boolean, Boolean, Long> valuesRow() {
        return (Row11) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Webhooks.WEBHOOKS.PK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Webhooks.WEBHOOKS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Webhooks.WEBHOOKS.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Webhooks.WEBHOOKS.URL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field5() {
        return Webhooks.WEBHOOKS.ENABLED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field6() {
        return Webhooks.WEBHOOKS.CREATION_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field7() {
        return Webhooks.WEBHOOKS.USER_FK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Webhooks.WEBHOOKS.SECRET;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field9() {
        return Webhooks.WEBHOOKS.NEW_SERIES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field10() {
        return Webhooks.WEBHOOKS.NEW_USER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field11() {
        return Webhooks.WEBHOOKS.ALBUM_FK;
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
    public String component2() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component5() {
        return getEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component6() {
        return getCreationTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component7() {
        return getUserFk();
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
        return getNewSeries();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component10() {
        return getNewUser();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component11() {
        return getAlbumFk();
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
    public String value2() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value5() {
        return getEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value6() {
        return getCreationTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value7() {
        return getUserFk();
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
        return getNewSeries();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value10() {
        return getNewUser();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value11() {
        return getAlbumFk();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebhooksRecord value1(Long value) {
        setPk(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebhooksRecord value2(String value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebhooksRecord value3(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebhooksRecord value4(String value) {
        setUrl(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebhooksRecord value5(Boolean value) {
        setEnabled(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebhooksRecord value6(Timestamp value) {
        setCreationTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebhooksRecord value7(Long value) {
        setUserFk(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebhooksRecord value8(String value) {
        setSecret(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebhooksRecord value9(Boolean value) {
        setNewSeries(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebhooksRecord value10(Boolean value) {
        setNewUser(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebhooksRecord value11(Long value) {
        setAlbumFk(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebhooksRecord values(Long value1, String value2, String value3, String value4, Boolean value5, Timestamp value6, Long value7, String value8, Boolean value9, Boolean value10, Long value11) {
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
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached WebhooksRecord
     */
    public WebhooksRecord() {
        super(Webhooks.WEBHOOKS);
    }

    /**
     * Create a detached, initialised WebhooksRecord
     */
    public WebhooksRecord(Long pk, String id, String name, String url, Boolean enabled, Timestamp creationTime, Long userFk, String secret, Boolean newSeries, Boolean newUser, Long albumFk) {
        super(Webhooks.WEBHOOKS);

        set(0, pk);
        set(1, id);
        set(2, name);
        set(3, url);
        set(4, enabled);
        set(5, creationTime);
        set(6, userFk);
        set(7, secret);
        set(8, newSeries);
        set(9, newUser);
        set(10, albumFk);
    }
}
