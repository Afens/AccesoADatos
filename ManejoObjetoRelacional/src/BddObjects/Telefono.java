package BddObjects;


public class Telefono {

    private String tipo;
    private NumeroTlf numeroTlf;

    public Telefono(String tipo, NumeroTlf numeroTlf){
        this.tipo=tipo;
        this.numeroTlf=numeroTlf;
    }
    public Telefono(String tipo){
        this.tipo=tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public NumeroTlf getNumeroTlf() {
        return numeroTlf;
    }

    public void setNumeroTlf(NumeroTlf numeroTlf) {
        this.numeroTlf = numeroTlf;
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "tipo='" + tipo + '\'' +
                ", numeroTlf=" + numeroTlf +
                '}';
    }
}
