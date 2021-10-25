package execution;

import java.io.IOException;
import java.util.Scanner;

import control.ConfiguracaoController;
import socket.Server;

public class ServerMain {
	
	
	
	public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(System.in);
        
//        Server server = new Server(s.nextInt());
        ConfiguracaoController config = new ConfiguracaoController();
        String ipPorta = config.lerArquivoConfiguracao();
        
        if(!(ipPorta.equals(""))) {
        	String[] valores = ipPorta.split(";");
        	int porta = Integer.parseInt(valores[1]);
        	Server server = new Server(80);
        }
        
    }
}
