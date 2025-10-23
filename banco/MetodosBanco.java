package banco;
import javax.swing.*;

public class MetodosBanco {
	public void VerSaldo(Cliente cliente) {
		JOptionPane.showMessageDialog(null,cliente.saldo);
	}
	public void VerFatura(Cliente cliente) {
		JOptionPane.showMessageDialog(null,cliente.fatura);
	}
	public void AdicionarSaldo(Cliente cliente,double valor) {
		cliente.saldo+=valor;
		if (cliente.fatura > 0) {
		    JOptionPane.showMessageDialog(null, "Cliente devendo, saldo será usado para pagar fatura");

		    if (cliente.saldo >= cliente.fatura) {
		        // saldo suficiente pra quitar a fatura
		        cliente.saldo -= cliente.fatura;
		        cliente.fatura = 0;
		        JOptionPane.showMessageDialog(null, "Fatura quitada com sucesso!");
		    } else {
		        // saldo insuficiente — paga parcialmente
		        cliente.fatura -= cliente.saldo;
		        cliente.saldo = 0;
		        JOptionPane.showMessageDialog(null, "Fatura parcialmente paga. Restam R$ " + cliente.fatura);
		    }
		}
		JOptionPane.showMessageDialog(null,"Deposito concluido");
	}
	
	public void RemoverSaldo(Cliente cliente,double valor) {
		cliente.saldo -= valor;
		if(cliente.saldo<0) {
			JOptionPane.showMessageDialog(null,"Saldo negativo, Valor adicionado na fatura");
			cliente.fatura = cliente.saldo*-1;
			cliente.saldo=0;
		}
		JOptionPane.showMessageDialog(null,"Resgate concluido");
	}
}
