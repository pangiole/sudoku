package pangiole.sudoku


case class SudokuGrid[A](matrix: Matrix[A]) {


  // Validate the given matrix by verifying there's no duplicate on rows, columns and boxes
  def isValid: Boolean = ???
}
