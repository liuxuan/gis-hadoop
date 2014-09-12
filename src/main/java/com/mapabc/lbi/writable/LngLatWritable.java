package com.mapabc.lbi.writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparable;

public class LngLatWritable implements WritableComparable<LngLatWritable> {
	
	private DoubleWritable lng;
	private DoubleWritable lat;
	private DoubleWritable weight;

	public DoubleWritable getLng() {
		return lng;
	}

	public void setLng(DoubleWritable lng) {
		this.lng = lng;
	}

	public DoubleWritable getLat() {
		return lat;
	}

	public void setLat(DoubleWritable lat) {
		this.lat = lat;
	}
	
	public DoubleWritable getWeight() {
		return weight;
	}

	public void setWeight(DoubleWritable weight) {
		this.weight = weight;
	}

	public LngLatWritable() {
		set(new DoubleWritable(), new DoubleWritable(), new DoubleWritable());
	}
	
	public void set(DoubleWritable lng, DoubleWritable lat, DoubleWritable weight) {
		this.lng = lng;
		this.lat = lat;
		this.weight = weight;
	}
	
	public void readFields(DataInput in) throws IOException {
		lng.readFields(in);
		lat.readFields(in);
		weight.readFields(in);
	}

	public void write(DataOutput out) throws IOException {
		lng.write(out);
		lat.write(out);
		weight.write(out);
	}

	public int compareTo(LngLatWritable lnglatWritable) {
		int cmp = weight.compareTo(lnglatWritable.getWeight());
		return cmp;
	}

}
