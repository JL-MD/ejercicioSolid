package mensajes;

public class App {

    public static void main(String[] args) {
        GeneradorTextoMensajes generador = new GeneradorTextoMensajes();

        Mensaje aviso = new Mensaje(
                TipoMensaje.AVISO,
                "intranet",
                "Grupo SMR1",
                "Cambio de aula",
                "Hoy la clase será en el aula 2.3 por mantenimiento.",
                "2026-02-26",
                null,
                null,
                null
        );

        Mensaje incidencia = new Mensaje(
                TipoMensaje.INCIDENCIA,
                "correo",
                "Tutor/a",
                "Retraso reiterado",
                "Se han detectado 3 retrasos esta semana.",
                "2026-02-26",
                "12345678A",
                "DAM1",
                "ALTA"
        );

        System.out.println(generador.generarTexto(aviso));
        System.out.println(generador.generarTexto(incidencia));
    }
}