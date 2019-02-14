package upf.edu.lsds2018;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;
import upf.edu.lsds2018.model.SimplifiedTweet;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

public class TwitterGames {

    public class TwitterGames {

        public static void main(String[] args){
            //Create a SparkContext to initialize
            SparkConf conf = new SparkConf().setAppName("Twitter Games");
            JavaSparkContext sparkContext = new JavaSparkContext(conf);

            // Load input
            JavaRDD<String> stringRDD = sparkContext.textFile(inputDir);
            JavaRDD<SimplifiedTweet> tweets = // transform the stringRDD

            // 2.1
            long numberOfTweets = // do something on tweets
                    System.out.println("Total tweets: " + numberOfTweets);

            // 2.2
            long numberOfOriginalTweets = // do something on tweets
                    // Transform long into float
                    System.out.println("Original tweets ratio: " + /*	value goes here */);

            // 2.3
            long uniqueUsers = // do something on tweets

                    System.out.println("Number of distinct users: " + uniqueUsers);

            // Top 10 users by followers
            JavaRDD<SimplifiedTweet> byFollowers = // do something on tweets
                    JavaRDD<SimplifiedTweet> top10Followers = // do something on the previous step

                            // Store here both outputs (the top10 and the overall list)
                            byFollowers.saveAsTextFile(outputDir + "/byFollowers");
            top10Followers.saveAsTextFile(outputDir + "/top10Followers");
        }
    }

}

