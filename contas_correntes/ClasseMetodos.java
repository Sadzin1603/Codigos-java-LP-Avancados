package contas_correntes;

import javax.swing.JOptionPane;
import java.io.*;

public class ClasseMetodos {
	public void cadastraContaCorrente() throws IOException{
		String fileName="ContasCorrentes.txt";
		BufferedWriter w = new BufferedWriter(new FileWriter(fileName));
		for(int i=0;i<5;i++) {
			w.write(Integer.toString(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo da conta"))));w.newLine();
			w.write(JOptionPane.showInputDialog("Digite o nome do cliente"));w.newLine();
			w.write(Double.toString(Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo da conta"))));w.newLine();
			w.write(Double.toString(Double.parseDouble(JOptionPane.showInputDialog("Digite o limite da conta"))));w.newLine();
			w.write(Integer.toString(Integer.parseInt(JOptionPane.showInputDialog("Digite o tipo da conta\n1-fisica\n2-conjunta\n3-juridica\n4-especial"))));w.newLine();
		}
		w.close();
	}
	public ContaCorrente[] lerContasCorrente() throws IOException{
		ContaCorrente contas[] = new ContaCorrente[5];
		String fileName = "ContasCorrentes.txt";
		BufferedReader r = new BufferedReader(new FileReader(fileName));
		
		for(int i=0;i<5;i++) {
			int codConta = Integer.parseInt(r.readLine());
			String nomeCliente = r.readLine();
			double saldoConta = Double.parseDouble(r.readLine());
			double limiteConta = Double.parseDouble(r.readLine());
			int tipoConta = Integer.parseInt(r.readLine());
			contas[i] = new ContaCorrente(codConta,nomeCliente,saldoConta,limiteConta,tipoConta);
		}
		r.close();
		
		ContaCorrente c;
		for(int j=0;j<5;j++) {
			for(int i =1;i<5-j;i++) {
				if(contas[i].codConta < contas[i-1].codConta) {
					c=contas[i-1];
					contas[i-1] = contas[i];
					contas[i] = c;
				}
			}
		}
		return contas;
	}
	public void cadastrarMovimento() throws IOException{
		String fileName="Movimentos.txt";
		BufferedWriter w = new BufferedWriter(new FileWriter(fileName));
		for(int i=0;i<10;i++) {
			w.write(Integer.toString(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo da conta"))));w.newLine();
			w.write(Double.toString(Double.parseDouble(JOptionPane.showInputDialog("Digite o Valor do movimento"))));w.newLine();
			w.write(Integer.toString(Integer.parseInt(JOptionPane.showInputDialog("Digite o tipo do movimento\n1-Crédito\n2-Debito"))));w.newLine();
			w.write(Integer.toString(Integer.parseInt(JOptionPane.showInputDialog("Digite o status do movimento"))));w.newLine();
		}
		w.close();
	}
	public MovimentoContas[] lerMovimento() throws IOException{
		MovimentoContas movimentos[] = new MovimentoContas[10];
		String fileName = "Movimentos.txt";
		BufferedReader r = new BufferedReader(new FileReader(fileName));
		
		for(int i=0;i<10;i++) {
			int codConta = Integer.parseInt(r.readLine());
			double valorMovimentado = Double.parseDouble(r.readLine());
			int tipoMovimento = Integer.parseInt(r.readLine());
			int status = Integer.parseInt(r.readLine());
			movimentos[i] = new MovimentoContas(codConta,valorMovimentado,tipoMovimento,status);
		}
		r.close();
		
		MovimentoContas m;
		for(int j=0;j<5;j++) {
			for(int i =1;i<5-j;i++) {
				if(movimentos[i].codConta < movimentos[i-1].codConta) {
					m=movimentos[i-1];
					movimentos[i-1] = movimentos[i];
					movimentos[i] = m;
				}
			}
		}
		return movimentos;
	}
	
	public void criaContasAtualizadas(ContaCorrente[] contas,MovimentoContas[] movimentos) throws IOException{
		ContasAtualizadas atu[] = new ContasAtualizadas[contas.length];
		
		int contador=0;
		for(ContaCorrente i:contas) {
			atu[contador] = new ContasAtualizadas(i.codConta,i.nomeCliente,i.saldoConta,i.limiteConta,i.tipoConta);
		}
		
		int cliente=0;
		for(MovimentoContas i : movimentos) {
			cliente = i.codConta;
			if(i.tipoMovimento == 1) {
				atu[cliente].saldoConta +=i.valorMovimentado;
			}else if(i.tipoMovimento==2) {
				atu[cliente].saldoConta -=i.valorMovimentado;
			}
			if(atu[cliente].saldoConta < i.valorMovimentado) {
				atu[cliente].limiteConta = acharLimite(contas[cliente]);
			}
			
		}
		String fileName = "ContasAtualizadas.txt";
		BufferedWriter w = new BufferedWriter(new FileWriter(fileName));
		for(ContasAtualizadas i : atu) {
			w.write(Integer.toString(i.codConta));w.newLine();
			w.write(i.nomeCliente);w.newLine();
			w.write(Double.toString(i.saldoConta));w.newLine();
			w.write(Double.toString(i.limiteConta));w.newLine();
			w.write(Integer.toString(i.tipoConta));w.newLine();
		}
		w.close();
		
	}
	public double acharLimite(ContaCorrente c) {
		double limite=0;
		switch(c.tipoConta) {
			case 1:
				limite=0;
				break;
			case 2:
				limite = c.limiteConta;
				break;
			case 3:
				limite = c.limiteConta + c.saldoConta*.5;
				break;
			case 4:
				limite = c.limiteConta + c.saldoConta*.5;
				break;
		}
		return limite;
		
	}
	public void verCorrente()throws IOException {
		String fileName="ContasCorrentes.txt";
		BufferedReader r = new BufferedReader(new FileReader(fileName));
		for(int i=0;i<5;i++) {
			System.out.println(r.readLine());
		}
		r.close();
	}
	public void verMovimento()throws IOException {
		String fileName="Movimentos.txt";
		BufferedReader r = new BufferedReader(new FileReader(fileName));
		for(int i=0;i<10;i++) {
			System.out.println(r.readLine());
		}
		r.close();
	}
	public void verAtualizados()throws IOException {
		String fileName="ContasAtualizadas.txt";
		BufferedReader r = new BufferedReader(new FileReader(fileName));
		for(int i=0;i<5;i++) {
			System.out.println(r.readLine());
		}
		r.close();
	}
}
