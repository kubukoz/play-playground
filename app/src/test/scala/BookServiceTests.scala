import cats.Id
import com.kubukoz.dao.BookDao
import com.kubukoz.messages.BookName
import com.kubukoz.services.BookServiceImpl
import org.scalatest.{FlatSpec, Matchers}

class BookServiceTests extends FlatSpec with Matchers {
  val bookDao: BookDao[Id] = () => List(BookName("Book 1"), BookName("Book 2"))

  val bookService = new BookServiceImpl(bookDao)

  "findAll" should "map books to names" in {
    bookService.findAll() shouldBe List(BookName("Book 1"), BookName("Book 2"))
  }
}
