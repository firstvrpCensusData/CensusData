package com.firstvrp.censusdata.Entity;

/**
 * Created by chenyuan on 16/5/31.
 * 场地专项指标-乙表子表
 */
public class PlaceSpecialIndexEntity {
    private int id;

    private String place_id;
    /// <summary>
    /// 所属场地ID
    /// </summary>

    private int viewers_seats;
    /// <summary>
    /// 观众席位
    /// </summary>

    private int screen_device;
    /// <summary>
    /// 大屏幕显示设备   1 有 2 无
    /// </summary>

    private int light_device;
    /// <summary>
    /// 灯光设备   1 有 2 无
    /// </summary>

    private int track_quantity;
    /// <summary>
    /// 环形跑道条数
    /// </summary>

    private String track_length;
    /// <summary>
    /// 跑道长度
    /// </summary>

    private String track_width;
    /// <summary>
    /// 跑道宽度
    /// </summary>

    private String track_surface;
    /// <summary>
    /// 跑道面层
    /// </summary>

    private String center_surface;
    /// <summary>
    /// 中心场地面层
    /// </summary>

    private String place_length;
    /// <summary>
    /// 场地长度
    /// </summary>

    private String place_width;
    /// <summary>
    /// 场地宽度
    /// </summary>

    private String place_radius;
    /// <summary>
    /// 场地半径
    /// </summary>

    private String indoor_high;
    /// <summary>
    /// 室内净高

    private String place_surface;
    /// <summary>
    /// 场地面层
    /// </summary>

    private int place_quantity;
    /// <summary>
    /// 场地数量
    /// </summary>

    private String tournament_length;
    /// <summary>
    /// 比赛池长
    /// </summary>

    private String tournament_width;
    /// <summary>
    /// 比赛池宽
    /// </summary>

    private String tournament_deep;
    /// <summary>
    /// 比赛池深

    private String training_length;
    /// <summary>
    /// 训练池长
    /// </summary>

    private String training_width;
    /// <summary>
    /// 训练池宽

    private String training_deep;
    /// <summary>
    /// 训练池深
    /// </summary>

    private String bathing_length;
    /// <summary>
    /// 戏水池长
    /// </summary>

    private String bathing_width;
    /// <summary>
    /// 戏水池宽
    /// </summary>

    private String bathing_deep;
    /// <summary>
    /// 戏水池深
    /// </summary>

    private String diving_length;
    /// <summary>
    /// 跳水池长
    /// </summary>

    private String diving_width;
    /// <summary>
    /// 跳水池宽
    /// </summary>

    private String diving_deep;
    /// <summary>
    /// 跳水池深

    private int jumping_quantity1;
    /// <summary>
    /// 跳台数量1
    /// </summary>

    private int jumping_quantity2;
    /// <summary>
    /// 跳台数量2
    /// </summary>

    private int jumping_quantity3;
    /// <summary>
    /// 跳台数量3
    /// </summary>

    private int jumping_quantity4;
    /// <summary>
    /// 跳台数量4
    /// </summary>

    private int jumping_quantity5;
    /// <summary>
    /// 跳台数量5
    /// </summary>

    private int springboard_quantity1;
    /// <summary>
    /// 跳板数量1
    /// </summary>

    private int springboard_quantity2;
    /// <summary>
    /// 跳板数量2
    /// </summary>

    private String place_name;
    /// <summary>
    /// 场地名称
    /// </summary>

    private String place_code;
    /// <summary>
    /// 场地代码
    /// </summary>

    private int ball_road_quantity;
    /// <summary>
    /// 保龄球球道数量
    /// </summary>

    private int pot_road_quantity;
    /// <summary>
    /// 冰壶球壶道数量
    /// </summary>

    private int shelter;
    /// <summary>
    /// 风雨棚     1 有   2 无 
    /// </summary>

    private String speedway_length;
    /// <summary>
    /// 赛道长度
    /// </summary>

    private String range_type;
    /// <summary>
    /// 靶场类别
    /// </summary>

    private int quantity;
    /// <summary>
    /// 数量
    /// </summary>

    private String range_system;
    /// <summary>
    /// 靶机设备系统
    /// </summary>

    private String boathouse_area;
    /// <summary>
    /// 船库面积
    /// </summary>

    private int dock_numbers;
    /// <summary>
    /// 船坞个数
    /// </summary>

    private int pier_numbers;
    /// <summary>
    /// 码头个数

    private int artificial_channel;
    /// <summary>
    /// 人工航道
    /// </summary>

    private String swim_water_area;
    /// <summary>
    /// 天然游泳场水面面积
    /// </summary>

    private String trail_length;
    /// <summary>
    /// 雪道长度
    /// </summary>

    private String trail_width;
    /// <summary>
    /// 雪道宽度
    /// </summary>

    private int cableway_quantity;
    /// <summary>
    /// 索道数量
    /// </summary>

    private String cableway_length;
    /// <summary>
    /// 索道总长度
    /// </summary>

    private int jumping;
    /// <summary>
    /// 有无跳台   1 有   2 无
    /// </summary>

    private int hole_quantity;
    /// <summary>
    /// 洞数
    /// </summary>

    private int hit_digit;
    /// <summary>
    /// 练习场打位数
    /// </summary>

    private int rock_ice_quantity;
    /// <summary>
    /// 岩/冰壁数量
    /// </summary>

    private String step_length;
    /// <summary>
    /// 步道长度
    /// </summary>

    private String step_widht;
    /// <summary>
    /// 步道平均宽度
    /// </summary>

    private String step_surface;
    /// <summary>
    /// 步道面层
    /// </summary>

    private int instrument_quantity;
    /// <summary>
    /// 器械数量
    /// </summary>

    private String pool_deep;
    /// <summary>
    /// 水池深度
    /// </summary>

    private String statistics_principal;
    /// <summary>
    /// 统计负责人
    /// </summary>

    private String fill_people;
    /// <summary>
    /// 填报人
    /// </summary>

    private String fill_tel;
    /// <summary>
    /// 填报人电话
    /// </summary>

    private String fill_date;
    /// <summary>
    /// 填报日期
    /// </summary>


    private String enter_deep;
    private String enter_high;
    private String enter_width;
    private String funpool_area;
    private String functionroom_area;
    private int updrop_station;
    private int makeup_room;
    private int rest_room;
    private int restaurant;
    private int recording_room;
    private String rirections;
    private String hall;
    private String show_room;
    private int report_room;
    private String display_room;
    private int art_classroom;
    private int function_room;
    private int meeting_room;
    private String building_high;
    private int books_room;
    private int device_room;
    private int store_room;
    private String stack_room;
    private String tool_reading_room;
    private String electronic_reading_room;
    private String news_reading_room;
    private String save_reading_room;
    private String temp_reading_room;
    private String foreign_reading_room;
    private String paper_library;
    private int stop_place;
    private String show_area;
    private String goods_show_area;
    private String book_picture_area;
    private String show_area_high;
    private int lectures_room;
    private int video_room;
    private int receive_room;
    private int history_store;
    private String greening_area;
    private String fitness_area;
    private int stage;
    private String sports_facility_area;
    private String culture_facility_area;
    private int dress_room;

    public String getElectronic_reading_room() {
        return electronic_reading_room;
    }

    public void setElectronic_reading_room(String electronic_reading_room) {
        this.electronic_reading_room = electronic_reading_room;
    }

    public String getNews_reading_room() {
        return news_reading_room;
    }

    public void setNews_reading_room(String news_reading_room) {
        this.news_reading_room = news_reading_room;
    }

    public String getSave_reading_room() {
        return save_reading_room;
    }

    public void setSave_reading_room(String save_reading_room) {
        this.save_reading_room = save_reading_room;
    }

    public String getTemp_reading_room() {
        return temp_reading_room;
    }

    public void setTemp_reading_room(String temp_reading_room) {
        this.temp_reading_room = temp_reading_room;
    }

    public String getForeign_reading_room() {
        return foreign_reading_room;
    }

    public void setForeign_reading_room(String foreign_reading_room) {
        this.foreign_reading_room = foreign_reading_room;
    }

    public String getPaper_library() {
        return paper_library;
    }

    public void setPaper_library(String paper_library) {
        this.paper_library = paper_library;
    }

    public int getStop_place() {
        return stop_place;
    }

    public void setStop_place(int stop_place) {
        this.stop_place = stop_place;
    }

    public String getShow_area() {
        return show_area;
    }

    public void setShow_area(String show_area) {
        this.show_area = show_area;
    }

    public String getGoods_show_area() {
        return goods_show_area;
    }

    public void setGoods_show_area(String goods_show_area) {
        this.goods_show_area = goods_show_area;
    }

    public String getBook_picture_area() {
        return book_picture_area;
    }

    public void setBook_picture_area(String book_picture_area) {
        this.book_picture_area = book_picture_area;
    }

    public String getShow_area_high() {
        return show_area_high;
    }

    public void setShow_area_high(String show_area_high) {
        this.show_area_high = show_area_high;
    }

    public int getLectures_room() {
        return lectures_room;
    }

    public void setLectures_room(int lectures_room) {
        this.lectures_room = lectures_room;
    }

    public int getVideo_room() {
        return video_room;
    }

    public void setVideo_room(int video_room) {
        this.video_room = video_room;
    }

    public int getReceive_room() {
        return receive_room;
    }

    public void setReceive_room(int receive_room) {
        this.receive_room = receive_room;
    }

    public int getHistory_store() {
        return history_store;
    }

    public void setHistory_store(int history_store) {
        this.history_store = history_store;
    }

    public String getGreening_area() {
        return greening_area;
    }

    public void setGreening_area(String greening_area) {
        this.greening_area = greening_area;
    }

    public String getFitness_area() {
        return fitness_area;
    }

    public void setFitness_area(String fitness_area) {
        this.fitness_area = fitness_area;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public String getSports_facility_area() {
        return sports_facility_area;
    }

    public void setSports_facility_area(String sports_facility_area) {
        this.sports_facility_area = sports_facility_area;
    }

    public String getCulture_facility_area() {
        return culture_facility_area;
    }

    public void setCulture_facility_area(String culture_facility_area) {
        this.culture_facility_area = culture_facility_area;
    }

    public int getDress_room() {
        return dress_room;
    }

    public void setDress_room(int dress_room) {
        this.dress_room = dress_room;
    }

    public String getEnter_deep() {
        return enter_deep;
    }

    public void setEnter_deep(String enter_deep) {
        this.enter_deep = enter_deep;
    }

    public String getEnter_high() {
        return enter_high;
    }

    public void setEnter_high(String enter_high) {
        this.enter_high = enter_high;
    }

    public String getEnter_width() {
        return enter_width;
    }

    public void setEnter_width(String enter_width) {
        this.enter_width = enter_width;
    }

    public String getFunpool_area() {
        return funpool_area;
    }

    public void setFunpool_area(String funpool_area) {
        this.funpool_area = funpool_area;
    }

    public String getFunctionroom_area() {
        return functionroom_area;
    }

    public void setFunctionroom_area(String functionroom_area) {
        this.functionroom_area = functionroom_area;
    }

    public int getUpdrop_station() {
        return updrop_station;
    }

    public void setUpdrop_station(int updrop_station) {
        this.updrop_station = updrop_station;
    }

    public int getMakeup_room() {
        return makeup_room;
    }

    public void setMakeup_room(int makeup_room) {
        this.makeup_room = makeup_room;
    }

    public int getRest_room() {
        return rest_room;
    }

    public void setRest_room(int rest_room) {
        this.rest_room = rest_room;
    }

    public int getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(int restaurant) {
        this.restaurant = restaurant;
    }

    public int getRecording_room() {
        return recording_room;
    }

    public void setRecording_room(int recording_room) {
        this.recording_room = recording_room;
    }

    public String getRirections() {
        return rirections;
    }

    public void setRirections(String rirections) {
        this.rirections = rirections;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public String getShow_room() {
        return show_room;
    }

    public void setShow_room(String show_room) {
        this.show_room = show_room;
    }

    public int getReport_room() {
        return report_room;
    }

    public void setReport_room(int report_room) {
        this.report_room = report_room;
    }

    public String getDisplay_room() {
        return display_room;
    }

    public void setDisplay_room(String display_room) {
        this.display_room = display_room;
    }

    public int getArt_classroom() {
        return art_classroom;
    }

    public void setArt_classroom(int art_classroom) {
        this.art_classroom = art_classroom;
    }

    public int getFunction_room() {
        return function_room;
    }

    public void setFunction_room(int function_room) {
        this.function_room = function_room;
    }

    public int getMeeting_room() {
        return meeting_room;
    }

    public void setMeeting_room(int meeting_room) {
        this.meeting_room = meeting_room;
    }

    public String getBuilding_high() {
        return building_high;
    }

    public void setBuilding_high(String building_high) {
        this.building_high = building_high;
    }

    public int getBooks_room() {
        return books_room;
    }

    public void setBooks_room(int books_room) {
        this.books_room = books_room;
    }

    public int getDevice_room() {
        return device_room;
    }

    public void setDevice_room(int device_room) {
        this.device_room = device_room;
    }

    public int getStore_room() {
        return store_room;
    }

    public void setStore_room(int store_room) {
        this.store_room = store_room;
    }

    public String getStack_room() {
        return stack_room;
    }

    public void setStack_room(String stack_room) {
        this.stack_room = stack_room;
    }

    public String getTool_reading_room() {
        return tool_reading_room;
    }

    public void setTool_reading_room(String tool_reading_room) {
        this.tool_reading_room = tool_reading_room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public int getViewers_seats() {
        return viewers_seats;
    }

    public void setViewers_seats(int viewers_seats) {
        this.viewers_seats = viewers_seats;
    }

    public int getScreen_device() {
        return screen_device;
    }

    public void setScreen_device(int screen_device) {
        this.screen_device = screen_device;
    }

    public int getLight_device() {
        return light_device;
    }

    public void setLight_device(int light_device) {
        this.light_device = light_device;
    }

    public int getTrack_quantity() {
        return track_quantity;
    }

    public void setTrack_quantity(int track_quantity) {
        this.track_quantity = track_quantity;
    }

    public String getTrack_length() {
        return track_length;
    }

    public void setTrack_length(String track_length) {
        this.track_length = track_length;
    }

    public String getTrack_width() {
        return track_width;
    }

    public void setTrack_width(String track_width) {
        this.track_width = track_width;
    }

    public String getTrack_surface() {
        return track_surface;
    }

    public void setTrack_surface(String track_surface) {
        this.track_surface = track_surface;
    }

    public String getCenter_surface() {
        return center_surface;
    }

    public void setCenter_surface(String center_surface) {
        this.center_surface = center_surface;
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

    public String getPlace_radius() {
        return place_radius;
    }

    public void setPlace_radius(String place_radius) {
        this.place_radius = place_radius;
    }

    public String getIndoor_high() {
        return indoor_high;
    }

    public void setIndoor_high(String indoor_high) {
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

    public String getTournament_length() {
        return tournament_length;
    }

    public void setTournament_length(String tournament_length) {
        this.tournament_length = tournament_length;
    }

    public String getTournament_width() {
        return tournament_width;
    }

    public void setTournament_width(String tournament_width) {
        this.tournament_width = tournament_width;
    }

    public String getTournament_deep() {
        return tournament_deep;
    }

    public void setTournament_deep(String tournament_deep) {
        this.tournament_deep = tournament_deep;
    }

    public String getTraining_length() {
        return training_length;
    }

    public void setTraining_length(String training_length) {
        this.training_length = training_length;
    }

    public String getTraining_width() {
        return training_width;
    }

    public void setTraining_width(String training_width) {
        this.training_width = training_width;
    }

    public String getTraining_deep() {
        return training_deep;
    }

    public void setTraining_deep(String training_deep) {
        this.training_deep = training_deep;
    }

    public String getBathing_length() {
        return bathing_length;
    }

    public void setBathing_length(String bathing_length) {
        this.bathing_length = bathing_length;
    }

    public String getBathing_width() {
        return bathing_width;
    }

    public void setBathing_width(String bathing_width) {
        this.bathing_width = bathing_width;
    }

    public String getBathing_deep() {
        return bathing_deep;
    }

    public void setBathing_deep(String bathing_deep) {
        this.bathing_deep = bathing_deep;
    }

    public String getDiving_length() {
        return diving_length;
    }

    public void setDiving_length(String diving_length) {
        this.diving_length = diving_length;
    }

    public String getDiving_width() {
        return diving_width;
    }

    public void setDiving_width(String diving_width) {
        this.diving_width = diving_width;
    }

    public String getDiving_deep() {
        return diving_deep;
    }

    public void setDiving_deep(String diving_deep) {
        this.diving_deep = diving_deep;
    }

    public int getJumping_quantity1() {
        return jumping_quantity1;
    }

    public void setJumping_quantity1(int jumping_quantity1) {
        this.jumping_quantity1 = jumping_quantity1;
    }

    public int getJumping_quantity2() {
        return jumping_quantity2;
    }

    public void setJumping_quantity2(int jumping_quantity2) {
        this.jumping_quantity2 = jumping_quantity2;
    }

    public int getJumping_quantity3() {
        return jumping_quantity3;
    }

    public void setJumping_quantity3(int jumping_quantity3) {
        this.jumping_quantity3 = jumping_quantity3;
    }

    public int getJumping_quantity4() {
        return jumping_quantity4;
    }

    public void setJumping_quantity4(int jumping_quantity4) {
        this.jumping_quantity4 = jumping_quantity4;
    }

    public int getJumping_quantity5() {
        return jumping_quantity5;
    }

    public void setJumping_quantity5(int jumping_quantity5) {
        this.jumping_quantity5 = jumping_quantity5;
    }

    public int getSpringboard_quantity1() {
        return springboard_quantity1;
    }

    public void setSpringboard_quantity1(int springboard_quantity1) {
        this.springboard_quantity1 = springboard_quantity1;
    }

    public int getSpringboard_quantity2() {
        return springboard_quantity2;
    }

    public void setSpringboard_quantity2(int springboard_quantity2) {
        this.springboard_quantity2 = springboard_quantity2;
    }

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

    public int getBall_road_quantity() {
        return ball_road_quantity;
    }

    public void setBall_road_quantity(int ball_road_quantity) {
        this.ball_road_quantity = ball_road_quantity;
    }

    public int getPot_road_quantity() {
        return pot_road_quantity;
    }

    public void setPot_road_quantity(int pot_road_quantity) {
        this.pot_road_quantity = pot_road_quantity;
    }

    public int getShelter() {
        return shelter;
    }

    public void setShelter(int shelter) {
        this.shelter = shelter;
    }

    public String getSpeedway_length() {
        return speedway_length;
    }

    public void setSpeedway_length(String speedway_length) {
        this.speedway_length = speedway_length;
    }

    public String getRange_type() {
        return range_type;
    }

    public void setRange_type(String range_type) {
        this.range_type = range_type;
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

    public String getBoathouse_area() {
        return boathouse_area;
    }

    public void setBoathouse_area(String boathouse_area) {
        this.boathouse_area = boathouse_area;
    }

    public int getDock_numbers() {
        return dock_numbers;
    }

    public void setDock_numbers(int dock_numbers) {
        this.dock_numbers = dock_numbers;
    }

    public int getPier_numbers() {
        return pier_numbers;
    }

    public void setPier_numbers(int pier_numbers) {
        this.pier_numbers = pier_numbers;
    }

    public int getArtificial_channel() {
        return artificial_channel;
    }

    public void setArtificial_channel(int artificial_channel) {
        this.artificial_channel = artificial_channel;
    }

    public String getSwim_water_area() {
        return swim_water_area;
    }

    public void setSwim_water_area(String swim_water_area) {
        this.swim_water_area = swim_water_area;
    }

    public String getTrail_length() {
        return trail_length;
    }

    public void setTrail_length(String trail_length) {
        this.trail_length = trail_length;
    }

    public String getTrail_width() {
        return trail_width;
    }

    public void setTrail_width(String trail_width) {
        this.trail_width = trail_width;
    }

    public int getCableway_quantity() {
        return cableway_quantity;
    }

    public void setCableway_quantity(int cableway_quantity) {
        this.cableway_quantity = cableway_quantity;
    }

    public String getCableway_length() {
        return cableway_length;
    }

    public void setCableway_length(String cableway_length) {
        this.cableway_length = cableway_length;
    }

    public int getJumping() {
        return jumping;
    }

    public void setJumping(int jumping) {
        this.jumping = jumping;
    }

    public int getHole_quantity() {
        return hole_quantity;
    }

    public void setHole_quantity(int hole_quantity) {
        this.hole_quantity = hole_quantity;
    }

    public int getHit_digit() {
        return hit_digit;
    }

    public void setHit_digit(int hit_digit) {
        this.hit_digit = hit_digit;
    }

    public int getRock_ice_quantity() {
        return rock_ice_quantity;
    }

    public void setRock_ice_quantity(int rock_ice_quantity) {
        this.rock_ice_quantity = rock_ice_quantity;
    }

    public String getStep_length() {
        return step_length;
    }

    public void setStep_length(String step_length) {
        this.step_length = step_length;
    }

    public String getStep_widht() {
        return step_widht;
    }

    public void setStep_widht(String step_widht) {
        this.step_widht = step_widht;
    }

    public String getStep_surface() {
        return step_surface;
    }

    public void setStep_surface(String step_surface) {
        this.step_surface = step_surface;
    }

    public int getInstrument_quantity() {
        return instrument_quantity;
    }

    public void setInstrument_quantity(int instrument_quantity) {
        this.instrument_quantity = instrument_quantity;
    }

    public String getPool_deep() {
        return pool_deep;
    }

    public void setPool_deep(String pool_deep) {
        this.pool_deep = pool_deep;
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


}
