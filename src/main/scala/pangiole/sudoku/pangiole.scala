package pangiole

package object sudoku {

  type Row[A] = List[A]
  type Col[A] = List[A]
  type Box[A] = List[A]
  type Matrix[A] = List[Row[A]]

}
