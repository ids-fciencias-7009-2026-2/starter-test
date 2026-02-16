package com.ids.starter.test

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.boot.CommandLineRunner

@Component
class SystemDiagnosticsByAriadnaGarcia(

    @Value("\${app.name}") private val appName: String,
    @Value("\${app.name}") private val appEnv: String,
    @Value("\${app.student.name}") private val studentName: String,
    @Value("\${app.max.users}") private val maxUsers: Int

) : CommandLineRunner {
    private val logger = LoggerFactory.getLogger(SystemDiagnosticsByAriadnaGarcia::class.java)

    override fun run(vararg args: String) {
        logger.info("Iniciando $appName")
        logger.info("Entorno: $appEnv")
        logger.info("Alumno: $studentName")

        if(appEnv == "dev"){
            logger.info("Modo desarrollo activo")
        } else{
            logger.info("Modo de producción activo")
        }

        if(maxUsers < 10){
            logger.warn("Capacidad máxima del sistema: $maxUsers usuarios")

        } else {
            logger.info("Capacidad máxima del sistema: $maxUsers usuarios")
        }

        logger.info("Sistema listo para iniciar correctamente")
    }
}
