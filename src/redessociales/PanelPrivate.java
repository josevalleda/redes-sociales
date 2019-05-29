
package redessociales;

import java.util.ArrayList;


public class PanelPrivate extends Paneles{
    
    private ArrayList<String> claves;
    private ArrayList<Mensajes> ListaSeguimiento;

    public ArrayList<String> getClaves() {
        return claves;
    }

    public ArrayList<Mensajes> getListaSeguimiento() {
        return ListaSeguimiento;
    }

    public PanelPrivate(Perfiles Propietario) {
        super(Propietario);
        claves = new ArrayList<String>();
        ListaSeguimiento = new ArrayList<Mensajes>();
    }
    
    public void Setclaves(String ... argumentos){
        ListaSeguimiento = new ArrayList<>();
        for (String argumento : argumentos) {
            //agregamos las palabras claves
            claves.add(argumento);
            for (Mensajes mensajes : Lista) {
                //verificamos que el texto clave este en el mensaje
                if(mensajes.getTexto().contains(argumento))
                    //verifica que el mensaje no se repita en la lista
                    if(!ListaSeguimiento.contains(mensajes))
                        ListaSeguimiento.add(mensajes);
            }
        }
    }

    Mensajes publicarmensaje(String texto, Perfiles autor, Mensajes resp) {
        Mensajes aux = null;
        if(autor.equals(Propietario)|| Lista.contains(resp)){
            aux = new Mensajes(texto, autor);
            //verificamos que el mensaje nuevo no sea para seguimiento
            for (String clave : claves) {
                if(texto.contains(clave)){
                    if(!ListaSeguimiento.contains(aux)){
                        ListaSeguimiento.add(aux);
                    }
                    break;
                }
            }
        }
        return aux;
    }

    boolean eliminarmensaje(Mensajes me) {
        if(ListaSeguimiento.contains(me)){
            return false;
        }
         return Lista.remove(me);
    }
    @Override
    public Paneles clone() throws CloneNotSupportedException 
    { 
        return null;
    } 
    
}
