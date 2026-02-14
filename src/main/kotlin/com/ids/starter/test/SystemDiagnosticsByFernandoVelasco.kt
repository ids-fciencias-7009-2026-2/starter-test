package com.ids.starter.test

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SystemDiagnosticsByFernandoVelasco(
    @Value("\${app.name}") private val appName: String,
    @Value("\${app.env}") private val appEnv: String,
    @Value("\${student.name}") private val studentName: String,
    @Value("\${max.users}") private val maxUsers: Int,

    ) : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(SystemDiagnosticsByFernandoVelasco::class.java)

    override fun run(vararg args: String) {
        logger.info("Iniciando $appName")
        logger.info("Entorno: $appEnv")
        logger.info("Alumno: $studentName")
        if(appEnv == "dev") {
            logger.info("Modo desarrollo activo")
        } else {
            logger.info("Modo produccion activo")
        }
        if(maxUsers < 10) {
            logger.warn("Capacidad maxima del sistema: $maxUsers usuarios")
        } else {
            logger.info("Capacidad maxima del sistema: $maxUsers usuarios")
        }
        logger.info("Sistema listo para iniciar correctamente")

    }
}