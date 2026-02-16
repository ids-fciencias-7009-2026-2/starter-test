package com.ids.starter.test

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SystemDiagnosticsByMiguelValente(
    @Value("\${app.name}") private val appName: String,
    @Value("\${app.env}") private val env: String,
    @Value("\${app.student.name}") private val studentName: String,
    @Value("\${app.max.users}") private val maxUsers: Int,
    @Value("\${app.total.memory.mb}") private val totalMemoryMb: Int,
    ) : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(SystemDiagnosticsByMiguelValente::class.java)

    override fun run(vararg args: String) {
        logger.info("Iniciando $appName")
        logger.info("Entorno: $env")
        logger.info("Alumno: $studentName")

        if (env == "dev" ) {
            logger.info("Modo desarrollo activo")
        } else {
            logger.info("Modo producción activo")
        }

        val maxUsersMessage = "Capacidad máxima del sistema: $maxUsers usuarios"
        if (maxUsers < 10 ) {
            logger.warn(maxUsersMessage)
        } else {
            logger.info(maxUsersMessage)
        }

        logger.info("Memoria total del sistema: $totalMemoryMb MB")
        logger.info("Sistema listo para iniciar correctamente")
    }
}