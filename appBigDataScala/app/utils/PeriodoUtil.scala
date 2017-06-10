package utils

import play.api._
import play.api.libs.json._
import play.api.Play.current

import models._

object PeriodoUtil {

    var listaPeriodos = scala.collection.mutable.Buffer[Periodo]() 
	listaPeriodos += new Periodo("Janeiro","01")
	listaPeriodos += new Periodo("Fevereiro","02")
	listaPeriodos += new Periodo("Marco","03")
	listaPeriodos += new Periodo("Abril","04")
	listaPeriodos += new Periodo("Maio","05")
	listaPeriodos += new Periodo("Junho","06")
	listaPeriodos += new Periodo("Julho","07")
	listaPeriodos += new Periodo("Agosto","08")
	listaPeriodos += new Periodo("Setembro","09")
	listaPeriodos += new Periodo("Outubro","10")
	listaPeriodos += new Periodo("Novembro","11")
	listaPeriodos += new Periodo("Dezembro","12")
	
	def periodosMap = listaPeriodos.map(t => t.codigo -> t.descricao).toMap
}
