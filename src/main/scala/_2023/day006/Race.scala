package _2023.day006

case class Race(raceTime: Long, raceDistance: Long):

  // working method
  def wins: Int = Range.Long(0, raceTime, 1).count { timeHold =>
    isWinning(distance(timeHold))
  }

  def isWinning(traveledDistance: Long): Boolean =
    traveledDistance > raceDistance

  def timeLeft(timeHold: Long): Long =
    raceTime - timeHold

  def distance(timeHold: Long): Long =
    timeHold * timeLeft(timeHold)

  // Race 7ms 9mm
  // hold 1ms; time left 7ms-1ms=6ms; speed 1ms*6ms=6mm
  // hold 2ms; time left 7ms-2ms=5ms; distance 2ms*5ms=10mm

end Race
