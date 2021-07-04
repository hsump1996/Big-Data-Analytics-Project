import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class CleanNew {

	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.err.println("Usage: CleanNew <input path> <output path>");              
			System.exit(-1);
			}       
		
		Job job = new Job();
	    job.setJarByClass(CleanNew.class);
	    job.setJobName("CleanNew");
	                
	    FileInputFormat.addInputPath(job, new Path(args[0]));
	    FileOutputFormat.setOutputPath(job, new Path(args[1]));
	                
	    job.setMapperClass(CleanNewMapper.class);
	    job.setReducerClass(CleanNewReducer.class);
	                
	    job.setOutputValueClass(Text.class);
    	job.setNumReduceTasks(0);
	                
	    System.exit(job.waitForCompletion(true) ? 0 : 1);
	}       
	                
}

