package mensajes;

class FormateadorAviso implements Formateador {
    @Override
    public String formatear(Mensaje m) {
        return "AVISO \nAsunto: " + m.getTitulo() + "\nCuerpo: " + m.getCuerpo();
    }
}

class FormateadorIncidencia implements Formateador {
    @Override
    public String formatear(Mensaje m) {
        return " INCIDENCIA \nPrioridad: ALTA\nDetalle: " + m.getCuerpo();
    }
}

class FormateadorFelicitacion implements Formateador {
    @Override
    public String formatear(Mensaje m) {
        return "Felicidades " + m.getCuerpo() + " :)";
    }
}