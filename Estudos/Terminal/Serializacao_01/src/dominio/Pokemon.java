package dominio;

import java.io.Serializable;

public class Pokemon implements Serializable{
    private String nome;
    private String tipo;
    private int ataque;
    private int defesa;
    private int nivel;
    private boolean vivo;
    
    public Pokemon(String nome, String tipo, int ataque, int defesa, int nivel, boolean vivo) {
        this.nome = nome;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defesa = defesa;
        this.nivel = nivel;
        this.vivo = vivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "nome=" + nome + ", tipo=" + tipo + ", ataque=" + ataque + ", defesa=" + defesa + ", nivel=" + nivel + ", vivo=" + vivo + '}';
    }
}
