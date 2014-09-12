/**
 * File Name:Bounds.java
 * Package Name:com.autonavi.map
 * Date:2013-5-29下午2:53:05
 * Copyright (c) 2013,keykeywu@qq.com All rights reserved
 * 
 */
package com.mapabc.lbi.core;


/**
 * 
 * 经纬度坐标矩形区域类。
 * <p>通过矩形的西南、东北角经纬度坐标，确定经纬度范围。此类为基础类。</p>
 * @version	1.0
 * @author liumk
 */
public class Bounds {
	/**
	 * 矩形西南角经纬度坐标
	 */
	public LngLat southwest;
	/**
	 * 矩形东北角经纬度坐标
	 */
	public LngLat northeast;
	/**
	 * 根据给定参数构造Bounds的新实例
	 * @param bboxs 边框角(西南和东北)字符串
	 */
	public Bounds(String bboxs){
		String[] bbox=bboxs.split(",");
    	double minx=Double.parseDouble(bbox[0]);
    	double miny=Double.parseDouble(bbox[1]);
    	double maxx=Double.parseDouble(bbox[2]);
    	double maxy=Double.parseDouble(bbox[3]);
		this.southwest=new LngLat(minx,miny);
		this.northeast=new LngLat(maxx,maxy);
	}
	/**
	 * 根据给定参数构造Bounds的新实例
	 * @param sw 矩形西南角经纬度坐标
	 * @param ne 矩形东北角经纬度坐标
	 */
	public Bounds(LngLat sw,LngLat ne){
		this.southwest=sw;
		this.northeast=ne;
	}
	/**
	 * 根据给定参数构造Bounds的新实例
	 * @param sw 矩形西南角经纬度坐标
	 * @param ne 矩形东北角经纬度坐标
	 */
	public Bounds(double x1,double y1,double x2,double y2){
		this.southwest=new LngLat(x1,y1);
		this.northeast=new LngLat(x2,y2);
	}
	/**
	 * 获取矩形中心坐标
	 * @return 中心坐标
	 */
	public LngLat getCenter() {
		double lng=(southwest.lng+northeast.lng)/2;
		double lat=(southwest.lat+northeast.lat)/2;
		return new LngLat(lng,lat);
	}
	/**
	 * 将Bounds对象转换为字符串
	 */
	public String toString(){
		return southwest.lng+","+southwest.lat+","+northeast.lng+","+northeast.lat;
	}
	/**
	 * 判断目标矩形区域是否包含此点
	 */
	public boolean contains(LngLat pt){
		if(pt.lng>=southwest.lng && pt.lng<=northeast.lng && pt.lat>=southwest.lat&& pt.lat<=northeast.lat)return true;
		return false;
	}
}
