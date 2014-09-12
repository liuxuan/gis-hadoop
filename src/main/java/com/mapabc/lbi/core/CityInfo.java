/**
 * MAPABC Co.2008
 */
package com.mapabc.lbi.core;

/**
 * 城市信息表
 * 
 * @author liumk
 * @version 1.0
 */
public class CityInfo {
	/*
	 * 行政区划编码
	 */
	public String code;
	/*
	 * 城市名称
	 */
	public String name;
	/*
	 * 行政级别
	 */
	public int grade;
	/*
	 * 中心经度
	 */
	public double x;
	/*
	 * 中心纬度
	 */
	public double y;
	/*
	 * 缩放级别
	 */
	public int level;
	/*
	 * 最小经度
	 */
	public double minx;
	/*
	 * 最小纬度
	 */
	public double miny;
	/*
	 * 最大经度
	 */
	public double maxx;
	/*
	 * 最大纬度
	 */
	public double maxy;
	/*
	 * 面积
	 */
	public double area;

	public CityInfo(String code, String name) {
		this.code = code;
		this.name = name;		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}

	public void setArea(double area) {
		this.area = area;
	}
	public double getArea() {
		return area;
	}

	public void setName(String name) {
		this.name = name;
	}

}
