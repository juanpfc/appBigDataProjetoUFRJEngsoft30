package models

import play.api._
import play.api.libs.json._
import play.api.Play.current

class Periodo(val desc: String, val cod: String) {
   var descricao: String = desc
   var codigo: String = cod
}
/*
object Localizacao {
    
    implicit object LocalizacaoFormat extends Format[Localizacao] {

        // convert from Localizacao object to JSON (serializing to JSON)
        def writes(localizacao: Localizacao): JsValue = {
            
            val localizacaoSeq = Seq(
                "Lat" -> JsNumber(localizacao.Lat),
                "Long" -> JsNumber(localizacao.Long),
                "Local" -> JsString(localizacao.Local),
				"Incidencias" -> JsNumber(localizacao.Incidencias),
				"PesoComparado" -> JsNumber(localizacao.PesoComparado)
            )
            JsObject(localizacaoSeq)
        }
		
		// convert from JSON string to a Localizacao object (de-serializing from JSON)
        // (i don't need this method; just here to satisfy the api)
        def reads(json: JsValue): JsResult[Localizacao] = {
            JsSuccess(new Localizacao(0,0,"",0,0))
        }

    }

}*/