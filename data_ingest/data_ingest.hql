
/* First created a directory for data sets we have found */
hdfs dfs -mkdir project1

/* Using scp, sent all the files to home directory */
scp change-visitors-parks-covid.csv hk2874@dumbo.es.its.nyu.edu:/home/hk2874
scp change-visitors-grocery-stores.csv hk2874@dumbo.es.its.nyu.edu:/home/hk2874
scp changes-residential-duration-covid.csv hk2874@dumbo.es.its.nyu.edu:/home/hk2874
scp historical_country_Taiwan_indicator_Consumer_Confidence.csv hk2874@dumbo.es.its.nyu.edu:/home/hk2874
scp historical_country_Taiwan_indicator_Consumer_Spending.csv hk2874@dumbo.es.its.nyu.edu:/home/hk2874
scp historical_country_Sweden_indicator_Consumer_Confidence.csv hk2874@dumbo.es.its.nyu.edu:/home/hk2874
scp historical_country_Sweden_indicator_Consumer_Spending.csv hk2874@dumbo.es.its.nyu.edu:/home/hk2874


/* Moving files to the hdfs project1 directory in dumbo cluster */
hdfs dfs -put historical_country_Sweden_indicator_Consumer_Spending.csv project1
hdfs dfs -put historical_country_Sweden_indicator_Consumer_Confidence.csv project1
hdfs dfs -put historical_country_Taiwan_indicator_Consumer_Spending.csv project1
hdfs dfs -put historical_country_Taiwan_indicator_Consumer_Confidence.csv project1
hdfs dfs -put changes-residential-duration-covid.csv project1
hdfs dfs -put change-visitors-grocery-stores.csv project1
hdfs dfs -put change-visitors-parks-covid.csv project1

/* Sharing HDFS files with team members using hdfs dfs -setfacl command */
hdfs dfs -setfacl -R -m default:user:gyo202:rwx /user/hk2874/project1
hdfs dfs -setfacl -R -m user:gyo202:rwx /user/hk2874/project1
hdfs dfs -setfacl -R -m default:user:sh4023:rwx /user/hk2874/project1
hdfs dfs -setfacl -R -m user:sh4023:rwx /user/hk2874/project1
hdfs dfs -getfacl /user/hk2874/project1

/* Confirmation of the access to the data and hdfs file */
hdfs dfs -ls /user/hk2874/project1
