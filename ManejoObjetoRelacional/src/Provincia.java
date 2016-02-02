/**
 * Created by Afens on 30/01/2016.
 */
public class Provincia {

    public String provincia;
    public String comunidadAutonoma;

    public Provincia(String provincia, String comunidadAutonoma){
        this.provincia = provincia;
        this.comunidadAutonoma = comunidadAutonoma;
    }

    public String getSQL(){
        return String.format("('%s', '%s')", provincia, comunidadAutonoma);
    }

    public static Provincia getObject(String cadena){
        String aux[];
        cadena = cadena.replaceAll("\"", "");
        cadena = cadena.replaceAll("\\)", "");
        cadena = cadena.replaceAll("\\(", "");
        aux = cadena.split(",");

        return new Provincia(aux[0], aux[1]);
    }

    @Override
    public String toString() {
        return String.format("Provincia: provincia='%s', comunidad='%s'"
                , provincia, comunidadAutonoma);

    }
}
