import io.github.cdimascio.dotenv.dotenv
import java.util.logging.Level
import java.util.logging.Logger

class SystemDiagnosticsByLuisMendez {

    private val logger: Logger = Logger.getLogger(SystemDiagnosticsByLuisMendez::class.java.name)
    private val dotenv = dotenv()

    fun runDiagnostics() {

        // Leer variables del .env
        val appName = dotenv["APP_NAME"] ?: "Aplicación"
        val appEnv = dotenv["APP_ENV"] ?: "prod"
        val studentName = dotenv["STUDENT_NAME"] ?: "Desconocido"
        val maxUsers = dotenv["MAX_USERS"]?.toIntOrNull() ?: 0

        // Mostrar información general
        logger.info("Iniciando $appName")
        logger.info("Entorno: $appEnv")
        logger.info("Alumno: $studentName")

        // Validar entorno
        if (appEnv.lowercase() == "dev") {
            logger.info("Modo desarrollo activo")
        } else {
            logger.info("Modo producción activo")
        }

        // Procesar valor numérico
        if (maxUsers < 10) {
            logger.log(Level.WARNING, "Capacidad máxima del sistema: $maxUsers usuarios")
        } else {
            logger.info("Capacidad máxima del sistema: $maxUsers usuarios")
        }

        // Mostrar resumen final
        logger.info("Sistema listo para iniciar correctamente")
    }
}
