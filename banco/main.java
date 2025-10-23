package banco;
import javax.swing.*;
import java.util.*; 
import java.io.*;
class Cliente{
	String name;
	double saldo;
	double fatura;
	
	Cliente() {
		this("",0.0,0.0);
	}
	Cliente(String name,double saldo,double fatura) {
		this.name = name;
		this.saldo = saldo;
		this.fatura = fatura;
	}
}

public class main {

	public static void main(String[] args) throws IOException{
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		MetodosClientes m = new MetodosClientes();
		MetodosBanco b = new MetodosBanco();
		int opc;
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Banco Imobiliario\n1-cadastrar cliente\n2-logar conta\n3-salvar clientes\n9-Sair"));
			switch(opc) {
				case 1:
					clientes.add(m.CadastrarCliente());
					break;
				case 2:
					String name = JOptionPane.showInputDialog("Digite o nome do usario");
					try{
						if(m.ProcuraCliente(name, clientes) == null) {
							
						}else {
						
							int opc2;
							do {
								opc2= Integer.parseInt(JOptionPane.showInputDialog("Banco Imobiliario - "+name+"\n1-Ver Saldo\n2-Ver Fatura\n3-Adicionar saldo\n4-Remover Saldo\n9-Sair da conta"));
								double valor;
								switch(opc2) {
									case 1:
										b.VerSaldo(m.ProcuraCliente(name, clientes));
										break;
									case 2:
										b.VerFatura(m.ProcuraCliente(name, clientes));
										break;
									case 3:
										valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor depositado."));
										b.AdicionarSaldo(m.ProcuraCliente(name, clientes),valor);
										break;										
									case 4:
										valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor resgatado."));
										b.RemoverSaldo(m.ProcuraCliente(name, clientes),valor);
										break;
									case 9:
										JOptionPane.showMessageDialog(null, "Deslogando");
										break;
								}
							}while(opc!=9);
						}
					}catch(Exception ex) {
					}
					
					break;
				case 3:
					m.SalvarClientes(clientes);
					break;
				case 9:
					JOptionPane.showMessageDialog(null,"Fechando");
					System.exit(0);
					break;
				default:
					JOptionPane.showMessageDialog(null,"Opção invalida");
					break;
			}
		}while(opc!=9);
	}

}
