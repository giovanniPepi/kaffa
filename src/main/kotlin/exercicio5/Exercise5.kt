import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter


class Exercise5 {

	fun getTime() : String? {
		val client = HttpClient.newBuilder().build()
		val request = HttpRequest.newBuilder().uri(URI.create("http://worldclockapi.com/api/json/utc/now")).build()
		val response = client.send(request, BodyHandlers.ofString())

		if (response.statusCode() != 200) {
			println("Service unavailable")
			return null
		}

		val typeRef: TypeReference<HashMap<String, String>> = object : TypeReference<HashMap<String, String>>() {}
		val responseMap = ObjectMapper().readValue(response.body(), typeRef)

		val utc = OffsetDateTime.parse(responseMap["currentDateTime"])
		val local = utc.minusHours(3)

		println("UTC: $utc")
		println("Local: $local")

		return local.toString()
	}
}
fun main() {
	Exercise5().getTime()
}