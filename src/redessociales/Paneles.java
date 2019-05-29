
package redessociales;

import java.util.ArrayList;
import java.util.Collections;


abstract class Paneles implements Cloneable{
    protected Perfiles Propietario;
    protected ArrayList<Mensajes> Lista;

    public Paneles(Perfiles Propietario) {
        this.Propietario = Propietario;
        this.Lista = new ArrayList<Mensajes>();
    }

    @Override
    public String toString() {
        return "Paneles{" + "Propietario=" + Propietario.getIdentificador() + ", Lista=" + Lista.size() + '}';
    }
    
    public ArrayList<Mensajes> ConsultarMensajes(Mensajes me){
        ArrayList<Mensajes> aux = new ArrayList<Mensajes>();
        //buscamos todos los mensajes relacionados y lo agregamos a la lista
        for (Mensajes mensajes : Lista) {
            if(mensajes.isIndependiente()){
                if(mensajes.getResponde().equals(me)){
                    aux.add(mensajes);
                }
            }
        }
        return aux;
    }
    
    public boolean borrarmensaje (Mensajes me){
        boolean auxbool = true;
        //buscamos cualquier mensaje relacionado
        for (Mensajes mensajes : Lista) {
            if(mensajes.isIndependiente()){
                if(mensajes.getResponde().equals(me)){
                    return false;
                }
            }
        }
       
        return eliminarmensaje(me);
    }
    abstract boolean eliminarmensaje(Mensajes me);
    abstract Mensajes publicarmensaje(String texto,Perfiles autor, Mensajes resp);
    public Mensajes añadirmensaje(String texto){
        Mensajes aux = publicarmensaje(texto, Propietario, null);
        if(aux != null)
            Lista.add(aux);
        return aux;
    }
    public Mensajes añadirmensaje(String texto,Perfiles autor, Mensajes resp){
        Mensajes aux = publicarmensaje(texto, autor, resp);
        if(aux != null)
            Lista.add(aux);
        return aux;
    }
    public ArrayList<Mensajes> ordenarmensaje(){
        ArrayList<Mensajes> aux = Lista;
        Collections.sort(aux);
        return aux;
    }
    @Override
    public Paneles clone() throws CloneNotSupportedException 
    { 
        Paneles aux = (Paneles) super.clone();
        aux.Lista.clear();
        return aux; 
    } 
}
