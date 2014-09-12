package com.mapabc.lbi.core;
/**
 * 
 * 瓦片类，该类为基础类（单位：块）。
 * <p>地图瓦片坐标系（Tile Coordinates）单位。</p>
 * <p>瓦片坐标系以左上角为原点(0, 0)，到右下角(2 ^ 图像级别 - 1, 2 ^ 图像级别 - 1)为止。</p>
 * @version	1.0
 * @author liumk
 */
public class Tile {
	/**
	 * 横向瓦片数
	 */
	public int X;
	/**
	 * 纵向瓦片数
	 */
	public int Y;
	/**
	 * 级别
	 */
	public int level;
	
	/**
	 * 根据给定参数构造Tile的新实例
	 * @param X 横向瓦片数
	 * @param Y 纵向瓦片数
	 */
	public Tile(int X,int Y){
		this.X=X;
		this.Y=Y;
	}
	/**
	 * 根据给定参数构造Tile的新实例
	 * @param X 横向瓦片数
	 * @param Y 纵向瓦片数
	 * @param level 级别
	 */
	public Tile(int X,int Y,int level){
		this.X=X;
		this.Y=Y;
		this.level=level;
	}
	public int getX() {
        return X;
     }
    public void setX(int X) {
        this.X = X;
     }
    public int getY() {
        return Y;
     }
    public void setY(int Y) {
        this.Y = Y;
     }
    public int getLevel() {
        return level;
     }
    public void setLevel(int level) {
        this.level = level;
     }
    /**
	 * 将Tile对象转换为字符串
	 */
    public String toString(){
		return X+","+Y+","+level;
	}
}
