package com.firstvrp.censusdata.Entity;

/**
 * Created by chenyuan on 16/6/13.
 */
public class PlaceInfoChildEntity {
    private String id;
//    private String place_id;
    private String place_name;
    private String place_code;
    private float place_width;
    private float place_length;
    private float indoor_high;
    private String place_surface;
    private int place_quantity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
//
//    public String getPlace_id() {
//        return place_id;
//    }
//
//    public void setPlace_id(String place_id) {
//        this.place_id = place_id;
//    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getPlace_code() {
        return place_code;
    }

    public void setPlace_code(String place_code) {
        this.place_code = place_code;
    }

    public float getPlace_width() {
        return place_width;
    }

    public void setPlace_width(float place_width) {
        this.place_width = place_width;
    }

    public float getPlace_length() {
        return place_length;
    }

    public void setPlace_length(float place_length) {
        this.place_length = place_length;
    }

    public float getIndoor_high() {
        return indoor_high;
    }

    public void setIndoor_high(float indoor_high) {
        this.indoor_high = indoor_high;
    }

    public String getPlace_surface() {
        return place_surface;
    }

    public void setPlace_surface(String place_surface) {
        this.place_surface = place_surface;
    }

    public int getPlace_quantity() {
        return place_quantity;
    }

    public void setPlace_quantity(int place_quantity) {
        this.place_quantity = place_quantity;
    }
}
