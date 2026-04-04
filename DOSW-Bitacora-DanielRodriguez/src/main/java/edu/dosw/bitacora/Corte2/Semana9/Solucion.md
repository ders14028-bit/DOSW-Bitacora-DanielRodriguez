# Solución — Semana 9

## 1) Identificación de requerimientos (explícitos e implícitos)

### Supuestos razonables
- La plataforma es web y requiere autenticación para operar con datos personales.
- Cada jugador tiene una cuenta, inventario y progreso persistente.
- Los combates son asíncronos (no en tiempo real), pero sus resultados deben ser consistentes.

### Catálogo de requerimientos
- **RF-01**: El sistema debe permitir el registro e inicio de sesión de usuarios.
- **RF-02**: El sistema debe permitir coleccionar criaturas Bakugan en un inventario por usuario.
- **RF-03**: El sistema debe permitir mejorar criaturas (nivel, atributos o habilidades).
- **RF-04**: El sistema debe permitir crear y resolver combates estratégicos entre jugadores.
- **RF-05**: El sistema debe almacenar el historial y resultado de cada partida.
- **RF-06**: El sistema debe implementar emparejamientos justos entre jugadores.
- **RF-07**: El sistema debe calcular resultados de combate con reglas de balance de criaturas/habilidades.
- **RF-08**: El sistema debe permitir consultar inventario, progreso y estadísticas de combate.
- **RF-09**: El sistema debe permitir administración básica de catálogo de criaturas y habilidades.
- **RF-10**: El sistema debe dejar preparado un mecanismo extensible para agregar eventos, rankings y cooperativo.
- **RNF-01**: El sistema debe garantizar consistencia de resultados de combate en escenarios asíncronos.
- **RNF-02**: El sistema debe persistir datos de partidas, inventarios y progreso sin pérdida ante fallos.
- **RNF-03**: El sistema debe responder operaciones clave (inventario, consulta de combate) en menos de 2 segundos en condiciones normales.
- **RNF-04**: El sistema debe diseñarse con arquitectura modular para facilitar evolución futura.
- **RNF-05**: El sistema debe proteger datos de usuario (autenticación segura y control de acceso).
- **RNF-06**: El sistema debe registrar auditoría mínima de combates y cambios relevantes.

---

## 2) Clasificación y justificación

- **Funcionales (RF)**: describen comportamientos y servicios del sistema (registro, combates, inventario, emparejamiento, administración).
- **No funcionales (RNF)**: describen atributos de calidad y restricciones (consistencia, rendimiento, seguridad, mantenibilidad, auditoría).

Ejemplo de justificación:
- **RF-06** es funcional porque define una capacidad concreta del sistema: emparejar jugadores.
- **RNF-03** es no funcional porque define un criterio de desempeño medible, no una función de negocio directa.

---

## 3) Redacción correcta (formato “El sistema debe…”)

Todos los requerimientos anteriores fueron redactados en formato formal y verificable. Para evitar ambigüedad:
- Se usaron verbos de acción claros (permitir, almacenar, calcular, garantizar).
- Se incluyeron criterios medibles donde aplica (ej. RNF-03: menos de 2 segundos).
- Se separó comportamiento de calidad técnica (RF vs RNF).

---

## 4) Priorización (Alta / Media / Baja)

| ID | Prioridad | Justificación |
|---|---|---|
| RF-01 | Alta | Sin autenticación no hay trazabilidad por usuario. |
| RF-02 | Alta | Núcleo del negocio: colección e inventario. |
| RF-03 | Alta | Núcleo de progresión del juego. |
| RF-04 | Alta | Valor principal del producto: combates. |
| RF-05 | Alta | Necesario para consistencia, soporte y análisis. |
| RF-06 | Alta | Impacta justicia percibida y retención de usuarios. |
| RF-07 | Alta | Impacta balance y confianza en resultados. |
| RF-08 | Media | Importante para UX, pero depende de módulos base. |
| RF-09 | Media | Necesario para operación, pero posterior al núcleo. |
| RF-10 | Baja | Es preparación a futuro, no MVP inmediato. |
| RNF-01 | Alta | Sin consistencia se compromete credibilidad del sistema. |
| RNF-02 | Alta | Riesgo crítico de pérdida de información. |
| RNF-03 | Media | Afecta experiencia, pero no bloquea MVP inicial. |
| RNF-04 | Media | Clave para evolución, pero no bloquea primer release. |
| RNF-05 | Alta | Riesgo legal y de seguridad. |
| RNF-06 | Media | Importante para soporte y mejora continua. |

---

## 5) Dependencias y bloqueos

### Dependencias principales
- **RF-02** depende de **RF-01** (usuario autenticado).
- **RF-03** depende de **RF-02** (no se mejora lo que no existe en inventario).
- **RF-04** depende de **RF-01, RF-02, RF-07 y RNF-01**.
- **RF-05** depende de **RF-04** y **RNF-02**.
- **RF-06** depende de **RF-01**, métricas de jugador y reglas de balance (**RF-07**).
- **RF-08** depende de **RF-02, RF-03, RF-05**.
- **RF-10** depende de **RNF-04** (arquitectura extensible).

### Bloqueos potenciales
- Reglas de balance incompletas o no validadas por negocio.
- Falta de criterios claros para “emparejamiento justo”.
- Definición insuficiente de cómo resolver conflictos de consistencia en combates asíncronos.
- Ausencia de acuerdos de seguridad (política de contraseñas, sesiones, permisos).

---

## 6) Matriz de trazabilidad

| ID | Tipo | Módulo / Caso de uso asociado | Prueba o validación sugerida |
|---|---|---|---|
| RF-01 | Funcional | Autenticación / Registro y login | Prueba de registro exitoso y login válido/inválido |
| RF-02 | Funcional | Inventario / Gestionar criaturas | Prueba CRUD de inventario por usuario |
| RF-03 | Funcional | Progresión / Mejorar criatura | Prueba de mejora con recursos válidos e inválidos |
| RF-04 | Funcional | Combate / Iniciar y resolver combate | Prueba de flujo completo de combate asíncrono |
| RF-05 | Funcional | Historial / Consultar partidas | Prueba de persistencia y consulta de resultados |
| RF-06 | Funcional | Matchmaking / Emparejamiento | Prueba de emparejamiento por nivel/ranking |
| RF-07 | Funcional | Motor de reglas / Balance | Prueba de cálculo determinista con mismos datos de entrada |
| RF-08 | Funcional | Perfil jugador / Estadísticas | Prueba de consulta de progreso e indicadores |
| RF-09 | Funcional | Administración / Catálogo de criaturas | Prueba de alta/baja/cambio de habilidad |
| RF-10 | Funcional | Extensibilidad / Módulos futuros | Prueba de integración de un módulo nuevo sin romper existentes |
| RNF-01 | No funcional | Consistencia transaccional | Prueba de concurrencia y repetibilidad de resultados |
| RNF-02 | No funcional | Persistencia y recuperación | Prueba de recuperación tras fallo simulado |
| RNF-03 | No funcional | Rendimiento | Prueba de tiempos de respuesta bajo carga normal |
| RNF-04 | No funcional | Arquitectura modular | Revisión técnica de acoplamiento y dependencias |
| RNF-05 | No funcional | Seguridad de acceso | Prueba de control de acceso y autenticación |
| RNF-06 | No funcional | Trazabilidad / Auditoría | Prueba de registro de eventos críticos |

---

## 7) Análisis de ambigüedades (mínimo 3)

1. **“Emparejamientos justos”**
   - Ambigüedad: no define métrica de justicia (nivel, ranking, historial, win-rate).
   - Validación requerida: acordar criterio principal y tolerancias.

2. **“Balance entre criaturas y habilidades”**
   - Ambigüedad: no define reglas numéricas ni frecuencia de ajustes.
   - Validación requerida: definir política de balance y parámetros base.

3. **“Consistencia en combates no tiempo real”**
   - Ambigüedad: no define manejo de simultaneidad, reintentos o conflictos.
   - Validación requerida: acordar reglas transaccionales y estrategia de resolución.

4. **“Facilidad de evolución a futuro”**
   - Ambigüedad: no define indicadores técnicos de extensibilidad.
   - Validación requerida: acordar estándares mínimos (modularidad, APIs, versionado).

5. **“Eventos, rankings y cooperativo” (futuro)**
   - Ambigüedad: no hay alcance, prioridad ni fecha.
   - Validación requerida: definir roadmap y criterios de entrada al backlog.

---

## Conclusión

La solución traduce el enunciado informal en un set de requerimientos claros, clasificados, priorizados y trazables. Con esto se reduce riesgo de interpretación y se establece una base sólida para diseño, implementación y validación con el cliente.

---

## 8) Estructura obligatoria por funcionalidad

Cada requerimiento funcional (RF) queda documentado con la estructura solicitada.

## RF-01 – Registro e inicio de sesión de usuario

### Información General
| Campo | Detalle |
|-------|---------|
| **Código** | RF-01 |
| **Nombre** | Registro e inicio de sesión |
| **Descripción** | El sistema debe permitir crear cuenta e iniciar sesión para acceder a la plataforma. |
| **Cómo se ejecutará** | El jugador diligencia registro, valida credenciales y luego inicia sesión. |
| **Actor principal** | Jugador |
| **Precondiciones** | No estar autenticado; correo no registrado previamente. |

### Datos de Entrada
| Nombre | Descripción | Tipo de campo | Reglas / Aplicación | Obligatorio |
|--------|-------------|---------------|----------------------|-------------|
| Usuario | Nombre visible del jugador | `String` | 3 a 20 caracteres | Sí |
| Correo | Correo del jugador | `String` | Formato válido y único | Sí |
| Contraseña | Clave de acceso | `String` | Mínimo 8 caracteres | Sí |

### Datos de Salida
| Nombre | Descripción | Tipo de campo | Reglas / Aplicación | Obligatorio |
|--------|-------------|---------------|----------------------|-------------|
| Sesión | Token y perfil básico | `AuthResponse` | Incluye idJugador y alias | Sí |

### Flujo Básico
| Paso | Actor | Descripción | Excepciones |
|------|-------|-------------|-------------|
| 1 | Jugador | Abre formulario de registro/login | — |
| 2 | Jugador | Envía credenciales | — |
| 3 | Jugador | Valida formato y existencia | E1: Correo ya registrado |
| 4 | Jugador | Crea sesión y retorna respuesta | E2: Credenciales inválidas |

### Flujo Alterno
| Paso | Actor | Descripción | Excepciones |
|------|-------|-------------|-------------|
| E1 | Jugador | Notifica duplicidad de correo | — |
| E2 | Jugador | Rechaza acceso y permite reintento | — |

### Reglas de Negocio
| No. | Descripción |
|-----|-------------|
| 1 | El correo del jugador debe ser único en el sistema |
| 2 | La contraseña debe almacenarse cifrada |

## RF-02 – Gestión de inventario de criaturas

### Información General
| Campo | Detalle |
|-------|---------|
| **Código** | RF-02 |
| **Nombre** | Inventario de criaturas |
| **Descripción** | El sistema debe permitir visualizar y administrar criaturas por jugador. |
| **Cómo se ejecutará** | El jugador consulta su inventario y realiza operaciones permitidas. |
| **Actor principal** | Jugador |
| **Precondiciones** | Usuario autenticado. |

### Datos de Entrada
| Nombre | Descripción | Tipo de campo | Reglas / Aplicación | Obligatorio |
|--------|-------------|---------------|----------------------|-------------|
| idJugador | Identificador del jugador | `UUID` | Debe existir | Sí |
| filtroElemento | Filtro por elemento/rareza | `String` | Opcional | No |

### Datos de Salida
| Nombre | Descripción | Tipo de campo | Reglas / Aplicación | Obligatorio |
|--------|-------------|---------------|----------------------|-------------|
| listadoCriaturas | Inventario del jugador | `List<CriaturaDTO>` | Incluye nivel, stats y estado | Sí |

### Flujo Básico
| Paso | Actor | Descripción | Excepciones |
|------|-------|-------------|-------------|
| 1 | Jugador | Solicita ver inventario | — |
| 2 | Jugador | Consulta criaturas asociadas | E1: Jugador sin inventario |
| 3 | Jugador | Retorna listado filtrado | — |

### Flujo Alterno
| Paso | Actor | Descripción | Excepciones |
|------|-------|-------------|-------------|
| E1 | Jugador | Retorna inventario vacío con mensaje informativo | — |

### Reglas de Negocio
| No. | Descripción |
|-----|-------------|
| 1 | Cada criatura pertenece a un único inventario de jugador |
| 2 | No se pueden usar criaturas no poseídas |

## RF-03 – Mejora de criaturas

### Información General
| Campo | Detalle |
|-------|---------|
| **Código** | RF-03 |
| **Nombre** | Progresión de criatura |
| **Descripción** | El sistema debe permitir mejorar nivel/atributos/habilidades de criaturas. |
| **Cómo se ejecutará** | El jugador selecciona criatura y aplica mejora con recursos disponibles. |
| **Actor principal** | Jugador |
| **Precondiciones** | Autenticado y criatura en inventario. |

### Datos de Entrada
| Nombre | Descripción | Tipo de campo | Reglas / Aplicación | Obligatorio |
|--------|-------------|---------------|----------------------|-------------|
| idCriatura | Identificador de criatura | `UUID` | Debe pertenecer al jugador | Sí |
| tipoMejora | Nivel/atributo/habilidad | `Enum` | Valores válidos definidos | Sí |
| recursoGastado | Recurso consumido | `Integer` | > 0 y suficiente saldo | Sí |

### Datos de Salida
| Nombre | Descripción | Tipo de campo | Reglas / Aplicación | Obligatorio |
|--------|-------------|---------------|----------------------|-------------|
| criaturaActualizada | Estado posterior de la criatura | `CriaturaDTO` | Incluye nuevos stats | Sí |

### Flujo Básico
| Paso | Actor | Descripción | Excepciones |
|------|-------|-------------|-------------|
| 1 | Jugador | Solicita mejora de criatura | — |
| 2 | Jugador | Valida propiedad y recursos | E1: Recursos insuficientes |
| 3 | Jugador | Aplica mejora y guarda cambios | E2: Tope de nivel alcanzado |
| 4 | Jugador | Retorna estado actualizado | — |

### Flujo Alterno
| Paso | Actor | Descripción | Excepciones |
|------|-------|-------------|-------------|
| E1 | Jugador | Rechaza mejora por recursos insuficientes | — |
| E2 | Jugador | Notifica límite máximo alcanzado | — |

### Reglas de Negocio
| No. | Descripción |
|-----|-------------|
| 1 | El costo de mejora crece por nivel |
| 2 | Ningún atributo puede superar el límite global |

## RF-04 – Creación y resolución de combates asíncronos

### Información General
| Campo | Detalle |
|-------|---------|
| **Código** | RF-04 |
| **Nombre** | Combate asíncrono |
| **Descripción** | El sistema debe permitir crear y resolver combates estratégicos entre jugadores. |
| **Cómo se ejecutará** | Se crea un enfrentamiento y el motor resuelve turnos sin simultaneidad en tiempo real. |
| **Actor principal** | Jugador |
| **Precondiciones** | Dos jugadores válidos con criaturas disponibles. |

### Datos de Entrada
| Nombre | Descripción | Tipo de campo | Reglas / Aplicación | Obligatorio |
|--------|-------------|---------------|----------------------|-------------|
| idRetador | Jugador que inicia | `UUID` | Debe estar autenticado | Sí |
| idOponente | Jugador oponente | `UUID` | Debe existir y estar habilitado | Sí |
| alineacion | Selección de criaturas | `List<UUID>` | Tamaño permitido por regla | Sí |

### Datos de Salida
| Nombre | Descripción | Tipo de campo | Reglas / Aplicación | Obligatorio |
|--------|-------------|---------------|----------------------|-------------|
| resultadoCombate | Ganador, log de turnos y recompensas | `ResultadoCombateDTO` | Debe ser determinista | Sí |

### Flujo Básico
| Paso | Actor | Descripción | Excepciones |
|------|-------|-------------|-------------|
| 1 | Jugador | Inicia combate | — |
| 2 | Jugador | Valida jugadores y alineaciones | E1: Alineación inválida |
| 3 | Jugador | Ejecuta motor de combate | E2: Error de consistencia |
| 4 | Jugador | Persiste y retorna resultado | — |

### Flujo Alterno
| Paso | Actor | Descripción | Excepciones |
|------|-------|-------------|-------------|
| E1 | Jugador | Rechaza solicitud por reglas incumplidas | — |
| E2 | Jugador | Reintenta o marca combate en revisión | — |

### Reglas de Negocio
| No. | Descripción |
|-----|-------------|
| 1 | La resolución del combate debe ser reproducible con la misma semilla y entradas |
| 2 | El combate finalizado no puede recalcularse manualmente |

## RF-05 – Historial de partidas

### Información General
| Campo | Detalle |
|-------|---------|
| **Código** | RF-05 |
| **Nombre** | Historial de combates |
| **Descripción** | El sistema debe permitir consultar resultados de partidas previas. |
| **Cómo se ejecutará** | El jugador accede a su historial y filtra por fecha/resultado. |
| **Actor principal** | Jugador |
| **Precondiciones** | Usuario autenticado y combates registrados. |

### Datos de Entrada
| Nombre | Descripción | Tipo de campo | Reglas / Aplicación | Obligatorio |
|--------|-------------|---------------|----------------------|-------------|
| idJugador | Identificador del jugador | `UUID` | Debe existir | Sí |
| fechaInicio/fechaFin | Rango de consulta | `Date` | Rango válido | No |

### Datos de Salida
| Nombre | Descripción | Tipo de campo | Reglas / Aplicación | Obligatorio |
|--------|-------------|---------------|----------------------|-------------|
| historial | Lista de partidas | `List<PartidaDTO>` | Incluye ganador y timestamp | Sí |

### Flujo Básico
| Paso | Actor | Descripción | Excepciones |
|------|-------|-------------|-------------|
| 1 | Jugador | Solicita historial | — |
| 2 | Jugador | Consulta BD con filtros | E1: Sin resultados |
| 3 | Jugador | Retorna partidas encontradas | — |

### Flujo Alterno
| Paso | Actor | Descripción | Excepciones |
|------|-------|-------------|-------------|
| E1 | Jugador | Retorna lista vacía y mensaje informativo | — |

### Reglas de Negocio
| No. | Descripción |
|-----|-------------|
| 1 | Todas las partidas deben quedar almacenadas con fecha y estado |
| 2 | Solo el propietario puede ver su historial completo |

## RF-06 – Emparejamiento justo

### Información General
| Campo | Detalle |
|-------|---------|
| **Código** | RF-06 |
| **Nombre** | Matchmaking |
| **Descripción** | El sistema debe emparejar jugadores con nivel competitivo similar. |
| **Cómo se ejecutará** | El jugador entra a cola y el sistema selecciona rival por criterios definidos. |
| **Actor principal** | Jugador |
| **Precondiciones** | Jugador autenticado y habilitado para combate. |

### Datos de Entrada
| Nombre | Descripción | Tipo de campo | Reglas / Aplicación | Obligatorio |
|--------|-------------|---------------|----------------------|-------------|
| idJugador | Jugador en cola | `UUID` | Debe existir | Sí |
| rankingActual | Puntaje/rango actual | `Integer` | >= 0 | Sí |
| region | Región lógica | `String` | Opcional por configuración | No |

### Datos de Salida
| Nombre | Descripción | Tipo de campo | Reglas / Aplicación | Obligatorio |
|--------|-------------|---------------|----------------------|-------------|
| emparejamiento | Rival y parámetros del combate | `EmparejamientoDTO` | Diferencia de rango en umbral permitido | Sí |

### Flujo Básico
| Paso | Actor | Descripción | Excepciones |
|------|-------|-------------|-------------|
| 1 | Jugador | Solicita entrar en cola | — |
| 2 | Jugador | Evalúa candidatos por rango | E1: Sin rivales compatibles |
| 3 | Jugador | Genera emparejamiento | — |

### Flujo Alterno
| Paso | Actor | Descripción | Excepciones |
|------|-------|-------------|-------------|
| E1 | Jugador | Mantiene en cola y amplía umbral gradualmente | — |

### Reglas de Negocio
| No. | Descripción |
|-----|-------------|
| 1 | El emparejamiento usa diferencia máxima de ranking configurable |
| 2 | El sistema prioriza tiempos de espera razonables sin sacrificar justicia |

## RF-07 – Motor de balance de criaturas y habilidades

### Información General
| Campo | Detalle |
|-------|---------|
| **Código** | RF-07 |
| **Nombre** | Reglas de balance |
| **Descripción** | El sistema debe calcular resultados usando reglas balanceadas de criatura/habilidad. |
| **Cómo se ejecutará** | El motor aplica modificadores y restricciones durante el combate. |
| **Actor principal** | Jugador |
| **Precondiciones** | Catálogo y parámetros de balance vigentes. |

### Datos de Entrada
| Nombre | Descripción | Tipo de campo | Reglas / Aplicación | Obligatorio |
|--------|-------------|---------------|----------------------|-------------|
| statsBase | Atributos de criaturas | `StatsDTO` | Deben estar normalizados | Sí |
| habilidadActiva | Habilidad usada | `HabilidadDTO` | Debe pertenecer a la criatura | Sí |
| versionBalance | Versión de reglas | `String` | Debe existir | Sí |

### Datos de Salida
| Nombre | Descripción | Tipo de campo | Reglas / Aplicación | Obligatorio |
|--------|-------------|---------------|----------------------|-------------|
| resultadoTurno | Resultado aplicado al turno | `TurnoDTO` | Con trazabilidad de cálculos | Sí |

### Flujo Básico
| Paso | Actor | Descripción | Excepciones |
|------|-------|-------------|-------------|
| 1 | Jugador | Carga reglas de balance activas | — |
| 2 | Jugador | Evalúa fórmula de resolución | E1: Regla inexistente |
| 3 | Jugador | Retorna efecto del turno | — |

### Flujo Alterno
| Paso | Actor | Descripción | Excepciones |
|------|-------|-------------|-------------|
| E1 | Jugador | Aplica regla por defecto y registra incidencia | — |

### Reglas de Negocio
| No. | Descripción |
|-----|-------------|
| 1 | Cada versión de balance debe quedar versionada |
| 2 | Un cambio de balance no altera resultados históricos ya cerrados |

## RF-08 – Consulta de progreso y estadísticas

### Información General
| Campo | Detalle |
|-------|---------|
| **Código** | RF-08 |
| **Nombre** | Panel de progreso |
| **Descripción** | El sistema debe mostrar progreso, rendimiento y estadísticas del jugador. |
| **Cómo se ejecutará** | El jugador abre su perfil y visualiza indicadores acumulados. |
| **Actor principal** | Jugador |
| **Precondiciones** | Usuario autenticado con historial existente. |

### Datos de Entrada
| Nombre | Descripción | Tipo de campo | Reglas / Aplicación | Obligatorio |
|--------|-------------|---------------|----------------------|-------------|
| idJugador | Identificador del jugador | `UUID` | Debe existir | Sí |
| periodo | Rango de tiempo | `Enum` | semanal/mensual/global | No |

### Datos de Salida
| Nombre | Descripción | Tipo de campo | Reglas / Aplicación | Obligatorio |
|--------|-------------|---------------|----------------------|-------------|
| estadisticas | Métricas del jugador | `EstadisticasDTO` | Victorias, derrotas, win-rate, progreso | Sí |

### Flujo Básico
| Paso | Actor | Descripción | Excepciones |
|------|-------|-------------|-------------|
| 1 | Jugador | Solicita ver panel de progreso | — |
| 2 | Jugador | Agrega datos de partidas e inventario | E1: Datos insuficientes |
| 3 | Jugador | Muestra estadísticas calculadas | — |

### Flujo Alterno
| Paso | Actor | Descripción | Excepciones |
|------|-------|-------------|-------------|
| E1 | Jugador | Muestra estado inicial sin métricas históricas | — |

### Reglas de Negocio
| No. | Descripción |
|-----|-------------|
| 1 | El win-rate se calcula sobre partidas finalizadas |
| 2 | Las estadísticas deben actualizarse al cerrar cada combate |

## RF-09 – Administración de catálogo de criaturas y habilidades

### Información General
| Campo | Detalle |
|-------|---------|
| **Código** | RF-09 |
| **Nombre** | Administración de catálogo |
| **Descripción** | El sistema debe permitir crear, editar y desactivar criaturas/habilidades del catálogo base. |
| **Cómo se ejecutará** | Un administrador gestiona entidades del juego desde un módulo de backoffice. |
| **Actor principal** | Administrador |
| **Precondiciones** | Usuario con rol administrativo. |

### Datos de Entrada
| Nombre | Descripción | Tipo de campo | Reglas / Aplicación | Obligatorio |
|--------|-------------|---------------|----------------------|-------------|
| nombreCriatura | Nombre de criatura | `String` | Único por versión de catálogo | Sí |
| tipoElemento | Elemento de criatura | `Enum` | Según catálogo permitido | Sí |
| habilidad | Configuración de habilidad | `JSON` | Debe validar esquema | Sí |

### Datos de Salida
| Nombre | Descripción | Tipo de campo | Reglas / Aplicación | Obligatorio |
|--------|-------------|---------------|----------------------|-------------|
| catalogoActualizado | Entidad creada/actualizada | `CatalogoDTO` | Con versión y estado | Sí |

### Flujo Básico
| Paso | Actor | Descripción | Excepciones |
|------|-------|-------------|-------------|
| 1 | Administrador | Envía alta/edición de entidad | — |
| 2 | Administrador | Valida permisos y consistencia | E1: Sin permisos |
| 3 | Administrador | Persiste cambios y versiona catálogo | E2: Dato duplicado |

### Flujo Alterno
| Paso | Actor | Descripción | Excepciones |
|------|-------|-------------|-------------|
| E1 | Administrador | Rechaza operación por rol inválido | — |
| E2 | Administrador | Notifica conflicto de nombre o regla | — |

### Reglas de Negocio
| No. | Descripción |
|-----|-------------|
| 1 | Toda modificación de catálogo debe quedar auditada |
| 2 | No se permite eliminar físicamente entidades ya usadas en partidas |

## RF-10 – Extensibilidad para eventos, rankings y modo cooperativo

### Información General
| Campo | Detalle |
|-------|---------|
| **Código** | RF-10 |
| **Nombre** | Extensibilidad de módulos futuros |
| **Descripción** | El sistema debe permitir integrar nuevos modos sin reescritura del núcleo. |
| **Cómo se ejecutará** | Se habilita arquitectura modular con interfaces y puntos de extensión. |
| **Actor principal** | Arquitecto/Equipo de desarrollo |
| **Precondiciones** | Núcleo desacoplado y contratos versionados. |

### Datos de Entrada
| Nombre | Descripción | Tipo de campo | Reglas / Aplicación | Obligatorio |
|--------|-------------|---------------|----------------------|-------------|
| moduloNuevo | Nombre del nuevo módulo | `String` | Debe cumplir convención | Sí |
| contratoIntegracion | Definición de interfaz | `YAML/JSON` | Debe validar versión | Sí |

### Datos de Salida
| Nombre | Descripción | Tipo de campo | Reglas / Aplicación | Obligatorio |
|--------|-------------|---------------|----------------------|-------------|
| integracion | Resultado de despliegue/integración | `IntegracionDTO` | Estado, versión y dependencias | Sí |

### Flujo Básico
| Paso | Actor | Descripción | Excepciones |
|------|-------|-------------|-------------|
| 1 | Equipo técnico | Registra módulo nuevo | — |
| 2 | Equipo técnico | Valida contratos y dependencias | E1: Contrato incompatible |
| 3 | Equipo técnico | Publica módulo en entorno | — |

### Flujo Alterno
| Paso | Actor | Descripción | Excepciones |
|------|-------|-------------|-------------|
| E1 | Equipo técnico | Rechaza integración y entrega reporte de incompatibilidades | — |


### Reglas de Negocio
| No. | Descripción |
|-----|-------------|
| 1 | Todo módulo nuevo debe ser compatible con la versión del núcleo |
| 2 | Debe existir rollback en caso de falla de integración |


