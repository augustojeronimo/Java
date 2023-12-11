public class Computador {
    
    private Processador processador;
    private PlacaMae placa;
    private Memoria memoria;
    private Armazenamento armazenamento;

    public Processador getProcessador() {
        return processador;
    }

    public void setProcessador(int nucleos, double clock, int nanometros, String marca) {
        this.processador = new Processador(nucleos, clock, nanometros, marca);
    }

    public PlacaMae getPlaca() {
        return placa;
    }

    public void setPlaca(String marca, int qtd_slots, int qdt_portas_usb) {
        this.placa = new PlacaMae(marca, qtd_slots, qdt_portas_usb);
    }

    public Memoria getMemoria() {
        return memoria;
    }

    public void setMemoria(int espaco, int ddr, double clock) {
        this.memoria = new Memoria(espaco, ddr, clock);
    }

    public Armazenamento getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(int espaco, int velocidade) {
        this.armazenamento = new Armazenamento(espaco, velocidade);
    }
    
}
