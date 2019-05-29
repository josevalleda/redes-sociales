package redessociales;

import java.util.ArrayList;

public class RedesSociales {

    public static void main(String[] args) {
        Perfiles p1 = new Perfiles("Juan");
        p1.Añadirtema("Java vs C++");
        Perfiles p2 = new Perfiles("Pedro");
        p2.Añadirtema("El nuevo estadio del real madrid");
        Perfiles p3 = new Perfiles("Enrique");
        ArrayList<Perfiles> l1 = new ArrayList<>();
        ArrayList<Paneles> l2 = new ArrayList<>();
        PanelPrivate aux1;
        Panelsuscripcion aux2;
        l1.add(p3);
        l1.add(p2);
        l1.add(p1);
        for (Perfiles perfiles : l1) {
            perfiles.getPprivado().añadirmensaje("hola soy  " + perfiles.getIdentificador() + "   Bienvenido!!");
            l2.add(perfiles.getPprivado());
            for (Paneles Interese : perfiles.Intereses()) {
                l2.add(Interese);
            }
        }
        
        for (Paneles paneles : l2) {
            if (paneles.getClass().getName().equals("redessociales.PanelPrivate")) {
                aux1 = (PanelPrivate) paneles;
                aux1.Setclaves("Hola", "Real Madrid", "Futbol");
            } 
        }
        for (Perfiles perfiles : l1) {
            for (Paneles paneles : l2) {
                
                if (paneles.getClass().getName().equals("redessociales.Panelsuscripcion")) {
                    aux2 = (Panelsuscripcion) paneles;
                    if(!perfiles.getIdentificador().equals(aux2.Propietario.getIdentificador())){
                      
                        aux2.añadircolaborador(perfiles);
                        aux2.añadirmensaje("Muy interesante..", perfiles, null);
                    }
                }
            }
        }
        System.out.println(""+l2.size());
         for (Paneles paneles : l2) {
             
             System.out.println("\n"+paneles.toString()+" \t "+paneles.getClass().getName());
         }
    }

}
