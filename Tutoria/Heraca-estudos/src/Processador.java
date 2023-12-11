public class Processador {
    
    private int nucleos;
    private double clock;
    private int nanometros;
    private String marca;

    public Processador() {        
    }

    public Processador(int nucleos, double clock, int nanometros, String marca) {
        this.nucleos = nucleos;
        this.clock = clock;
        this.nanometros = nanometros;
        this.marca = marca;
    }
    

    public int getNucleos() {
        return nucleos;
    }

    public void setNucleos(int nucleos) {
        this.nucleos = nucleos;
    }

    public double getClock() {
        return clock;
    }

    public void setClock(double clock) {
        this.clock = clock;
    }

    public int getNanometros() {
        return nanometros;
    }

    public void setNanometros(int nanometros) {
        this.nanometros = nanometros;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
    
}
