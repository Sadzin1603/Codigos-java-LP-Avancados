package votacao;
import javax.swing.*;
import java.io.*;
class 	Votacao{
	int numSecao;
	int numCandidato;
	Votacao(){
		this(0,0);
	}
	Votacao(int sec,int cand){
		this.numSecao=sec;
		this.numCandidato=cand;
	}
}
public class main {
	public static void main(String[] args) throws IOException{	
		Votacao votos[] = new Votacao[200];
		ClasseMetodos m = new ClasseMetodos();
		int opc;
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("SISTEMA DE VOTAÇÃO \n 1 – Carregar Seção/Número Eleitor \n 2 – Classificar por Seção \n 3 – Gravar Registros \n 4 – Mostrar Indicadores \n 9 – Finalizar"));
			switch(opc) {
				case 1:
					votos = m.FCADRASTRAVOTACAO(votos);
					break;
				case 2:
					votos = m.FCLASSIFICASECAO(votos);
					break;
				case 3:
					votos = m.FGRAVAVOTACAO(votos);
					break;
				case 4:
					int opc2 = 0;
					while(opc2 != 9) {
						opc2 = Integer.parseInt(JOptionPane.showInputDialog("Mostrar Indicadores \n Estatísticas de Votação em 2021 \n 1 – Quantidade Eleitores por Seção \n 2 –Seção com Maior e Menor número de Eleitores \n 3 – Quantidade de votos por candidato \n 4 – 10 primeiros colocadas (nro cand. e qtd votos) \n 9 – Finaliza consulta"));
						switch(opc2) {
						case 1:
							m.QTDELLEITORES(votos);
							break;
						case 2:
							m.MAIORMENORNUMELEITORES(votos);
							break;
						case 3:
							m.QTDVOTOSCANDIDATOS(votos);
							break;
						case 4:
							m.PRIMEIROS10COLLOCADOS(votos);
							break;
						case 9:
							JOptionPane.showMessageDialog(null, "FIM Consulta");
							break;
						}
					}
					break;
				case 9:
					JOptionPane.showMessageDialog(null, "FIM");
					System.exit(0);
					break;
				
			}
			
		}while(opc!=9);

	}	

}