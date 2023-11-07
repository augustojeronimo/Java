class Armazenamento {
    
    private int espaco;
    private int velocidade;

    public Armazenamento() {
    }

    public Armazenamento(int espaco, int velocidade) {
        this.espaco = espaco;
        this.velocidade = velocidade;
    }
    

    public int getEspaco() {
        return espaco;
    }

    public void setEspaco(int espaco) {
        this.espaco = espaco;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }
    
}
