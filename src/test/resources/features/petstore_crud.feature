Feature: CRUD PetStore API

  Scenario: Ejecutar ciclo completo CRUD de mascota
    Given que el usuario crea una mascota
    When consulta la mascota creada
    And actualiza la mascota
    And elimina la mascota
    Then valida que la mascota ya no existe
