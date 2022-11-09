package pangiole.sudoku

import scala.annotation.tailrec

case class SudokuGrid[A](m: Matrix[A]) {


  // Validate the given m by verifying there's no duplicate on rows, columns and boxes
  def isValid: Boolean = {
    (rows(m) forall nodups) &&
      (cols(m) forall nodups) &&
      (boxes(m) forall nodups)
  }


  // ---------------------------
  // PRIVATE helpers

  // Extract the rows of the given m
  private def rows[B](m: Matrix[B]): List[Row[B]] = m


  // Extract the columns of the given m
  private def cols[B](m: Matrix[B]): List[Col[B]] = m.transpose


  // Extract the boxes of the given m (DIFFICULT!)
  private def boxes(m: Matrix[A]): List[Box[A]] = {

    // chop the given list into fragments of the given size n
    def chop[B](n: Int, list: List[B]): Matrix[B] = list match {
      case Nil => List.empty[List[B]]
      case xs => xs.take(n) :: chop(n, xs.drop(n))
    }

    def chopBy3[B]: (List[B] => Matrix[B]) = chop(3, _: List[B])

    def pack[B](m: Matrix[B]): Matrix[Matrix[B]] = chopBy3 (m map chopBy3)

    def concat[B](m: Matrix[B]): List[B] = m.flatten

    def unpack[B](m: Matrix[Matrix[B]]): Matrix[B] = concat(m) map concat

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
