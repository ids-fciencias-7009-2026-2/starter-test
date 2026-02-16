package com.ids.starter.test

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component


@Component
class SystemDiagnosticsByJulietaFlores (
    @Value("\${APP_NAME}") private val name: String,
    @Value("\${APP_ENV}") private val env: String,
    @Value("\${STUDENT_NAME}") private val student: String,
    @Value("\${MAX_USERS}") private val maxUsers: Int ,

    ) : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(SystemDiagnosticsByJulietaFlores::class.java)


    override fun run(vararg args: String) {
        logger.info("Iniciando $name")
        logger.info("Entorno: $env")
        logger.info("Alumno: $student")
        if(env == "dev")
            logger.info("Modo desarrollo activo")
        else
            logger.info("Modo producción activo")



        val max_capacity_msg = "Capacidad máxima del sistema: $maxUsers usuarios"
        if(maxUsers <10)
            logger.warn(max_capacity_msg)
        else
            logger.info(max_capacity_msg)

        logger.info("Sistema listo para iniciar correctamente")


    }

}