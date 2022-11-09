package pangiole.sudoku

import scala.annotation.tailrec

case class SudokuGrid[A](matrix: Matrix[A]) {


  // Validate the given matrix by verifying there's no duplicate on rows, columns and boxes
  def isValid: Boolean = {
    (rows(matrix) forall nodups) &&
      (cols(matrix) forall nodups) &&
      (boxes(matrix) forall nodups)
  }


  // ---------------------------
  // PRIVATE helpers

  // Extract the rows of the given matrix
  private def rows[B](matrix: Matrix[B]): Matrix[B] = matrix


  // Extract the columns of the given matrix
  private def cols[B](matrix: Matrix[B]): Matrix[B] = matrix.transpose


  // Extract the boxes of the given matrix (DIFFICULT!)
  private def boxes(m: Matrix[A]): Matrix[A] = {

    // chop the given list into fragments of the given size n
    def chop[B](n: Int, row: List[B]): Matrix[B] = row match {
      case Nil => List.empty[List[B]]
      case xs => xs.take(n) :: chop(n, xs.drop(n))
    }

    def chopBy3[B] = chop(3, _: List[B])

    def pack[B](m: Matrix[B]) = chopBy3 (m map chopBy3)

    def concat[B](m: Matrix[B]) = m.flatten

    def unpack[B](m: Matrix[Matrix[B]]) = concat(m).map(x => concat(x))

    // Let's extract the boxes
    unpack (pack(m) map cols)
  }


  @tailrec
  // Check if the given list has no duplicates
  private def nodups(list: List[A]): Boolean = list match {
    case Nil => true
    case (x :: xs) => !xs.contains(x) && nodups(xs)
  }
}
