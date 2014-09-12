/**
 * File Name:Point.java
 * Package Name:com.autonavi.map
 * Date:2013-6-13上午10:41:57
 * Copyright (c) 2013,keykeywu@qq.com All rights reserved
 * 
 */
package com.mapabc.lbi.core;

/**            
 * 点坐标类，该类为基础类.        
 * date: 2013-6-13上午10:41:57 <br/>            
 * @author mingkai.liu   
 * @version 1.0                        
 */
public class SPoint {
	/**
	 * X坐标
	 */	 
	public double X;
	/**
	 * Y坐标
	 */
	public double Y;
	/**
	 * 根据给定参数构造Point的新实例
	 * @param x X坐标
	 * @param y Y坐标
	 */
	public SPoint(double x,double y){
		this.X=x;
		this.Y=y;
	}	
}
