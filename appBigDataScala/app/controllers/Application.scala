package controllers

import play.api._
import play.api.mvc._
import javax.inject._
import play.api.routing._
import play.api.libs.json._
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.sql.types._
import org.apache.spark.sql._

import models._
import utils._

@Singleton
class Application @Inject() extends Controller {

   val spark = SparkSession.builder()
		  .master("local")
		  .appName("IncidenciasRJ")		  
		  .getOrCreate()
   import spark.implicits._
   val sinistroDF = spark.read.option("header","true")
               .csv("dados_sinistro.csv")
   sinistroDF.createOrReplaceTempView("sinistros")
   val resumoDF = spark.sql("select substr(AVI_DT_OCORRENCIA,1,6) as periodo, trim(AVI_DS_MARCA) as marca, BOL_NM_BAIRRO_SINI as bairro, count(*) as quantidade from sinistros where AVI_DT_OCORRENCIA <> '' group by substr(AVI_DT_OCORRENCIA,1,6), trim(AVI_DS_MARCA), BOL_NM_BAIRRO_SINI")
   resumoDF.createOrReplaceTempView("resumo")

  def index = Action {
        var listaLocal : scala.collection.mutable.Buffer[Localizacao] = listaFiltradaSpark("Todos","Todas")
	calculaPesoComparadoLista(listaLocal)

	val jsArr: JsValue = Json.toJson(listaLocal)
	
    	Ok(views.html.index(jsArr, listaPeriodos, listaMarcas))
  }
    
  def ajaxCall(id: String, marca: String) = Action { implicit request =>
	  var listaLocal = listaFiltradaSpark(id, marca)
	  calculaPesoComparadoLista(listaLocal)

	  println("chamada ao ajaxCall " + id + "--" + marca)
	  
	  val jsArr: JsValue = Json.toJson(listaLocal)	  
	  Ok(jsArr)
  }
  
  def javascriptRoutes = Action { implicit request =>
	  import routes.javascript._
	  Ok(
		JavaScriptReverseRouter("jsRoutes")(
		  routes.javascript.Application.ajaxCall
		)
	  ).as("text/javascript")
  }
  
  private def listaFiltradaSpark(id: String, marca: String) : scala.collection.mutable.Buffer[Localizacao] = {
	val listaIni = scala.collection.mutable.Buffer[Localizacao]()
	val strSql = criaSql(id, marca)
	println(strSql)
	val sqlFiltro = spark.sql(strSql)
        sqlFiltro.collect().foreach(result => {
		var bairro = BairroUtil.bairroMap(result.getString(0))
		var incidencias: Long = result.getLong(1)
		listaIni += new Localizacao(bairro.lat, bairro.long, bairro.nome, incidencias, 1)
	})	
	listaIni
  }

  private def listaPeriodos() : scala.collection.mutable.Buffer[Periodo] = {
	var lista = scala.collection.mutable.Buffer[Periodo]()
	val sqlPeriodos = spark.sql("select distinct periodo from resumo order by 1")
        sqlPeriodos.collect().foreach(anomes => {
                var ano = anomes.getString(0).substring(0,4)
                var periodo = PeriodoUtil.periodosMap(anomes.getString(0).substring(4,6))
		lista += new Periodo(s"$periodo $ano",anomes.getString(0))
	})
	lista
  }

  private def listaMarcas() : scala.collection.mutable.Buffer[String] = {
	var lista = scala.collection.mutable.Buffer[String]()
  	val sqlPeriodos = spark.sql("select distinct marca from resumo")
        sqlPeriodos.collect().foreach(marca => lista += marca.getString(0))
	lista
  }

  private def calculaPesoComparadoLista(lista: scala.collection.mutable.Buffer[Localizacao]) = {
	 var maximo: Long = 0
	  lista.foreach(localizacao => {
		if (localizacao.Incidencias > maximo)
			maximo = localizacao.Incidencias
	  })
	  lista.foreach(localizacao => {
		localizacao.PesoComparado = scala.math.BigDecimal(localizacao.Incidencias * 100 / maximo).toInt
	  })
  }

  private def criaSql(id: String, marca: String): String = {
	var sql = "select bairro, SUM(quantidade) from resumo"
	if (id != "Todos") sql += s" where periodo = '$id'"
        var strWhere = if (id != "Todos") "and" else "where"
	if (marca != "Todas") sql += s" $strWhere marca = '$marca'"
	sql += " group by bairro"
	sql
  }

}
