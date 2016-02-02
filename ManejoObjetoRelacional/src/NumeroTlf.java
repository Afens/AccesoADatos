/**
 * Created by Afens on 30/01/2016.
 */
public class NumeroTlf{

    public String prefijoPais;
    public String numero;

    public NumeroTlf(String prefijoPais, String numero){
        this.prefijoPais = prefijoPais;
        this.numero = numero;
    }

    public static NumeroTlf getObject(String cadena){
        String aux[];
        cadena = cadena.replaceAll("\"", "");
        cadena = cadena.replaceAll("\\)", "");
        cadena = cadena.replaceAll("\\(", "");
        aux = cadena.split(",");

        return new NumeroTlf(aux[0], aux[1]);
    }

    public String getSQL(){
        return String.format("('%s', '%s')", prefijoPais, numero);
    }

    @Override
    public String toString() {
        return String.format("NumeroTlf: PrefPais='%s', telf='%s'", prefijoPais, numero);
    }
}
