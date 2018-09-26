package com.jawg.electricalshow.utils;

/**
 * url常量类
 */
public interface Url {

    String HOME_IP = "http://dndzl.cn/newStart/";//主机地址
    String GET_DEVICE_LIST=HOME_IP+"mitu_select.php";//获取设备列表
    String DELATE_MITU_DEVICE=HOME_IP+"delete_mitu.php";//删除单条设备
    String UPLOAD_DEVICE_ID=HOME_IP+"t_rtu_produce.php?mitu_id=";//上传设备编号
    String GET_DEVICE_TYPE=HOME_IP+"fac_device_type.php";//获取设备类型
    String GET_PER_MITU_INFO=HOME_IP+"getPerMituInfo.php?mitu_id=";//获取设备实时信息
    String GET_CITY_LIST=HOME_IP+"true_false.php";//获取城市列表
    String GET_CONSTRICTION_LIST=HOME_IP+"getConstructionList.php?cityID=";//获得建筑物列表
    String GET_CONSTRUCTION_INFO=HOME_IP+"construction_id.php?construction_id=";//获取建筑物信息

}
