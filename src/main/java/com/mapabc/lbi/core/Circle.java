package com.mapabc.lbi.core;

import java.math.BigDecimal;
/**
 * 
 * 圆类，它的实例为圆形覆盖物。
 * @version	1.0
 * @author liumk
 */
public class Circle {
	/**
	 * 中心坐标
	 */
	private LngLat cenPT=null;
	/**
	 * 半径
	 */
	private double radius;
	/**
	 * 根据给定参数构造Circle的新实例
	 * @param cent 中心坐标
	 * @param radius 半径，单位为米
	 */
	public Circle(LngLat cent,double radius){
		this.cenPT=cent;
		this.radius=radius;
	}
	/**
	 * 获取中心坐标
	 * @return 中心坐标
	 */
	public LngLat getCenter() {
		return cenPT;
	}
	/**
	 * 设置中心坐标
	 * @param cent 中心坐标
	 */
    public void setCenter(LngLat cent) {
        this.cenPT = cent;
	}
    /**
	 * 获取圆半径
	 * @return 半径
	 */
    public double getRadius() {
		return radius;
	}
    /**
	 * 设置圆半径
	 * @param radius 半径，单位为米
	 */
    public void setRadius(double radius) {
        this.radius = radius;
	}
    /**
   	 * 获取外接矩形
   	 * @return 外接矩形
   	 */
    public Bounds getBounds() {
    	Bounds bounds=null;
    	LngLat sw=TMap.getLngLatByOffset(cenPT, -radius, -radius);
    	LngLat ne=TMap.getLngLatByOffset(cenPT, radius, radius);
    	bounds=new Bounds(sw,ne);
		return bounds;
    }    
    /**
   	 * 获取圆面积
   	 * @return 面积。单位：平方米
   	 */
    public double getArea() {
    	double b=Math.PI*Math.pow(this.radius,2);
    	//保留小数点后两位
    	BigDecimal bd = new BigDecimal(b); 
    	double area = bd.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    	return area;
    }
    /**
   	 * 判断圆是否包含此点。
   	 * <p>如果点在圆内： 返回0</p>
   	 * <p>如果点在圆边上： 返回1</p>
   	 * <p>如果点在圆外： 返回2</p>
   	 * @return 返回值
   	 */
    public int contains(LngLat pt){
    	double len=TMap.getDistance(cenPT, pt);
    	if(len<radius){
    		return 0;
    	}else if(len==radius){
    		return 1;
    	}else{
    		return 2;
    	}
    }
}
