package com.mapabc.lbi.core;
import java.util.Map;
import java.util.HashMap;
public class Col {
	private String name;
	private String label;
	private int type;
	
	public Col(String name,int type){
		this.name=name;
		this.type=type;
	}
	public Col(String name,String label,int type){
		this.name=name;
		this.label=label;
		this.type=type;
	}
	public void setName(String value){
		this.name=value;
	}
	public String getName(){
		return this.name;
	}
	public void setLabel(String value){
		this.label=value;
	}
	public String getLabel(){
		return this.label;
	}	
	public void setType(int value){
		this.type=value;
	}
	public int getType(){
		return this.type;
	}
	public Map toMap(){
    	Map map=new HashMap();
		if (name != null)map.put("name",name);
		if (label != null)map.put("label",label);
		map.put("type",type);
    	return map;
    }
}
