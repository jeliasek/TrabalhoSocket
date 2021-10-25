package control;

import java.util.HashMap;

import model.Dados;
import model.Jogador;


public class JogadorController {
	Jogador jogador;
	
	public static String create(HashMap<String, String> parametros) {
		if(Dados.jogadores.get(parametros.get("cpf")) != null) {
			return "Jogador com CPF informado já existe.";
		}
		
		String nome = parametros.get("nome");
		String cpf = parametros.get("cpf");
		String endereco = parametros.get("endereco");
		String posicao = parametros.get("posicao");
		int numero = Integer.parseInt(parametros.get("numero"));
		
		Jogador jogador = new Jogador(nome, cpf, endereco, posicao, numero);
		Dados.jogadores.put(jogador.getCpf(), jogador);
		
		return "Jogador cadastrado com sucesso!";
	}
	
	public static String update(HashMap<String, String> parametros) {
		
		
		Jogador jogador = Dados.jogadores.get(parametros.get("cpf"));
		if(jogador != null) {
			String nome = parametros.get("nome");
			String endereco = parametros.get("endereco");
			String posicao = parametros.get("posicao");
			int numero = Integer.parseInt(parametros.get("numero"));
			
			if(!(nome == null))
				jogador.setNome(nome);
			if(!(endereco == null))
				jogador.setEndereco(endereco);
			if(numero > 0) {
				jogador.setNumero(numero);
			}
				
			if(!(posicao == null))
				jogador.setPosicao(posicao);
			return "Jogador atualizado com sucesso!"; 
		}else {
			return "Jogador não encontrado!";
		}
		
		
	}
	
	public static String delete(HashMap<String, String> parametros) {
		Jogador jogador = Dados.jogadores.get(parametros.get("cpf"));
		if(jogador != null) {
			for(int id : Dados.times.keySet()) {
				if(Dados.times.get(id).getJogador(parametros.get("cpf")) != null) {
					return "Não foi possível remover! Jogador " + jogador.getNome() + " vinculado ao time " + Dados.times.get(id).getNome();
				}
			}
			Dados.jogadores.remove(jogador.getCpf());
			return "Jogador removido com sucesso!";
		}else {
			return "Jogador não encontrado";
		}
		
		
		
	}
	
	public static String getOne(HashMap<String, String> parametros) {
		
		Jogador jogador = Dados.jogadores.get(parametros.get("cpf"));
		if(jogador != null) {
			return jogador.toString();
		}else {
			return "Jogador não encontrado";
		}
	}
	
	public static String getAll() {
		String retorno = "";
		
		for(String cpf : Dados.jogadores.keySet()) {
			retorno += Dados.jogadores.get(cpf).toString() + "\n";
		}
		
		if(retorno.equals("")) {
			retorno = "Nenhum jogador encontrado.";
		}
		
		return retorno;
	}
}
