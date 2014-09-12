package com.mapabc.lbi.driver;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import com.mapabc.lbi.mapper.GridThinningMapper;
import com.mapabc.lbi.reducer.GridThinningReducer;
import com.mapabc.lbi.writable.LngLatWritable;

/**
 * 网格抽稀启动Job类
 * @author liu.xuan
 *
 */
public class GridThinningDriver extends Configured implements Tool {
	
	public static void main(String[] args) throws Exception {
		int result = ToolRunner.run(new GridThinningDriver(), args);
		System.exit(result);
	}

	@Override
	public int run(String[] args) throws Exception {
		Job job = new Job(getConf());
		job.setJarByClass(GridThinningDriver.class);
		job.setJobName("GridThinning");
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LngLatWritable.class);
		
		job.setMapperClass(GridThinningMapper.class);
		job.setReducerClass(GridThinningReducer.class);
		
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		boolean success = job.waitForCompletion(true);
		return success ? 0 : 1;
	}
}
