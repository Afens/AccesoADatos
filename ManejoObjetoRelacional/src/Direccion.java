/**
 * Created by Afens on 30/01/2016.
 */
public class Direccion {

    public String calle;
    public String numero;
    public Poblacion poblacion;
    public String codPostal;

    public Direccion (String calle, String numero, Poblacion poblacion, String codPostal){
        this.calle = calle;
        this.numero = numero;
        this.poblacion = poblacion;
        this.codPostal = codPostal;
    }

    public String getSQL(){
        return String.format("('%s', '%s', %s, '%s')", calle, numero, poblacion.getSQL(), codPostal);
    }

    public static Direccion getObject(String cadena){
        String aux[];
        cadena = cadena.replaceAll("\"", "");
        cadena = cadena.replaceAll("\\)", "");
        cadena = cadena.replaceAll("\\(", "");
        aux = cadena.split(",");
        return new Direccion(aux[0], aux[1], new Poblacion(aux[2], new Provincia(aux[3], aux[4]), aux[5]), aux[6]);
    }

    @Override
    public String toString() {
        return String.format("Direcion: Calle='%s', num='%s', %s, CodPostal='%s'"
                , calle, numero, poblacion, codPostal);

    }
}
