# 📘Setup base con Spring Boot + Kotlin

Estas notas describen el **setup base del proyecto REST** que utilizaremos durante el curso. El objetivo es que todos partamos desde una **estructura común, profesional y fácil de entender**, similar a lo que se usa en proyectos reales.

Estas configuraciones permiten:

- Ejecutar el proyecto localmente sin modificar código sensible.
- Comprender el uso de variables de entorno.
- Aplicar buenas prácticas de logging.
- Entender el arranque de una aplicación Spring Boot.

---

# 🎯 Objetivos de este setup

Al terminar esta etapa, deberás ser capaz de:

- Clonar y ejecutar un proyecto Spring Boot + Kotlin.
- Configurar variables de entorno usando `.env`.
- Comprender cómo funciona el arranque de Spring Boot.
- Utilizar logs profesionales.
- Entender la separación entre **configuración** y **código**.

---

# 🧱 Tecnologías utilizadas

- Java 21
- Kotlin
- Spring Boot
- Maven / Gradle
- SLF4J + Logback (logging)
- dotenv (manejo de variables de entorno)

---

# 📂 Estructura general del proyecto

```
src/main/kotlin/com/ids/starter/test
 └── LoggerDePrueba.kt
 └── Application.kt

src/main/resources
 └── application.properties

.env.example
.gitignore
```

---

# ⚙️ Variables de entorno con `.env`

En proyectos reales **nunca se deben guardar contraseñas o credenciales directamente en el código**. En su lugar, se utilizan **variables de entorno**.

Para esto, usamos un archivo `.env`.

---

## 📄 Archivo `.env.example`

Este archivo sirve como **plantilla** y sí se sube al repositorio:

```
MY_PASSWORD=tu_password_aqui
APP_NOMBRE=Proyecto Demo REST
```

Cada alumno debe crear su propio archivo `.env` local:

```bash
cp .env.example .env
```

⚠️ El archivo `.env` **no debe subirse a GitHub**.

---

## 🚫 `.gitignore`

Se debe incluir:

```
.env
```

Esto evita subir contraseñas al repositorio.

---

# 🔗 Conexión entre `.env` y `application.properties`

Spring Boot no lee automáticamente archivos `.env`, por lo tanto se carga manualmente en el arranque.

---

## 📄 `application.properties`

```
app.nombre=${APP_NOMBRE:Proyecto Default}
app.my.password=${MY_PASSWORD}
```

Esto significa:

- `${APP_NOMBRE}` → variable leída desde `.env`
- `:Proyecto Default` → valor por defecto si la variable no existe

---

# ▶️ Arranque del proyecto (`main`)

En el archivo principal (`Application.kt`):

```kotlin
import io.github.cdimascio.dotenv.dotenv
import org.springframework.boot.runApplication

fun main(args: Array<String>) {
    dotenv().entries().forEach {
        System.setProperty(it.key, it.value)
    }
    runApplication<Application>(*args)
}
```

Esto permite que:

- Se lea el archivo `.env`
- Se carguen sus variables en el entorno del sistema
- Spring Boot pueda utilizarlas

---

# 📝 Logging profesional

En lugar de usar `println()`, los proyectos reales utilizan **sistemas de logging**.

Ventajas:

- Control de niveles de detalle
- Mejor depuración
- Registros persistentes

---

## 📄 Clase LoggerDePrueba

```kotlin
@Component
class LoggerDePrueba : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(LoggerDePrueba::class.java)

    override fun run(vararg args: String) {
        logger.info("Hello World desde Spring Boot con Kotlin")
    }
}
```

Esto permite:

- Ejecutar código automáticamente al iniciar la aplicación.
- Mostrar mensajes en consola con formato profesional.

---

# 🧠 Conceptos importantes

## 1. Externalización de configuración

Separar configuración del código permite:

- Cambiar entornos (dev, test, prod)
- Mayor seguridad
- Despliegues más fáciles

---

## 2. Variables de entorno

Se usan para:

- Contraseñas
- Tokens
- URLs
- Puertos

Nunca deben almacenarse directamente en el código.

---

## 3. Logging

Niveles principales:

| Nivel | Uso |
| --- | --- |
| TRACE | Detalle extremo |
| DEBUG | Depuración |
| INFO | Flujo normal |
| WARN | Advertencias |
| ERROR | Errores |

---

# 🧪 Práctica sugerida

1. Clonar el repositorio
2. Crear archivo `.env`
3. Ejecutar el proyecto
4. Verificar salida en consola
5. Cambiar valores del `.env` y observar los cambios

---

# 🏁 Resultado esperado

Al ejecutar el proyecto, deberás ver algo similar a:

```
INFO  --- Iniciando Proyecto Demo REST
INFO  --- Hello World desde Spring Boot con Kotlin
```

---

📌 *Estas prácticas replican la forma en la que se configuran aplicaciones backend profesionales.*