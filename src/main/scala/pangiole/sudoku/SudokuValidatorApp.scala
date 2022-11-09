package pangiole.sudoku

object SudokuValidatorApp extends App {
  assert(args.nonEmpty, "missing path")

  val path = args(0)
  val grid = SudokuLoader.load(path)

  if (grid.isValid) {
    println("VALID")
    sys.exit(0)
  }
  else {
    println("INVALID")
    sys.exit(1)
  }

}
