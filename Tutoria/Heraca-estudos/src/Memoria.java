class Memoria {
    private int espaco;
    private int ddr;
    private double clock;

    public Memoria() {
    }

    public Memoria(int espaco, int ddr, double clock) {
        this.espaco = espaco;
        this.ddr = ddr;
        this.clock = clock;
    }
    

    public int getEspaco() {
        return espaco;
    }

    public void setEspaco(int espaco) {
        this.espaco = espaco;
    }

    public int getDdr() {
        return ddr;
    }

    public void setDdr(int ddr) {
        this.ddr = ddr;
    }

    public double getClock() {
        return clock;
    }

    public void setClock(double clock) {
        this.clock = clock;
    }
    
    
}
