package com.ids.starter.test

// Herramientas necesarias. SLF4J para los logs, Spring para las anotaciones y CommandLineRunner para que el código se ejecute al iniciar.
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SystemDiagnosticsByAlexisArizmendi : CommandLineRunner {

    // Crea el objeto logger.
    private val logger = LoggerFactory.getLogger(SystemDiagnosticsByAlexisArizmendi::class.java)

    // Inyección de dependencias
    @Value("\${APP_NAME}")
    private lateinit var appName: String
    @Value("\${APP_ENV}")
    private lateinit var appEnv: String
    @Value("\${STUDENT_NAME}")
    private lateinit var studentName: String
    @Value("\${MAX_USERS}")
    private var maxUsers: Int = 0

    // Permite la ejecución al iniciar la aplicación
    override fun run(vararg args: String) {
        // Mostrar información general
        logger.info("Iniciando $appName")
        logger.info("Entorno: $appEnv")
        logger.info("Alumno: $studentName")

        // Validar entorno
        if (appEnv == "dev") {
            logger.info("Modo desarrollo activo")
        } else {
            logger.info("Modo producción activo")
        }

        // Procesar valor numérico
        logger.info("Capacidad máxima del sistema: $maxUsers usuarios")


        if (maxUsers < 10) {
            // Usamos el metodo .warn(), para eventos inesperado o peligrosos
            logger.warn("La capacidad es menor a 10")
        } else {
            // Usamos el metodo .info(), para eventos que son esperados
            logger.info("La capacidad es mayor o igual a 10")
        }

        // Resumen final
        logger.info("Sistema listo para iniciar correctamente")
    }
}