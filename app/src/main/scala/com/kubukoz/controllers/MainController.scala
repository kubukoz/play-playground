package com.kubukoz.controllers

import com.google.inject.Inject
import com.kubukoz.services.BookService
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

class MainController @Inject()(cc: ControllerComponents, bookService: BookService[Future])(
  implicit ec: ExecutionContext) extends AbstractController(cc) {

  val home: Action[AnyContent] = Action.async {
    bookService.findAll().map(values => Ok(Json.toJson(values)))
  }

}
