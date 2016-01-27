package BddObjects;


public class NumeroTlf {
    private String prefijoPais;
    private String numero;

    public NumeroTlf(){

    }
    public NumeroTlf(String prefijoPais, String numero){
        this.prefijoPais=prefijoPais;
        this.numero=numero;
    }

    public String getPrefijoPais() {
        return prefijoPais;
    }

    public void setPrefijoPais(String prefijoPais) {
        this.prefijoPais = prefijoPais;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
