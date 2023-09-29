//
//import com.github.plokhotnyuk.jsoniter_scala.macros._
//import com.github.plokhotnyuk.jsoniter_scala.core._
//
//given codec: JsonValueCodec[User] = JsonCodecMaker.make
object Jsoniter extends App {
  case class Device(id: Int, model: String)

  case class User(name: String, devices: Seq[Device])

  import com.github.plokhotnyuk.jsoniter_scala.macros._
  import com.github.plokhotnyuk.jsoniter_scala.core._

//  given codec: JsonValueCodec[User] = JsonCodecMaker.make
  implicit val codec: JsonValueCodec[User] = JsonCodecMaker.make


  val inputJson = """{"name":"Ivan","device":[{"id":1,"model":"HTC one X"}]}"""
  val parsedJson = readFromString(inputJson)
  println(parsedJson)
  //  val user = JsonReader(inputJson)

}
