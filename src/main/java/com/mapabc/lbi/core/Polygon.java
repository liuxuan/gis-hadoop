package com.mapabc.lbi.core;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
/**
 * 
 * 多边形类。
 * @version	1.0
 * @author liumk
 */
public class Polygon {
	/**
	 * 路径。点集合
	 */
	private List<LngLat> Path;
	
	private final static double EarthRadius = 6378137;
	/**
	 * 根据给定参数构造Polygon的新实例
	 * @param path 路径点数组
	 */
	public Polygon(List<LngLat> path){
		this.Path = path;
	}
	public List<LngLat> getPath() {
		return Path;
	}
    public void setPath(List<LngLat> path) {
        this.Path = path;
	}
    /**
	 * 获取多边形中心坐标
	 * @return 中心坐标
	 */
    public LngLat getCenter() {
    	LngLat cenPT=null;
    	double minX=0,minY=0,maxX=0,maxY=0;
    	double cenX=0,cenY=0;
    	for(int i=0;i<Path.size();i++){
    		LngLat pt=Path.get(i);
    		double fx=pt.lng;
    		double fy=pt.lat;
    		if(i==0){
    			maxX=minX=fx;
    			maxY=minY=fy;
    		}
    		if(fx<minX)minX=fx;
    		if(fx>maxX)maxX=fx;
    		if(fy<minY)minY=fy;
    		if(fy>maxY)maxY=fy;
    	}
    	cenX=(minX+maxX)/2;
    	cenY=(minY+maxY)/2;
    	cenPT=new LngLat(cenX,cenY);     	
    	return cenPT;
    }
    /**
   	 * 获取外接矩形
   	 * @return 外接矩形
   	 */
    public Bounds getBounds() {
    	Bounds bounds=null;
    	double minX=0,minY=0,maxX=0,maxY=0;
    	for(int i=0;i<Path.size();i++){
    		LngLat pt=Path.get(i);
    		double fx=pt.lng;
    		double fy=pt.lat;
    		if(i==0){
    			maxX=minX=fx;
    			maxY=minY=fy;
    		}
    		if(fx<minX)minX=fx;
    		if(fx>maxX)maxX=fx;
    		if(fy<minY)minY=fy;
    		if(fy>maxY)maxY=fy;
    	}
    	LngLat sw=new LngLat(minX,minY);
    	LngLat ne=new LngLat(maxX,maxY);
    	bounds=new Bounds(sw,ne);
		return bounds;
	}
    /**
   	 * 获取多边形面积
   	 * @return 面积。单位：平方米
   	 */
    public double getArea() {
    	double a=EarthRadius*Math.PI/180;
    	double b=0;
    	int d=Path.size();
    	int i=0;
    	if(d<3)return 0;
    	for(i=0;i<d-1;i++){
    		LngLat e=Path.get(i);
    		LngLat f=Path.get(i+1);
    		b+=e.lng*a*Math.cos(e.lat*Math.PI/180)*f.lat*a-f.lng*a*Math.cos(f.lat*Math.PI/180)*e.lat*a;
    	}
    	LngLat pt1=Path.get(i);
    	LngLat pt2=Path.get(0);
    	b+=pt1.lng*a*Math.cos(pt1.lat*Math.PI/180)*pt2.lat*a-pt2.lng*a*Math.cos(pt2.lat*Math.PI/180)*pt1.lat*a;
    	//保留小数点后两位
    	BigDecimal bd = new BigDecimal(0.5*Math.abs(b)); 
    	double area = bd.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    	return area;
    }
    /**
   	 * 判断多边形是否包含此点。
   	 * <p>射线法判断点q与多边形polygon的位置关系，要求polygon为简单多边形，顶点逆时针排列</p>
   	 * <p>如果点在多边形内： 返回0</p>
   	 * <p>如果点在多边形边上： 返回1</p>
   	 * <p>如果点在多边形外： 返回2</p>
   	 * @return 返回值
   	 */
    public int contains(LngLat point){
    	int n = Path.size();
    	int count = 0;
    	LineSegment line = new LineSegment(point,new LngLat(INFINITY,point.lat));
    	for( int i = 0; i < n; i++ ) {
    		// 得到多边形的一条边
    		LngLat pt1 = Path.get(i);
    		LngLat pt2 = Path.get((i + 1) % n);
    		LineSegment side = new LineSegment(pt1,pt2);
    		if(IsOnline(point, side)) {
    	        return 1 ;
    	    }
    		// 如果side平行x轴则不作考虑
    		if( Math.abs(side.pt1.lat - side.pt2.lat) < ESP ) {
    	        continue;
    	    }
    		if( IsOnline(side.pt1, line) ) {
    	        if( side.pt1.lat > side.pt2.lat ) count++;
    	    } else if( IsOnline(side.pt2, line) ) {
    	        if( side.pt2.lat > side.pt1.lat ) count++;
    	    } else if( Intersect(line, side) ) {
    	        count++;
    	    }
    	}
    	
    	if ( count % 2 == 1 ) 
	    {
	    	return 0;
	    }
	    else 
	    {
	    	return 2;
	    }

	}
    
    private double INFINITY = 1e10;
    private double ESP = 1e-5;
//    private int MAX_N = 1000;
	// 计算叉乘 |P0P1| × |P0P2|
    private double Multiply(LngLat p1, LngLat p2, LngLat p0){
	    return ( (p1.lng - p0.lng) * (p2.lat - p0.lat) - (p2.lng - p0.lng) * (p1.lat - p0.lat) );
	}
	// 判断线段是否包含点point
	private boolean IsOnline(LngLat point, LineSegment line)
	{
	    return( ( Math.abs(Multiply(line.pt1, line.pt2, point)) < ESP ) &&
	    ( ( point.lng - line.pt1.lng ) * ( point.lng - line.pt2.lng ) <= 0 ) &&
	    ( ( point.lat - line.pt1.lat ) * ( point.lat - line.pt2.lat ) <= 0 ) );
	}	
	private boolean Intersect(LineSegment L1, LineSegment L2)
	{
	    return( (Math.max(L1.pt1.lng, L1.pt2.lng) >= Math.min(L2.pt1.lng, L2.pt2.lng)) &&
	    (Math.max(L2.pt1.lng, L2.pt2.lng) >= Math.min(L1.pt1.lng, L1.pt2.lng)) &&
	    (Math.max(L1.pt1.lat, L1.pt2.lat) >= Math.min(L2.pt1.lat, L2.pt2.lat)) &&
	    (Math.max(L2.pt1.lat, L2.pt2.lat) >= Math.min(L1.pt1.lat, L1.pt2.lat)) &&
	    (Multiply(L2.pt1, L1.pt2, L1.pt1) * Multiply(L1.pt2, L2.pt2, L1.pt1) >= 0) &&
	    (Multiply(L1.pt1, L2.pt2, L2.pt1) * Multiply(L2.pt2, L1.pt2, L2.pt1) >= 0)
	    );
	}

	 
    public static void main(String[] args){
    	List<LngLat> path = new ArrayList<LngLat>();
    	LngLat pt1=new LngLat(116.48646582,40.01069427);
    	LngLat pt2=new LngLat(116.61830176,40.06116378);
    	LngLat pt3=new LngLat(116.69795264,39.92649544);
    	LngLat pt4=new LngLat(116.5963291,39.8527364);
    	LngLat pt5=new LngLat(116.50843848,39.90964323);
    	LngLat pt6=new LngLat(116.50843848,39.90964323);
    	path.add(pt1);
    	path.add(pt2);
    	path.add(pt3);
    	path.add(pt4);
    	path.add(pt5);
    	path.add(pt6);
    	LngLat checkpoint=new LngLat(116.5963291,39.8727364);
    	Polygon pg = new Polygon(path);
    	int m = pg.contains(checkpoint);
    	System.out.println("========="+m);
    }
}
