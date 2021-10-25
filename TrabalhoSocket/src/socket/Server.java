package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import control.JogadorController;
import control.TimeController;
import control.TreinadorController;

public class Server {
	private int porta;
	public Server(int porta) throws IOException {
		this.porta = porta;
		try ( ServerSocket server = new ServerSocket(this.porta);) /* try-with */ {

            server.setReuseAddress(true);
            System.out.println("Aguardando conexao TCP na porta "+ this.porta +"...");

            try ( Socket conn = server.accept();) /* try-with */ {

                System.out.println("Conexão recebida de: " + conn.getInetAddress().getHostAddress());

                InputStream in = conn.getInputStream();
                OutputStream out = conn.getOutputStream();

                // receber o comando a ser executado
                byte[] dadosBrutos = new byte[1024];
                int qtdBytesLidos = in.read(dadosBrutos);
                String parametros = new String(dadosBrutos, 0, qtdBytesLidos);
                System.out.println("Lalala" + parametros);
                while (!parametros.equals("exit") && (!parametros.equals("invalidAction"))) {
                    System.out.println("Parametros recebidos: "+parametros);
                    
                    String resultado = null;
                    
                    resultado = executaAcao(parametros);

                    System.out.println(resultado);
                    out.write(resultado.getBytes());

                    System.out.println("Execucao finalizada. Aquardando proxima ação...");
                   
                    dadosBrutos = new byte[1024];
                    qtdBytesLidos = in.read(dadosBrutos);
                    parametros = new String(dadosBrutos, 0, qtdBytesLidos);
                }
                System.out.println("Fechando o servidor.");
            }
        }
			
	}
	
	public String executaAcao(String parametrosUsuario) {
		
		String[] itens = parametrosUsuario.split(";");
		HashMap<String, String> parametros = new HashMap<>();
		for(String parametro : itens) {
			parametros.put(parametro.split("=")[0], parametro.split("=")[1]);
		}
		
		switch(parametros.get("modelo")) {
			case "TREINADOR": {
				switch(parametros.get("acao")) {
					case "CREATE":{
						return TreinadorController.create(parametros);
					}
					
					case "UPDATE":{
						return TreinadorController.update(parametros);
					} 
					
					case "DELETE":{
						return TreinadorController.delete(parametros);
					}
					
					case "GETONE":{
						return TreinadorController.getOne(parametros);
					}
					
					case "GETALL":{
						return TreinadorController.getAll();
					}
				}
			}
			
			case "JOGADOR":{
				switch(parametros.get("acao")) {
					case "CREATE":{
						return JogadorController.create(parametros);
					}
					
					case "UPDATE":{
						return JogadorController.update(parametros);
					}
					
					case "DELETE":{
						return JogadorController.delete(parametros);
					}
					
					case "GETONE":{
						return JogadorController.getOne(parametros);
					}
					
					case "GETALL":{
						return JogadorController.getAll();
					}
				}
			}
			
			case "TIME":{
				
				switch(parametros.get("acao")) {
					case "CREATE":{
						return TimeController.create(parametros);
					}
					
					case "UPDATE":{
						return TimeController.update(parametros);
					}
					
					case "DELETE":{
						return TimeController.delete(parametros);
					}
					
					case "GETONE":{
						return TimeController.getOne(parametros);
					}
					
					case "GETALL":{
						return TimeController.getAll();
					}
					
					case "ADDJOGADOR":{
						return TimeController.addJogador(parametros);
					}
					
					case "REMOVEJOGADOR":{
						return TimeController.removeJogador(parametros);
					}
					
					case "ADDTREINADOR":{
						return TimeController.addTreinador(parametros);
					}
					
					case "REMOVETREINADOR":{
						return TimeController.removeTreinador(parametros);
					}
				}
			}
		}
		
		
		return "";
	}

}
