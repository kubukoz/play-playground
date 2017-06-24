import com.google.inject.{AbstractModule, TypeLiteral}
import com.kubukoz.dao.{BookDao, BookDaoImpl}
import com.kubukoz.impl.BookServiceFutureImpl
import com.kubukoz.services.BookService
import net.codingwell.scalaguice.ScalaModule

import scala.concurrent.Future

class Module extends AbstractModule with ScalaModule {
  override def configure(): Unit = {
    bind(new TypeLiteral[BookService[Future]]() {}).to(classOf[BookServiceFutureImpl])
    bind(new TypeLiteral[BookDao[Future]]()     {}).to(classOf[BookDaoImpl])
  }
}
