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
 * 行政区划编码类。
 * date: 2013-5-30下午5:36:46 
 * @version	1.0
 * @author liumk
 */

public class Code {
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 行政区级别
	 */
	private int grade;
	/**
	 * 根据给定参数构造Code的新实例
	 * @param name 行政区名称
	 * @param code 行政区划编码
	 */
	public Code(String name,String code){
		this.name=name;
		this.code=code;
	}
	/**
	 * 根据给定参数构造Code的新实例
	 * @param name 行政区名称
	 * @param code 行政区划编码
	 * @param grade 行政区级别
	 */
	public Code(String name,String code,int grade){
		this.name=name;
		this.code=code;
		this.grade=grade;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getCode(){
		return code;
	}
	
	public void setCode(String code){
		this.code=code;
	}
	
	public int getGrade(){
		return grade;
	}
	
	public void setGrade(int grade){
		this.grade=grade;
	}
}
