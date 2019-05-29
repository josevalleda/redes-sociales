package redessociales;

public class Mensajes implements Comparable {

    private String texto;
    private Perfiles autor;
    private Mensajes responde;
    private boolean independiente;

    public Mensajes(String texto, Perfiles autor) {
        this.texto = texto;
        this.autor = autor;
        independiente = false;
    }

    public Mensajes(String texto, Perfiles autor, Mensajes responde) {
        this.texto = texto;
        this.autor = autor;
        this.responde = responde;
        independiente = false;
    }

    public boolean isIndependiente() {
        return independiente;
    }

    public String getTexto() {
        return texto;
    }

    public Perfiles getAutor() {
        return autor;
    }

    public Mensajes getResponde() {
        return responde;
    }

    @Override
    public String toString() {
        return "Mensajes{" + "mensaje = " + texto + ", autor=" + autor + ", independiente=" + independiente + '}';
    }

    // creamos nuestro comparador segun el criterio del ejercicio
    @Override
    public int compareTo(Object o) {
        Mensajes otro = (Mensajes) o;
        //comparamos el autor
        int commparacion = autor.getIdentificador().compareTo(otro.getAutor().getIdentificador());

        if (commparacion != 0) {
            return commparacion;
        }
        //sino comparamos los texto en caso de empate
        return texto.compareTo(otro.getTexto());
    }

}
