package com.makarios.app.makarios.models;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = FashionLine.TABLE_NAME_FASHION_LINE)
public class FashionLine extends Base {
    public static final String TABLE_NAME_FASHION_LINE = "fashionLine";
    @DatabaseField
    private String gender;

    @DatabaseField
    private String designer;
    @DatabaseField
    private Double pricePoint;
    private MyCollection mycollections;

    public FashionLine() {
    }


    public FashionLine(String gender, String designer, Double pricePoint) {
        this.gender = gender;
        this.designer = designer;
        this.pricePoint = pricePoint;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public Double getPricePoint() {
        return pricePoint;
    }

    public void setPricePoint(Double pricePoint) {
        this.pricePoint = pricePoint;
    }

    public MyCollection getMycollections() {
        return mycollections;
    }

    public void setMycollections(MyCollection mycollections) {
        this.mycollections = mycollections;
    }
}
