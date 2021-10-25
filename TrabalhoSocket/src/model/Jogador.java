package model;

public class Jogador extends Pessoa{
	private String posicao;
	private int numero;
	
	public Jogador() {
		// TODO Auto-generated constructor stub
	}
	
	public Jogador(String nome, String cpf, String endereco, String posicao, int numero) {
		super(nome, cpf, endereco);
		this.posicao = posicao;
		this.numero = numero;
	}
	
	public String getPosicao() {
        return posicao;
    }
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
	public int getNumero() {
        return numero;
    }

    
    @Override
    public String toString() {
        String msg = "Jogador - ";
        msg += super.toString();
        msg += ", Posição: " + this.posicao + ", Número: " + this.numero;
        return msg;
    }

	
	
}
