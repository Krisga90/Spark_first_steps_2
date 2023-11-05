import org.apache.spark.{SparkConf, SparkContext}

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

object AsyncTask extends App{

  val conf = new SparkConf().setAppName("Sesion8").setMaster("local[*]")
  val sc = new SparkContext(conf)

  val rdd1 = sc.parallelize(List(1, 2, 3, 4, 5, 6))
  val slowRDD = rdd1.collectAsync().map{ x =>
    x.map{ x => println("List 1 Elements: " +x); Thread.sleep(2000)}}

  val rdd2 = sc.parallelize(List(10, 20, 30, 40, 50, 60))
  rdd2.collect().map{ x => println("List 2 Elements: " + x)}

  Await.result(slowRDD, Duration.Inf)

}
