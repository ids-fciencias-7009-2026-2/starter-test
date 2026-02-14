package com.ids.starter.test

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SystemDiagnosticsByIsaacGarcia(
    @Value("\${app.name}") private val appName: String,
    @Value("\${app.env}") private val envValue: String,
    @Value("\${student.name}") private val studentName: String,
    @Value("\${max.users}") private val capacityUsers: Int,
    ) : CommandLineRunner {

    private  val logger = LoggerFactory.getLogger(SystemDiagnosticsByIsaacGarcia::class.java)

    override fun run(vararg args: String) {
        logger.info("Iniciando: $appName")
        logger.info("Entorno: $envValue")
        logger.info("Alumno: $studentName")

        val logOutput = if(envValue == "dev") "Modo desarrollo activo" else "Modo producción activo"
        logger.info(logOutput)

        val users = "Capacidad máxima del sistema: $capacityUsers usuarios"
        if(capacityUsers < 10) logger.warn(users) else logger.info(users)

        logger.info("Sistema listo para iniciar correctamente")
    }

}