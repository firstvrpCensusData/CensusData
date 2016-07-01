package com.firstvrp.censusdata.Entity;

import java.util.List;

/**
 * Created by chenyuan on 16/5/31.
 *  场地基本信息-乙表
 */
public class PlaceInfoEntity {
    private String id;

    private String units_id;
    /// <summary>
    /// 所属体育场所ID
    /// </summary>

    //场地坐标
    private String coordinate;

    private String place_code;
    /// <summary>
    /// 场地代码
    /// </summary>

    private String place_name;
    /// <summary>
    /// 场地名称
    /// </summary>

    private String place_distributed;
    /// <summary>
    /// 场地分布
    /// </summary>

    private String create_year;
    /// <summary>
    /// 建成年份
    /// </summary>

    private String land_area;
    /// <summary>
    /// 用地面积
    /// </summary>

    private String building_area;
    /// <summary>
    /// 建筑面积
    /// </summary>

    private String place_area;
    /// <summary>
    /// 场地面积
    /// </summary>

    private String investment_total;
    /// <summary>
    /// 投资金额-合计
    /// </summary>

    private String investment_finances;
    /// <summary>
    /// 投资金额-财政拨款
    /// </summary>

    private String investment_chest;
    /// <summary>
    /// 投资金额-体彩公益金
    /// </summary>

    private String investment_self;
    /// <summary>
    /// 投资金额-单位自筹
    /// </summary>

    private String investment_donate;
    /// <summary>
    /// 投资金额-社会捐赠
    /// </summary>

    private String investment_other;
    /// <summary>
    /// 投资金额-其他
    /// </summary>

    private int practitioners_counts;
    /// <summary>
    /// 单位场地从业人员总数
    /// </summary>

    private String operations_mode;
    /// <summary>
    /// 运营模式
    /// </summary>

    private String open_situation;
    /// <summary>
    /// 对外开放情况
    /// </summary>

    private int year_open_days;
    /// <summary>
    /// 年开放天数
    /// </summary>

    private String week_reception_pcounts;
    /// <summary>
    /// 平均每周接待健身人次
    /// </summary>

    private String income_total;
    /// <summary>
    /// 收入合计
    /// </summary>

    private String expenses_total;
    /// <summary>
    /// 支出合计
    /// </summary>


    private int audit_state;
    /// <summary>
    /// 审核状态
    /// 0：未审核  1：已审核
    /// </summary>

    private String audit_options;

    public String getAudit_options() {
        return audit_options;
    }

    public void setAudit_options(String audit_options) {
        this.audit_options = audit_options;
    }

    private List<PlaceRangeEntity> placeRange;

    public List<PlaceRangeEntity> getPlaceRanges() {
        return placeRange;
    }

    public void setPlaceRanges(List<PlaceRangeEntity> placeRange) {
        this.placeRange = placeRange;
    }

    private List<PlaceHomeEntity> placeHome;
    /// <summary>
    /// 场地归属-乙表子表
    /// 实体集合
    /// </summary>


    private List<SportsItemEntity> sportsItem;
    /// <summary>
    /// 场地专项指标-开展的体育项目-乙表子表
    /// 实体集合
    /// </summary>


    private PlaceSpecialIndexEntity placeSpecialIndex;
    /// <summary>
    /// 场地专项指标-乙表子表
    /// 实体
    /// </summary>

    private List<PlaceInfoChildEntity> placeInfoChild;

    public List<PlaceInfoChildEntity> getPlaceinfochild() {
        return placeInfoChild;
    }

    public void setPlaceinfochild(List<PlaceInfoChildEntity> placeInfoChild) {
        this.placeInfoChild = placeInfoChild;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnits_id() {
        return units_id;
    }

    public void setUnits_id(String units_id) {
        this.units_id = units_id;
    }

    public String getPlace_code() {
        return place_code;
    }

    public void setPlace_code(String place_code) {
        this.place_code = place_code;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getPlace_distributed() {
        return place_distributed;
    }

    public void setPlace_distributed(String place_distributed) {
        this.place_distributed = place_distributed;
    }

    public String getCreate_year() {
        return create_year;
    }

    public void setCreate_year(String create_year) {
        this.create_year = create_year;
    }

    public String getLand_area() {
        return land_area;
    }

    public void setLand_area(String land_area) {
        this.land_area = land_area;
    }

    public String getBuilding_area() {
        return building_area;
    }

    public void setBuilding_area(String building_area) {
        this.building_area = building_area;
    }

    public String getPlace_area() {
        return place_area;
    }

    public void setPlace_area(String place_area) {
        this.place_area = place_area;
    }

    public String getInvestment_total() {
        return investment_total;
    }

    public void setInvestment_total(String investment_total) {
        this.investment_total = investment_total;
    }

    public String getInvestment_finances() {
        return investment_finances;
    }

    public void setInvestment_finances(String investment_finances) {
        this.investment_finances = investment_finances;
    }

    public String getInvestment_chest() {
        return investment_chest;
    }

    public void setInvestment_chest(String investment_chest) {
        this.investment_chest = investment_chest;
    }

    public String getInvestment_self() {
        return investment_self;
    }

    public void setInvestment_self(String investment_self) {
        this.investment_self = investment_self;
    }

    public String getInvestment_donate() {
        return investment_donate;
    }

    public void setInvestment_donate(String investment_donate) {
        this.investment_donate = investment_donate;
    }

    public String getInvestment_other() {
        return investment_other;
    }

    public void setInvestment_other(String investment_other) {
        this.investment_other = investment_other;
    }

    public int getPractitioners_counts() {
        return practitioners_counts;
    }

    public void setPractitioners_counts(int practitioners_counts) {
        this.practitioners_counts = practitioners_counts;
    }

    public String getOperations_mode() {
        return operations_mode;
    }

    public void setOperations_mode(String operations_mode) {
        this.operations_mode = operations_mode;
    }

    public String getOpen_situation() {
        return open_situation;
    }

    public void setOpen_situation(String open_situation) {
        this.open_situation = open_situation;
    }

    public int getYear_open_days() {
        return year_open_days;
    }

    public void setYear_open_days(int year_open_days) {
        this.year_open_days = year_open_days;
    }

    public String getWeek_reception_pcounts() {
        return week_reception_pcounts;
    }

    public void setWeek_reception_pcounts(String week_reception_pcounts) {
        this.week_reception_pcounts = week_reception_pcounts;
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

    public int getAudit_state() {
        return audit_state;
    }

    public void setAudit_state(int audit_state) {
        this.audit_state = audit_state;
    }

    public List<PlaceHomeEntity> getPlaceHome() {
        return placeHome;
    }

    public void setPlaceHome(List<PlaceHomeEntity> placeHome) {
        this.placeHome = placeHome;
    }

    public List<SportsItemEntity> getSportsItem() {
        return sportsItem;
    }

    public void setSportsItem(List<SportsItemEntity> sportsItem) {
        this.sportsItem = sportsItem;
    }

    public PlaceSpecialIndexEntity getPlaceSpecialIndex() {
        return placeSpecialIndex;
    }

    public void setPlaceSpecialIndex(PlaceSpecialIndexEntity placeSpecialIndex) {
        this.placeSpecialIndex = placeSpecialIndex;
    }
}
