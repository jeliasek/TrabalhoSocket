package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ConfiguracaoController {
	String ip = "";
	int porta = 0;

	
	public String lerArquivoConfiguracao() {
		String retorno = "";
        File arq = new File("ArquivoConfig.txt");
        try {
            FileReader leitorArq = new FileReader(arq);
            BufferedReader leitorTexto = new BufferedReader(leitorArq);
            String linha = leitorTexto.readLine();
            HashMap<String, String> configuracoes = new HashMap<>();
            while (linha != null) {
        		configuracoes.put(linha.split("=")[0], linha.split("=")[1]);        		
                linha = leitorTexto.readLine();
            }
            ip = configuracoes.get("IP_SERVIDOR");
    		porta = Integer.parseInt(configuracoes.get("PORTA_SERVIDOR"));
    		
    		if(ip.equals("") || porta < 1) {
    			System.out.println("Arquivo de configuração parametrizado errado. Acesse link <https://github.com/jeliasek/TrabalhoSocket.git> para saber como configurar.");
    		}
    		retorno = ip + ";" + porta;
    		
            leitorTexto.close();
            leitorArq.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de configuração não encontrado. Acesse link <https://github.com/jeliasek/TrabalhoSocket.git> para saber como configurar.");
            
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo de configuração. Tente novamente");
            
        }
        return retorno;
    }
}
