package com.ids.starter.test

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SystemDiagnosticsByBrendaRodriguez(
    @Value("\${app.autor}") private val nombre: String,
    @Value("\${spring.application.name}") private val app: String,
    @Value("\${app.entorno}") private val entorno: String,
    @Value("\${app.max.users}") private val max: Int,

    ) : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(SystemDiagnosticsByBrendaRodriguez::class.java)


    override fun run(vararg args: String) {
        logger.info("Iniciando $app...")
        logger.info("Entorno: $entorno")
        logger.info("Alumno: $nombre")

        if(entorno == "dev") logger.info("Modo desarrollo activo") else logger.info("Modo producción activo")

        if(max < 10){
            logger.warn("Capacidad máxima del sistema: $max usuarios")
        } else{
            logger.info("Capacidad máxima del sistema: $max usuarios")
        }

        logger.info("Sistema listo para iniciar correctamente")
    }

}