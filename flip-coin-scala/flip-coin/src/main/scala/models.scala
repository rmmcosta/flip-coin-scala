object Models {
  def showMenu: Unit = println("(h)eads, (t)ails, (q)uit:")

  def showMenu2: Unit = println("(h)eads, (t)ails, (n)ew, (s)ummary, (q)uit:")

  def flip: Boolean = Math.random() > 0.5

  def showResult(result: Boolean) = print(
    s" Flip was ${if (result) "Head" else "Tails"}. "
  )

  def showGameStatus(flipsHistory: List[Flip]) = println(
    s"#Flips: ${flipsHistory.size}, #Correct: ${flipsHistory.filter {
        currentFlip => currentFlip.result == currentFlip.bet
      }.size}"
  )

  case class Flip(result: Boolean, bet: Boolean)
}
