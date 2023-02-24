/**
 * @PARAMS
 * REST server returning a JSON like:
 * {
 * 		"currentDateTime":"2019-08-12T14:40Z"
 * }
 * **/

package exercicio6

import Exercise5
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Exercise6 {

	@GetMapping(produces = ["application/json"])
	fun getTime() : ResponseEntity<Any> {
		val response = mapOf("currentDateTime" to Exercise5().getTime())
		return ResponseEntity.ok(response)
	}
}

@SpringBootApplication
open class RestServer() {}

fun main(args: Array<String>) {
		SpringApplication.run(RestServer::class.java, *args)
}