package candidatos;
import javax.swing.*;
import java.io.*;
//Questão 1
class Candidatos{
	int num_insc;
	String nome;
	int idade;
	int num_dependentes;
	int num_pontos;
	
	Candidatos(){
		this(0,"",0,0,0);
	}
	Candidatos(int num_insc,String nome,int idade,int num_dependentes,int num_pontos){
		this.num_insc = num_insc;
		this.nome = nome;
		this.idade = idade;
		this.num_dependentes = num_dependentes;
		this.num_pontos = num_pontos;
	}
	
}

public class Main {

	public static void main(String[] args) throws IOException{
		Candidatos cand[] = new Candidatos[80];
		ClasseMetodos m = new ClasseMetodos(); 
		
		int opc;
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção\n1-leitura dos candidatos\n2-Pesquisa do candidato\n3-Grava 50 Classificados\n9-FIM"));
			switch(opc) {
				case 1:
					cand = m.LerCandidatos(cand);
					break;
				case 2:
					String nome = m.AcharCandidato(cand, Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do candidato")));
					JOptionPane.showMessageDialog(null,nome);
					break;
				case 3:
					m.Classificar(cand);
					break;
				case 9:
					JOptionPane.showMessageDialog(null,"Encerrando");
					break;
			}
		}while(opc!=9);

	}

}
