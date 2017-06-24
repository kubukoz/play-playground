package com.kubukoz.config

import com.google.inject.{Inject, Singleton}
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.{JdbcBackend, JdbcProfile}

@Singleton
class DbConfig @Inject()(configProvider: DatabaseConfigProvider) {
  private val dbConfig            = configProvider.get[JdbcProfile]
  val db: JdbcBackend#DatabaseDef = dbConfig.db
}
