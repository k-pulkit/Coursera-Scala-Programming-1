package recfun
import java.util.NoSuchElementException
import scala.util.control.Breaks._

object RecFun extends RecFunInterface:

  private var pascal_map: Map[(Int, Int), Int] = Map.empty   
  
  def pascal_s(c: Int, r: Int): Int = {
    val res: Int = pascal(c, r)
    pascal_map = pascal_map + ((c, r) -> res)
    res
  }

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()

  /**
   * Exercise 1
   */

  def pascal(c: Int, r: Int): Int = {
    if (c > r || c < 0 || r < 0) {
      throw new NoSuchElementException("Invalid value for c and r.")
    }
    else if (c == r || c == 0) {
      return 1
    } 
    else {
      var x: Int = pascal_map.getOrElse((c-1, r-1), pascal_s (c-1, r-1))
      var y: Int = pascal_map.getOrElse((c, r-1), pascal_s (c, r-1))
      return x + y
    }
  }

  def balance_aux(chars: List[Char], brackets: List[Char]): Boolean = {
    // Handle edge case
    if (chars.isEmpty) {
      return (brackets.length == 1)
    }
    else {
      var brackets_pass: List[Char] = if brackets.isEmpty then List(' ') else brackets
      val head_chars: Char = chars.head
      val head_brackets: Char = brackets_pass.head
      if (head_chars == '(' || head_chars == ')') {
        if ( (head_chars == ')' && head_brackets == '(') && head_brackets != ' ') {
          brackets_pass = brackets.tail
        } else {
          brackets_pass = head_chars :: brackets_pass
        }
      }
      // call recursively
      balance_aux(chars.tail, brackets_pass)
    }
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = balance_aux(chars, List())

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    var solutionMap: Set[List[Int]] = Set()
    var toskip: Set[(Int, Int, List[Int])] = Set()

    def count_change_aux(money: Int, coins: List[Int], coin_list: List[Int]): Boolean = {
    // println(s"money: $money")
    var result: Boolean = true
    if (money == 0) {
      val x = coin_list.sorted
      solutionMap += x
      result = true
    } 
    else if (money < 0 || (money > 0 && coins.isEmpty)) {
      result = false
    }
    else {
      for (coin <- coins) {       
          if (!toskip.contains((money-coin, coin, coin_list.sorted))) {
          result = count_change_aux(money - coin, coins, coin :: coin_list)
          if (!result && (money-coin > 0)) {
            toskip += (money-coin, coin, coin_list.sorted)
            // print(toskip)
          }
        }
      }
    }
    result
  }

    count_change_aux(money, coins.sorted, List())
    solutionMap.size
  }
