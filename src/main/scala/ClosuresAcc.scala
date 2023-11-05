
import org.apache.spark.{SparkContext, SparkConf}

object ClosuresAcc extends App {
  var conf = new SparkConf().setAppName("Sesion7").setMaster("local[*]")
  val sc = new SparkContext(conf)

  var counter = 0
  val data = Array(1,2,3,4,5)
  val ParRDD = sc.parallelize(data)

  ParRDD.foreach(x => counter +=x)
  println("Counter value: " + counter)

  val accum = sc.longAccumulator("Counter")
  sc.parallelize(data).foreach(x => accum.add(x))
  println("Acum value: " + accum.value)



}
