package com.ids.starter.test

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SystemDiagnosticsByXimenaCarpinteiro : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(SystemDiagnosticsByXimenaCarpinteiro::class.java)

    override fun run(vararg args: String) {

        val appName = System.getProperty("APP_NAME")
        val appEnv = System.getProperty("APP_ENV")
        val studentName = System.getProperty("STUDENT_NAME")
        val maxUsers = System.getProperty("MAX_USERS").toInt()

        logger.info("Iniciando $appName")
        logger.info("Entorno: $appEnv")
        logger.info("Alumno: $studentName")

        // Para env
        if (appEnv.lowercase() == "dev") {
            logger.info("Modo desarrollo activo")
        } else {
            logger.info("Modo producción activo")
        }

        // Para valor máximo
        logger.info("Capacidad máxima del sistema: $maxUsers usuarios")

        logger.info("Sistema listo para iniciar correctamente")
    }
}
