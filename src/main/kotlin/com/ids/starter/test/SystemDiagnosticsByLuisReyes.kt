package com.ids.starter.test

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.boot.CommandLineRunner

@Component
class SystemDiagnosticsByLuisReyes(
    @Value("\${APP_NAME}") private val appName: String,
    @Value("\${APP_ENV}") private val env: String,
    @Value("\${STUDENT_NAME}") private val studentName: String,
    @Value("\${MAX_USERS}") private val maxUsers: Int
    
    ) : CommandLineRunner {
    
        private val logger = LoggerFactory.getLogger(SystemDiagnosticsByLuisReyes::class.java)
   
        override fun run(vararg args: String){
            logger.info("Inciciando $appName...")
            logger.info("Entorno: $env")
            logger.info("Alumno: $studentName")

            if(appName == "dev") logger.info("Modo desarrollo activo") else logger.info("Modo producción activo")
            if(maxUsers < 10) logger.warn("Capacidad máxima del sistema: $maxUsers usuarios")
                else logger.info("Capacidad máxima del sistema: $maxUsers usuarios")

            logger.info("Sistema listo para iniciar correctamente")

        }

    }