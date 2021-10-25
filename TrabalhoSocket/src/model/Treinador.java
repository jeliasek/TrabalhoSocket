package model;

public class Treinador extends Pessoa{
	private String numeroLicenca;
	
	public Treinador() {
		// TODO Auto-generated constructor stub
	}
	
	public Treinador(String nome, String cpf, String endereco, String numeroLicenca) {
		super(nome, cpf, endereco);
		this.numeroLicenca = numeroLicenca;
	}
	
	public String getNumeroLicenca() {
		return numeroLicenca;
	}
	
	public void setNumeroLicenca(String numeroLicenca) {
		this.numeroLicenca = numeroLicenca;
	}
	
	  @Override
	  public String toString() {
        String msg = "Treinador - ";
        msg += super.toString();
        msg += ", Número Licença: " + this.numeroLicenca;
        return msg;
	  }
}
