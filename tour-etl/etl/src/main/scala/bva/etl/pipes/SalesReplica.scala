package bva.etl.pipes

import org.apache.spark.sql.{DataFrame, SparkSession}

import java.util.Properties

class SalesReplica(spark: SparkSession, jdbcUrl: String, saleTableName: String, props: Properties) {

  def createSalesReplica(): Unit = {
    val df: DataFrame = spark.read.jdbc(jdbcUrl, saleTableName, props);

  }
}
