package com.ids.starter.test

import io.github.cdimascio.dotenv.dotenv
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SystemDiagnosticsByMarcoRubio : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(SystemDiagnosticsByMarcoRubio::class.java)
    private val dotenv = dotenv()

    override fun run(vararg args: String) {
        //lectura del .env
        val appName = dotenv["APP_NAME"]
        val myEnv = dotenv["APP_ENV"]
        val studentName = dotenv["STUDENT_NAME"]
        val maxUsers = dotenv["MAX_USERS"].toInt()

        //logs requeridos
        logger.info("Iniciando $appName")
        logger.info("Entorno: $myEnv")
        logger.info("Alumno: $studentName")

        //validación del entorno
        val modo = if (myEnv == "dev") {
            "Modo desarrollo activo"
        } else {
            "Modo producción activo"
        }
        logger.info(modo)

        //procesar valor numérico
        if (maxUsers < 10) {
            logger.warn("Capacidad máxima del sistema: $maxUsers usuarios")
        } else {
            logger.info("Capacidad máxima del sistema: $maxUsers usuarios")
        }

        //resumen final.
        logger.info("Sistema listo para iniciar correctamente")
    }
}