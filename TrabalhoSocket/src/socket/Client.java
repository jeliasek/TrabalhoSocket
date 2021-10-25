package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	private String host;
	private int porta;
	private Socket socket;
	
	public Socket getSocket() {
		return socket;
	}
	
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public Client(String host, int porta, Scanner s) throws IOException {
		this.host = host;
		this.porta = porta;
		
		try ( Socket conn = new Socket(this.host, this.porta);) /* try-with */ {
            System.out.println("Conectado!");
            InputStream in = conn.getInputStream();
            OutputStream out = conn.getOutputStream();

            String parametros = ""; 
            do {
            	System.out.println(
            			   "--------------------------------- \n" +
            			   "(1) - Manipular Treinadores \n" +
						   "(2) - Manipular Jogadores \n" +
						   "(3) - Manipular Times de Futebol \n" +
						   "(4) - Sair \n" +
						   "---------------------------------"
				);
				int modelEscolhido = s.nextInt();
				int acao = 0;
				
                if(modelEscolhido > 0 && modelEscolhido < 5) {

					//Escolher ação para manipular a classe escolhida.
					
					if(modelEscolhido != 4) { 
						String opcoes = "";
						opcoes = "--------------------------------- \n" +
								"(1) - CRIAR \n" +
								"(2) - ATUALIZAR \n" +
								"(3) - REMOVER \n" +
								"(4) - BUSCAR UM \n" +
								"(5) - LISTAR TODOS \n"
						;
						if(modelEscolhido == 3) {
							opcoes +=  "(6) - ADICIONAR JOGADOR \n" +
									   "(7) - REMOVER JOGADOR \n" +
									   "(8) - INFORMAR TREINADOR \n" +
									   "(9) - REMOVER TREINADOR \n"
							;
						}
						opcoes += "---------------------------------";
						System.out.println(opcoes);
						acao = s.nextInt();
					}
                }
				
				//Montar string a ser enviada para o server.
				String strParametros = "";
				String strAcao = "";
				switch(modelEscolhido) {
					case 1: { //Treinadores
						switch(acao) {
							case 1: {
								String cpf = "";
								while(cpf.length() != 11) {
									if(!(cpf.equals(""))) {
										System.out.println("ERRO 01 - INFORME UM CPF VÁLIDO!");
									}
									System.out.println("Digite o CPF");
									cpf = s.next();
								}
								
								System.out.println("Digite o Nome");
								s.nextLine();
								String nome = s.nextLine();
								System.out.println("Digite o Endereço");
								String endereco = s.nextLine();
								System.out.println("Digite o Número da Licença");
								String numeroLicenca = s.nextLine();
								strParametros = "cpf=" + cpf + ";nome=" + nome + ";endereco=" + endereco + ";numeroLicenca=" + numeroLicenca;
								strAcao = "CREATE";
								break;
								
							}
							
							case 2:{
								System.out.println("** Digite apenas os registros que deseja atualizar! **");
								String cpf = "";
								while(cpf.length() != 11) {
									if(!(cpf.equals(""))) {
										System.out.println("ERRO 01 - INFORME UM CPF VÁLIDO!");
									}
									System.out.println("Digite o CPF");
									cpf = s.next();
								}
								System.out.println("Digite o Nome");
								s.nextLine();
								String nome = s.nextLine();
								System.out.println("Digite o Endereço");
								String endereco = s.nextLine();
								System.out.println("Digite o Número da Licença");
								String numeroLicenca = s.nextLine();
								strParametros = "cpf=" + cpf;
								if(!nome.equals(""))
									strParametros += ";nome="+nome;
								if(!endereco.equals(""))
									strParametros += ";endereco="+endereco;
								if(!numeroLicenca.equals(""))
									strParametros += ";numeroLicenca="+numeroLicenca;
//								strParametros = "cpf=" + cpf + ";nome=" + nome + ";endereco=" + endereco + ";numeroLicenca=" + numeroLicenca;
								strAcao = "UPDATE";
								break;
							}
							
							case 3:{
								String cpf = "";
								while(cpf.length() != 11) {
									if(!(cpf.equals(""))) {
										System.out.println("ERRO 01 - INFORME UM CPF VÁLIDO!");
									}
									System.out.println("Digite o CPF");
									cpf = s.next();
								}
								strParametros = "cpf=" + cpf;
								strAcao = "DELETE";
								break;
								
							}
							
							case 4:{
								String cpf = "";
								while(cpf.length() != 11) {
									if(!(cpf.equals(""))) {
										System.out.println("ERRO 01 - INFORME UM CPF VÁLIDO!");
									}
									System.out.println("Digite o CPF");
									cpf = s.next();
								}
								strParametros = "cpf=" + cpf;
								strAcao = "GETONE";
								break;
							}
							
							case 5:{
								strAcao = "GETALL";
								break;
							}
							
							default:{
								System.out.println("Selecione uma ação válida");
								parametros = "invalidAction";
								break;
							}
						}
						if(acao > 0 && acao < 6) {
							parametros = "modelo=TREINADOR;acao=" + strAcao + ";" + strParametros;
							
						}
						break;
					}
					
					case 2: { //Jogadores
						switch(acao) {
							case 1: {
								String cpf = "";
								while(cpf.length() != 11) {
									if(!(cpf.equals(""))) {
										System.out.println("ERRO 01 - INFORME UM CPF VÁLIDO!");
									}
									System.out.println("Digite o CPF");
									cpf = s.next();
								}
								System.out.println("Digite o Nome");
								s.nextLine();
								String nome = s.nextLine();
								System.out.println("Digite o Endereço");
								String endereco = s.nextLine();
								System.out.println("Digite a Posição");
								String posicao = s.nextLine();
								System.out.println("Digite o Número");
								int numero = s.nextInt();
								strParametros = "cpf=" + cpf + ";nome=" + nome + ";endereco=" + endereco + ";posicao=" + posicao + ";numero=" + numero;
								strAcao = "CREATE";
								break;
							
							}
							
							case 2: {
								System.out.println("** Digite apenas os registros que deseja atualizar! **");
								String cpf = "";
								while(cpf.length() != 11) {
									if(!(cpf.equals(""))) {
										System.out.println("ERRO 01 - INFORME UM CPF VÁLIDO!");
									}
									System.out.println("Digite o CPF");
									cpf = s.next();
								}
								System.out.println("Digite o Nome");
								s.nextLine();
								String nome = s.nextLine();
								System.out.println("Digite o Endereço");
								String endereco = s.nextLine();
								System.out.println("Digite a Posição");
								String posicao = s.nextLine();
								System.out.println("Digite o Número");
								int numero = s.nextInt();
								
								strParametros = "cpf=" + cpf;
								if(!nome.equals(""))
									strParametros += ";nome=" + nome;
								if(!endereco.equals(""))
									strParametros += ";endereco=" + endereco;
								if(!posicao.equals(""))
									strParametros += ";posicao=" + posicao;
								if(numero > 0)
									strParametros += ";numero=" + numero;
								strAcao = "UPDATE";
								break;
							}
							
							case 3:{
								String cpf = "";
								while(cpf.length() != 11) {
									if(!(cpf.equals(""))) {
										System.out.println("ERRO 01 - INFORME UM CPF VÁLIDO!");
									}
									System.out.println("Digite o CPF");
									cpf = s.next();
								}
                                strParametros = "cpf=" + cpf;
                                strAcao = "DELETE";
                                break;
							}
							
							case 4:{
								String cpf = "";
								while(cpf.length() != 11) {
									if(!(cpf.equals(""))) {
										System.out.println("ERRO 01 - INFORME UM CPF VÁLIDO!");
									}
									System.out.println("Digite o CPF");
									cpf = s.next();
								}
	                              strParametros = "cpf=" + cpf;
	                              strAcao = "GETONE";
	                              break;
							}
							
							case 5:{
								strAcao = "GETALL";
								break;
							}
							
							default:{
								System.out.println("Selecione uma ação válida");
								parametros = "invalidAction";
								
							}
							break;
						}
						if(acao > 0 && acao < 6) {
							parametros = "modelo=JOGADOR;acao=" + strAcao + ";" + strParametros;
							break;
						}
					}
					
					case 3: { //Times
						switch(acao) {
							case 1: {
								System.out.println("Digite o Nome");
								s.nextLine();
								String nome = s.nextLine();
								System.out.println("Digite o Ano de Criação");
								String anoCriacao = s.next();
								strParametros = "nome=" + nome + ";anoCriacao=" + anoCriacao;
								strAcao = "CREATE";
								break;
							
							}
							
							case 2:{
								System.out.println("** Digite apenas os registros que deseja atualizar! **");
								System.out.println("Digite o ID");
								int id = s.nextInt();
								System.out.println("Digite o Nome");
								s.nextLine();
								String nome = s.nextLine();
								System.out.println("Digite o Ano de Criação");
								String anoCriacao = s.next();
								strParametros = "id=" + id;
								if(!nome.equals(""))
									strParametros += ";nome=" + nome;
								if(!anoCriacao.equals(""))
									strParametros += ";anoCriacao=" + anoCriacao;
								
								strAcao = "UPDATE";
								break;
							}
							
							case 3:{
								System.out.println("Digite o ID");
								int id = s.nextInt();
								strParametros = "id=" + id;
								strAcao = "DELETE";
								break;
							}
							
							case 4:{
								System.out.println("Digite o ID");
								int id = s.nextInt();
								strParametros = "id=" + id;
								strAcao = "GETONE";
								break;
							}
							
							case 5:{
								strAcao = "GETALL";
								break;
							}
							
							case 6:{
								System.out.println("Digite o ID do Time");
								int id = s.nextInt();
								System.out.println("Digite o CPF do Jogador");
								String cpf = s.next();
								strParametros = "id=" + id + ";cpf=" + cpf;
								strAcao = "ADDJOGADOR";
								break;
								
							}
							
							case 7: {
								System.out.println("Digite o ID do Time");
								int id = s.nextInt();
								System.out.println("Digite o CPF do Jogador");
								String cpf = s.next();
								strParametros = "id=" + id + ";cpf=" + cpf;
								strAcao = "REMOVEJOGADOR";
								break;
							}
							
							case 8:{
								System.out.println("Digite o ID do Time");
								int id = s.nextInt();
								System.out.println("Digite o CPF do Treinador");
								String cpf = s.next();
								strParametros = "id=" + id + ";cpf=" + cpf;
								strAcao = "ADDTREINADOR";
								break;
							}
							
							case 9:{
								System.out.println("Digite o ID do Time");
								int id = s.nextInt();
								System.out.println("Digite o CPF do Treinador");
								String cpf = s.next();
								strParametros = "id=" + id + ";cpf=" + cpf;
								strAcao = "REMOVETREINADOR";
								break;
							}
							default:{
								System.out.println("Selecione uma ação válida");
								parametros = "invalidAction";
								break;
							}
						}
						if (acao > 0 && acao < 10) {
							parametros = "modelo=TIME;acao=" + strAcao + ";" + strParametros;
							
						}
						break;
					}
					
					case 4: { //Sair
						System.out.println("Execução finalizada.");
						parametros = "exit";
						break;
					}
					
					default:{
						System.out.println("Selecione uma opção válida!");
						parametros = "invalidAction";
						break;
					}
				}
				
				
                // enviar o comando para o servidor
                out.write(parametros.getBytes());
//                System.out.println("Linha 312 " + parametros);
                if (!parametros.equals("exit") && !parametros.equals("invalidAction")) {
                    // receber resultado do comando retornado pelo servidor
                    byte[] dadosBrutos = new byte[1024];
                    int qtdBytesLidos;
                    do {
                        qtdBytesLidos = in.read(dadosBrutos);
                        String resultado = new String(dadosBrutos, 0, qtdBytesLidos);
                        System.out.println(resultado);
                    } while (qtdBytesLidos == dadosBrutos.length);
                }
            } while (!parametros.equals("exit"));

        } catch (UnknownHostException e) {
            System.out.println("Host não encontrado");
            e.printStackTrace();
        }
	}
}
