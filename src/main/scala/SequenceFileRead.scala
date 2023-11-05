import org.apache.hadoop.io.{NullWritable, Text}
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object SequenceFileRead {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Sesion2").setMaster("local[1]")
    val sc = new SparkContext(conf)

//    val normalFile = sc.textFile("./src/main/scala/datasets")
//    normalFile.map(x => (NullWritable.get(), x)).saveAsSequenceFile("./src/main/scala/SeqFiles")

    sc.sequenceFile("./src/main/scala/SeqFiles",
      classOf[NullWritable], classOf[Text]).map(r => r.toString()).collect().foreach(println)
  }
}
