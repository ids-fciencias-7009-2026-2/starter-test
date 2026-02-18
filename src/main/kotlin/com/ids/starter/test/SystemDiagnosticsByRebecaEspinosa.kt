package com.ids.starter.test

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import org.slf4j.LoggerFactory

@Component
class SystemDiagnosticsByRebecaEspinosa : CommandLineRunner {
    
    private val logger = LoggerFactory.getLogger(javaClass)
    
    override fun run(vararg args: String) {
        // MOSTRAR INFORMACIÓN GENERAL
        val appName = System.getProperty("APP_NAME") ?: "No definido"
        val appEnv = System.getProperty("APP_ENV") ?: "No definido"
        val studentName = System.getProperty("STUDENT_NAME") ?: "No definido"
        
        logger.info("Iniciando $appName")
        logger.info("Entorno: $appEnv")
        logger.info("Alumno: $studentName")
        
        // VALIDAR ENTORNO
        if (appEnv == "dev") {
            logger.info("Modo desarrollo activo")
        } else {
            logger.info("Modo producción activo")
        }
        
        // PROCESAR VALOR NUMÉRICO
        val maxUsers = System.getProperty("MAX_USERS", "0")?.toIntOrNull() ?: 0
        logger.info("Capacidad máxima del sistema: $maxUsers usuarios")
        
        if (maxUsers < 10) {
            logger.warn("Capacidad baja: menos de 10 usuarios")
        } else {
            logger.info("Capacidad suficiente: $maxUsers usuarios")
        }
        
        // RESUMEN FINAL
        logger.info("Sistema listo para iniciar correctamente")
    }
}
