package com.kubukoz.models

import play.api.mvc.PathBindable
import play.api.mvc.PathBindable.bindableLong
import slick.jdbc.MySQLProfile.api._

case class BookId(value: Long) extends AnyVal

object BookId {
  implicit val mapper: BaseColumnType[BookId] = MappedColumnType.base[BookId, Long](_.value, BookId(_))

  implicit val pathBindable: PathBindable[BookId] = bindableLong.transform(BookId(_), _.value)
}

case class Book(id: BookId, name: String)
