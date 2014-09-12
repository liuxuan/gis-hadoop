package com.mapabc.lbi.core;
/**
 * 
 * 地理坐标类，该类为基础类（单位：度）。
 * <p>经纬度坐标系。</p>
 * <p>以格林尼治皇家天文台为起始经线，以赤道为起始纬线。</p>
 * @version	1.0
 * @author liumk
 */
public class LngLat {
	/**
	 * 经度
	 */	 
	public double lng;
	/**
	 * 纬度
	 */
	public double lat;	 
	
	/**
	 * 权重
	 */
	public double weights; 
	public double getWeights() {
		return weights;
	}

	public void setWeights(double weights) {
		this.weights = weights;
	}
	private Object opt_value;
	
	/**
	 * 根据给定参数构造LngLat的新实例
	 * @param x 经度
	 * @param y 纬度
	 */
	public LngLat(double x,double y){
		this.lng=x;
		this.lat=y;
	}	
	
	public LngLat(double x,double y,Object opt_value){
		this.lng=x;
		this.lat=y;
		this.opt_value = opt_value;
	}	
	
	public Object getValue() {
        return opt_value;
    }
	public void setValue(Object opt_value) {
        this.opt_value = opt_value;
    }
	
	public double getLng() {
        return lng;
     }
    public void setLng(double lng) {
        this.lng = lng;
     }
    public double getLat() {
        return lat;
     }
    public void setLat(double lat) {
        this.lat = lat;
     }
    /**
	 * 将LngLat对象转换为字符串
	 */
	public String toString(){
		return lng+","+lat;
	}
}
