package com.firstvrp.censusdata.Entity;

import java.io.Serializable;

/**
 * Created by chenyuan on 16/5/31.
 * 单位基本情况-甲表
 */
public class UnitsInfoEntity implements Serializable{
    private String id;
  
    private String org_code;
    /// <summary>
    /// 组织机构代码
    /// </summary>
 
    private String units_name;
    /// <summary>
    /// 单位名称
    /// </summary>
   
    private String units_principal;
    /// <summary>
    /// 单位负责人
    /// </summary>
   
    private String units_tel;
    /// <summary>
    /// 单位电话
    /// </summary>
 
    private String deptname;
    /// <summary>
    /// 主管部门
    /// </summary>
  
    private String area_code;
    /// <summary>
    /// 区划代码
    /// </summary>
  
    private String city_code;
    /// <summary>
    /// 城乡代码
    /// </summary>
   
    private int province_id;
    /// <summary>
    /// 所在省ID
    /// </summary>
 
    private int city_id;
    /// <summary>
    /// 所在市ID
    /// </summary>
  
    private int county_id;
    /// <summary>
    /// 所在区县ID
    /// </summary>
   
    private String township;
    /// <summary>
    /// 所在乡镇
    /// </summary>
    
    private String street;
    /// <summary>
    /// 街道
    /// </summary>
  
    private String street_code;
    /// <summary>
    /// 街道号
    /// </summary>
    
    private String view_system;
    /// <summary>
    /// 所在系统
    /// </summary>
    
    private String subjection_relation;
    /// <summary>
    /// 隶属关系
    /// </summary>
   
    private String units_type;
    /// <summary>
    /// 单位类型
    /// </summary>
   
    private String register_type;
    /// <summary>
    /// 企业登记注册类型
    /// </summary>
    
    private String athlete_type;
    /// <summary>
    /// 所接待运动队类型
    /// </summary>
    
    private String receive_people_counts;
    /// <summary>
    /// 累计接待运动员人次
    /// </summary>
   
    private String receive_days;
    /// <summary>
    /// 累计接待运动员天数
    /// </summary>
    
    private int practitioners_counts;
    /// <summary>
    /// 单位场地从业人员总数
    /// </summary>
    
    private String income_total;
    /// <summary>
    /// 收入合计
    /// </summary>
   
    private String expenses_total;
    /// <summary>
    /// 支出合计
    /// </summary>
  
    private int yb_counts;
    /// <summary>
    /// 本单位所填报乙表数量
    /// </summary>
  
    private String statistics_principal;
    /// <summary>
    /// 统计负责人
    /// </summary>
 
    private String fill_people;
    /// <summary>
    /// 填报人
   
    private String fill_tel;
    /// <summary>
    /// 填报人电话
    /// </summary>
 
    private String fill_date;
    /// <summary>
    /// 填报日期
    /// </summary>
  
    private int audit_state;
    /// <summary>
    /// 审核状态  0：未审核  1：已审核
    /// </summary>

    private String audit_options;

    public String getAudit_options() {
        return audit_options;
    }

    public void setAudit_options(String audit_options) {
        this.audit_options = audit_options;
    }

    public String getReceive_people_counts() {
        return receive_people_counts;
    }

    public void setReceive_people_counts(String receive_people_counts) {
        this.receive_people_counts = receive_people_counts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrg_code() {
        return org_code;
    }

    public void setOrg_code(String org_code) {
        this.org_code = org_code;
    }

    public String getUnits_name() {
        return units_name;
    }

    public void setUnits_name(String units_name) {
        this.units_name = units_name;
    }

    public String getUnits_principal() {
        return units_principal;
    }

    public void setUnits_principal(String units_principal) {
        this.units_principal = units_principal;
    }

    public String getUnits_tel() {
        return units_tel;
    }

    public void setUnits_tel(String units_tel) {
        this.units_tel = units_tel;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getArea_code() {
        return area_code;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public int getProvince_id() {
        return province_id;
    }

    public void setProvince_id(int province_id) {
        this.province_id = province_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public int getCounty_id() {
        return county_id;
    }

    public void setCounty_id(int county_id) {
        this.county_id = county_id;
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet_code() {
        return street_code;
    }

    public void setStreet_code(String street_code) {
        this.street_code = street_code;
    }

    public String getView_system() {
        return view_system;
    }

    public void setView_system(String view_system) {
        this.view_system = view_system;
    }

    public String getSubjection_relation() {
        return subjection_relation;
    }

    public void setSubjection_relation(String subjection_relation) {
        this.subjection_relation = subjection_relation;
    }

    public String getUnits_type() {
        return units_type;
    }

    public void setUnits_type(String units_type) {
        this.units_type = units_type;
    }

    public String getRegister_type() {
        return register_type;
    }

    public void setRegister_type(String register_type) {
        this.register_type = register_type;
    }

    public String getAthlete_type() {
        return athlete_type;
    }

    public void setAthlete_type(String athlete_type) {
        this.athlete_type = athlete_type;
    }


    public String getReceive_days() {
        return receive_days;
    }

    public void setReceive_days(String receive_days) {
        this.receive_days = receive_days;
    }

    public int getPractitioners_counts() {
        return practitioners_counts;
    }

    public void setPractitioners_counts(int practitioners_counts) {
        this.practitioners_counts = practitioners_counts;
    }

    public String getIncome_total() {
        return income_total;
    }

    public void setIncome_total(String income_total) {
        this.income_total = income_total;
    }

    public String getExpenses_total() {
        return expenses_total;
    }

    public void setExpenses_total(String expenses_total) {
        this.expenses_total = expenses_total;
    }

    public int getYb_counts() {
        return yb_counts;
    }

    public void setYb_counts(int yb_counts) {
        this.yb_counts = yb_counts;
    }

    public String getStatistics_principal() {
        return statistics_principal;
    }

    public void setStatistics_principal(String statistics_principal) {
        this.statistics_principal = statistics_principal;
    }

    public String getFill_people() {
        return fill_people;
    }

    public void setFill_people(String fill_people) {
        this.fill_people = fill_people;
    }

    public String getFill_tel() {
        return fill_tel;
    }

    public void setFill_tel(String fill_tel) {
        this.fill_tel = fill_tel;
    }

    public String getFill_date() {
        return fill_date;
    }

    public void setFill_date(String fill_date) {
        this.fill_date = fill_date;
    }

    public int getAudit_state() {
        return audit_state;
    }

    public void setAudit_state(int audit_state) {
        this.audit_state = audit_state;
    }


    @Override
    public String toString() {
        return "UnitsInfoEntity{" +
                "id='" + id + '\'' +
                ", org_code='" + org_code + '\'' +
                ", units_name='" + units_name + '\'' +
                ", units_principal='" + units_principal + '\'' +
                ", units_tel='" + units_tel + '\'' +
                ", deptname='" + deptname + '\'' +
                ", area_code='" + area_code + '\'' +
                ", city_code='" + city_code + '\'' +
                ", province_id=" + province_id +
                ", city_id=" + city_id +
                ", county_id=" + county_id +
                ", township=" + township +
                ", street='" + street + '\'' +
                ", street_code='" + street_code + '\'' +
                ", view_system='" + view_system + '\'' +
                ", subjection_relation='" + subjection_relation + '\'' +
                ", units_type='" + units_type + '\'' +
                ", register_type='" + register_type + '\'' +
                ", athlete_type='" + athlete_type + '\'' +
                ", receive_people_counts='" + receive_people_counts + '\'' +
                ", receive_days='" + receive_days + '\'' +
                ", practitioners_counts=" + practitioners_counts +
                ", income_total='" + income_total + '\'' +
                ", expenses_total='" + expenses_total + '\'' +
                ", yb_counts=" + yb_counts +
                ", statistics_principal='" + statistics_principal + '\'' +
                ", fill_people='" + fill_people + '\'' +
                ", fill_tel='" + fill_tel + '\'' +
                ", fill_date='" + fill_date + '\'' +
                ", audit_state=" + audit_state +
                '}';
    }
}
