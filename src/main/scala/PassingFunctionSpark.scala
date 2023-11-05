import org.apache.spark.{SparkContext, SparkConf}

object PassingFunctionSpark extends App{
  val conf = new SparkConf().setAppName("Sesion1").setMaster("local[1]")
  val sc = new SparkContext(conf)

  private val data =  Array(1, 2, 3, 4, 5)
  val parRDD = sc.parallelize(data)



  def add2(i: Int): Int={
    return i+2
  }

  val newRDD = parRDD.map(add2)
  newRDD.collect().foreach(println)

}
