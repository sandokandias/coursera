package recfun
import common._

object Main {
  def main(args: Array[String]) {

    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    println()
    val text = args(0)
    println(s"Parentheses Balancing: $text")
    println(balance(text.toList))
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == -1) 0
    else if (c == r || c== 0) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    def balanceHelper(open: Int, close: Int, list: List[Char]): Boolean = {
      if (list.isEmpty) open == close
      else if (list.head == '(') balanceHelper(open + 1, close, list.tail)
      else if (list.head == ')') balanceHelper(open, close + 1, list.tail)
      else balanceHelper(open, close, list.tail)
    }

    balanceHelper(0, 0, chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = ???
}
