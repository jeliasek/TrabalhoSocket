package execution;

import java.io.IOException;
import java.util.Scanner;

import control.ConfiguracaoController;
import socket.Client;

public class ClientMain {
	public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
//        s.useDelimiter("\n");
        ConfiguracaoController config = new ConfiguracaoController();
        String ipPorta = config.lerArquivoConfiguracao();
        
        if(!(ipPorta.equals("")) || !(ipPorta.equals(";"))) {
        	String[] valores = ipPorta.split(";");
        	int porta = Integer.parseInt(valores[1]);
        	String ip = valores[0];
        	Client c = new Client(ip, porta, s);
        }
        
    }
}


