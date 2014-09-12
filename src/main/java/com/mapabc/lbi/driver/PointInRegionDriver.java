package com.mapabc.lbi.driver;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import com.mapabc.lbi.mapper.PointInRegionMapper;
import com.mapabc.lbi.reducer.PointInRegionReducer;

/**
 * 点在面中判断Job启动类
 * @author liu.xuan
 *
 */
public class PointInRegionDriver extends Configured implements Tool {

	@Override
	public int run(String[] args) throws Exception {
		
		Configuration conf = getConf();
		conf.set("sample.features.input", args[0]);
		conf.set("sample.features.keyattribute", "NAME");
		conf.setInt("samples.csvdata.columns.lat", 1);
		conf.setInt("samples.csvdata.columns.long", 2);
		
		Job job = new Job(conf);
		job.setJarByClass(PointInRegionDriver.class);
		job.setJobName("PointInRegion");
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		job.setMapperClass(PointInRegionMapper.class);
		job.setReducerClass(PointInRegionReducer.class);
		
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		
		FileInputFormat.setInputPaths(job, new Path(args[1]));
		FileOutputFormat.setOutputPath(job, new Path(args[2]));
		
		boolean success = job.waitForCompletion(true);
		
		return success ? 0 : 1;
	}

	public static void main(String[] args) throws Exception {
		int status = ToolRunner.run(new PointInRegionDriver(), args);
		System.exit(status);
	}
}
