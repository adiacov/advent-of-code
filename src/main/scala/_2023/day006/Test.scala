package _2023.day006

object Test {

  @main def test(): Unit = {
    val race: Race = Race(7, 9)

    println(">>> RUN TESTS")
    assert(race.distance(0) == 0)
    assert(race.distance(1) == 6)
    assert(race.distance(2) == 10)
    assert(race.distance(3) == 12)
    assert(race.distance(4) == 12)
    assert(race.distance(5) == 10)
    assert(race.distance(6) == 6)
    assert(race.distance(7) == 0)

    println(">>> TESTS PASS")
  }

}
