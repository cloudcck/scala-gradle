package cck.cloud

import org.apache.spark.scheduler.SparkListener
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by cloudchan on 15/03/2017.
  */
object App {
  def main(args: Array[String]): Unit = {
    val spark_home = System.getenv("SPARK_HOME")
    println(spark_home)
    val logFile = "/opt/spark/README.md"
    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println(s"Lines with a : $numAs, Lines with b : $numBs")
  }
}
