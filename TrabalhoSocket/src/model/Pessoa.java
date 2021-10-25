package model;

public class Pessoa {
	private String cpf;
	private String nome;
	private String endereco;
	
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}
	
	 public Pessoa(String nome, String cpf, String endereco) {
	        this.nome = nome;
	        this.cpf = cpf;
	        this.endereco = endereco;
	    }

	    public String getNome() { 
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public String getCpf() {
	        return cpf;
	    }

	    public void setCpf(String cpf) {
	        this.cpf = cpf;
	    }

	    public String getEndereco() {
	        return endereco;
	    }

	    public void setEndereco(String endereco) {
	        this.endereco = endereco;
	    }

	    @Override
	    public String toString() {
	        return "Nome: " + this.nome + ", " +
	                "CPF: " + this.cpf + ", " +
	                "Endereço: " + this.endereco;
	    }
}
