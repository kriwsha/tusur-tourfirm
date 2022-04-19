package bva.etl

import bva.etl.pipes.SalesReplica
import org.apache.spark.sql.{DataFrame, SparkSession}

object App {
  val MASTER = "local[*]"
  val APP_NAME = "Travel ETL"
  val spark: SparkSession = SparkSession.builder().master(MASTER).appName(APP_NAME).getOrCreate()

  def main(args: Array[String]): Unit = {
    val salesReplica = new SalesReplica(
      spark = spark,
      jdbcUrl = "",
      saleTableName = "",
      props = null
    )
    salesReplica.createSalesReplica()
  }
}
