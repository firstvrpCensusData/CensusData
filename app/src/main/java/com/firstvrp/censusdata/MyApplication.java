package com.firstvrp.censusdata;

import android.app.Application;

import com.firstvrp.censusdata.Entity.BasUserEntity;
import com.firstvrp.censusdata.Entity.BigPlaceInfoEntity;
import com.firstvrp.censusdata.Entity.PlaceInfoEntity;
import com.firstvrp.censusdata.Entity.SaveStyleEnum;
import com.firstvrp.censusdata.Entity.UnitsInfoEntity;

/**
 * Created by chenyuan on 16/6/14.
 */
public class MyApplication extends Application {
    private static final String NAME = "MyApplication";

    public String placeName;

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public SaveStyleEnum savestyle;
    public SaveStyleEnum getSavestyle() {
        return savestyle;
    }

    public void setSavestyle(SaveStyleEnum savestyle) {
        this.savestyle = savestyle;
    }
    /**
     * 用户信息
     */
    public  BasUserEntity basUserEntity;

    /**
     * 添加完成单位信息后返回的单位ID
     */
    public  String UnitsID;

    /**
     * 从组织机构代码中查到的单位信息
     */
    public  UnitsInfoEntity unitsInfoEntity;

    /**
     * 选择完乙表后乙表的id,,从审核中
     */
    public  int typeID;

    /**
     * 从审核中保存的
     */
    public PlaceInfoEntity placeInfoEntity;

    public BigPlaceInfoEntity bigPlaceInfoEntity;

    public BigPlaceInfoEntity getBigPlaceInfoEntity() {
        return bigPlaceInfoEntity;
    }

    public void setBigPlaceInfoEntity(BigPlaceInfoEntity bigPlaceInfoEntity) {
        this.bigPlaceInfoEntity = bigPlaceInfoEntity;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public PlaceInfoEntity getPlaceInfoEntity() {
        return placeInfoEntity;
    }

    public void setPlaceInfoEntity(PlaceInfoEntity placeInfoEntity) {
        this.placeInfoEntity = placeInfoEntity;
    }

    public static String getNAME() {
        return NAME;
    }

    public BasUserEntity getBasUserEntity() {
        return basUserEntity;
    }

    public void setBasUserEntity(BasUserEntity basUserEntity) {
        this.basUserEntity = basUserEntity;
    }

    public String getUnitsID() {
        return UnitsID;
    }

    public void setUnitsID(String unitsID) {
        UnitsID = unitsID;
    }

    public UnitsInfoEntity getUnitsInfoEntity() {
        return unitsInfoEntity;
    }

    public void setUnitsInfoEntity(UnitsInfoEntity unitsInfoEntity) {
        this.unitsInfoEntity = unitsInfoEntity;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }
}
