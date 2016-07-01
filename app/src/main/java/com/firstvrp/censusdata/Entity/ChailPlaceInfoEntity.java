package com.firstvrp.censusdata.Entity;

/**
 * Created by chenyuan on 16/6/19.
 */
public class ChailPlaceInfoEntity {
    String placeId;
    String placeName;
    int type;
    String unitsID;
    private int audit_state;
    /// <summary>
    /// 审核状态  0：未审核  1：已通过 2：未通过
    /// </summary>

    private String audit_options;

    public int getAudit_state() {
        return audit_state;
    }

    public void setAudit_state(int audit_state) {
        this.audit_state = audit_state;
    }

    public String getAudit_options() {
        return audit_options;
    }

    public void setAudit_options(String audit_options) {
        this.audit_options = audit_options;
    }

    public String getUnitsID() {
        return unitsID;
    }

    public void setUnitsID(String unitsID) {
        this.unitsID = unitsID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }


}
