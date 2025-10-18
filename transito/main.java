package transito;

import javax.swing.JOptionPane;
import java.io.*;

class Estatistica{
	int codigoCidade;
	String nomeCidade;
	int qtdAcidentes;
	Estatistica(){
		this(0,"",0);
	}
	Estatistica(int cod,String nome,int qtd){
		this.codigoCidade=cod;
		this.nomeCidade=nome;
		this.qtdAcidentes=qtd;
	}
}

public class main {
	public static void main (String args[]) throws IOException {
		int opc;
		Estatistica est[] = new Estatistica[3];
		ClasseMetodos m= new ClasseMetodos();
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Menu Estatisticas\n1-cadastro estatistica\n2-Consulta por quantidade de acidentes\n3-Consulta por estatísticas de acidentes\n4-Acidentes acima da média das 10 cidades \n9-FINALIZA"));
			
			switch(opc) {
				case 1:
					est = m.FCADRASTRAESTATISTICA(est);
					break;
				case 2:
					est = m.PQTDACIDENTES(est);
					break;
				case 3:
					est = m.PMAIORMENOR(est);
					break;
				case 4:
					est = m.PACIMA(est);
					break;
			}
			
		}while(opc!=9);
	}
}