package com.ids.starter.test

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class SystemDiagnosticsByKarlaGuadalupe (

    @Value("\${APP_NAME}")
    private val appName: String,

    @Value("\${APP_ENV}")
    private val appEnv: String,

    @Value("\${STUDENT_NAME}")
    private val studentName: String,

    @Value("\${MAX_USERS}")
    private val maxUsers: Int

) : ApplicationRunner {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun run(arg: ApplicationArguments) {

        // Requisito 1: Mostrar información general
        logger.info("Iniciando $appName")
        logger.info("Entorno: $appEnv")
        logger.info("Alumno: $studentName")

        // Requisito 2: Validar entorno
        if (appEnv == "dev") {
            logger.info("Modo desarrollo activo")
        } else {
            logger.info("Modo producción activo")
        }

        // Requisito 3: Procesar valor numérico
        if (maxUsers < 10) {
            logger.warn("Capacidad máxima del sistema: $maxUsers usuarios")
        } else {
            logger.info("Capacidad máxima del sistema: $maxUsers usuarios")
        }

        // Requisito 5: Resumen final
        logger.info("Sistema listo para iniciar correctamente")
    }
}