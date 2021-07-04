import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CountRecsNewReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

        @Override
        public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        	int sumvalue = 0; 
		    	for (IntWritable value : values) {
						sumvalue = Integer.sum(sumvalue, value.get()); 
		    }
		    context.write(key, new IntWritable(sumvalue)); 
                
        }
}