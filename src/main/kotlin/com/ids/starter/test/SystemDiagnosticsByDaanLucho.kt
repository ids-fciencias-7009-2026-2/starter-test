package com.ids.starter.test

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SystemDiagnosticsByDaanLucho : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(SystemDiagnosticsByDaanLucho::class.java)

    @Value("\${APP_NAME:Sistema Demo}")
    private lateinit var appName: String

    @Value("\${APP_ENV:dev}")
    private lateinit var appEnv: String

    @Value("\${STUDENT_NAME:Daan Lucho}")
    private lateinit var studentName: String

    @Value("\${MAX_USERS:0}")
    private var maxUsers: Int = 0

    // FIJATE AQUÍ: El "vararg args: String" debe ser exacto, sin el "?"
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

        if (maxUsers < 10) {
            logger.warn("Atención: Capacidad de usuarios muy baja")
        } else {
            logger.info("Capacidad dentro de los parámetros normales")
        }

        logger.info("Sistema listo para iniciar correctamente")
    }
}