package com.ids.starter.test

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SystemDiagnosticsByWendySanchez(
    @Value("\${APP_NAME}") private val nombreApp: String,
    @Value("\${APP_ENV}") private val entorno: String,
    @Value("\${STUDENT_NAME}") private val nombreEstudiante: String,
    @Value("\${MAX_USERS}") private val maxUsuarios: String

    ) : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(SystemDiagnosticsByWendySanchez::class.java)

    override fun run(vararg args: String) {
        logger.info("Iniciando $nombreApp")
        logger.info("Entorno: $entorno")
        logger.info("Alumno: $nombreEstudiante")

        if (entorno == "dev") logger.info("Modo desarrollo activo")
        else logger.info("Modo producción activo")

        if (maxUsuarios.toInt() < 10 ) logger.warn("Capacidad máxima del sistema: $maxUsuarios usuarios")
        else logger.info("Capacidad máxima del sistema: $maxUsuarios usuarios")

        logger.info("Sistema listo para iniciar correctamente")
    }
}