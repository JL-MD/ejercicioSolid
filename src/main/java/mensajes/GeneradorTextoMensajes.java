package mensajes;

import java.util.HashMap;
import java.util.Map;

public class GeneradorTextoMensajes {

    private final Map<TipoMensaje, Formateador> formateadores;

    public GeneradorTextoMensajes() {
        formateadores = new HashMap<>();
        formateadores.put(TipoMensaje.AVISO, new FormateadorAviso());
        formateadores.put(TipoMensaje.INCIDENCIA, new FormateadorIncidencia());
        formateadores.put(TipoMensaje.FELICITACION, new FormateadorFelicitacion());
    }

    public String generarTexto(Mensaje mensaje) {
        Formateador formateador = formateadores.get(mensaje.getTipo());

        if (formateador == null) {
            return "Tipo de mensaje no soportado.";
        }

        return formateador.formatear(mensaje);
    }
}