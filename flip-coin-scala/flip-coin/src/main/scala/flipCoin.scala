import scala.io.StdIn.readChar
import Models._

@main def flipCoin(): Unit = {
  println("Welcome to the Flip Coin app!")
  var flipsHistory = List.empty[Flip]
  var keepPlaying = true
  while (keepPlaying) {
    showMenu
    val command = readChar()
    command match {
      case 'h' => {
        val result = flip
        showResult(result)
        flipsHistory = flipsHistory.appended(Flip(result, true))
      }
      case 't' => {
        val result = flip
        showResult(result)
        flipsHistory = flipsHistory.appended(Flip(result, false))
      }
      case 'q' => {
        println("Thank you for flipping some coins. See you next time...")
        keepPlaying = false
      }
      case _ => println("Invalid command!")
    }
    showGameStatus(flipsHistory)
  }
}
