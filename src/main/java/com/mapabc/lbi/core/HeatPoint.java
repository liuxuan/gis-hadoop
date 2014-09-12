package com.mapabc.lbi.core;
/**
 * 
 * 热点类
 * @version	1.0
 * @author liumk
 */
public class HeatPoint extends Pixel{
	/**
	 * 亮度
	 */
	public int intensity;
	/**
	 * 根据给定参数构造HeatPoint的新实例
	 * @param x 横向像素
	 * @param y 纵向像素
	 * @param intensity 亮度
	 */
	public HeatPoint(int x,int y,int intensity){
		super(x,y);
		this.intensity=intensity;
	}
    public int getIntensity() {
        return intensity;
     }
    public void setIntensity(int intensity) {
        this.intensity = intensity;
     }
}
