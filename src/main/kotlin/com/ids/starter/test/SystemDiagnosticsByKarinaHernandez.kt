package com.ids.starter.test

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SystemDiagnosticsByKarinaHernandez : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(SystemDiagnosticsByKarinaHernandez::class.java)

    override fun run(vararg args: String) {

        val appName = System.getProperty("APP_NAME") ?: "APP_NAME_no_definido"
        val appEnv = System.getProperty("APP_ENV") ?: "APP_ENV_no_definido"
        val studentName = System.getProperty("STUDENT_NAME") ?: "STUDENT_NAME_no_definido"
        val maxUsersStr = System.getProperty("MAX_USERS") ?: "0"

        logger.info("Iniciando $appName")
        logger.info("Entorno: $appEnv")
        logger.info("Alumno: $studentName")

        if (appEnv == "dev") {
            logger.info("Modo desarrollo activo")
        } else {
            logger.info("Modo producción activo")
        }

        val maxUsers = maxUsersStr.toIntOrNull() ?: 0
        logger.info("Capacidad máxima del sistema: $maxUsers usuarios")

        logger.info("Sistema listo para iniciar correctamente")
    }
}
