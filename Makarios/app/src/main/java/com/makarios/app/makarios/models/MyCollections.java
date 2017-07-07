package com.makarios.app.makarios.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = MyCollections.TABLE_NAME_COLLECTIONS)
public class MyCollections extends Base{

    public static final String TABLE_NAME_COLLECTIONS = "collections";
    @DatabaseField
    private String lifeStyle;
    @DatabaseField
    private String name;
    @DatabaseField
    private String season;
    @DatabaseField
    private int fashionLineId;


    MyCollections(String lifeStyle, String name, String season, int fashionLineId) {
        this.lifeStyle = lifeStyle;
        this.name = name;
        this.season = season;
        this.fashionLineId = fashionLineId;
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
