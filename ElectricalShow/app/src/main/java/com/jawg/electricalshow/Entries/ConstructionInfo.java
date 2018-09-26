package com.jawg.electricalshow.Entries;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ConstructionInfo {


    /**
     * construction_id : 51
     * name : 经安纬固消防科技办公楼
     * location : 山东省济南市天桥区无影山北路68号
     * address_description : 天建·天和园小区冬园-西门附近33米
     * lati : 36.71152879299231
     * long : 116.9819877289958
     * unit_id : 330
     * floor : 3
     * height : 15
     * build_area : 11500
     * city_id : 370100
     * city : 济南市
     * area_id : 370105
     * area : 天桥区
     * county_id : 370105001
     * short_county : 无影山街道
     * com_name : 山东经安纬固消防科技有限公司
     * construction_type_id : 5
     * construction_type : 科研建筑
     * structure_type_id : 3
     * structure_type : 砖混结构
     * buildingarea_firefac : [{"id":"01","type":"室内消火栓系统"},{"id":"03","type":"火灾自动报警系统"}]
     */

    private String construction_id;
    private String name;
    private String location;
    private String address_description;
    private String lati;
    @SerializedName("long")
    private String longX;
    private String unit_id;
    private String floor;
    private String height;
    private String build_area;
    private String city_id;
    private String city;
    private String area_id;
    private String area;
    private String county_id;
    private String short_county;
    private String com_name;
    private String construction_type_id;
    private String construction_type;
    private String structure_type_id;
    private String structure_type;
    private List<BuildingareaFirefacBean> buildingarea_firefac;

    public String getConstruction_id() {
        return construction_id;
    }

    public void setConstruction_id(String construction_id) {
        this.construction_id = construction_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress_description() {
        return address_description;
    }

    public void setAddress_description(String address_description) {
        this.address_description = address_description;
    }

    public String getLati() {
        return lati;
    }

    public void setLati(String lati) {
        this.lati = lati;
    }

    public String getLongX() {
        return longX;
    }

    public void setLongX(String longX) {
        this.longX = longX;
    }

    public String getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(String unit_id) {
        this.unit_id = unit_id;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getBuild_area() {
        return build_area;
    }

    public void setBuild_area(String build_area) {
        this.build_area = build_area;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCounty_id() {
        return county_id;
    }

    public void setCounty_id(String county_id) {
        this.county_id = county_id;
    }

    public String getShort_county() {
        return short_county;
    }

    public void setShort_county(String short_county) {
        this.short_county = short_county;
    }

    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public String getConstruction_type_id() {
        return construction_type_id;
    }

    public void setConstruction_type_id(String construction_type_id) {
        this.construction_type_id = construction_type_id;
    }

    public String getConstruction_type() {
        return construction_type;
    }

    public void setConstruction_type(String construction_type) {
        this.construction_type = construction_type;
    }

    public String getStructure_type_id() {
        return structure_type_id;
    }

    public void setStructure_type_id(String structure_type_id) {
        this.structure_type_id = structure_type_id;
    }

    public String getStructure_type() {
        return structure_type;
    }

    public void setStructure_type(String structure_type) {
        this.structure_type = structure_type;
    }

    public List<BuildingareaFirefacBean> getBuildingarea_firefac() {
        return buildingarea_firefac;
    }

    public void setBuildingarea_firefac(List<BuildingareaFirefacBean> buildingarea_firefac) {
        this.buildingarea_firefac = buildingarea_firefac;
    }

    public static class BuildingareaFirefacBean {
        /**
         * id : 01
         * type : 室内消火栓系统
         */

        private String id;
        private String type;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
