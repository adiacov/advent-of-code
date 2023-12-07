package _2023.day006

import common.FileUtils

object Day006:

  val input: List[String] =
    FileUtils.readResourceFile("2023/day006.txt")

  def normalizeInput(str: String): List[String] =
    str.trim().split("\\s+").toList

  val times: List[String] =
    input.collectFirst { case s"Time: $nums" => normalizeInput(nums) }
      .getOrElse(Nil)

  val distances: List[String] =
    input.collectFirst { case s"Distance: $nums" => normalizeInput(nums) }
      .getOrElse(Nil)

  def zipped(left: List[String], right: List[String]): List[(Long, Long)] =
    left.map(_.toLong).zip(right.map(_.toLong))

  val races: List[Race] =
    times.zip(distances).map((t, d) => Race(t.toLong, d.toLong))

  def concatList(l: List[String]): Long = l.fold("")(_ concat _).toLong

  val race: Race = Race(concatList(times), concatList(distances))

  @main def run(): Unit =
    val part1 = races.map(_.wins).product
    println(s">>> PART 1: $part1") // >>> PART 1: 5133600
    val part2 = race.wins
    println(s">>> PART 2: $part2") // >>> PART 2: 40651271

end Day006
