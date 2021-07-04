import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class CleanMapper extends Mapper<LongWritable, Text, Text, Text> {



    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String s = value.toString();
      	if (!s.startsWith("Country")){
          String[] line = s.split(",");

          String country = line[0];
          String category =line[1];

          String date_time = line[2];
          String data_value = line[3];
          String frequency = line[4];

          context.write(new Text("Country, Category, Date, Value, Frequency"),new Text(country + "," + category + "," + date_time + "," + data_value + "," + frequency));
        }
    }
}