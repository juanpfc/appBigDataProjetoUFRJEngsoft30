package utils

import play.api._
import play.api.libs.json._
import play.api.Play.current

import models._

object BairroUtil {

    var listaBairros = scala.collection.mutable.Buffer[Bairro]() 
	listaBairros += new Bairro(-22.8742263,-43.4685442,"BANGU")
	listaBairros += new Bairro(-23.0003709,-43.365895,"BARRA DA TIJUCA")
	listaBairros += new Bairro(-22.8926246,-43.2397455,"BENFICA")
	listaBairros += new Bairro(-22.9511149,-43.1809269,"BOTAFOGO")
	listaBairros += new Bairro(-22.8331178,-43.3022257,"BRAS DE PINA")
	listaBairros += new Bairro(-22.8792069,-43.2155524,"CAJU")
	listaBairros += new Bairro(-22.8856237,-43.3481044,"CAMPINHO")
	listaBairros += new Bairro(-22.9035842,-43.5662438,"CAMPO GRANDE")
	listaBairros += new Bairro(-22.8725957,-43.3136,"CAVALCANTI")
	listaBairros += new Bairro(-22.9070828,-43.1819148,"CENTRO")
	listaBairros += new Bairro(-22.8234412,-43.2959357,"CORDOVIL")
	listaBairros += new Bairro(-22.8803653,-43.2690045,"DEL CASTILHO")
	listaBairros += new Bairro(-22.895332,-43.2957776,"ENGENHO DE DENTRO")
	listaBairros += new Bairro(-22.9331294,-43.1774267,"FLAMENGO")
	listaBairros += new Bairro(-22.811262,-43.2269366,"GALEAO")
	listaBairros += new Bairro(-22.9237136,-43.258999,"GRAJAU")
	listaBairros += new Bairro(-22.8401095,-43.3780741,"GUADALUPE")
	listaBairros += new Bairro(-22.9939925,-43.596635,"GUARATIBA")
	listaBairros += new Bairro(-22.8453344,-43.3558285,"HONORIO GURGEL")
	listaBairros += new Bairro(-22.9567123,-43.1984978,"HUMAITA")
	listaBairros += new Bairro(-22.984667,-43.1985932,"IPANEMA")
	listaBairros += new Bairro(-22.8387571,-43.3241817,"IRAJA")
	listaBairros += new Bairro(-22.9621372,-43.2076913,"LAGOA")
	listaBairros += new Bairro(-22.8725334,-43.3363639,"MADUREIRA")
	listaBairros += new Bairro(-22.9127036,-43.2261662,"MARACANA")
	listaBairros += new Bairro(-22.9021344,-43.2803832,"MEIER")
	listaBairros += new Bairro(-22.8749746,-43.351177,"OSWALDO CRUZ")
	listaBairros += new Bairro(-22.8780979,-43.4483194,"PADRE MIGUEL")
	listaBairros += new Bairro(-22.8184513,-43.3030143,"PARADA DE LUCAS")
	listaBairros += new Bairro(-22.8936588,-43.3217453,"QUINTINO BOCAIUVA")
	listaBairros += new Bairro(-22.8763107,-43.4302937,"REALENGO")
	listaBairros += new Bairro(-23.0136663,-43.4634068,"RECREIO DOS BANDEIRANTES")
	listaBairros += new Bairro(-22.8996949,-43.2551084,"RIACHUELO")
	listaBairros += new Bairro(-22.9196515,-43.6843877,"SANTA CRUZ")
	listaBairros += new Bairro(-22.8759688,-43.526314,"SANTISSIMO")
	listaBairros += new Bairro(-22.8993179,-43.2016664,"SANTO CRISTO")
	listaBairros += new Bairro(-22.8982426,-43.2189006,"SAO CRISTOVAO")
	listaBairros += new Bairro(-22.9230494,-43.3739788,"TAQUARA")
	listaBairros += new Bairro(-22.9325728,-43.2410248,"TIJUCA")
	listaBairros += new Bairro(-22.8928494,-43.2846653,"TODOS OS SANTOS")
	listaBairros += new Bairro(-22.8574907,-43.329357,"VAZ LOBO")
	listaBairros += new Bairro(-22.8440802,-43.3094623,"VILA DA PENHA")
	
	def bairroMap = listaBairros.map(t => t.nome -> t).toMap
}


/*
#https://stackoverflow.com/questions/39913510/spark-2-0-with-play-2-5/42652322

##https://github.com/anubhav100/spark/tree/master/spark_wordCount
##https://github.com/knoldus/Play-Spark-Scala
##https://www.youtube.com/watch?v=yTzjnFzLq0M

##  jdbc,
##  anorm,
##  cache,##  "org.apache.spark"  %% "spark-core"              % "1.0.1",
##  "com.typesafe.akka" %% "akka-actor"              % "2.2.3", 
##  "com.typesafe.akka" %% "akka-slf4j"              % "2.2.3",
##  "org.apache.spark"  %% "spark-streaming-twitter" % "1.0.1",
##  "org.apache.spark"  %% "spark-sql"               % "1.0.1",
##  "org.apache.spark"  %% "spark-mllib"             % "1.0.1"

   "com.fasterxml.jackson.core" % "jackson-core" % "2.8.7",
   "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.7",
   "com.fasterxml.jackson.core" % "jackson-annotations" % "2.8.7",
   "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.8.7",
   
      "org.apache.spark" % "spark-core_2.11" % "2.0.0",
   "org.apache.spark" % "spark-mllib_2.11" % "2.0.0",
   "org.apache.spark" % "spark-sql_2.11" % "2.0.0"   



   
*/

