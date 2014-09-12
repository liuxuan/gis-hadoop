/**
 * File Name:Code.java
 * Package Name:com.autonavi.map
 * Date:2013-5-30下午5:36:46
 * Copyright (c) 2013,keykeywu@qq.com All rights reserved
 * 
 */
package com.mapabc.lbi.core;
/**
 * 
 * 颜色编码类。
 * date: 2013-5-30下午5:36:46 
 * @version	1.0
 * @author liumk
 */

public class ColorCode {
	/**
	 * 颜色值
	 */
	public String color;
	/**
	 * 行政区划编码
	 */
	public String code;
	/**
	 * 行政区名称
	 */
	public String name;
	
	/**
	 * 根据给定参数构造ColorCode的新实例
	 * @param color 颜色值
	 * @param code 行政区划编码
	 */
	public ColorCode(String color,String code){
		this.color=color;
		this.code=code;
	}
	
	public String getColor(){
		return color;
	}
	
	public void setColor(String color){
		this.color=color;
	}
	
	public String getCode(){
		return code;
	}
	
	public void setCode(String code){
		this.code=code;
	}	
}
