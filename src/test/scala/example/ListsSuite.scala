package example
import Lists.*

class ListsSuits extends munit.FunSuite {
    // test sum function
    test("sum of a few numbers (10pts)") {
        assertEquals(sum(List(1,2,0)), 3)
    }

    // test max function
    test("max of a few numbers (10pts)") {
        val result: Either[Int, Throwable] = max(List(3, 7, 2))

        result match {
            case Left(x) => {
                assertEquals(x, 7)
            }
            case Right(error) => ()
        }

    }

    test("Empty list should throw error") {
        val result: Either[Int, Throwable] = max(List())
        
        result match {
            case Left(x) => fail("No exception has been thrown")
            case Right(error) => ()
        }
    }


}