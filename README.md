# TSP - Heurísticas 
## Descrição

O [Problema do Caixeiro Viajante - Traveling Salesman Problem (TSP)](https://pt.wikipedia.org/wiki/Problema_do_caixeiro-viajante) consiste na determinação do percurso pelo caixeiro, passando por todas as cidades em seu território exatamente uma vez e retornando à origem, de forma a cobrir a menor distância, dado que o custo entre os pares de cidade é conhecido. Ele é um problema de otimização NP-difícil inspirado na necessidade dos vendedores em realizar entregas em diversos locais percorrendo o menor caminho possível, reduzindo o tempo necessário para a viagem e os possíveis custos com transporte e combustível.


## Vídeos de Explicação

- ***[Simulated Annealing](https://drive.google.com/file/d/1-N8ofGH_Fr1npwlCnvEFgoB9rjXksYwc/view)***
- ***[Hill-Climbing](https://drive.google.com/file/d/1BrCgjD71y9qjn6mgdqtFD__dwf5ma_rr/view?usp=sharing)***

## Como Rodar os Arquivos:

  
- **Passo 1**: Compilar os Arquivos - Para compilar os arquivos basta executar no terminal o comando abaixo:

```
  

javac Cidade.java Hill.java ManipuladorArquivo.java SimulatedAnnealing.java Solucao.java Utils.java

  
```

- **Passo 2**: Executar o algoritmo - Para rodar qualquer um dos algoritmos, basta executar no terminal o seguinte comando:

```
  

java Hill
  

```

- -> Para o Hill Climbing;

Ou...

```


java SimulatedAnnealing


```

- -> para o algoritmo Simulated Annealing.

## Resultados Obtidos
- ***Hill-Climbing***

| **Arquivo** | **Melhor Distância** | **Distância Encontrada** | **Diferença** | 
|--|--|--|--|
| att48 | 10628 | 47988 | 37360 |
| berlin52 | 7542 | 10166 | 2624 |
| bier127 | 118282 | 170431 | 52149 |
| eil76 | 538 | 853 | 315 |
| eil101 | N.D. | 928 | N.D. |
| kroA100 | 21282 | 38572 | 17290 |
| kroE100 | 22068 | 40852 | 18784 |
| pr76 | 108159 | 214942 | 106783 |
| rat99 | 1211 | 2238 | 1027 |
| st70 | 675 | 974 | 299 |


- ***Simulated Annealing***

| **Arquivo** | **Melhor Distância** | **Distância Encontrada** | **Diferença** | 
|--|--|--|--|
| att48 | 10628 | 164722 | 154094 |
| berlin52 | 7542 | 31148 | 23606 |
| bier127 | 118282 | 608856 | 490574 |
| eil76 | 538 | 2609| 2071 |
| eil101 | N.D. | 3399 | N.D. |
| kroA100 | 21282 | 166872 | 145590 |
| kroE100 | 22068 | 187604 | 165536 |
| pr76 | 108159 | 592039 | 483880 |
| rat99 | 1211 | 8227 | 7016 |
| st70 | 675 | 3694 | 3019 |
