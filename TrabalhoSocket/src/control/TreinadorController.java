package control;

import java.io.PrintStream;
import java.util.HashMap;

import model.Dados;
import model.Treinador;

public class TreinadorController {
	Treinador treinador;
	
	public static String create(HashMap<String, String> parametros, PrintStream ps) {
		if(Dados.treinadores.get(parametros.get("cpf")) != null) {
			return "Treinador com CPF informado já existe.";
		}
		
		String nome = parametros.get("nome");
		String cpf = parametros.get("cpf");
		String endereco = parametros.get("endereco");
		String numeroLicenca = parametros.get("numeroLicenca");
		
		Treinador treinador = new Treinador(nome, cpf, endereco, numeroLicenca);
		Dados.treinadores.put(treinador.getCpf(), treinador);
		
		return "Treinador cadastrado com sucesso!";
	}
	
	public static String update(HashMap<String, String> parametros, PrintStream ps) {
		
		Treinador treinador = Dados.treinadores.get(parametros.get("cpf"));
		if(treinador != null) {
			String nome = parametros.get("nome");
			String endereco = parametros.get("endereco");
			String numeroLicenca = parametros.get("numeroLicenca");
			System.out.println("O NOME É " + nome);
			if(!(nome == null))
				treinador.setNome(nome);
			if(!(endereco == null))
				treinador.setEndereco(endereco);
			if(!(numeroLicenca == null))
				treinador.setNumeroLicenca(numeroLicenca);
			return "Treinador atualizado com sucesso!"; 
		}else {
			return "Treinador não encontrado!";
		}
		
		
	}
	
	public static String delete(HashMap<String, String> parametros, PrintStream ps) {
		Treinador treinador = Dados.treinadores.get(parametros.get("cpf"));
		if(treinador != null) {
			Dados.treinadores.remove(treinador.getCpf());
			return "Treinador removido com sucesso!";
		}else {
			return "Treinador não encontrado";
		}
		
		
		
	}
	
	public static String getOne(HashMap<String, String> parametros, PrintStream ps) {
		
		Treinador treinador = Dados.treinadores.get(parametros.get("cpf"));
		if(treinador != null) {
			return "--------------------------------- \n" + 
					treinador.toString();
		}else {
			return "Treinador não encontrado";
		}
	}
	
	public static String getAll(PrintStream ps) {
		String retorno = "";
		
		for(String cpf : Dados.treinadores.keySet()) {
			if(!(retorno.equals(""))) {
				retorno += "\n";
			}else {
				retorno += "--------------------------------- \n";
			}
			retorno += Dados.treinadores.get(cpf).toString();
		}
		if(retorno.equals("")) {
			retorno = "Nenhum treinador encontrado!";
		}
		return retorno;
	}
}
