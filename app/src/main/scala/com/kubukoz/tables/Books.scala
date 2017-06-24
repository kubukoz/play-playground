package com.kubukoz.tables

import com.kubukoz.models.{Book, BookId}
import slick.jdbc.MySQLProfile.api._
import slick.lifted.{ProvenShape, QueryBase}

class Books(tag: Tag) extends Table[Book](tag, "books") {
  val id: Rep[BookId]   = column("id")
  val name: Rep[String] = column("name")

  override def * : ProvenShape[Book] =
    (id, name) <> (Book.tupled, Book.unapply)
}

object Books {
  private val Table = TableQuery[Books]

  object queries {
//    private val all                         = Table.to[List]
    val allNames: QueryBase[List[String]] = Table.map(_.name).to[List]
  }
}
