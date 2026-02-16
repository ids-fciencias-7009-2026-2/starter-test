package com.ids.starter.test

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SystemDiagnosticsByYolandaSanchez (

    @Value("\${APP_NAME}") private val nombre: String,
    @Value("\${APP_ENV}") private val entorno: String,
    @Value("\${STUDENT_NAME}") private val estudiante: String,
    @Value("\${MAX_USERS}") private val numUsuarios: Int,

    ) : CommandLineRunner {

        private val logger = LoggerFactory.getLogger(SystemDiagnosticsByYolandaSanchez::class.java)


        override fun run(vararg args: String) {
            logger.info("Iniciando $nombre")
            logger.info("Entorno:  $entorno")
            logger.info("Alumna: $estudiante")

            if (entorno == "dev"){
                logger.info("Modo desarrollo activo")
            } else {
                logger.info("Modo producción activo")
            }

            if (numUsuarios <= 10){
                logger.warn("Capacidad máxima del sistema: $numUsuarios usuarios")
            } else {
                logger.info("Capacidad máxima del sistema: $numUsuarios usuarios")
            }

            logger.info("Sistema listo para iniciar correctamente")


        }
}