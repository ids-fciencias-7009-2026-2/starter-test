package com.ids.starter.test

import io.github.cdimascio.dotenv.dotenv
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SystemDiagnosticsByLuisCarrillo : CommandLineRunner {
    val logger = LoggerFactory.getLogger(SystemDiagnosticsByLuisCarrillo::class.java)

    override fun run(vararg args: String) {
        val env = dotenv()

        env.entries().forEach { entry ->
            System.setProperty(entry.key, entry.value)
        }

        val appName = env.get("APP_NAME")
        val entorno = env.get("APP_ENV")
        val studentName = env.get("STUDENT_NAME")
        val usuarios = env.get("MAX_USERS").toInt()

        logger.info("Iniciando Sistema Demo")
        logger.info("Entorno: $entorno")
        logger.info("Alumno: $studentName")

        if (entorno == "dev") {
            logger.info("Modo desarrollo activo")
        }

        if (usuarios < 10) {
            logger.warn("Capacidad máxima del sistema: $usuarios")
        } else {
            logger.info("Capacidad máxima del sistema: $usuarios")
        }

        logger.info("Sistema listo para iniciar correctamente")
    }
}