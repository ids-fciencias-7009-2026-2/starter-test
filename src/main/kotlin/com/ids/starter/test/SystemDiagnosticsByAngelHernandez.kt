package com.ids.starter.test

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SystemDiagnosticsByAngelHernandez : CommandLineRunner {

    private val log = LoggerFactory.getLogger(SystemDiagnosticsByAngelHernandez::class.java)

    private fun getVar(key: String): String? =
        System.getProperty(key) ?: System.getenv(key)

    override fun run(vararg args: String) {
        val appName = getVar("APP_NAME") ?: "App"
        val env = (getVar("APP_ENV") ?: "prod").lowercase()
        val student = getVar("STUDENT_NAME") ?: "Alumno"
        val maxUsers = (getVar("MAX_USERS") ?: "0").toIntOrNull() ?: 0

        log.info("Iniciando {}", appName)
        log.info("Entorno: {}", env)
        log.info("Alumno: {}", student)

        if (env == "dev") log.info("Modo desarrollo activo")
        else log.info("Modo producción activo")

        if (maxUsers < 10) log.warn("Capacidad máxima del sistema: {} usuarios", maxUsers)
        else log.info("Capacidad máxima del sistema: {} usuarios", maxUsers)

        log.info("Sistema listo para iniciar correctamente")
    }
}
