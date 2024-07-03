Feature: Proceso de logueo de un usuario

  @Login
  Scenario: [TC-08] Permitir ingresoWS con datos correctos
    Given Usuario ingresa a la página
    And Usuario llena el Login con datos correctos
    And Usuario envía el Login
    Then Usuario es redirigido a su perfil

  @Login
  Scenario: [TC-09] NNo permitir enviar el formulario de ingreso con datos incompletos
    Given Usuario ingresa a la página
    And Usuario llena el campo de <campo>
    Then Botón de enviar del Login debería estar desactivado

    Examples:
      | campo      |
      | email      |
      | contraseña |

  @Login
  Scenario: [TC-10] Mostrar el nombre de usuario al ingresar correctamente
    Given Usuario ingresa a la página
    And Usuario llena el Login con datos correctos
    And Usuario envía el Login
    Then Usuario puede ver su nombre en el perfil

  @Login
  Scenario: [TC-11] Cerrar la cuenta del usuario al usar el botón de Logout
    Given Usuario ingresa a la página
    And Usuario llena el Login con datos correctos
    And Usuario envía el Login
    And Usuario se desloguea de su cuenta
    Then Usuario es des-autenticado
