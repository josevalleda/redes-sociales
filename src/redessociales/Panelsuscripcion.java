
package redessociales;

import java.util.ArrayList;


public class Panelsuscripcion extends Paneles{
    private ArrayList<Perfiles> colaboradores;

    public Panelsuscripcion(Perfiles Propietario) {
        super(Propietario);
        colaboradores = new ArrayList<>();
    }
    
    public void añadircolaborador(Perfiles cola){
        colaboradores.add(cola);

    }
    public void eliminarcolaborador(Perfiles cola){
        colaboradores.remove(cola);
    }

    Mensajes publicarmensaje(String texto, Perfiles autor, Mensajes resp) {
        Mensajes aux = null;
        //verificamos que sea propietario o colaborador
        if(autor.equals(Propietario)|| colaboradores.contains(autor)){
            aux = new Mensajes(texto, autor);
        }
        return aux;
    }

    boolean eliminarmensaje(Mensajes me) {
        return Lista.remove(me);
    }
    @Override
    public Paneles clone() throws CloneNotSupportedException 
    { 
        Paneles aux = (Paneles) super.clone();
        return aux; 
    } 
    
}
