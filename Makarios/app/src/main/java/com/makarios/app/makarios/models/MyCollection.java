package com.makarios.app.makarios.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = MyCollection.TABLE_NAME_COLLECTIONS)
public class MyCollection extends Base{

    public static final String TABLE_NAME_COLLECTIONS = "collections";
    @DatabaseField
    private String lifeStyle;
    @DatabaseField
    private String name;
    @DatabaseField
    private String season;
    @DatabaseField
    private int fashionLineId;


    public MyCollection(String lifeStyle, String name, String season) {
        this.lifeStyle = lifeStyle;
        this.name = name;
        this.season = season;
    }

    public MyCollection() {
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getLifeStyle() {
        return lifeStyle;
    }

    public void setLifeStyle(String lifeStyle) {
        this.lifeStyle = lifeStyle;
    }

    public int getFashionLineId() {
        return fashionLineId;
    }

    public void setFashionLineId(int fashionLineId) {
        this.fashionLineId = fashionLineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
