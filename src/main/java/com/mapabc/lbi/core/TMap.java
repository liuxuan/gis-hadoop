package com.mapabc.lbi.core;
/**
 * 
 * 地图类
 * @version	1.0
 * @author liumk
 */
public class TMap {
	/**
	 * 
	 * 测距
	 * 
	 * @param a	经纬度坐标1
	 * @param b	经纬度坐标2
	 * @return 距离(米)
	 */
	public static double getDistance(LngLat a,LngLat b){
    	double c=a.lat*Math.PI/180;
    	double d=b.lat*Math.PI/180;
    	double dis=(Math.asin(Math.sqrt(Math.pow(Math.sin((c-d)/2),2)+Math.cos(c)*Math.cos(d)*Math.pow(Math.sin((a.lng-b.lng)*Math.PI/180/2),2)))*12756274);
    	//dis=dis/1000;	//换算为公里
    	return dis;
    }
	/**
	 * 
	 * 根据偏移距离计算经纬度
	 * <p>根据原始点经纬度坐标、偏移量，计算偏移后的经纬度坐标	</p>
	 * @param pt	经纬度坐标
	 * @param w	东西方向的偏移量，向东为正，向西为负，单位：米
	 * @param s	南北方向的偏移量，向北为正，向南为负，单位：米
	 * @return 经纬度坐标
	 */
	public static LngLat getLngLatByOffset(LngLat pt,double w,double s){
    	double x,y;    	
    	x=pt.lng+Math.asin(Math.sin(Math.round(w)/12756274.0)/Math.cos(pt.lat*Math.PI/180))*360/Math.PI;
    	y=pt.lat+Math.asin(Math.round(s)/12756274.0)*360/Math.PI;
    	return  new LngLat(x,y);
    }
	/**
	 * 
	 * 经纬度转墨卡托坐标
	 * @param pt	经纬度坐标
	 * @return 墨卡托坐标
	 */
	public static SPoint lonLat2Mercator(LngLat lonLat){
		double x = lonLat.lng * 20037508.34 / 180;
        double M_PI = Math.PI;
        double y = Math.log(Math.tan((90 + lonLat.lat) * M_PI / 360)) / (M_PI / 180);
        y = y * 20037508.34 / 180;
        SPoint mercator = new SPoint(x, y);
        return mercator;
	}
	/**
	 * 
	 * 墨卡托坐标转经纬度
	 * @param mercator 墨卡托坐标
	 * @return 经纬度
	 */
	public static LngLat Mercator2lonLat(SPoint mercator){
		double x = mercator.X / 20037508.34 * 180;
        double y = mercator.Y / 20037508.34 * 180;
        double M_PI = Math.PI;
        y = 180 / M_PI * (2 * Math.atan(Math.exp(y * M_PI / 180)) - M_PI / 2);
        LngLat lonLat = new LngLat(x, y);
        return lonLat;
	}
	
	public static void main(String args[]){
		SPoint p=new SPoint(1.001875417139462E7,1.5028131257091936E7);
		LngLat l=Mercator2lonLat(p);
		System.out.println(l.lat+","+l.lng);
		//73.265915  135.242
		//3.409029   53.5539
		//66.51326044810476,45.00000000626406
		//79.17133464435,90.00000001252808
		
	}
}
