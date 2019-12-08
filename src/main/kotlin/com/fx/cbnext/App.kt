package com.fx.cbnext

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CBNextApi {
	companion object {
		const val VERSION = "v2"
	}
}

fun main() {
	runApplication<CBNextApi>()
	println("ready...")
	println("open API: http://localhost:8888/swagger-ui/index.html?url=/v2/api-docs")
}
