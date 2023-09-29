import scala.io.{Source}
import com.github.plokhotnyuk.jsoniter_scala.core._
import com.github.plokhotnyuk.jsoniter_scala.macros._

object CountriesIssue extends App {

  case class Country(
                    name: Name,
                    capital: List[String],
                    region: Option[String],
                    area: Option[Double],
                  )

  case class Name(
                   official: String,
                 )

  /**
   *
   * Read json file with countries and select 10 countries with the biggest area in africa region
   * - official name
   * - area
   * - capital
   * - region
   *
   * Json can not contain the field "area" for some countries
   *
   *
   *
   * */

  // Получаем InputStream из ресурсов
  val inputStream = getClass.getResourceAsStream("/countries.json")

  // Читаем содержимое файла в строку
  val jsonStr = Source.fromInputStream(inputStream).mkString

  // Закрываем InputStream
  inputStream.close()

  implicit val codec: JsonValueCodec[List[Country]] = JsonCodecMaker.make
  val parsedJson = readFromString(jsonStr)

  // Фильтруем страны в регионе Африки и сортируем по площади
  val africanCountries = parsedJson
    .filter(_.region.getOrElse("") == "Africa")
    .sortBy(_.area.getOrElse(0.0))(Ordering[Double].reverse)
    .take(10)

  africanCountries.foreach(country => {
    val officialName = country.name.official
    val area = country.area.getOrElse(0)
    val capital = country.capital(0)
    val region = country.region.getOrElse("")
    println(s"Region: ${region} Name: ${officialName} Capital: ${capital} Area: ${area}")
  })

}