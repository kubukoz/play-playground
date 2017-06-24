package com.kubukoz.messages

import play.api.libs.json.{Json, Writes}

case class BookName(value: String) extends AnyVal

object BookName {
  implicit val writes: Writes[BookName] = Json.writes[BookName]
}
