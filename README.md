# AUTO_API_PETSTORE_SCREENPLAY

## Descripcion del proyecto

Proyecto de automatizacion de pruebas API construido con **Serenity BDD**, **Screenplay Pattern** y **Serenity Rest** para validar el ciclo completo CRUD de la API publica de PetStore:

- `https://petstore.swagger.io`

## Objetivo de la automatizacion

Validar, en un flujo E2E de punta a punta, que la API de mascotas permite:

1. Crear una mascota (`POST`)
2. Consultar la mascota creada (`GET`)
3. Actualizar la mascota (`PUT`)
4. Eliminar la mascota (`DELETE`)
5. Confirmar que ya no existe (`GET` con respuesta esperada `404`)

## Tecnologias utilizadas

- Java 16
- Gradle (con `gradlew.bat` en el proyecto)
- Serenity BDD
- Serenity Cucumber
- Serenity Screenplay
- Serenity Screenplay REST
- Serenity Rest Assured
- Cucumber
- JUnit

## Arquitectura del proyecto (Screenplay Pattern)

El proyecto sigue el patron Screenplay para separar responsabilidades y mejorar mantenibilidad:

- **Tasks**: encapsulan acciones HTTP (crear, consultar, actualizar, eliminar).
- **StepDefinitions**: orquestan el flujo funcional del escenario.
- **Questions**: consultan resultados del sistema (por ejemplo, codigo de estado).
- **Hooks**: preparan y limpian el contexto de ejecucion (actors y setup).
- **Runners**: definen la configuracion de ejecucion Cucumber + Serenity.
- **Util**: utilidades compartidas, como generacion dinamica de ID.

## Estructura del proyecto

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

Implementacion actual relevante:

- `src/test/java/automation/tasks/CreatePet.java`
- `src/test/java/automation/tasks/GetPet.java`
- `src/test/java/automation/tasks/UpdatePet.java`
- `src/test/java/automation/tasks/DeletePet.java`
- `src/test/java/automation/stepdefinitions/PetStoreStepDefinitions.java`
- `src/test/java/automation/runners/PetStoreRunner.java`
- `src/test/resources/features/petstore_crud.feature`
- `src/test/resources/serenity.conf`

## Explicacion del flujo CRUD automatizado

El escenario automatizado ejecuta los siguientes pasos:

1. **POST `/v2/pet`**
   - Crea una mascota con ID dinamico generado con `ThreadLocalRandom`.
   - Body usado:

```json
{
  "id": ID_GENERADO,
  "name": "Firulais",
  "status": "available"
}
```

2. **GET `/v2/pet/{id}`**
   - Consulta la mascota creada por ID.
   - Se espera `200` y nombre `Firulais`.

3. **PUT `/v2/pet`**
   - Actualiza la mascota cambiando el nombre a `FirulaisActualizado`.
   - Se espera `200` y nombre actualizado.

4. **DELETE `/v2/pet/{id}`**
   - Elimina la mascota por ID.
   - Se espera `200`.

5. **GET `/v2/pet/{id}`**
   - Consulta posterior a la eliminacion.
   - Se espera `404` para confirmar eliminacion.

## Requisitos

- JDK 16 instalado y configurado en `JAVA_HOME`.
- Acceso a internet (API publica de PetStore).
- Gradle Wrapper incluido en el repositorio (`gradlew.bat`).

> Nota: la version de Java declarada en `build.gradle` es 16 (`sourceCompatibility` y `targetCompatibility`).

## Como ejecutar las pruebas

Desde la raiz del proyecto en Windows (`cmd.exe`):

```bat
gradlew.bat clean test aggregate
```

Ejecucion puntual del runner (si aplica a tu entorno):

```bat
gradlew.bat test --tests automation.runners.PetStoreRunner
```

## Ejemplo del flujo de prueba (Gherkin)

```gherkin
Feature: CRUD PetStore API

  Scenario: Ejecutar ciclo completo CRUD de mascota
    Given que el usuario crea una mascota
    When consulta la mascota creada
    And actualiza la mascota
    And elimina la mascota
    Then valida que la mascota ya no existe
```

## Serenity Reports (explicacion breve)

Serenity genera reportes HTML con evidencia detallada de la ejecucion:

- Estado de escenarios (paso a paso)
- Peticiones y respuestas HTTP
- Tiempos y trazabilidad de ejecucion
- Resumen general de resultados

Ubicaciones comunes de salida:

- `target/site/serenity/index.html`
- `build/reports/` (segun configuracion de Gradle/Serenity)