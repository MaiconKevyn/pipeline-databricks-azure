// Databricks notebook source
dbutils.fs.mkirs("/mnt/dados")

// COMMAND ----------

// MAGIC %python
// MAGIC dbutils.fs.ls("/mnt")

// COMMAND ----------

val configs = Map(
  "fs.azure.account.auth.type" -> "OAuth",
  "fs.azure.account.oauth.provider.type" -> "org.apache.hadoop.fs.azurebfs.oauth2.ClientCredsTokenProvider",
  "fs.azure.account.oauth2.client.id" -> "339ce8f6-9d01-4c6e-9dca-d913661e4ace",
  "fs.azure.account.oauth2.client.secret" -> "SNN8Q~B_TBTVs29pL9qrEeYm6P6DFzij8QCHcb92",
  "fs.azure.account.oauth2.client.endpoint" -> "https://login.microsoftonline.com/4a14843d-0847-4add-a7dc-a2db3a02c80c/oauth2/token")
// Optionally, you can add <directory-name> to the source URI of your mount point.
dbutils.fs.mount(
  source = "abfss://imoveis@datalakestoragen2alura.dfs.core.windows.net/",
  mountPoint = "/mnt/dados",
  extraConfigs = configs)

// COMMAND ----------

// MAGIC %python
// MAGIC dbutils.fs.ls("/mnt/dados")

// COMMAND ----------


