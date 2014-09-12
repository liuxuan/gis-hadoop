package com.mapabc.lbi.core;
/**
 * 
 * 网格类
 * @version	1.0
 * @author liumk
 */
public class Grid {
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 值
	 */
	private double val;
	/**
	 * 矩形对象
	 */
	private Bounds bounds;

	private String count;
	
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}

	/**
	 * 根据给定参数构造Grid的新实例
	 * @param sw 矩形西南角经纬度坐标
	 * @param ne 矩形东北角经纬度坐标
	 */
	public Grid(LngLat sw,LngLat ne){
		this.bounds=new Bounds(sw,ne);
	}
	/**
	 * 根据给定参数构造Grid的新实例
	 * @param XN 网格X坐标
	 * @param YN 网格Y坐标
	 * @param sideLen 网格边长
	 */
	public Grid(long XN,long YN,long sideLen){
		this.code=XN+"_"+YN;
		SPoint swPt=new SPoint((XN-1)*sideLen,(YN-1)*sideLen);
		SPoint nePt=new SPoint(XN*sideLen,YN*sideLen);
		LngLat sw=TMap.Mercator2lonLat(swPt);
		LngLat ne=TMap.Mercator2lonLat(nePt);
		this.bounds=new Bounds(sw,ne);
	}
	/**
	 * 根据给定参数构造Grid的新实例
	 * @param bounds 矩形对象
	 */
	public Grid(Bounds bounds){
		this.bounds=bounds;
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
	
	public double getVal(){
		return val;
	}
	
	public void setVal(double val){
		this.val=val;
	}
	
	public Bounds getBounds(){
		return this.bounds;
	}
	
	/**
	 * 将Grid对象转换为字符串
	 */
	public String toString(){
		return bounds.southwest.lng+","+bounds.southwest.lat+","+bounds.northeast.lng+","+bounds.northeast.lat;
	}
	/**
	 * 判断目标矩形区域是否包含此点
	 */
	public boolean contains(LngLat pt){
		if(pt.lng>=bounds.southwest.lng && pt.lng<=bounds.northeast.lng && pt.lat>=bounds.southwest.lat&& pt.lat<=bounds.northeast.lat)return true;
		return false;
	}
}
