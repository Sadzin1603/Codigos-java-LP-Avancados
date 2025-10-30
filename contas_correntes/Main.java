package contas_correntes;

import javax.swing.JOptionPane;
import java.io.*;
class ContaCorrente{
	int codConta;
	String nomeCliente;
	double saldoConta;
	double limiteConta;
	int tipoConta;
	
	ContaCorrente(){
		this(0,"",0,0,0);
	}
	ContaCorrente(int cod,String nome,double saldo,double limite,int tipo){
		this.codConta = cod;
		this.nomeCliente=nome;
		this.saldoConta=saldo;
		this.limiteConta=limite;
		this.tipoConta=tipo;
	}
}
class MovimentoContas{
	int codConta;
	double valorMovimentado;
	int tipoMovimento;
	int status;
	MovimentoContas(){
		this(0,0,0,0);
	}
	MovimentoContas(int cod,double valor,int tipo,int status){
		this.codConta = cod;
		this.valorMovimentado=valor;
		this.tipoMovimento=tipo;
		this.status=status;
	}
}
class ContasAtualizadas{
	int codConta;
	String nomeCliente;
	double saldoConta;
	double limiteConta;
	int tipoConta;
	
	ContasAtualizadas(){
		this(0,"",0,0,0);
	}
	
	ContasAtualizadas(int cod,String nome,double saldo,double limite,int tipo){
		this.codConta = cod;
		this.nomeCliente = nome;
		this.saldoConta = saldo;
		this.limiteConta = limite;
		this.tipoConta = tipo;
	}
}
public class Main {
	public static void main(String args[]) throws IOException {
		ContaCorrente c[] = new  ContaCorrente[5];
		MovimentoContas mov[] = new MovimentoContas[10];
		ClasseMetodos m = new ClasseMetodos();
		int opc;
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("MENU PRINCIPAL\n1-Cadastra Conta Corrente\n2-Cadastrar Movimento\n3- Gera Contas Atualizadas"));
			switch(opc) {
				case 1:
					if(Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para cadastrar agora, e 2 para puxar o arquivo")) == 1) {
						m.cadastraContaCorrente();
						c = m.lerContasCorrente();
					}else {
						c =m.lerContasCorrente();
					}
					break;
				case 2:
					if(Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para cadastrar agora, e 2 para puxar o arquivo")) == 1) {
						m.cadastraContaCorrente();
						mov = m.lerMovimento();
					}else {
						mov = m.lerMovimento();
					}
					break;
				case 3:
					
					break;
				case 9:
					JOptionPane.showMessageDialog(null, "Fim");
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção indisponivel");
					break;
			}
		}while(opc!=9);
	}
}
