package com.ids.starter.test

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SystemDiagnosticsBySamCharlize : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(SystemDiagnosticsBySamCharlize::class.java)

    @Value("\${APP_NAME}")
    lateinit var appName: String

    @Value("\${APP_ENV}")
    lateinit var appEnv: String

    @Value("\${STUDENT_NAME}")
    lateinit var studentName: String

    @Value("\${MAX_USERS}")
    var maxUsers: Int = 0

    // CORRECCIÓN AQUÍ: Se cambió "String?" por "String" (sin el signo de interrogación)
    override fun run(vararg args: String) {
        logger.info("Iniciando $appName")
        logger.info("Entorno: $appEnv")
        logger.info("Alumno: $studentName")

        if (appEnv == "dev") {
            logger.info("Modo desarrollo activo")
        } else {
            logger.info("Modo producción activo")
        }

        logger.info("Capacidad máxima del sistema: $maxUsers usuarios")

        if (maxUsers < 18) {
            logger.warn("Cuidado: Capacidad muy baja")
        } else if (maxUsers >= 10) {
            logger.info("Capacidad aceptable")
        }

        logger.info("Sistema listo para iniciar correctamente")
    }
}