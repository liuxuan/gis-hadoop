package com.mapabc.lbi.mapper;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Mapper;
import com.mapabc.lbi.writable.LngLatWritable;

public class GridThinningMapper extends
		Mapper<LongWritable, Text, Text, LngLatWritable> {

	private int lngIndex = 0;
	private int latIndex = 1;
	private int weightIndex = -1;
	private double gridWidth = 0.0015;

	@Override
	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, Text, LngLatWritable>.Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		String[] val = line.split(",");

		double lng = Double.parseDouble(val[lngIndex]);
		double lat = Double.parseDouble(val[latIndex]);
		double weight = 0;
		if (weightIndex == -1) {
			weight = 1;
		} else {
			weight = Double.parseDouble(val[weightIndex]);
		}

		long x = (long) Math.ceil(lng / gridWidth);
		long y = (long) Math.ceil(lat / gridWidth);

		String gridKey = String.valueOf(x) + "_" + String.valueOf(y);

		LngLatWritable lnglatWritable = new LngLatWritable();
		DoubleWritable lngWritable = new DoubleWritable(lng);
		DoubleWritable latWritable = new DoubleWritable(lat);
		DoubleWritable weightWritable = new DoubleWritable(weight);
		lnglatWritable.setLng(lngWritable);
		lnglatWritable.setLat(latWritable);
		lnglatWritable.setWeight(weightWritable);

		context.write(new Text(gridKey), lnglatWritable);
	}

}
