package com.ids.starter.test

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

// @Component
class LoggerDePrueba(
    @Value("\${app.autor}") private val nombre: String,
    @Value("\${app.my.password}") private val myPassword: String,

    ) : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(LoggerDePrueba::class.java)


    override fun run(vararg args: String) {
        logger.info("Hello World")
        logger.info("Mi nombre es $nombre")
        logger.error("My password es $myPassword")
    }
}