package com.ids.starter.test

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SystemDiagnosticsByAndrickMarcial : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(SystemDiagnosticsByAndrickMarcial::class.java)

    override fun run(vararg args: String) {

        val appName = System.getProperty("APP_NAME")
        val appEnv = System.getProperty("APP_ENV")
        val studentName = System.getProperty("STUDENT_NAME")
        val maxUsers = System.getProperty("MAX_USERS")?.toIntOrNull()

        logger.info("Iniciando $appName")
        logger.info("Entorno: $appEnv")
        logger.info("Alumno: $studentName")

        if (appEnv?.lowercase() == "dev") {
            logger.info("Modo desarrollo activo")
        } else {
            logger.info("Modo producción activo")
        }

        if (maxUsers != null) {

            val message = "Capacidad máxima del sistema: $maxUsers usuarios"

            if (maxUsers < 10) {
                logger.warn(message)
            } else {
                logger.info(message)
            }

        } else {
            logger.error("MAX_USERS no es un número válido")
        }

        logger.info("Sistema listo para iniciar correctamente")
    }
}
