import scala.io.StdIn.readChar
import scala.util.control.TailCalls.TailRec
import Models._
import scala.annotation.tailrec

@main def FlipCoinFP(): Unit = {
  println("Welcome to the Flip Coin game!")

  flipIter(List.empty)

  @tailrec
  def flipIter(flips: List[Flip]): Unit = {

    if (!flips.isEmpty) showGameStatus(flips)

    showMenu

    readChar() match {
      case 'h' => {
        val result = flip
        showResult(result)
        flipIter(flips.appended(Flip(result, true)))
      }
      case 't' => {
        val result = flip
        showResult(result)
        flipIter(flips.appended(Flip(result, false)))
      }
      case 'q' => {
        println("Thank you for flipping some coins. See you next time...")
        showGameStatus(flips)
      }
      case _ => {
        println("Invalid command!")
        flipIter(flips)
      }
    }
  }
}
