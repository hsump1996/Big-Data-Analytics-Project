import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class CountRecsNewMapper extends Mapper<LongWritable, Text, Text, IntWritable> {


    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
	    String s = value.toString();
      	if (!s.startsWith("Entity")){
          context.write(new Text("line"), new IntWritable(1));
        }
    }
}