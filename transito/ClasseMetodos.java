package transito;
import javax.swing.JOptionPane;
import java.io.*;
public class ClasseMetodos {
	public Estatistica[] FCADRASTRAESTATISTICA(Estatistica[] est) throws IOException {
		String fileName = "estatisticas.txt";
		BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));
		for(int i=0;i<3;i++) {
			est[i] = new Estatistica();	
			est[i].codigoCidade = Integer.parseInt(JOptionPane.showInputDialog("Digite o cod da cidade: "));
			gravar.write(Integer.toString(est[i].codigoCidade));
			gravar.newLine();
		    est[i].nomeCidade = JOptionPane.showInputDialog("Digite o nome da cidade: ");
		    gravar.write(est[i].nomeCidade);
			gravar.newLine();
		    est[i].qtdAcidentes = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de acidentes na cidade: "));
		    gravar.write(Integer.toString(est[i].qtdAcidentes));
			gravar.newLine();
		}
		gravar.close();
		return est;
	}
	public Estatistica[] PQTDACIDENTES(Estatistica[] est) throws IOException {
	    String fileName = "estatisticas.txt";
	    BufferedReader ler = new BufferedReader(new FileReader(fileName));
	    int cod, qtd;
	    String nome;

	    for (int i = 0; i < est.length; i++) {
	        cod = Integer.parseInt(ler.readLine());
	        nome = ler.readLine();
	        qtd = Integer.parseInt(ler.readLine());
	        if (qtd > 100 && qtd < 500) {
	            System.out.println("Codigo: " + cod + " Nome: " + nome + " Qtd: " + qtd);
	        }
	    }

	    ler.close();
	    return est;
	}

	public Estatistica[] PMAIORMENOR(Estatistica[] est) throws IOException {
	    String fileName = "estatisticas.txt";
	    BufferedReader ler = new BufferedReader(new FileReader(fileName));

	    int cod, qtd;
	    String nome;

	    cod = Integer.parseInt(ler.readLine());
	    nome = ler.readLine();
	    qtd = Integer.parseInt(ler.readLine());

	    int maior = qtd, menor = qtd;
	    int maiorCod = cod, menorCod = cod;
	    String maiorNome = nome, menorNome = nome;

	    for (int i = 1; i < est.length; i++) {
	        cod = Integer.parseInt(ler.readLine());
	        nome = ler.readLine();
	        qtd = Integer.parseInt(ler.readLine());

	        if (qtd > maior) {
	            maior = qtd;
	            maiorCod = cod;
	            maiorNome = nome;
	        }
	        if (qtd < menor) {
	            menor = qtd;
	            menorCod = cod;
	            menorNome = nome;
	        }
	    }

	    ler.close();

	    System.out.println("Maior: Codigo: " + maiorCod + " Nome: " + maiorNome + " Qtd: " + maior);
	    System.out.println("Menor: Codigo: " + menorCod + " Nome: " + menorNome + " Qtd: " + menor);

	    return est;
	}

	public Estatistica[] PACIMA(Estatistica[] est) throws IOException {
	    String fileName = "estatisticas.txt";
	    BufferedReader ler = new BufferedReader(new FileReader(fileName));

	    int cod, qtd;
	    String nome;

	    int soma = 0;
	    double qtd_media=0;
	    int[] qtds = new int[est.length];
	    String[] nomes = new String[est.length];
	    int[] codigos = new int[est.length];

	    for (int i = 0; i < est.length; i++) {
	        cod = Integer.parseInt(ler.readLine());
	        nome = ler.readLine();
	        qtd = Integer.parseInt(ler.readLine());

	        soma += qtd;
	        qtd_media+=1;
	        codigos[i] = cod;
	        nomes[i] = nome;
	        qtds[i] = qtd;
	    }

	    ler.close();

	    double media = (double) soma / qtd_media;

	    System.out.println("Média de acidentes: " + media);
	    System.out.println("Cidades acima da média:");

	    for (int i = 0; i < est.length; i++) {
	        if (qtds[i] > media) {
	            System.out.println("Codigo: " + codigos[i] + " Nome: " + nomes[i] + " Qtd: " + qtds[i]);
	        }
	    }

	    return est;
	}

}