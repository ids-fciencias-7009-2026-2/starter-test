package com.ids.starter.test

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SystemDiagnosticsByLaraGuillen(

    @Value("\${app.name}") private val nombreApp: String,
    @Value("\${app.my.password}") private val myPassword: String,
    @Value("\${app.student.name}") private val student: String,
    @Value("\${app.env}") private val env: String,
    @Value("\${app.max.users}") private val maxUsers: Int,
    @Value("\${app.total.memory.mb}") private val memoria: Int


) : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(SystemDiagnosticsByLaraGuillen::class.java)

    override fun run(vararg args: String) {

        logger.info("Iniciando $nombreApp")
        logger.info("Alumno: $student")
        logger.info("Memoria asignada: $memoria MB")

        logger.info("Entorno: $env")

        if (env == "dev") {
            logger.info("Modo desarrollo activo")
        } else {
            logger.info("Modo producción activo")
        }

        if (maxUsers < 10) {
            logger.warn("Capacidad máxima del sistema: $maxUsers")
        } else {
            logger.info("Capacidad máxima del sistema: $maxUsers")
        }

        logger.info("Sistema configurado exitosamente y listo para iniciar correctamente")
    }
}
