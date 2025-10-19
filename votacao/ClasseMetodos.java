package votacao;
import java.util.Random;
import java.io.*;
public class ClasseMetodos {
	public static Votacao[] FCADRASTRAVOTACAO(Votacao vot[]) {
		Random rand = new Random();
		for(int i=0;i<vot.length;i++) {
			vot[i] = new Votacao();
			vot[i].numSecao = rand.nextInt(0,11);
			vot[i].numCandidato = rand.nextInt(0,301);
			
		}
		return vot;
	}
	public static Votacao[] FCLASSIFICASECAO(Votacao vot[]) {
		int aux_num;
		int aux_cand;
		for(int i=0;i<vot.length;i++) {
			for(int j=1;j<vot.length-i;j++) {
				if(vot[j].numSecao<vot[j-1].numSecao) {
					aux_num=vot[j].numSecao;
					aux_cand=vot[j].numCandidato;
					vot[j].numSecao = vot[j-1].numSecao;
					vot[j].numCandidato = vot[j-1].numCandidato;
					vot[j-1].numSecao=aux_num;
					vot[j-1].numCandidato=aux_cand;
				}
			}
		}
		for(int i=0;i<vot.length;i++) {
			System.out.println(vot[i].numSecao);
		}
		
		System.out.println("Dados classificados");
		return vot;
	}
	public static Votacao[] FGRAVAVOTACAO(Votacao vot[]) throws IOException{
		String fileName = "Votação2021.txt";
		BufferedWriter w = new BufferedWriter(new FileWriter(fileName));
		int contandor;
		for(int i=0;i<vot.length;i++) {
			w.write(Integer.toString(vot[i].numSecao));w.newLine();
			w.write(Integer.toString(vot[i].numCandidato));w.newLine();
		}
		w.close();
		System.out.println("Arquivo Gerado!");
		return vot;
	}
	public static void QTDELLEITORES(Votacao vot[]) {
		int vet[] = new int[11];
		for(int i=0;i<vot.length;i++) {
			vet[vot[i].numSecao]+=vot[i].numCandidato;
		}
		for(int i=0;i<vet.length;i++) {
			System.out.println("Seção "+i+ ". Quantidade de candidatos: " + vet[i]);
		}
	}
	public static void MAIORMENORNUMELEITORES(Votacao vot[]) {
		int maior=0,menor=0;
		int vet[] = new int[11];
		for(int i=0;i<vot.length;i++) {
			vet[vot[i].numSecao]+=vot[i].numCandidato;
		}
		for(int i=0;i<vet.length;i++) {
			if(i==0) {
				maior=i;
				menor=i;
			}
			if(vet[i]>vet[maior]) {
				maior=i;
			}
			if(vet[i]<vet[menor]) {
				menor=i;
			}
		}
		System.out.println("Seção com maior numero de candidatos. Seção: "+maior+". Quantidade de eleitores: "+vet[maior])	;
		System.out.println("Seção com menor numero de candidatos. Seção: "+menor+". Quantidade de eleitores: "+vet[menor])	;
		
	}
	public static void QTDVOTOSCANDIDATOS(Votacao vot[]) {
		int vet[] = new int[301];
		
		for(int i=0;i<vot.length;i++) {
			vet[vot[i].numCandidato]++;
		}
		for(int i=0;i<vet.length;i++) {
			if(vet[i]!=0) {
				System.out.println("Candidato "+i+". Votos: "+vet[i]);				
			}
			
		}
	}
	public static void PRIMEIROS10COLLOCADOS(Votacao vot[]) {
		int vet[] = new int[301];
		for(int i=0;i<vot.length;i++) {
			vet[vot[i].numCandidato]++;
		}
		
		int vet2[] = new int[vet.length];
		for(int i=0;i<vet2.length;i++) {
			vet2[i]=i;
		}
		int aux;
		for(int i=0;i<vet.length;i++) {
			for(int j=1;j<vet.length-i;j++) {
				if(vet[j]<vet[j-1]) {
					aux = vet[j-1];
					vet[j-1]=vet[j];
					vet[j]=aux;
					aux=vet2[j-1];
					vet2[j-1]=vet2[j];
					vet2[j]=aux;
				}
			}
		}
		
		for(int i=vet.length-1;i>vet.length-11;i--) {
			System.out.println("Candidato com mais votos: "+vet2[i]);
		}
	}

}