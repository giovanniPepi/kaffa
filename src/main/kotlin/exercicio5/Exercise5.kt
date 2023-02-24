package com.org.exercise1.kt

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class Exercise5 {


	fun teste() {
		val client = HttpClient.newBuilder().build()
		val request = HttpRequest.newBuilder().uri(URI.create("http://worldclockapi.com/api/json/utc/now")).build()
		val response = client.send(request, BodyHandlers.ofString())


		println(response.body())
	}
}

fun main() {
	Exercise5().teste()
}