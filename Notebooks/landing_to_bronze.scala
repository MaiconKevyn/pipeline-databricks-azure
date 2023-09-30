// Databricks notebook source
// MAGIC %python
// MAGIC dbutils.fs.ls("/mnt/dados/landing")

// COMMAND ----------

// MAGIC %md
// MAGIC
// MAGIC ##Lendo os dados

// COMMAND ----------

val path = "dbfs:/mnt/dados/landing/dados_brutos_imoveis.json"
val dados = spark.read.json(path)

// COMMAND ----------

display(dados)

// COMMAND ----------

// MAGIC %md
// MAGIC ##Removendo Colunas

// COMMAND ----------

val dados_anuncio = dados.drop("imagens", "usuario")
display(dados_anuncio)

// COMMAND ----------

// MAGIC %md
// MAGIC ## Criando o id como uma coluna separada - Coluna de Identificação

// COMMAND ----------

import org.apache.spark.sql.functions.col

// COMMAND ----------

val df_bronze = dados_anuncio.withColumn("id", col("anuncio.id"))
display(df_bronze)

// COMMAND ----------

// MAGIC %md
// MAGIC ##Salvando na camada bronze

// COMMAND ----------

val path = "dbfs:/mnt/dados/bronze/dataset_imoveis"
df_bronze.write.format("delta").mode(SaveMode.Overwrite).save(path)
