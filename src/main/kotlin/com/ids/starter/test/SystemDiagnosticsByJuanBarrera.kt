package com.ids.starter.test

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SystemDiagnosticsByJuanBarrera(
    @Value("\${APP_NAME}") private val appName: String,
    @Value("\${APP_ENV}") private val appEnv: String,
    @Value("\${STUDENT_NAME}") private val studentName: String,
    @Value("\${MAX_USERS}") private val maxUsers: Int,

    ) : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(SystemDiagnosticsByJuanBarrera::class.java)


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
            logger.warn("Capacidad de usuarios por debajo del límite sugerido")
        }
        if (maxUsers >= 10) {
            logger.info("Capacidad operativa dentro de los rangos")
        }
        logger.info("Sistema listo para iniciar correctamente")
    }
}