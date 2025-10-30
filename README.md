# Codigos-java-LP-Avançados
Codigos propostos nas aulas de Linguagem de Programação, codigos mais complexos e com mais requisitos e incio de POO e de BD, usando gravação e leitura de Arquivos (I/O)

Questão Eleição


Com base no documento que você forneceu, você precisa desenvolver um sistema em Java para simular uma eleição com 2 candidatos.

As principais tarefas (manipulação de registro lógico e arquivo físico) são:


Desenvolvimento em Java.

Criação de Estruturas de Dados e Arquivos:

Um arquivo de Cadastro Eleitoral com 10 eleitores (Número do Eleitor, Nome do Eleitor, Seção).




Um vetor (em memória) com os números das Seções Válidas (01, 03, 04, 05, 09, 10).


A votação deve ser registrada com os campos Seção, Código do Candidato e Número do Eleitor. Os códigos dos candidatos são:


1 - JOSÉ 

2 - MARIA 

3 - BRANCO 

4 - NULO 

Processamento de Votação (Cadastro Votação 1 e 2):

Criar um sistema de votação que cadastre 5 eleitores para cada um dos dois grupos de votações (Votação 1 e Votação 2).


A Votação 1 é para as Seções 01, 03, 04.

A Votação 2 é para as Seções 05, 09, 10.

O sistema deve identificar o número do eleitor, nome, seção e o candidato votado.

Validações durante a votação:

Se a seção digitada for inválida, exibir "Seção inválida" e coletar uma nova seção.

Se o Número de Eleitor for inválido (não estiver no arquivo Cadastro_Eleitor), exibir "Número de eleitor inválido" e coletar um novo número.

Agrupamento e Apuração (Processamento de Arquivos):

Após os cadastros, ordenar os arquivos das Votações 1 e 2 em memória pelo CodCandidato.


Concatenar (usando a técnica Balance-Line) os dois arquivos ordenados em um único arquivo chamado apuração.

Geração de Estatísticas (Apuração Final):

Após o cadastramento e agrupamento, processar e apurar o seguinte:

Vencedor.



2º colocado.



Quantidade de votos em branco.



Quantidade de votos nulos.


Criação de Menus:

Implementar um MENU PRINCIPAL para as opções de: Cadastrar Eleitor, Cadastrar Votação 1, Cadastrar Votação 2, Agrupar Apuração e Menu Estatística.




Implementar um MENU ESTATÍSTICA para exibir os resultados apurados (Vencedor, 2º Colocado, Votos Brancos/Nulos, Mostrar Eleitores, Mostrar Apuração).
