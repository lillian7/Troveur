package com.makarios.app.makarios.models;


import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

import java.util.Date;

public abstract class Base {
    public static final String FIELD_NAME_ID = "id";
    public static final String FIELD_CDATE_NAME = "createdAt";

    @DatabaseField(columnName = FIELD_NAME_ID, generatedId = true)
    private long id;
    @DatabaseField(dataType = DataType.DATE_LONG, columnName = FIELD_CDATE_NAME)
    private Date createdAt;

    public Base(){}

    public Base(long id, Date createdAt) {
        this.id = id;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}