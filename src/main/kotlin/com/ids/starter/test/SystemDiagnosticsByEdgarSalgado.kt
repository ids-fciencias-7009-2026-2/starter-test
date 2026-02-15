package com.ids.starter.test

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SystemDiagnosticsByEdgarSalgado (
    @Value("\${APP_NAME}") private val appName: String,
    @Value("\${APP_ENV}") private val appEnv: String,
    @Value("\${STUDENT_NAME}") private val studentName: String,
    @Value("\${MAX_USERS}") private val maxUsers: Int,

    ) : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(SystemDiagnosticsByEdgarSalgado::class.java)


    override fun run(vararg args: String) {
        logger.info("Iniciando $appName")
        logger.info("Entorno: $appEnv")
        logger.info("Alumno: $studentName")
        if(appEnv=="dev"){
            logger.info("Modo desarrollo activo")
        } else {
            logger.info("Modo producción activo")
        }
        if(maxUsers < 10){
            logger.warn("Capacidad máxima del sistema: $maxUsers")
        } else {
            logger.info("Capacidad máxima del sistema: $maxUsers")
        }
        logger.info("Sistema listo para iniciar correctamente")
    }
}