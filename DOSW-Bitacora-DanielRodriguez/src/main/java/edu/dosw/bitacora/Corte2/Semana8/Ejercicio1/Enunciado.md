# Ejercicio 1: Sistema de Notificaciones

- Una empresa necesita un sistema que envíe notificaciones a los usuarios a través de diferentes canales como: Email, SMS y Push Notification.
- El sistema debe permitir que el tipo de notificación pueda cambiar dinámicamente, dependiendo del canal seleccionado.
- Además, se requiere que todas las notificaciones pasen por un servicio centralizado que gestione el envío, para evitar múltiples instancias del servicio en el sistema.
- Requisitos:
   - El sistema debe permitir agregar nuevos tipos de notificación sin modificar el código existente.
   - El servicio de envío debe existir una sola vez en el sistema.
   - El sistema debe poder cambiar el comportamiento del envío según el canal elegido.