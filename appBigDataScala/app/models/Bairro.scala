package models

import play.api._
import play.api.libs.json._
import play.api.Play.current

class Bairro(val xc: Double, val yc: Double, val nomec: String) {
   var lat: Double = xc
   var long: Double = yc
   var nome: String = nomec
   
}
