# README file
# final, working analytic


# Project Topic
Do governmental regulations regarding COVID-19 affect people’s spending habits and outdoor activities? 



# ​Project Description
The primary goal of this application is to determine whether contrasting governmental guidelines influence the public's expenditures on food, clothing, shelter, and cultural life. 
In order to validate the hypothesis, we will choose two countries that are using radically different government policies. 
For example, Sweden is one of the countries in which the government imposes “herd immunity” strategy. 
Herd immunity is a strategy that lets society return to normal and expect a certain percentage of the population to become immune to the virus in the future. 
Taiwan, on the other hand, is an example of a country where the government imposes very strict rules and regulations on the public. 
By examining people’s economic activities and mobility data from these two countries, we expect to gain insight about people’s spending habits and perceptions about Coronavirus.



# Who will benefit from your analytic?
Groups that potentially can benefit from our analytics are primarily government, private businesses, economists, industry groups, and non-governmental organizations that have an interest in consumption patterns.



# What insight will you derive from the data?
We will figure out changes in people’s spending habits by comparing pre-coronavirus data sets and post-coronavirus data sets of living expenses in Sweden where people’s lifestyles are not restricted by their government. From those changes, we will be able to compare the same data sets from other countries where the government imposes strict regulations on Covid-19. By doing so, we will gain insights of correlations between governmental regulations and peoples’ spending habits.
5. Describe how you will check the goodness of the analytic. i.e., why do you believe that the results are accurate and can be trusted?
First, population, subject, location, and time slot in the dataset should be carefully examined to maintain the integrity of data. Second, in order to efficiently use the data, not only we go over the reliability of the data itself but also validate data before processing by checking data types, ranges, null values, redundancy, and the format. Moreover, we will make use of various kinds of visual graphs to better analyze the results with inclusion of criteria of time. Lastly, measuring bias and variance could be applied to assess the generalizability of the result.



# Data Schema & Data Source
## About the Data
    1. Name / Title: Historical Consumer_Confidence, Consumer_Spending data (1980-2020)
    2. Link to Data: https://tradingeconomics.com/ 
    3. Source / Origin: 
        * Author or Creator: research center for taiwan economic development, National institute of economic research
        * Publication Date: 
        * Publisher: tradingeconomics
    4: Raw data sets we are using
        historical_country_Taiwan_indicator_Consumer_Confidence.csv
        historical_country_Taiwan_indicator_Consumer_Spending.csv
        historical_country_Sweden_indicator_Consumer_Confidence.csv
        historical_country_Sweden_indicator_Consumer_Spending.csv

    1. Name / Title: Google Mobility Data 
    2. Link to Data: https://ourworldindata.org/covid-mobility-trends 
    3. Source / Origin: 
        * Author or Creator: Google
        * Publication Date: 
        * Publisher: our world in data
        * Version or Data Accessed: 
    4. Raw data sets we are using
        Change-visitors-parks-covid.csv
        Changes-residential-duration-covid.csv
        Change-visitors-grocery-stores.csv



# Code and commands for data ingestion in a /data_ingest directory 
    Codes, commands in Big_Data_Project/data_ingest.hql
    Output all inside "Code or Steps for Data Ingest(update).pdf"
    hdfs dfs -ls /user/hk2874/project1


# ETL/cleaning code in a /etl_code directory
## Notation. 
    Before we added mobility data, we only had 6 tables.
    GDP, consumer_spending, consumer confidence data for each Taiwan and Sweden. We cleaned data through files below.
    CountRecs.java 
    CountRecsReducer.java 
    Clean.java 
    CleanReducer.java 
    CountRecsMapper.java 
    CleanMapper.java 

    Then, we dropped GDP data from our analysis and added google mobility data. For the mobiilty data, we used codes below to clean tables. 
    CountRecsNew.java 
    CountRecsNewReducer.java 
    CleanNew.java 
    CleanNewReducer.java 
    CountRecsNewMapper.java 

## Location.  Dumbo Hadoop /user/hk2874/project1/ 

## Commands for opening CLEANED Google Mobility Data 
    hdfs dfs -cat /user/hk2874/project1/output_residentalN/part-m-00000 
    hdfs dfs -cat /user/hk2874/project1/output_parksN/part-m-00000 
    hdfs dfs -cat /user/hk2874/project1/output_grocN/part-m-00000 

## Commands for counting rows result >> DESIRED NUMBER OF ROWS (correct)  
    hdfs dfs -cat /user/hk2874/project1/count_inputgroc/part-r-00000  >>line	36329
    hdfs dfs -cat /user/hk2874/project1/count_outputgroc/part-r-00000 >>line	564

    hdfs dfs -cat /user/hk2874/project1/count_inputpark/part-r-00000 >>line	36140
    hdfs dfs -cat /user/hk2874/project1/count_outputpark/part-r-00000 >>line	564

    hdfs dfs -cat /user/hk2874/project1/count_inputres/part-r-00000 >>line	36205
    hdfs dfs -cat /user/hk2874/project1/count_outputres/part-r-00000 >>line	564

## Commands MapReduce count 
    hadoop jar countNew.jar CountRecsNew /user/hk2874/project1/change-visitors-grocery-stores.csv /user/hk2874/project1/count_inputgroc
    hadoop jar countNew.jar CountRecsNew /user/hk2874/project1/output_grocN/part-m-00000 /user/hk2874/project1/count_outputgroc

    hadoop jar countNew.jar CountRecsNew /user/hk2874/project1/change-visitors-parks-covid.csv /user/hk2874/project1/count_inputpark
    hadoop jar countNew.jar CountRecsNew /user/hk2874/project1/output_parksN/part-m-00000 /user/hk2874/project1/count_outputpark
    
    hadoop jar countNew.jar CountRecsNew /user/hk2874/project1/changes-residential-duration-covid.csv /user/hk2874/project1/count_inputres
    hadoop jar countNew.jar CountRecsNew /user/hk2874/project1/output_residentalN/part-m-00000 /user/hk2874/project1/count_outputres


# Test Codes, Source codes, Analytic running ... 
We used Hive for Analytic and put input txt files in each of our directory to create tables 
    user/own_net_id/any_own_input_dir/SW_CC.txt
    user/own_net_id/any_own_input_dir/SW_CS.txt
    user/own_net_id/any_own_input_dir/TW_CC.txt
    user/own_net_id/any_own_input_dir/TW_CS.txt
    user/own_net_id/sweden_groc_input/sweden_groc.txt
    user/own_net_id/sweden_parks_input/sweden_parks.txt
    user/own_net_id/sweden_res_input/sweden_res.txt
    user/own_net_id/taiwan_groc_input/taiwan_groc.txt
    user/own_net_id/taiwan_parks_input/taiwan_parks.txt
    user/own_net_id/taiwan_res_input/taiwan_res.txt

used Big_Data_Project/ana_code/analytics.hql to run analytics (On Hive, we ran queries/codes line by line)

# Summary 
# Describe your directories and files, how to build your code, how to run your code , where to find results of a run, where we can find the input data that you used.
    - Working directories: 
        hdfs dfs ls -/user/hk2874/project1/
        Big_Data_Project 
    - location of input data: 
        1) Raw Input directory
            hdfs /user/hk2874/project1
            Big_Data_Project/raw_data_files
        2) After Data Cleaning: 
            hdfs /user/hk2874/project1/output_residentalN/part-m-00000 
            hdfs /user/hk2874/project1/output_parksN/part-m-00000 
            hdfs /user/hk2874/project1/output_grocN/part-m-00000 
            Big_Data_Project/input_files
        2) Inputs for Hive 
            Big_Data_Project/input_files
    - build code: ana_code/analytics.hql
    - where to find results: 
        ana_code/"HW11_additional_codes_and_its_output1.pdf"
        ana_code/"HW11_additional_codes_and_its_output1.pdf"
        + screenshots




