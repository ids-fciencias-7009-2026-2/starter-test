package com.ids.starter.test

import io.github.cdimascio.dotenv.dotenv
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application {
}
	fun main(args: Array<String>) {
		dotenv().entries().forEach {
			System.setProperty(it.key, it.value)
		}
		runApplication<Application>(*args)
	}