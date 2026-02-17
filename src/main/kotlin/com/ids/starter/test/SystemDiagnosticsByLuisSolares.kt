package com.ids.starter.test

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import kotlin.math.max

@Component
class SystemDiagnosticsByLuisSolares(
    @Value("\${app.name}") private val appName: String,
    @Value("\${app.env}") private val appEnv: String,
    @Value("\${app.student.name}") private val studentName: String,
    @Value("\${app.max.users}") private val maxUsers: Int,

    ) : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(SystemDiagnosticsByLuisSolares::class.java)


    override fun run(vararg args: String) {

        // 1 Mostrar informacion general
        logger.info("Iniciando ${appName}")
        logger.info("Entorno: ${appEnv}")
        logger.info("Alumno: ${studentName}")

        // 2 Validar entorno
        if (appEnv == "dev") {
            logger.info("Modo desarrollo activo")
        } else {
            logger.info("Modo produccion activo")
        }

        // 3 Procesar valor numerico
        logger.info("Capacidad maxima del sistema: ${maxUsers}")

        if (maxUsers < 18){
            logger.warn("Atencion: El numero de usuarios es bajo")
        } else if (maxUsers >= 10){
            logger.info("Capacidad de usuarios dentro del rango")
        }

        // 4 Mostrar resumen final
        logger.info("Sistema listo para iniciar correctamente")
    }
}