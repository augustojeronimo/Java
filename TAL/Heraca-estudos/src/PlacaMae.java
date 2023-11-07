public class PlacaMae {
    private String marca;
    private int qtd_slots;
    private int qdt_portas_usb;

    public PlacaMae() {
    }
    
    public PlacaMae(String marca, int qtd_slots, int qdt_portas_usb) {
        this.marca = marca;
        this.qtd_slots = qtd_slots;
        this.qdt_portas_usb = qdt_portas_usb;
    }
    

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getQtd_slots() {
        return qtd_slots;
    }

    public void setQtd_slots(int qtd_slots) {
        this.qtd_slots = qtd_slots;
    }

    public int getQdt_portas_usb() {
        return qdt_portas_usb;
    }

    public void setQdt_portas_usb(int qdt_portas_usb) {
        this.qdt_portas_usb = qdt_portas_usb;
    }
    
}
