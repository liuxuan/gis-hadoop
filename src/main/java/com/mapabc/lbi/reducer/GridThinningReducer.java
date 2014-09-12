package com.mapabc.lbi.reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import com.mapabc.lbi.writable.LngLatWritable;

public class GridThinningReducer extends Reducer<Text, LngLatWritable, Text, DoubleWritable> {

	@Override
	protected void reduce(Text key, Iterable<LngLatWritable> lnglatList,
			Reducer<Text, LngLatWritable, Text, DoubleWritable>.Context context) throws IOException,
			InterruptedException {
		
		double lngSum = 0;
		double latSum = 0;
		double wtSum = 0;
		long count = 0;
		for (LngLatWritable lnglatWritable : lnglatList) {
			double lng = lnglatWritable.getLng().get();
			double lat = lnglatWritable.getLat().get();
			double weight = lnglatWritable.getWeight().get();
			lngSum += lng;
			latSum += lat;
			wtSum += weight;
			count++;
		}
		double lngAve = lngSum / count;
		double latAve = latSum / count;
		double wtAve = wtSum / count;
		
		String lnglat = lngAve + "," + latAve;
		context.write(new Text(lnglat), new DoubleWritable(wtSum));
	}

}
