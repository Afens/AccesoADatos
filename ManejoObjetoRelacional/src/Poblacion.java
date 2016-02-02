/**
 * Created by Afens on 30/01/2016.
 */
public class Poblacion {

    public String poblacion;
    public Provincia provincia;
    public String pais;

    public Poblacion(String poblacion, Provincia provincia, String pais){
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.pais = pais;
    }

    public String getSQL(){
        return String.format("('%s', %s, '%s')", poblacion, provincia.getSQL(), pais);
    }

    public static Poblacion getObject(String cadena){
        String aux[];
        cadena = cadena.replaceAll("\"", "");
        cadena = cadena.replaceAll("\\)", "");
        cadena = cadena.replaceAll("\\(", "");
        aux = cadena.split(",");

        return new Poblacion(aux[0], new Provincia(aux[1], aux[2]), aux[3]);
    }

    @Override
    public String toString() {
        return String.format("Poblacion: poblacion='%s', %s, pais='%s'"
                , poblacion, provincia, pais);
    }
}
