import scala.io.StdIn.readChar
import scala.util.control.TailCalls.TailRec
import Models._
import scala.annotation.tailrec

@main def FlipCoinFPWithNew(): Unit = {
  println("Welcome to the Flip Coin game!")

  flipIter(List.empty, List.empty)

  @tailrec
  def flipIter(flipsHistory: List[List[Flip]], flips: List[Flip]): Unit = {
    if (!flips.isEmpty) showGameStatus(flips)

    showMenu2

    readChar() match {
      case 'h' => {
        val result = flip
        showResult(result)
        flipIter(flipsHistory, flips.appended(Flip(result, true)))
      }
      case 't' => {
        val result = flip
        showResult(result)
        flipIter(flipsHistory, flips.appended(Flip(result, false)))
      }
      case 'n' => {
        println("=== New Game ===")
        flipIter(flipsHistory.appended(flips), List.empty)
      }
      case 's' => {
        showFlipsHistory(flipsHistory.appended(flips))
        flipIter(flipsHistory, flips)
      }
      case 'q' => {
        println("Thank you for flipping some coins. See you next time...")
        showGameStatus(flips)
      }
      case _ => {
        println("Invalid command!")
        flipIter(flipsHistory, flips)
      }
    }
  }
}

def showFlipsHistory(flipsHistory: List[List[Flip]]) = {
  if (flipsHistory.isEmpty) println("No Games finished yet")
  else {
    println(s"${flipsHistory.size} game(s) played:\n")
    println("------ Summary ------")
    flipsHistory.foreach { currHistory =>
      showGameStatus(currHistory)
    }
    println("---- End Summary ----\n")
  }
}
