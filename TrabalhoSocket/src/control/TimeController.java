package control;

import java.util.HashMap;

import model.Dados;
import model.Jogador;
import model.TimeFutebol;
import model.Treinador;

public class TimeController {
	TimeFutebol time;
	
	public static String create(HashMap<String, String> parametros) {
		
		String nome = parametros.get("nome");
		int anoCriacao = Integer.parseInt(parametros.get("anoCriacao"));
		
		TimeFutebol time = new TimeFutebol(nome, anoCriacao);
		Dados.times.put(time.getId(), time);
		System.out.println(time.getId());
		return "Time " + time.getId() + " - " + time.getNome() + " cadastrado com sucesso!";
	}
	
	public static String update(HashMap<String, String> parametros) {
		System.out.println("Recebido: " + parametros.get("id"));
		int id = Integer.parseInt(parametros.get("id"));
		System.out.println("Tratado: " + id);
		TimeFutebol time = Dados.times.get(id);
		if(time != null) {
			String nome = parametros.get("nome");
			int anoCriacao = Integer.parseInt(parametros.get("anoCriacao"));
			
			if(nome != null)
				time.setNome(nome);
			if(anoCriacao > 0)
				time.setAnoCriacao(anoCriacao);

			return "Time atualizado com sucesso!"; 
		}else {
			return "Time não encontrado!";
		}
		
		
	}
	
	public static String delete(HashMap<String, String> parametros) {
		int id = Integer.parseInt(parametros.get("id"));
		TimeFutebol time = Dados.times.get(id);
		if(time != null) {
			Dados.times.remove(time.getId());
			return "Time removido com sucesso!";
		}else {
			return "Time não encontrado";
		}
		
		
		
	}
	
	public static String getOne(HashMap<String, String> parametros) {
		int id = Integer.parseInt(parametros.get("id"));
		TimeFutebol time = Dados.times.get(id);
		if(time != null) {
			return time.toString();
		}else {
			return "Time não encontrado";
		}
	}
	
	public static String getAll() {
		String retorno = "";
		for(int id : Dados.times.keySet()) {
			if(!(retorno.equals(""))) {
				retorno += "\n --------------------------------- \n";
				retorno += "Total de Registros Encontrados: " + Dados.times.size() + "\n";
			}
			retorno += Dados.times.get(id).toString();
		}
		if(retorno.equals("")) {
			return "Nenhum time encontrado";
		}
		return retorno;
	}
	
	public static String addTreinador(HashMap<String, String> parametros) {
		int id = Integer.parseInt(parametros.get("id"));
		TimeFutebol time = Dados.times.get(id);
		if(time != null) {
			Treinador treinador = Dados.treinadores.get(parametros.get("cpf"));
			if(treinador != null) {
				for(int i : Dados.times.keySet()) {
					if(Dados.times.get(i).getTreinador() == treinador) {
						return "Treinador " +treinador.getNome()+ " já vinculado ao time " + Dados.times.get(i).getNome() + "!";
					}
				}
				time.setTreinador(treinador);
				return "Treinador " +treinador.getNome()+ " adicionado ao time " +time.getNome()+ " com sucesso";
			}else {
				return "Treinador não encontrado";
			}
		}else {
			return "Time não encontrado";
		}
	}
	
	public static String removeTreinador(HashMap<String, String> parametros) {
		int id = Integer.parseInt(parametros.get("id"));
		TimeFutebol time = Dados.times.get(id);
		if(time != null) {
			Treinador treinador = Dados.treinadores.get(parametros.get("cpf"));
			if(treinador != null) {
				if(treinador != time.getTreinador()) {
					return "Treinador " +  treinador.getNome() + " não vinculado ao time " + time.getNome();
				}
				time.setTreinador(null);
				return "Treinador " + treinador.getNome() + " removido do time " +time.getNome()+ " com sucesso";
			}else {
				return "Treinador não encontrado";
			}
		}else {
			return "Time não encontrado";
		}
	}
	
	public static String addJogador(HashMap<String, String> parametros) {
		int id = Integer.parseInt(parametros.get("id"));
		TimeFutebol time = Dados.times.get(id);
		if(time != null) {
			String cpf = parametros.get("cpf");
			Jogador jogador = Dados.jogadores.get(cpf);
			if(jogador != null) {
				for(int i : Dados.times.keySet()) {
					if(Dados.times.get(i).getJogador(cpf) != null) {
						return "Jogador " +jogador.getNome() + " já vinculado ao time "+ Dados.times.get(i).getNome();
					}
				}
				time.addJogador(parametros.get("cpf"));
				return "Jogador " +jogador.getNome() + " adicionado ao time " +time.getNome()+ " com sucesso";
			}else {
				return "Jogador não encontrado";
			}
		}else {
			return "Time não encontrado"; 
		}
	}
	
	public static String removeJogador(HashMap<String, String> parametros) {
		int id = Integer.parseInt(parametros.get("id"));
		TimeFutebol time = Dados.times.get(id);
		if(time != null) {
			Jogador jogador = Dados.jogadores.get(parametros.get("cpf"));
			if(jogador != null) {
				return time.removeJogador(parametros.get("cpf"));
			}else {
				return "Jogador não encontrado";
			}
		}else {
			return "Time não encontrado";
		}
	}
	
}
