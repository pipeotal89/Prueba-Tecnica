Feature: Proceso de registro de un usuario

  @Registro
  Scenario: [TC-01] Registrar un usuario con datos incorrectos
    Given Usuario ingresa a la página
    When Usuario clickea para registrarse
    And Usuario llena el formulario con información válida
    And Usuario envía el formulario
    Then Cuenta del usuario se crea correctamente

  @Registro
  Scenario: [TC-02] Permitir únicamente dos o más palabras en el campo de nombre
    Given Usuario ingresa a la página
    When Usuario clickea para registrarse
    And Usuario ingresa el formulario con <cant> nombres
    Then Botón de enviar del formulario debería estar <estadoBoton>

    Examples:
      | cant | estadoBoton |
      |    1 | desactivado |
      |    2 | activado    |
      |    3 | activado    |

  @Registro
  Scenario: [TC-03] Enviar error si el correo no cumple con el formato
    Given Usuario ingresa a la páginaA
    When Usuario clickea para registrarse
    And Usuario ingresa removiendo <removido> del correo
    Then Botón de enviar del formulario debería estar desactivado

    Examples:
      | removido |
      | @        |
      | .com     |
      | .        |

  @Registro
  Scenario: [TC-04] Enviar error si la el correo ya está registrado
    Given Usuario ingresa a la página
    When Usuario clickea para registrarse
    And Usuario ingresa con un email ya registrado
    Then Botón de enviar del formulario debería estar desactivado

  @Registro
  Scenario: [TC-05] Enviar error si la contraseña no cumple con el formato
    Given Usuario ingresa a la página
    When Usuario clickea para registrarse
    And Usuario ingresa sin <removido> en la contraseña
    Then Botón de enviar del formulario debería estar desactivado

    Examples:
      | removido   |
      | minusculas |
      | mayusculas |
      | numeros    |
      | simbolos   |
      | longitud   |

  @Registro
  Scenario: [TC-06] No permitir enviar el formulario con campos incompletos
    Given Usuario ingresa a la página
    When Usuario clickea para registrarse
    And Usuario llena el formulario dejando <campo> vacío
    Then Botón de enviar del formulario debería estar desactivado

    Examples:
      | campo       |
      | email       |
      | nombre      |
      | contraseñas |

  @Registro
  Scenario: [TC-07] Enviar error si las dos contraseñas son diferentes
    Given Usuario ingresa a la página
    When Usuario clickea para registrarse
    And Usuario llena el formulario con dos contraseñas diferentes
    Then Botón de enviar del formulario debería estar desactivado
