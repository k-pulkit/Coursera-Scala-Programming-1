package funsets

object Main extends App:
  import FunSets.*

  val s: FunSet = (1 to 100).map(x => singletonSet(x)).reduce((x, y) => union(x, y))
  val p: Int => Int = x => x*x

  printSet(map(s, p))
