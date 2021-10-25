package model;

import java.util.HashMap;

public class TimeFutebol {
	private String nome;
	private static int id = 0;
	private int anoCriacao;
	private Treinador treinador;
	private final HashMap<String, Jogador> jogadores = new HashMap<>();
	
	public TimeFutebol() {
		// TODO Auto-generated constructor stub
	}
	
	public TimeFutebol(String nome, int anoCriacao) {
		this.nome = nome;
		this.id = id + 1;
		this.anoCriacao = anoCriacao;
	}
	
	public Treinador getTreinador() {
        return this.treinador;
    }

    public void setTreinador(Treinador treinador) {
        this.treinador = treinador;
    }
    
    public HashMap<String, Jogador> getJogadores() {
        return jogadores;
    }

    public Jogador getJogador(String cpf) {
        for (String k : this.jogadores.keySet()) {
            if (cpf.equals(k)) {
                return this.jogadores.get(k);
            }
        }
        return null;
    }
    
    public Jogador addJogador(String cpf) {

    	Jogador s = Dados.jogadores.get(cpf);
        if (s != null) {
            jogadores.put(cpf, s);
            return s;
        }
        return null;

    }
    
    public String removeJogador(String cpf) {
    	Jogador jogador = Dados.jogadores.get(cpf);
        if (jogador != null) {
        	String nomeJogador = jogador.getNome();
        	jogador = getJogador(cpf);
        	if(jogador != null) {
        		this.jogadores.remove(cpf);
                return "Jogador " + nomeJogador + " removido do time " + this.getNome() + " com sucesso.";
        	}else {
        		return "Jogador " +nomeJogador+ " não vinculado ao time " + this.getNome();
        	}
        }else {
        	return "Jogador não existe";
        }

    }
    
    public int getId() {
        return this.id;
    }

    
    public int getAnoCriacao() {
        return anoCriacao;
    }

    public void setAnoCriacao(int anoCriacao) {
        this.anoCriacao = anoCriacao;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
    	String strJogadores = "";
    	for(String x : jogadores.keySet()) {
    		strJogadores += Dados.jogadores.get(x).toString() + "\n";
    	}
        String strTreinador = "";
        if (this.treinador != null) {
            strTreinador = this.treinador.toString();
        }else {
        	strTreinador = "Time não possui treinador";
        }
        if(strJogadores.equals("")) {
        	strJogadores = "Time não possui jogadores";
        }
        return "Time: " + this.nome + ", ID: " + this.id + ", Ano de Criação: " + this.anoCriacao + "\n" + 
        strTreinador + "\n" + 
        strJogadores;
    }


    
	
	
}
