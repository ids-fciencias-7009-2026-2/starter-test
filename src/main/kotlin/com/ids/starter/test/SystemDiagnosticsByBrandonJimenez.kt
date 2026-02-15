package com.ids.starter.test

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SystemDiagnosticsByBrandonJimenez(
    @Value("\${app.name}") private val appName: String,
    @Value("\${app.env}") private val appEnv: String,
    @Value("\${app.student}") private val studentName: String,
    @Value("\${app.max-users}") private val maxUsers: Int
) : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(SystemDiagnosticsByBrandonJimenez::class.java)

    override fun run(vararg args: String) {

        // 1. Información general
        logger.info("Iniciando $appName")
        logger.info("Entorno: $appEnv")
        logger.info("Alumno: $studentName")

        // 2. Validar entorno
        if (appEnv == "dev") {
            logger.info("Modo desarrollo activo")
        } else {
            logger.info("Modo producción activo")
        }

        // 3. Procesar valor numérico
        if (maxUsers < 10) {
            logger.warn("Capacidad máxima del sistema: $maxUsers usuarios")
        } else {
            logger.info("Capacidad máxima del sistema: $maxUsers usuarios")
        }

        // 4. Resumen final
        logger.info("Sistema listo para iniciar correctamente")
    }
}