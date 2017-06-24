package com.kubukoz.impl

import com.google.inject.Inject
import com.kubukoz.dao.BookDao
import com.kubukoz.services.BookServiceImpl

import scala.concurrent.{ExecutionContext, Future}
import cats.instances.future._

class BookServiceFutureImpl @Inject()(bookDao: BookDao[Future])(
  implicit ec: ExecutionContext)
    extends BookServiceImpl(bookDao)
