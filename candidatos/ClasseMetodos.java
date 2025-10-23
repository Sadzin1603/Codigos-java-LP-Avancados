package candidatos;
import java.io.*;
public class ClasseMetodos {
	public Candidatos[] LerCandidatos(Candidatos[] cand) throws IOException{
		BufferedReader r = new BufferedReader(new FileReader("CANDIDATOS.txt"));
		for(int i=0;i<cand.length;i++) {
			cand[i] = new Candidatos();
			cand[i].num_insc = Integer.parseInt(r.readLine());
			cand[i].nome = r.readLine();
			cand[i].idade = Integer.parseInt(r.readLine());
			cand[i].num_dependentes = Integer.parseInt(r.readLine());
			cand[i].num_pontos = Integer.parseInt(r.readLine());
		}
		r.close();
		return cand;
	}
	public String AcharCandidato(Candidatos[] cand,int num) {
		String res="";
		if(!cacar(0,num)) {
			res = "Candidato inesistente";
		}else {
			res=cand[num-1].nome;
		}
		return res;
	}
	public boolean cacar(int busca,int num) {
		if(busca>num) {
			return false;
		}
		if(busca==num) {
			return true;
		}else {
			return cacar(busca+1,num);
		}
	}
	public void Classificar(Candidatos[] cand) throws IOException{
		int[] vet = new int[cand.length];
		for(int i=0;i<cand.length;i++) {
			vet[i] = cand[i].num_pontos;
		}
		//Candidato auxiliar para trocar os candidatos
		Candidatos aux;
		//codigo crescente
		 for (int i = 0; i < cand.length - 1; i++) {
		        for (int j = i + 1; j < cand.length; j++) {
		            boolean troca = false;

		            if (cand[j].num_pontos > cand[i].num_pontos) {
		                troca = true;
		            } 
		            else if (cand[j].num_pontos == cand[i].num_pontos) {
		                if (cand[j].idade >= 60 && cand[i].idade < 60) {
		                    troca = true;
		                } 
		                else if (cand[j].idade == cand[i].idade) {
		                    if (cand[j].num_dependentes > cand[i].num_dependentes) {
		                        troca = true;
		                    }
		                }
		            }

		            if (troca) {
		                aux = cand[i];
		                cand[i] = cand[j];
		                cand[j] = aux;
		            }
		        }
		    }
		String fileName = "CLASSIFICADOS.txt";
		BufferedWriter t = new BufferedWriter(new FileWriter(fileName));
		for(int i=cand.length-1;i>cand.length-50;i--) {
			t.write(Integer.toString(cand[i].num_insc));t.newLine();
			t.write(cand[i].nome);t.newLine();
			t.write(Integer.toString(cand[i].idade));t.newLine();
			t.write(Integer.toString(cand[i].num_insc));t.newLine();
			t.write(Integer.toString(cand[i].num_insc));t.newLine();
			
		}
		t.close();
	}
}
