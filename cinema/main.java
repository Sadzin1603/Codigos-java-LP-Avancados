package cinema;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

class Filme {
    String titulo;
    String genero;
    double precoIngresso;
    int ingressosVendidos;

    Filme() {
        this("", "", 0, 0);
    }

    Filme(String titulo, String genero, double precoIngresso, int ingressosVendidos) {
        this.titulo = titulo;
        this.genero = genero;
        this.precoIngresso = precoIngresso;
        this.ingressosVendidos = ingressosVendidos;
    }

    public void venderIngresso(int qtd) {
        this.ingressosVendidos += qtd;
    }

    public double calcularLucro() {
        return precoIngresso * ingressosVendidos;
    }
}

class Cinema {
    List<Filme> listaFilmes = new ArrayList<>();

    public void cadastrarFilme(Filme f) {
        listaFilmes.add(f);
        JOptionPane.showMessageDialog(null, "🎬 Filme cadastrado com sucesso!");
    }

    public void listarFilmes() {
        if (listaFilmes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum filme cadastrado!");
            return;
        }

        StringBuilder sb = new StringBuilder("📽️ Lista de Filmes:\n");
        for (Filme i : listaFilmes) {
            sb.append("- ").append(i.titulo)
              .append(" (").append(i.genero)
              .append(") | R$").append(i.precoIngresso)
              .append(" | Vendidos: ").append(i.ingressosVendidos)
              .append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public Filme buscarFilme(String titulo) {
        for (Filme i : listaFilmes) {
            if (i.titulo.equalsIgnoreCase(titulo)) {
                JOptionPane.showMessageDialog(null, "✅ Filme encontrado:\n" +
                        i.titulo + " (" + i.genero + ") - R$" + i.precoIngresso);
                return i;
            }
        }
        JOptionPane.showMessageDialog(null, "❌ Filme não encontrado!");
        return null;
    }

    public void venderIngressos(String titulo, int quantidade) {
        Filme filme = buscarFilme(titulo);
        if (filme != null) {
            filme.venderIngresso(quantidade);
            JOptionPane.showMessageDialog(null, "🎟️ " + quantidade + " ingresso(s) vendidos para " + filme.titulo);
        }
    }

    public void mostrarLucroTotal() {
        if (listaFilmes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum filme cadastrado!");
            return;
        }

        double total = 0;
        for (Filme i : listaFilmes) {
            total += i.calcularLucro();
        }
        JOptionPane.showMessageDialog(null, String.format("💰 Lucro total do cinema: R$ %.2f", total));
    }

    public void salvarEmArquivo() throws IOException {
        String fileName = "Cinema.txt";
        BufferedWriter w = new BufferedWriter(new FileWriter(fileName));
        for (Filme i : listaFilmes) {
            w.write(i.titulo);
            w.newLine();
            w.write(i.genero);
            w.newLine();
            w.write(Double.toString(i.precoIngresso));
            w.newLine();
            w.write(Integer.toString(i.ingressosVendidos));
            w.newLine();
        }
        w.close();
        JOptionPane.showMessageDialog(null, "💾 Arquivo salvo com sucesso!");
    }

    public void carregarArquivo() throws IOException {
        String fileName = "Cinema.txt";
        File f = new File(fileName);
        if (!f.exists()) {
            JOptionPane.showMessageDialog(null, "⚠️ Arquivo não encontrado!");
            return;
        }

        BufferedReader r = new BufferedReader(new FileReader(fileName));
        listaFilmes.clear();
        String linha;
        while ((linha = r.readLine()) != null) {
            String titulo = linha;
            String genero = r.readLine();
            double preco = Double.parseDouble(r.readLine());
            int qtds = Integer.parseInt(r.readLine());
            listaFilmes.add(new Filme(titulo, genero, preco, qtds));
        }
        r.close();
        JOptionPane.showMessageDialog(null, "📂 Arquivo carregado com sucesso!");
    }
}

public class main {
    public static void main(String args[]) throws IOException {
        Cinema c = new Cinema();
        int opc;

        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(
                    "🎬 CINE TECH 🎬\n\n"
                    + "1 - Cadastrar Filme\n"
                    + "2 - Listar Filmes\n"
                    + "3 - Buscar Filme\n"
                    + "4 - Vender Ingressos\n"
                    + "5 - Mostrar Lucro Total\n"
                    + "6 - Salvar em Arquivo\n"
                    + "7 - Carregar do Arquivo\n"
                    + "9 - Sair\n\n"
                    + "Escolha uma opção:"));

            switch (opc) {
                case 1:
                    String nome = JOptionPane.showInputDialog("Digite o título do filme:");
                    String gen = JOptionPane.showInputDialog("Digite o gênero do filme:");
                    double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do ingresso:"));
                    c.cadastrarFilme(new Filme(nome, gen, preco, 0));
                    break;

                case 2:
                    c.listarFilmes();
                    break;

                case 3:
                    String titulo = JOptionPane.showInputDialog("Digite o título do filme para buscar:");
                    c.buscarFilme(titulo);
                    break;

                case 4:
                    String title = JOptionPane.showInputDialog("Digite o título do filme:");
                    int qtd = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de ingressos:"));
                    c.venderIngressos(title, qtd);
                    break;

                case 5:
                    c.mostrarLucroTotal();
                    break;

                case 6:
                    c.salvarEmArquivo();
                    break;

                case 7:
                    c.carregarArquivo();
                    break;

                case 9:
                    JOptionPane.showMessageDialog(null, "👋 Encerrando o sistema...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "❌ Opção inválida!");
                    break;
            }
        } while (opc != 9);
    }
}
