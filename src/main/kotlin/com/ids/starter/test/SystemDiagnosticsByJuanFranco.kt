package com.ids.starter.test

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SystemDiagnosticsByJuanFranco : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(SystemDiagnosticsByJuanFranco::class.java)

    override fun run(vararg args: String) {

        val appName = System.getProperty("APP_NAME")
        val appEnv = System.getProperty("APP_ENV")
        val studentName = System.getProperty("STUDENT_NAME")
        val maxUsers = System.getProperty("MAX_USERS")?.toIntOrNull() ?: 0

        // Información general
        logger.info("Iniciando $appName")
        logger.info("Entorno: $appEnv")
        logger.info("Alumno: $studentName")

        // Validar entorno
        if (appEnv == "dev") {
            logger.info("Modo desarrollo activo")
        } else {
            logger.info("Modo producción activo")
        }

        // Procesar valor numérico
        if (maxUsers < 10) {
            logger.warn("Capacidad máxima del sistema: $maxUsers usuarios")
        } else {
            logger.info("Capacidad máxima del sistema: $maxUsers usuarios")
        }

        // Resumen final
        logger.info("Sistema listo para iniciar correctamente")
    }
}
