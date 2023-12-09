package common

class Resource(val name: String)

object Resource {

  extension (r: Resource)
    def lines: List[String] = FileUtils.readResourceFile(r.name)
}
