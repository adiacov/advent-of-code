package common

import scala.io.Source
import scala.util.{ Failure, Success, Using }

object FileUtils {

  def readResourceFile(fileName: String): List[String] =
    Using(Source.fromResource(fileName)) { source =>
      source.getLines().toList
    } match
      case Failure(exception) =>
        throw new Exception(
          s"Could not read file: ]$fileName], becausa of $exception"
        )
      case Success(value) => value

}
