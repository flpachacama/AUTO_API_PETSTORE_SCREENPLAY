# Historias de Usuario - API PetStore

## HDU 1: Crear mascota (POST)

### Historia de Usuario
Como **tester de API**
Quiero **crear una mascota en PetStore mediante el servicio POST**
Para **asegurar que la API permite registrar nuevas mascotas correctamente**

### Criterios de aceptacion
- Se envia una solicitud `POST /v2/pet` con datos validos de mascota.
- La API responde con codigo `200`.
- La respuesta devuelve el mismo `id`, `name` y `status` enviados.

---

## HDU 2: Consultar mascota (GET)

### Historia de Usuario
Como **tester de API**
Quiero **consultar una mascota por su identificador usando GET**
Para **confirmar que la informacion creada puede recuperarse**

### Criterios de aceptacion
- Se envia una solicitud `GET /v2/pet/{id}` con un ID existente.
- La API responde con codigo `200`.
- La respuesta contiene los datos esperados de la mascota consultada.

---

## HDU 3: Actualizar mascota (PUT)

### Historia de Usuario
Como **tester de API**
Quiero **actualizar el nombre de una mascota con el servicio PUT**
Para **validar que los cambios se guardan correctamente en la API**

### Criterios de aceptacion
- Se envia una solicitud `PUT /v2/pet` con el mismo ID y nombre actualizado.
- La API responde con codigo `200`.
- La respuesta refleja el nuevo nombre de la mascota.

---

## HDU 4: Eliminar mascota (DELETE)

### Historia de Usuario
Como **tester de API**
Quiero **eliminar una mascota por su ID con DELETE**
Para **verificar que la API elimina registros y no permite consultarlos despues**

### Criterios de aceptacion
- Se envia una solicitud `DELETE /v2/pet/{id}` para una mascota existente.
- La API responde con codigo `200` al eliminar.
- Una consulta posterior `GET /v2/pet/{id}` responde `404`.
