# Automatizacion API PetStore con Serenity BDD

## 1. Descripcion del Proyecto

Este repositorio contiene una automatizacion de pruebas de API construida con **Serenity BDD**, **Serenity Rest** y el patron **Screenplay**. La solucion valida el ciclo CRUD completo de la API publica de PetStore:

- `https://petstore.swagger.io`

El escenario E2E ejecuta en un solo flujo las operaciones de creacion, consulta, actualizacion y eliminacion de una mascota, incluyendo la verificacion final de eliminacion.

## 2. Objetivo

Validar la integridad y el comportamiento esperado de los servicios REST de PetStore mediante pruebas automatizadas, reduciendo riesgos de regresion y mejorando la confianza en los endpoints expuestos.

## 3. Tecnologias Utilizadas

- Java
- Serenity BDD
- Serenity Rest
- Cucumber
- Screenplay Pattern
- Gradle o Maven

## 4. Arquitectura del Proyecto

El proyecto usa el patron **Screenplay**, que organiza la automatizacion por responsabilidades y favorece la mantenibilidad:

- Los **actores** ejecutan acciones sobre el sistema.
- Las **tasks** encapsulan interacciones de negocio (peticiones HTTP).
- Las **questions** consultan resultados para validar comportamientos.
- Los **step definitions** orquestan el flujo funcional del escenario.

## 5. Estructura del Proyecto

```text
automation
 ├── hooks
 ├── questions
 ├── runners
 ├── stepdefinitions
 ├── tasks
 ├── ui
 └── util
```

Descripcion de carpetas:

- `hooks`: configuracion y ciclo de vida antes/despues de escenarios.
- `questions`: consultas para validar estados y respuestas.
- `runners`: clases de ejecucion (Cucumber con Serenity).
- `stepdefinitions`: definicion de pasos Gherkin y orquestacion del flujo.
- `tasks`: acciones reutilizables para consumir endpoints REST.
- `ui`: espacio reservado para componentes UI (si aplica en el futuro).
- `util`: utilidades compartidas (por ejemplo, generacion de datos dinamicos).

## 6. Flujo de Prueba Automatizado

El escenario automatizado ejecuta este flujo CRUD:

1. Crear mascota (`POST`)
2. Consultar mascota (`GET`)
3. Actualizar mascota (`PUT`)
4. Eliminar mascota (`DELETE`)
5. Verificar eliminacion (`GET`)

## 7. Requisitos para ejecutar el proyecto

- Java 11 o superior
- Maven o Gradle instalado
- Git

> Nota: valida la version de Java configurada en el proyecto (`build.gradle` o `pom.xml`) para alinear el entorno local.

## 8. Clonar el repositorio

```bash
git clone URL_DEL_REPOSITORIO
```

## 9. Ejecutar las pruebas

Si usas **Gradle** (Linux/macOS):

```bash
./gradlew clean test
```

Si usas **Gradle** en Windows:

```bat
gradlew clean test
```

Si usas **Maven**:

```bash
mvn clean verify
```

## 10. Reportes de Serenity

Serenity genera reportes automaticamente al finalizar la ejecucion de pruebas, incluyendo detalle de escenarios, pasos, resultados y evidencia de las llamadas realizadas.

Ruta esperada del reporte:

- `target/site/serenity/index.html`

## 11. Autor

- **Freddy Leonel**