import java.util.ArrayList;

/**
 * Created by Afens on 26/10/2015.
 */
public class ListaContactos {
    private ArrayList<Contacto> lista=new ArrayList<Contacto>();

    public ListaContactos(){}

    public void add(Contacto cont){
        lista.add(cont);
    }

    public ArrayList<Contacto> getListaContactos(){
        return lista;
    }
}
