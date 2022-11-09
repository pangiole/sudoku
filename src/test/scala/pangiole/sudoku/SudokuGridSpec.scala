package pangiole.sudoku

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class SudokuGridSpec extends AnyFlatSpec with Matchers {

  behavior of "Sudoku grid"

  it should "fail if invalid" in {
    // SETUP
    val grid = SudokuGrid(List(
      List('9', '.', '4', '.', '6', '.', '7', '.', '1'),
      List('.', '2', '.', '4', '.', '3', '.', '8', '.'),
      List('8', '.', '.', '.', '.', '.', '.', '.', '4'),
      List('.', '.', '1', '8', '4', '9', '6', '.', '.'),
      List('.', '.', '.', '.', '.', '.', '.', '.', '.'),
      List('.', '.', '3', '2', '5', '7', '9', '.', '.'),
      List('4', '.', '.', '.', '.', '.', '.', '.', '7'),
      List('.', '8', '.', '6', '.', '4', '.', '5', '.'),
      List('5', '.', '6', '.', '8', '.', '2', '.', '3')
    ))

    // EXERCISE & VERIFY
    grid.isValid mustBe false
  }



  it should "succeed if valid" in {
    // SETUP
    val grid = SudokuGrid(List(
      List('1', '2', '3', '4', '5', '6', '7', '8', '9'),
      List('7', '8', '9', '1', '2', '3', '4', '5', '6'),
      List('4', '5', '6', '7', '8', '9', '1', '2', '3'),
      List('5', '1', '2', '6', '4', '7', '9', '3', '8'),
      List('9', '3', '4', '8', '1', '5', '2', '6', '7'),
      List('8', '6', '7', '9', '3', '2', '5', '1', '4'),
      List('2', '4', '8', '3', '7', '1', '6', '9', '5'),
      List('3', '9', '5', '2', '6', '4', '8', '7', '1'),
      List('6', '7', '1', '5', '9', '8', '3', '4', '2')
    ))

    // EXERCISE & VERIFY
    grid.isValid mustBe true
  }



}