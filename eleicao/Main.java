package eleicao;
import javax.swing.*;
import java.io.*;

class Eleitor{
	int numEleitor;
	String nomeEleitor;
	int secao;
	
	public Eleitor(int num,String nome,int secao){
		this.numEleitor = num;
		this.nomeEleitor = nome;
		this.secao = secao;
	}
}
class Voto {
    int secao;
    int codCandidato; // 1 José, 2 Maria, 3 Branco, 4 Nulo
    int numEleitor;

    public Voto(int secao, int codCandidato, int numEleitor) {
        this.secao = secao;
        this.codCandidato = codCandidato;
        this.numEleitor = numEleitor;
    }
}
class Votacao1{
	int secao;
	int codCandidato;
	int numEleitor;
	public Votacao1(int secao, int codCandidato, int numEleitor) {
        this.secao = secao;
        this.codCandidato = codCandidato;
        this.numEleitor = numEleitor;
    }
	
}
class Votacao2{
	int secao;
	int codCandidato;
	int numEleitor;
	public Votacao2(int secao, int codCandidato, int numEleitor) {
        this.secao = secao;
        this.codCandidato = codCandidato;
        this.numEleitor = numEleitor;
    }
	
}
public class Main {
	public static void main(String args[]) throws IOException{
		ClasseMetodos m = new ClasseMetodos();
		int secao_valida[] = {1,3,4,5,9,10};
		int opc;
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Menu Principal\n1-Cadastrar Eleitor"));
			
			switch(opc) {
			case 1: m.cadastrarEleitores();
				break;
			case 2:
				int opc2;
				do {
					opc2= Integer.parseInt(JOptionPane.showInputDialog("Cadastro Votação\n1-Votação 1\n2-Votação 2\n9-fim"));
					switch(opc2) {
					case 1:
						m.cadastrarVotacao1();
						break;
					case 2:
						m.cadastrarVotacao2();
						break;
					case 9:
						JOptionPane.showMessageDialog(null,"Saindo");
						break;
					default:
						JOptionPane.showMessageDialog(null,"Opção invalida");
						break;
					}
				}while(opc2!=9);
				break;
			}
			
		}while(opc != 9);
	}
}
