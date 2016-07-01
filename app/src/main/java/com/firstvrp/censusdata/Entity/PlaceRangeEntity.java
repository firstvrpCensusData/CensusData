package com.firstvrp.censusdata.Entity;

/**
 * 射击
 * Created by chenyuan on 16/6/19.
 */
public class PlaceRangeEntity {
    private String range_type;
    private String place_length;
    private String place_width;
    private int quantity;
    private String range_system;
    private int light_device;

    public String getRange_type() {
        return range_type;
    }

    public void setRange_type(String range_type) {
        this.range_type = range_type;
    }

    public String getPlace_length() {
        return place_length;
    }

    public void setPlace_length(String place_length) {
        this.place_length = place_length;
    }

    public String getPlace_width() {
        return place_width;
    }

    public void setPlace_width(String place_width) {
        this.place_width = place_width;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRange_system() {
        return range_system;
    }

    public void setRange_system(String range_system) {
        this.range_system = range_system;
    }

    public int getLight_device() {
        return light_device;
    }

    public void setLight_device(int light_device) {
        this.light_device = light_device;
    }
}
