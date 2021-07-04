import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class CleanNewMapper extends Mapper<LongWritable, Text, Text, Text> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String s = value.toString();
      	if (s.startsWith("Sweden") || s.startsWith("Taiwan")){
          String[] line = s.split(",");

          String entity = line[0];
          String code = line[1];

          String date = line[2];
          String values = line[3];

          context.write(new Text(""), new Text(entity + "," + code + "," + date + "," + values));
        }
    }
}















            
            
            







