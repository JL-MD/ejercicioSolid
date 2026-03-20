# Análisis y corrección SOLID — Paquete: mensajes

## 1) Principio SOLID vulnerado principalmente
**Principio (SRP / OCP / LSP / DIP):OCP**

## 2) Justificación con evidencias
**Clase(s) y/o método(s) donde se concentra el problema:**
- GeneradorTextoMensajes: El método que genera el texto contiene toda la lógica de formato para todos los tipos de mensajes, probablemente mediante un bloque switch o if-else basado en el TipoMensaje.

**Síntomas que lo delatan (marca y explica brevemente):**
-Cada vez que se añade un nuevo tipo de mensaje (ej. "URGENTE"), hay que modificar el GeneradorTextoMensajes, lo que incumple el OCP.

-La clase GeneradorTextoMensajes conoce los detalles de implementación de cada formato (Avisos, Incidencias, Felicitaciones).

## 3) Inconvenientes del diseño actual
**Indica cambios futuros caros o arriesgados, partes difíciles de probar o mantener, errores fáciles de introducir si el proyecto crece...:**
-Al modificar el switch para añadir una funcionalidad a "Incidencia", es fácil cometer un error que afecte a "Aviso" por accidente.
-A medida que el instituto pida formatos más complejos (negritas, HTML, metadatos adicionales), el método de generación se volverá un "método dios" difícil de seguir y testear unitariamente

## 4) Propuesta y aplicación de la corrección
**Describe la refactorización (qué extraes, qué conviertes en interfaz, qué separas, etc.):**
-Se crea una interfaz Formateador que define el contrato para transformar un objeto Mensaje en String.
-Se crean clases concretas (FormateadorAviso, FormateadorIncidencia, etc.) que contienen la lógica específica de cada tipo.
-El GeneradorTextoMensajes se refactoriza para utilizar un Map o un selector de estrategias. Al no poder modificar App, el Generador puede inicializar estos formateadores internamente para que la llamada desde App siga funcionando exactamente igual.