package eleicao;

import javax.swing.JOptionPane;
import java.io.*;

public class ClasseMetodos {
	public void cadastrarEleitores() throws IOException{
		String fileName = "CadastroEleitor.txt";
		BufferedWriter w = new BufferedWriter(new FileWriter(fileName));
		for(int i=0;i<10;i++) {
			int num = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do eleitor"));
			String nome =JOptionPane.showInputDialog("Digite o nome do eleitor");
			int secao = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do eleitor"));
			w.write(Integer.toString(num));w.newLine();
			w.write(nome);w.newLine();
			w.write(Integer.toString(secao));w.newLine();
		}
		w.close();
	}
	public void cadastrarVotacao1() throws IOException{
		int secao_valida[] = {1,3,4};
		for(int i=0;i<5;i++) {
			int secao=0;
			boolean errado=true;
			do {
				secao = Integer.parseInt(JOptionPane.showInputDialog("Digite a seção da votaçao"));
				for(int j : secao_valida) {
					if(j ==secao) {
						errado=false;
						break;
					}
				}
				if(errado) {
					JOptionPane.showMessageDialog(null,"Seção invalida");
				}
			}while(errado);
			int codCandidato=0;
			errado = true;
			do {
				codCandidato = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do candidato"));
				String fileName = "CadastroEleitor.txt";
				BufferedReader r = new BufferedReader(new FileReader(fileName));
				for(int j=0;j<5;i++) {
					r.readLine();
				}
			}while(errado);
			
			int numEleitor = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do eleitor"));;
			
		}
	}
	public void cadastrarVotacao2() {
		int secao_valida[] = {5,9,10};
	}
	
}
