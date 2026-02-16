package com.ids.starter.test

import org.springframework.stereotype.Component
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Value
import org.slf4j.LoggerFactory

@Component
class SystemDiagnosticsByAlanDiaz {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @Value("\${APP_NAME}") private lateinit var appName: String
    @Value("\${APP_ENV}") private lateinit var appEnv: String
    @Value("\${STUDENT_NAME}") private lateinit var studentName: String
    @Value("\${MAX_USERS}") private var maxUsers: Int = 0

    @PostConstruct
    fun init() {
        logger.info("Iniciando $appName")
        logger.info("Entorno: $appEnv")
        logger.info("Alumno: $studentName")

        if (appEnv == "dev") logger.info("Modo desarrollo activo")
        else logger.info("Modo producción activo")

        logger.info("Capacidad máxima del sistema: $maxUsers usuarios")

        if (maxUsers < 18) logger.warn("Capacidad por debajo del umbral")
        if (maxUsers >= 10) logger.info("Capacidad suficiente")

        logger.info("Sistema listo para iniciar correctamente")
    }
}