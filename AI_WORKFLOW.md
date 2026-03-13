# AI Workflow - Automatizacion API PetStore

## 1. Descripcion del uso de IA

En este proyecto se utilizo inteligencia artificial como apoyo para acelerar la construccion de una automatizacion E2E de API con Serenity BDD, Screenplay y Serenity Rest.

La IA se uso para:
- Proponer la estructura base del proyecto siguiendo Screenplay.
- Generar clases `Task` para cada verbo HTTP del CRUD.
- Crear los `StepDefinitions`, `Runner` y archivo `feature`.
- Sugerir validaciones de respuestas HTTP y buenas practicas de mantenibilidad.
- Redactar documentacion tecnica y funcional.

## 2. Prompts utilizados

Ejemplos de prompts usados durante el desarrollo:

```text
Necesito crear una automatizacion de API utilizando Serenity BDD con el patron Screenplay y Serenity Rest.
Implementa un flujo E2E CRUD para PetStore con POST, GET, PUT, DELETE y GET final de validacion.
```

```text
Genera las clases CreatePet, GetPet, UpdatePet y DeletePet implementando Task y usando SerenityRest.
Usa header Content-Type application/json, pathParam para id y Tasks.instrumented.
```

```text
Crea los StepDefinitions para ejecutar todo el flujo CRUD en un solo escenario y valida codigos 200/404.
```

```text
Configura serenity.conf con base.url https://petstore.swagger.io y logging VERBOSE.
```

```text
Genera documentacion en espanol para README, AI_WORKFLOW y USER_STORIES.
```

## 3. Como la IA ayudo a generar codigo

La IA actuo como copiloto tecnico:
- Convirtio requisitos funcionales en clases Java concretas.
- Propuso nombres de metodos y factories legibles (`withData`, `byId`).
- Estandarizo el uso de `SerenityRest.given()` para peticiones HTTP.
- Alineo la implementacion con buenas practicas de Screenplay (`Task`, `Tasks.instrumented`, separacion por capas).
- Ayudo a reducir errores de estructura y boilerplate repetitivo.

## 4. Como se valido el codigo generado

La validacion del codigo se realizo en dos niveles:

1. **Validacion estatica/estructural**
   - Revision de paquetes y clases segun arquitectura Screenplay.
   - Verificacion de imports, compilacion y consistencia de nombres.

2. **Validacion funcional (E2E CRUD)**
   - Verificar respuesta `200` al crear mascota.
   - Verificar respuesta `200` y datos esperados al consultar.
   - Verificar respuesta `200` y nombre actualizado en `PUT`.
   - Verificar respuesta `200` al eliminar.
   - Verificar respuesta `404` al consultar la mascota eliminada.

## 5. Flujo de trabajo entre desarrollador e IA

El flujo colaborativo fue iterativo:

1. El desarrollador define objetivo, alcance y criterios de aceptacion.
2. La IA propone implementacion inicial (codigo + estructura).
3. El desarrollador revisa, ajusta y solicita mejoras.
4. La IA refina clases, validaciones y documentacion.
5. Se ejecutan pruebas y se corrigen detalles finales.

Este ciclo corto de feedback permitio avanzar rapido manteniendo control humano sobre decisiones tecnicas.

## 6. Beneficios de usar IA en automatizacion de pruebas

- **Mayor velocidad de entrega**: menos tiempo en codigo repetitivo.
- **Mejor consistencia**: patrones y convenciones aplicados de forma uniforme.
- **Soporte en buenas practicas**: diseno en capas y legibilidad del codigo.
- **Mejor onboarding**: documentacion y ejemplos listos para nuevos miembros.
- **Enfoque en calidad**: el equipo invierte mas tiempo en estrategia de pruebas y menos en tareas mecanicas.

## 7. Recomendaciones de uso responsable

- Mantener revision humana obligatoria en cada cambio.
- Ejecutar pruebas automaticas tras cada generacion de codigo.
- No asumir que toda salida de IA es correcta sin validar reglas de negocio.
- Versionar prompts y decisiones para trazabilidad del proceso.
