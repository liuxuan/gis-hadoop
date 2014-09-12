package com.mapabc.lbi.core;

/**
 * 
 * 范围类。
 * @version	1.0
 * @author liumk
 */
public class Range {
	/**
	 * 最小值
	 */
	private double min;
	/**
	 * 最大值
	 */
	private double max;
	/**
	 * 根据给定参数构造Range的新实例
	 * @param minVal 最小值
	 * @param maxVal 最大值
	 */
	public Range(int minVal,int maxVal){
		this.min=minVal;
		this.max=maxVal;
	}
	/**
	 * 根据给定参数构造Range的新实例
	 * @param minVal 最小值
	 * @param maxVal 最大值
	 */
	public Range(String minVal,String maxVal){
		this.min=Double.parseDouble(minVal);
		this.max=Double.parseDouble(maxVal);
	}
	/**
	 * 根据给定参数构造Range的新实例
	 * @param minVal 最小值
	 * @param maxVal 最大值
	 */
	public Range(double minVal,double maxVal){
		this.min=minVal;
		this.max=maxVal;
	}
	public void setMin(double value){
		min=value;
	}
	public void setMin(String value){
		this.min=Double.parseDouble(value);
	}
	public double getMin(){
		return this.min;
	}
	public void setMax(double value){
		max=value;
	}
	public void setMax(String value){
		this.max=Double.parseDouble(value);
	}
	public double getMax(){
		return this.max;
	}
	/**
	 * 用分隔符将Range对象转换为字符串
	 * @param split 分隔符
	 */
	public String join(String split){
		String msg=null;
		if(min==max){
			if(min==(int)min)msg=String.valueOf((int)min);
			else msg=String.valueOf(min);
		}else{
			if(min==(int)min)msg=String.valueOf((int)min);
			else msg=String.valueOf(min);
			if(max==(int)max)msg+=split+String.valueOf((int)max);
			else msg+=split+String.valueOf(max);			
		}
		return msg;
	}
	/**
	 * 将Range对象转换为字符串
	 */
	public String toString(){
		return "min:"+min+";max:"+max;		
	}
}
