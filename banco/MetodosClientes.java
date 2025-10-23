package banco;
import javax.swing.*;



import java.util.*; 
import java.io.*;


public class MetodosClientes {
	public Cliente CadastrarCliente() {
		String name;
		double saldo;
		name = JOptionPane.showInputDialog("Digite o nome do cliente");
		saldo = Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo do cliente"));
		Cliente cliente = new Cliente(name,saldo,0.0);
		return cliente;
	}
	public Cliente ProcuraCliente(String name,List<Cliente> clientes) throws IOException{
		int num=-1;
		
		for(int i=0;i<clientes.size();i++) {
			if(clientes.get(i).name.equals(name)) {
				num=i;
				return clientes.get(num);
			}
		}
		return null;

		
	}
	public void SalvarClientes(List<Cliente> clientes) throws IOException{
		String fileName = "Clientes.txt";
		BufferedWriter w = new BufferedWriter(new FileWriter(fileName));
		for(int i=0;i<clientes.size();i++) {
			
			w.write(clientes.get(i).name);w.newLine();
			w.write(Double.toString(clientes.get(i).saldo));w.newLine();
			w.write(Double.toString(clientes.get(i).fatura));w.newLine();
			
		}
		w.close();
		JOptionPane.showMessageDialog(null, "Clientes salvos com sucesso!");
	}
}
