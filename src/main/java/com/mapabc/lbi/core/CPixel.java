package com.mapabc.lbi.core;
/**
 * 
 * 加权像素类
 * @version	1.0
 * @author liumk
 */
public class CPixel extends Pixel{
	/**
	 * 加权值
	 */
	public int z;
	/**
	 * 根据给定参数构造CPixel的新实例
	 * @param x 横向像素
	 * @param y 纵向像素
	 */
	public CPixel(int x,int y){
		super(x,y);
	}
	/**
	 * 根据给定参数构造CPixel的新实例
	 * @param x 横向像素
	 * @param y 纵向像素
	 * @param z 加权值
	 */
	public CPixel(int x,int y,int z){
		super(x,y);
		this.z=z;
	}
    public int getZ() {
        return z;
     }
    public void setZ(int z) {
        this.z = z;
     }
}
