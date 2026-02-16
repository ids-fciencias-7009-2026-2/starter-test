package com.ids.starter.test

import jakarta.annotation.PostConstruct
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class SystemDiagnosticsByLuisCasique {

    private val logger = LoggerFactory.getLogger(SystemDiagnosticsByLuisCasique::class.java)

    @PostConstruct
    fun init() {

        val appName = System.getProperty("APP_NAME")
        val appEnv = System.getProperty("APP_ENV")
        val studentName = System.getProperty("STUDENT_NAME")
        val maxUsers = System.getProperty("MAX_USERS")?.toIntOrNull()

        logger.info("Iniciando $appName")
        logger.info("Entorno: $appEnv")
        logger.info("Alumno: $studentName")

        if (appEnv == "dev") {
            logger.info("Modo desarrollo activo")
        } else {
            logger.info("Modo producción activo")
        }

        if (maxUsers != null) {
            if (maxUsers < 10) {
                logger.warn("Capacidad máxima del sistema: $maxUsers usuarios")
            } else {
                logger.info("Capacidad máxima del sistema: $maxUsers usuarios")
            }
        }

        logger.info("Sistema listo para iniciar correctamente")
    }
}