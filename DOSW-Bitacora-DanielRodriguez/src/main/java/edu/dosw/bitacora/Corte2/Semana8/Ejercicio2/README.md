# Ejercicio 2: Sistema de Procesamiento de Pagos

## Qué implementa
- **Adapter** para integrar proveedores externos con APIs diferentes.
- **Chain of Responsibility** para ejecutar validaciones configurables.
- **Singleton** para centralizar el servicio de pagos.

## Uso general
1. Obtener la instancia única con `PaymentService.getInstance()`.
2. Registrar un proveedor nuevo con `registerProvider(...)` si hace falta.
3. Configurar o reemplazar la cadena de validación con `setValidationChain(...)`.
4. Procesar un pago con `process("paypal", request)` u otro proveedor registrado.

## Extensibilidad
Para agregar un nuevo proveedor:
- Crear un adaptador que implemente `PaymentAdapter`.
- Registrar el adaptador en `PaymentService` sin cambiar la lógica principal.

