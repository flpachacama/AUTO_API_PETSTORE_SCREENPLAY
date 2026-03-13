# AUTO_API_PETSTORE_SCREENPLAY

Automatizacion API con Serenity BDD + Screenplay + Serenity Rest para validar el flujo CRUD completo de PetStore.

## Escenario cubierto

- POST `/v2/pet` (crear mascota)
- GET `/v2/pet/{id}` (consultar mascota)
- PUT `/v2/pet` (actualizar mascota)
- DELETE `/v2/pet/{id}` (eliminar mascota)
- GET `/v2/pet/{id}` (validar eliminacion)

## Estructura principal

- `src/test/java/automation/hooks`
- `src/test/java/automation/questions`
- `src/test/java/automation/runners`
- `src/test/java/automation/stepdefinitions`
- `src/test/java/automation/tasks`
- `src/test/java/automation/ui`
- `src/test/java/automation/util`

## Ejecucion

```bat
gradlew.bat clean test aggregate
```

Reporte Serenity generado en:

- `target/site/serenity/index.html`