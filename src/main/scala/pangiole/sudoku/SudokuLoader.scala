package pangiole.sudoku

object SudokuLoader {

  // Load the Sudoku grid at the given path
  def load(path: String): SudokuGrid[Char] = {
    SudokuGrid(
      matrix = scala.io.Source.fromFile(path).toList
        .filter(c => c != '\n')
        .filter(c => c != ',')
        .grouped(9)
        .toList
    )
  }

}
