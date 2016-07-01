package com.firstvrp.censusdata.Entity;

import java.util.List;

/**
 * Created by chenyuan on 16/5/31.
 * 大型场地基本信息-丙表
 */
public class BigPlaceInfoEntity {
    private String id;

    private String units_id;
    /// <summary>
    /// 所属体育场所ID
    /// </summary>

    private String place_code;
    /// <summary>
    /// 场地代码
    /// </summary>

    private String place_name;
    /// <summary>
    /// 场地名称
    /// </summary>

    private String sport_state;
    /// <summary>
    /// 承办运动会情况
    /// </summary>

    private String open_place_area;
    /// <summary>
    /// 开放场地面积
    /// </summary>

    private String week_open_times;
    /// <summary>
    /// 周对外开放时间
    /// </summary>

    private int train_quantity;
    /// <summary>
    /// 全年健身培训班数量
    /// </summary>

    private int train_pcounts;
    /// <summary>
    /// 全年健身培训人次
    /// </summary>

    private int country_event;
    /// <summary>
    /// 全国及以上体育赛事
    /// </summary>

    private int province_event;
    /// <summary>
    /// 省级及以下体育赛事
    /// </summary>

    private int culture;
    /// <summary>
    /// 文化演艺活动
    /// </summary>

    private int exhibition;
    /// <summary>
    /// 会展活动
    /// </summary>

    private int public_interest;
    /// <summary>
    /// 公益活动
    /// </summary>

    private int other_activity;
    /// <summary>
    /// 其他活动
    /// </summary>

    private String assets_total;
    /// <summary>
    /// 资产总计
    /// </summary>

    private String be_in_debt_total;
    /// <summary>
    /// 负债合计
    /// </summary>

    private String income_total;
    /// <summary>
    /// 收入合计
    /// </summary>

    private String financial;
    /// <summary>
    /// 财政拨款
    /// </summary>

    private String career_income;
    /// <summary>
    /// 事业收入
    /// </summary>

    private String operate_income;
    /// <summary>
    /// 经营收入
    /// </summary>

    private String cost_total;
    /// <summary>
    /// 成本合计
    /// </summary>

    private String manage_cost;
    /// <summary>
    /// 管理费用
    /// </summary>

    private String energy_cost;
    /// <summary>
    /// 能源费用
    /// </summary>

    private String water_cost;
    /// <summary>
    /// 水费
    /// </summary>

    private String electricity_cost;
    /// <summary>
    /// 电费
    /// </summary>

    private String gas_cost;
    /// <summary>
    /// 燃气热力费
    /// </summary>

    private String expenses_tatol;
    /// <summary>
    /// 支出合计
    /// </summary>

    private String balance;
    /// <summary>
    /// 收支结余
    /// </summary>

    private String taxes_tatol;
    /// <summary>
    /// 税金合计
    /// </summary>

    private String business_profit;
    /// <summary>
    /// 营业利润
    /// </summary>

    private String fund_rate;
    /// <summary>
    /// 经费自给率
    /// </summary>

    private String fill_tel;
    /// <summary>
    /// 填报人电话
    /// </summary>

    private String fill_people;
    /// <summary>
    /// 填报人
    /// </summary>

    private String statistics_principal;
    /// <summary>
    /// 统计负责人
    /// </summary>

    private String fill_date;
    /// <summary>
    /// 填报日期
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

    private List<SportsStateEntity> sportsState;
    /// <summary>
    /// 承办省级及以上大型综合性运动会情况-丙表子表
    /// 实体集合
    /// </summary>

    private List<BearTaskEntity> bearTask;
    /// <summary>
    /// 在赛事中承担的任务-丙表子表
    /// 实体集合
    /// </summary>


    private List<FitnessItemEntity> fitnessItem;
    /// <summary>
    /// 开展健身项目-丙表子表
    /// 实体集合
    /// </summary>

    private List<TrainItemEntity> trainItem;
    /// <summary>
    /// 培训项目-丙表子表
    /// 实体集合
    /// </summary>


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

    public String getSport_state() {
        return sport_state;
    }

    public void setSport_state(String sport_state) {
        this.sport_state = sport_state;
    }

    public String getOpen_place_area() {
        return open_place_area;
    }

    public void setOpen_place_area(String open_place_area) {
        this.open_place_area = open_place_area;
    }

    public String getWeek_open_times() {
        return week_open_times;
    }

    public void setWeek_open_times(String week_open_times) {
        this.week_open_times = week_open_times;
    }

    public int getTrain_quantity() {
        return train_quantity;
    }

    public void setTrain_quantity(int train_quantity) {
        this.train_quantity = train_quantity;
    }

    public int getTrain_pcounts() {
        return train_pcounts;
    }

    public void setTrain_pcounts(int train_pcounts) {
        this.train_pcounts = train_pcounts;
    }

    public int getCountry_event() {
        return country_event;
    }

    public void setCountry_event(int country_event) {
        this.country_event = country_event;
    }

    public int getProvince_event() {
        return province_event;
    }

    public void setProvince_event(int province_event) {
        this.province_event = province_event;
    }

    public int getCulture() {
        return culture;
    }

    public void setCulture(int culture) {
        this.culture = culture;
    }

    public int getExhibition() {
        return exhibition;
    }

    public void setExhibition(int exhibition) {
        this.exhibition = exhibition;
    }

    public int getPublic_interest() {
        return public_interest;
    }

    public void setPublic_interest(int public_interest) {
        this.public_interest = public_interest;
    }

    public int getOther_activity() {
        return other_activity;
    }

    public void setOther_activity(int other_activity) {
        this.other_activity = other_activity;
    }

    public String getAssets_total() {
        return assets_total;
    }

    public void setAssets_total(String assets_total) {
        this.assets_total = assets_total;
    }

    public String getBe_in_debt_total() {
        return be_in_debt_total;
    }

    public void setBe_in_debt_total(String be_in_debt_total) {
        this.be_in_debt_total = be_in_debt_total;
    }

    public String getIncome_total() {
        return income_total;
    }

    public void setIncome_total(String income_total) {
        this.income_total = income_total;
    }

    public String getFinancial() {
        return financial;
    }

    public void setFinancial(String financial) {
        this.financial = financial;
    }

    public String getCareer_income() {
        return career_income;
    }

    public void setCareer_income(String career_income) {
        this.career_income = career_income;
    }

    public String getOperate_income() {
        return operate_income;
    }

    public void setOperate_income(String operate_income) {
        this.operate_income = operate_income;
    }

    public String getCost_total() {
        return cost_total;
    }

    public void setCost_total(String cost_total) {
        this.cost_total = cost_total;
    }

    public String getManage_cost() {
        return manage_cost;
    }

    public void setManage_cost(String manage_cost) {
        this.manage_cost = manage_cost;
    }

    public String getEnergy_cost() {
        return energy_cost;
    }

    public void setEnergy_cost(String energy_cost) {
        this.energy_cost = energy_cost;
    }

    public String getWater_cost() {
        return water_cost;
    }

    public void setWater_cost(String water_cost) {
        this.water_cost = water_cost;
    }

    public String getElectricity_cost() {
        return electricity_cost;
    }

    public void setElectricity_cost(String electricity_cost) {
        this.electricity_cost = electricity_cost;
    }

    public String getGas_cost() {
        return gas_cost;
    }

    public void setGas_cost(String gas_cost) {
        this.gas_cost = gas_cost;
    }

    public String getExpenses_tatol() {
        return expenses_tatol;
    }

    public void setExpenses_tatol(String expenses_tatol) {
        this.expenses_tatol = expenses_tatol;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getTaxes_tatol() {
        return taxes_tatol;
    }

    public void setTaxes_tatol(String taxes_tatol) {
        this.taxes_tatol = taxes_tatol;
    }

    public String getBusiness_profit() {
        return business_profit;
    }

    public void setBusiness_profit(String business_profit) {
        this.business_profit = business_profit;
    }

    public String getFund_rate() {
        return fund_rate;
    }

    public void setFund_rate(String fund_rate) {
        this.fund_rate = fund_rate;
    }

    public String getFill_tel() {
        return fill_tel;
    }

    public void setFill_tel(String fill_tel) {
        this.fill_tel = fill_tel;
    }

    public String getFill_people() {
        return fill_people;
    }

    public void setFill_people(String fill_people) {
        this.fill_people = fill_people;
    }

    public String getStatistics_principal() {
        return statistics_principal;
    }

    public void setStatistics_principal(String statistics_principal) {
        this.statistics_principal = statistics_principal;
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

    public List<SportsStateEntity> getSportsState() {
        return sportsState;
    }

    public void setSportsState(List<SportsStateEntity> sportsState) {
        this.sportsState = sportsState;
    }

    public List<BearTaskEntity> getBearTask() {
        return bearTask;
    }

    public void setBearTask(List<BearTaskEntity> bearTask) {
        this.bearTask = bearTask;
    }

    public List<FitnessItemEntity> getFitnessItem() {
        return fitnessItem;
    }

    public void setFitnessItem(List<FitnessItemEntity> fitnessItem) {
        this.fitnessItem = fitnessItem;
    }

    public List<TrainItemEntity> getTrainItem() {
        return trainItem;
    }

    public void setTrainItem(List<TrainItemEntity> trainItem) {
        this.trainItem = trainItem;
    }
}
