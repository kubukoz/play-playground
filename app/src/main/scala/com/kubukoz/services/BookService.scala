package com.kubukoz.services

import cats.Applicative
import com.kubukoz.dao.BookDao
import com.kubukoz.messages.BookName

import scala.language.higherKinds

trait BookService[M[_]] {
  def findAll(): M[List[BookName]]
}

class BookServiceImpl[M[_]: Applicative](bookDao: BookDao[M]) extends BookService[M] {

  override def findAll(): M[List[BookName]] =
    bookDao.findNames()
}
