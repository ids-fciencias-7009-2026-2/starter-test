package com.ids.starter.test

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SystemDiagnosticsByWendySanchez(
    @Value("\${app.name}") private val nombreApp: String,
    @Value("\${app.env}") private val entorno: String,
    @Value("\${app.student.name}") private val nombreEstudiante: String,
    @Value("\${app.max.users}") private val maxUsuarios: String

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