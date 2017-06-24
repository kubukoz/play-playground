package com.kubukoz.dao

import com.google.inject.Inject
import com.kubukoz.config.DbConfig
import com.kubukoz.messages.BookName
import com.kubukoz.tables.Books.{queries => bookQueries}
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.{ExecutionContext, Future}
import scala.language.higherKinds

trait BookDao[M[_]] {
  def findNames(): M[List[BookName]]
}

class BookDaoImpl @Inject()(dbConfig: DbConfig)
                           (implicit ec: ExecutionContext) extends BookDao[Future] {
  import dbConfig.db

  override def findNames(): Future[List[BookName]] = {
    db.run(bookQueries.allNames.result).map(_.map(BookName(_)))
  }
}
