package recfun

object RecFun extends RecFunInterface :

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if c == 0 || c == r
    then 1
    else {
      pascal(c, r - 1) + pascal(c - 1, r - 1)
    }


  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean =
    def helper(chars: List[Char], numLeft: Int): Boolean =
      if chars.isEmpty
      then numLeft == 0
      else if chars.head == '('
      then helper(chars.tail, numLeft + 1)
      else if chars.head == ')'
      then
        if numLeft == 0
        then false
        else helper(chars.tail, numLeft - 1)
      else helper(chars.tail, numLeft)

    helper(chars, 0)


  /**
   * Exercise 3
   * f(money, i): number of ways to make money from coins[i:]
   * f(money, i) = sum(f(money - coins[j], j) for j in range(i, len(coins)))
   * f(0) = 1
   */
  def countChange(money: Int, coins: List[Int]): Int =
    if money < 0
    then 0
    else if money == 0
    then 1
    else if coins.isEmpty
    then 0
    else {
      countChange(money - coins.head, coins)
        + countChange(money, coins.tail)
    }

