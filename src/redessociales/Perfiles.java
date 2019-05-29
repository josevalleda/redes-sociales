
package redessociales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Perfiles {
    private String identificador;
    private PanelPrivate pprivado;
    private Map<String, Paneles > mapa;

    public PanelPrivate getPprivado() {
        return pprivado;
    }
    
    public Perfiles(String identificador) {
        this.identificador = identificador;
        pprivado = new PanelPrivate(this);
        mapa = new  HashMap<String ,Paneles >();
    }
    
    public void Añadirtema(String tema){
        Panelsuscripcion aux = new Panelsuscripcion(this);
        mapa.put(tema, aux);
    }
    public Paneles Consultar(String tema){
        Paneles aux = null;
        if(mapa.containsKey(tema)){
            aux = mapa.get(tema);
        }
        return aux;
    }

    public String getIdentificador() {
        return identificador;
    }
    
    public ArrayList<Paneles> Intereses(){
        ArrayList<Paneles> aux = new ArrayList<>();
        for (Paneles value : mapa.values()) {
            aux.add(value);
        }
        return aux;
    }
    
}
