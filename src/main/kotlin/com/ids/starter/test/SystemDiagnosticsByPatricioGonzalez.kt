package com.ids.starter.test

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SystemDiagnosticsByPatricioGonzalez (
    @Value("\${app.name}") private val appName: String,
    @Value("\${app.env}") private val myEnv: String,
    @Value("\${student.name}") private val studentName: String,
    @Value("\${max.users}") private val maxUsers: Int,

    ) : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(SystemDiagnosticsByPatricioGonzalez::class.java)

    override fun run(vararg args: String) {
        logger.info("Starting SystemDiagnosticsByPatricioGonzalez")
        logger.info("Iniciando $appName")
        logger.info("Alumno: $studentName")
        val modoMensaje = if (myEnv == "dev") "Modo desarrollo activo" else "Modo producción activo"
        logger.info(modoMensaje)
        //Sé que el when está feo pero quería usarlo
        when (maxUsers < 10) {
            true -> logger.warn("Capacidad máxima del sistema: $maxUsers usuarios")
            false -> logger.info("Capacidad máxima del sistema: $maxUsers usuarios")
        }
        logger.info("Sistema listo para iniciar correctamente")
    }
}