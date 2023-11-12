package example
import java.util.NoSuchElementException

object Lists:
    def sum(xs: List[Int]): Int = {
        var result: Int = 0
        for(x <- xs) {
            result += x
        }
        result
    }

    def max(xs: List[Int]): Either[Int, Throwable] = {
        var max_num = -1
        for (x <- xs) {
            if (x > max_num) {
                max_num = x
            }
        }
        if (max_num > -1) {
            Left(max_num)
        }
        else {
            val error: Throwable = new NoSuchElementException("The list is empty")
            Right(error)
        }
    }