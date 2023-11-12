package funsets

/**
 * This class is a test suite for the methods in object FunSets.
 *
 * To run this test suite, start "sbt" then run the "test" command.
 */
class FunSetSuite extends munit.FunSuite:

  import FunSets.*

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   *   val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets:
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)

  /**
   * This test is currently disabled (by using .ignore) because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", remove the
   * .ignore annotation.
   */

    test("singleton set one contains one".ignore) {
    
    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets:
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
  }

  test("union contains all elements of each set") {
    new TestSets:
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
  }

  test("filter applies to a set") {
    new TestSets:
      val s = union(union(s1, s2), s3)
      val s_filtered = filter(s, (x) => x!=3)
      assert(contains(s_filtered, 1), "Contains 1")
      assert(contains(s_filtered, 2), "Contains 2")
      assert(!contains(s_filtered, 3), "Filters 3")
      
  }

  test("foreach works") {
    val s: FunSet = (1 to 100).map(x => singletonSet(x)).reduce((x, y) => union(x, y))
    val p1: Int => Boolean = x => x > 0
    val p2: Int => Boolean = x => x < 400
    val p3: Int => Boolean = x => x < 40

    assert(forall(s, p1), "condition should be true")
    assert(forall(s, p2), "condition should be true")
    assert(!forall(s, p3), "condition should not be true")
  }

  test("exists works") {
    val s: FunSet = (1 to 100).map(x => singletonSet(x)).reduce((x, y) => union(x, y))
    val p1: Int => Boolean = x => x < 0
    val p2: Int => Boolean = x => x < 400
    val p3: Int => Boolean = x => x < 40

    assert(!exists(s, p1), "no elements satisfy condition")
    assert(exists(s, p2), "multiple elements satisfy condition")
    assert(exists(s, p3), "multiple elements satisfy condition")
  }




  import scala.concurrent.duration.*
  override val munitTimeout = 10.seconds
