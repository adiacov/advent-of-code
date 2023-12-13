package _2023.day002

import common.Resource

import scala.util.matching.Regex

object Day002:
  def input: List[String] = Resource("2023/day002.txt").lines

  val gameRegex: Regex = """(^Game \d*:)(.*)""".r

  def createCube(num: String, color: String): Cube = {
    Cube(num.trim.toInt, CubeColor.valueOf(color.trim))
  }

  def createCubes(str: String): List[Cube] = {
    val entries: Array[String] = str.trim.split(",")
    entries.map { entry =>
      val innerSplit = entry.trim.split(" ")
      createCube(innerSplit.head, innerSplit.tail.head)
    }.toList
  }

  def createPlays(str: String): List[Play] = {
    val entries = str.split(";").map(_.trim)
    entries.map { entry => Play(createCubes(entry)) }.toList
  }

  def games: List[Game] = input.map {
    case gameRegex(game, cubes) =>
      val gameId: Int = game.filter(_.isDigit).toInt
      Game(gameId, createPlays(cubes))
  }

  enum CubeColor:
    case red, green, blue

  case class Cube(no: Int, color: CubeColor)

  case class Play(cubes: List[Cube]) {
    def reds: List[Int]   = cubes.filter(_.color == CubeColor.red).map(_.no)
    def greens: List[Int] = cubes.filter(_.color == CubeColor.green).map(_.no)
    def blues: List[Int]  = cubes.filter(_.color == CubeColor.blue).map(_.no)

    def isPossible(setup: GameSetup): Boolean = {
      setup.redCubes >= reds.sum &&
      setup.greeCubes >= greens.sum &&
      setup.blueCubes >= blues.sum
    }
  }

  case class GameSetup(redCubes: Int, greeCubes: Int, blueCubes: Int)

  case class Game(id: Long, plays: List[Play]) {

    def isPossible(setup: GameSetup): Boolean =
      plays.forall(_.isPossible(setup))

    def playTotal: Int = {
      val r = plays.flatMap(_.reds).maxOption.getOrElse(1)
      val g = plays.flatMap(_.greens).maxOption.getOrElse(1)
      val b = plays.flatMap(_.blues).maxOption.getOrElse(1)

      r * g * b
    }
  }

  def part1(games: List[Game], gameSetup: GameSetup): Long =
    games.filter(_.isPossible(gameSetup)).map(_.id).sum

  def part2(games: List[Game], gameSetup: GameSetup): Int =
    games.map(_.playTotal).sum

  @main def run(): Unit =
    val gameSetup: GameSetup = GameSetup(12, 13, 14)
    println(s">>> PART 1: ${part1(games, gameSetup)}") // 2162

    println(s">>> PART 2: ${part2(games, gameSetup).longValue}") // 72513

end Day002
