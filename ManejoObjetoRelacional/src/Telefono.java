import java.util.List;

/**
 * Created by Afens on 30/01/2016.
 */
public class Telefono{
    public enum TiposTlf {
        FIJO_PERSONAL, FIJO_TRABAJO, MOVIL_PERSONAL, MOVIL_TRABAJO
    }

    public TiposTlf tipo;
    public NumeroTlf numeroTlf;

    public Telefono(TiposTlf tipo, NumeroTlf numeroTlf){
        this.tipo = tipo;
        this.numeroTlf = numeroTlf;
    }

    public static Telefono getObject(String cadena){
        TiposTlf tipo = null;
        String aux[];
        cadena = cadena.replaceAll("\"", "");
        cadena = cadena.replaceAll("\\)", "");
        cadena = cadena.replaceAll("\\(", "");
        aux = cadena.split(",");
        for (TiposTlf t: TiposTlf.values())
            if (aux[0].equals(t.toString()))
                tipo = t;

        return new Telefono(tipo, new NumeroTlf(aux[1], aux[2]));
    }

    public static String newArray(List<Telefono> listaTlf){
        String cadenaArrayTelef = "CAST(ARRAY[";
        for (int i = 0; i < listaTlf.size(); i++) {
            cadenaArrayTelef += listaTlf.get(i).getSQL();
            if (i != listaTlf.size()-1)
                cadenaArrayTelef += ", ";
            else
                cadenaArrayTelef += "] AS t_telefono ARRAY)";
        }
        return cadenaArrayTelef;
    }

    public String getSQL(){
        return String.format("('%s', %s)", tipo, numeroTlf.getSQL());
    }

    @Override
    public String toString() {
        return String.format("Telefono: tipo='%s', %s", tipo, numeroTlf);

    }
}
