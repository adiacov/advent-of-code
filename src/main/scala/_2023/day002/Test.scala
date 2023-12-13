package _2023.day002

import _2023.day002.Day002.*
import _2023.day002.Day002.CubeColor.*

object Test {

  val testGameSetup: GameSetup = GameSetup(12, 13, 14)

  val testGames: List[Game] = List(
    Game(
      // Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
      1L,
      List(
        Play(List(Cube(3, blue), Cube(4, red))),
        Play(List(Cube(1, red), Cube(2, green), Cube(6, blue))),
        Play(List(Cube(2, green)))
      )
    ),
    Game(
      // Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
      2L,
      List(
        Play(List(Cube(1, blue), Cube(2, green))),
        Play(List(Cube(3, green), Cube(4, blue), Cube(1, red))),
        Play(List(Cube(1, green), Cube(1, blue)))
      )
    ),
    Game(
      // Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
      3L,
      List(
        Play(List(Cube(8, green), Cube(6, blue), Cube(20, red))),
        Play(List(Cube(5, blue), Cube(4, red), Cube(13, green))),
        Play(List(Cube(5, green), Cube(1, red)))
      )
    ),
    Game(
      // Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red

      4L,
      List(
        Play(List(Cube(1, green), Cube(3, red), Cube(6, blue))),
        Play(List(Cube(3, green), Cube(6, red))),
        Play(List(Cube(3, green), Cube(15, blue), Cube(14, red)))
      )
    ),
    Game(
      // Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
      5L,
      List(
        Play(List(Cube(6, red), Cube(1, blue), Cube(3, green))),
        Play(List(Cube(2, blue), Cube(1, red), Cube(2, green)))
      )
    )
  )

  @main def test(): Unit = {
//    val result = Day002.part1(testGames, testGameSetup)
//    assert(result == 8L, s"Expected [8], but got [$result]")

    val result2 = Day002.part2(testGames, testGameSetup)
    assert(result2 == 2286L, s"Expected [2286], but got [$result2]")
  }

}
