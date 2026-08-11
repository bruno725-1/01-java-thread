# Thread Calculadora

## 1. Objetivo

O programa demonstra o uso de múltiplas threads em Java por meio da interface
`Runnable`.

Cada tarefa recebe dois números e uma operação matemática (`+`, `-`, `*` ou `/`).
As tarefas são executadas por threads diferentes e realizam três cálculos,
alterando o resultado a cada iteração por meio da variável `i`.

A execução de cada tarefa é pausada por 1 segundo entre os cálculos para
simular uma operação que demanda tempo.

---

## 2. Classe `Tarefa`

A classe `Tarefa` implementa a interface `Runnable`:

```java
class Tarefa implements Runnable
A implementação de Runnable permite definir o trabalho que será executado por uma thread no método run().
A classe possui três atributos:
n1 e n2 são dois inteiros, são os números da operação.
operacao é um char que representa a operação que será realizada (+ para soma, - subtração, * multiplicação, / divisão)

---

## 3. Construtor
O construtor recebe os dois números, a operação e os armazena nos atributos da tarefa.
## 4. Método run()
O método run() contém o trabalho que será realizado pela thread.
Primeiramente, é criada a variável resultado, em seguida um laço for executa três vezes. A variável i é utilizada para que cada iteração produza um cálculo diferente.

---

## 5. Escolha da operação
A cada iteração,  o switch verifica o operador recebido pela tarefa:
Quando a operação é +, são somados os dois números e o valor de i; quando a operação é -, n1 é subtraído de n2 e o valor de i é subtraído dessa subtração, e assim sucessivamente.
Esta calculadora trabalha apenas com valores inteiros. Em caso de divisão, qualquer parte decimal do resultado é descartada e é exibido apenas o número inteiro.
O valor da operação é atribuído a variável resultado, e após isso, o resultado é impresso na tela utilizando System.out.printf
Por exemplo:
```java
System.out.printf("Soma entre %d, %d e %d = %d%n", n1, n2, i, resultado);
Os especificadores %d são substituídos pelos valores inteiros fornecidos como argumentos.
O %n representa uma quebra de linha.

---

##6. Simulação de uma tarefa demorada
Após cada cálculo, a thread é pausada por um segundo:
```java
Thread.sleep(1000);
O valor 1000 representa 1000 milissegundos, ou seja, 1 segundo.
O método pode lançar InterruptedException, por isso a chamada é protegida
por um bloco try/catch:
```java
try {
    Thread.sleep(1000);
} catch (InterruptedException e) {
    System.out.println("Tarefa foi interrompida.");
}
Caso a thread seja interrompida durante o sleep, a mensagem correspondente será exibida.

---

## 7. Finalização da tarefa
Ao término das três iterações, é impressa uma mensagem, indicando que a tarefa foi concluída:
System.out.println("TAREFA " + operacao + " FINALIZADA!");

---

## 8. Classe principal
A classe Principal contém o método main() que é o ponto de entrada do programa. Neste método, são criadas quatro tarefas, cada uma delas representa uma operação diferente.

---

## 9. Criação das threads
As tarefas então são associadas a objetos do tipo Thread.
A classe Tarefa representa o trabalho que deve ser realizado, enquanto Thread representa a linha de execução responsável por executar esse trabalho.
Dessa forma:
t1 → tarefa1
t2 → tarefa2
t3 → tarefa3
t4 → tarefa4

---

## 10. Início das threads
As threads são iniciadas utilizando o método start(), que inicia uma nova thread de execução e faz com que o método run() da tarefa seja executado nessa nova thread.
É importante não chamar run() diretamente, por exemplo:
t1.run();
Nesse caso, run() seria apenas um método comum utilizado pela thread que já está executando o main, não se criaria uma nova thread .
Com start():
Thread principal
      │
      ├── inicia t1 → executa tarefa1.run()
      ├── inicia t2 → executa tarefa2.run()
      ├── inicia t3 → executa tarefa3.run()
      └── inicia t4 → executa tarefa4.run()
Deste modo, as quatro tarefas podem ser executadas concorrentemente.

---

## 11. Ordem da saída
Como as tarefas são executadas paralelamente, não há garantia de que os resultados aparecerão na mesma ordem que estão no código. Uma execução poderia produzir:
Soma entre 10, 5 e 1 = 16
Multiplicação entre 2, 3 e 1 = 6
Divisão entre 50000, 10 e 1 = 5000
Subtração entre 20, 3 e 1 = 16
...
Em outra execução, a ordem pode ser diferente.

# Thread Jogo de Advinhação
## 1. Objetivo
O programa demonstra o uso de várias threads por meio da interface `runnable`.
## 2. Execução
Cada tarefa cria um número secreto entre 1 e 10. Após isso, um loop for é executado três vezes. Em cada iteração, um novo número, também entre 1 e 10 é gerado. Se o número for igual ao número secreto, o programa informa que o jogador acertou, e o loop é encerrado imediatamente; se for diferente, o loop continua a ser executado até chegar a 3 tentativas. Se nenhum dos palpites acertar, a tarefa é finalizada.
## 3. Geração dos números aleatórios
Para gerar esses números, utilizamos a classe `Random`, que gera números aleatórios de 0 até n - 1, onde n é o número fornecido como parâmetro na construtora do objeto.
Para que o intervalo do número gerado fique entre 1 e n, adicionamos 1:
```java
int numeroSecreto = aleatorio.nextInt(10) + 1;
Em vez de os números gerados serem entre 0 e 9, serão entre 1 e 10.

# Thread Contador de caracteres

Cada tarefa recebe uma `string`, possui um identificador único e, quando executada, calcula e exibe a quantidade de caracteres da string recebida.

---

## 2. Classe `Tarefa`

Possui três atributos:
proximoId: Contador estático utilizado para gerar o próximo identificador;
id: Identificador individual da tarefa;
estringue: A string que será analisada.
## 2.1. Geração dos identificadores
A variável proximoId é static, portanto existe apenas uma cópia dela, compartilhada por todas as instâncias da classe Tarefa.
Ela começa com o valor 1 e é incrementada toda vez que uma nova tarefa é criada.
O atributo id não é estático. Cada tarefa possui seu próprio identificador.
No construtor:
```Java
id = proximoId++;
O valor de proximoId é atribuído ao id da tarefa que está sendo construída, em seguida proximoId é incrementado.
Dessa forma, as tarefas recebem identificadores sequenciais:
Tarefa 1 → id = 1
Tarefa 2 → id = 2
Tarefa 3 → id = 3
...
## 3. Construtora
A construtora recebe uma string como parâmetro. Enquanto um identificador único é atribuído à tarefa, o parâmetro s é armazenado no atributo estringue.
## 4. Método run()
O método run() contém o código que será executado pela thread.
## 4.1. Contagem de caracteres
A quantidade de caracteres da string é obtida utilizando o método:
```Java
estringue.length();
Este método retorna um valor inteiro (int) correspondente à quantidade de caracteres da string. Esse valor é usado com o especificador %d:
```Java
System.out.printf("A string %s da tarefa %d tem %d caracteres%n", estringue, id, estringue.length());
Especificadores utilizados:
%s: Utilizado para exibir a string;
%d: Utilizado para exibir números inteiros;
%n: Utilizado para imprimir uma nova linha.
Por exemplo, se a tarefa receber a string "Java", a saída será:
A string Java da tarefa 1 tem 4 caracteres

---

## 5. Finalização da tarefa
Depois de exibir a quantidade de caracteres, uma mensagem indica que a tarefa foi finalizada:
```Java
System.out.printf("TAREFA %d FINALIZADA!%n", id);
O identificador da tarefa é utilizado para indicar qual tarefa terminou.
Por exemplo:
TAREFA 1 FINALIZADA!

# Thread Soma de vetores
## 1. Objetivo
O programa demonstra o uso de várias threads para somar os elementos de dois vetores.
Cada tarefa recebe dois vetores, cada um com 10 posições. Para cada posição, os valores dos dois vetores são somados e o resultado é exibido no console.
São criadas quatro tarefas, cada uma trabalhando com seu próprio par de vetores, e cada tarefa é executada por uma thread diferente.

---

## 2. Classe `Tarefa`
Esta classe possui os seguintes atributos:
```java
private static int proximoId = 1;
private int id;
private int[] vet1;
private int[] vet2;
```
Os ids são gerados de forma sequencial, e a primeira tarefa recebe o id 1.
## 2.1. Vetores
```java
private int[] vet1;
private int[] vet2;
```
Esses atributos armazenam os dois vetores que serão utilizados pela tarefa. Cada tarefa recebe seu próprio par de vetores.

---

## 3. Construtora
A construtora recebe dois vetores:
```java
public Tarefa(int[] v1, int[] v2) {
    id = proximoId++;
    vet1 = v1;
    vet2 = v2;
}
```
Um identificador é atribuído à tarefa, depois, os vetores recebidos como parâmetros são armazenados nos atributos `vet1`e `vet2`.
Assim, quando uma tarefa é criada:
```java
Tarefa tarefa1 = new Tarefa(preencherVetor(), preencherVetor());
```
os dois vetores gerados são associados àquela tarefa.

---

## 4. Método `run()`
O método `run()` contém o trabalho que será executado pela thread, que é percorrer os vetores e somar os índices. A cada iteração, os valores que estão no mesmo índice dos dois vetores são somados:
```java
soma = vet1[i] + vet2[i];
```
Por exemplo, se:
```text
vet1 = [10, 20, 30]
vet2 = [ 5,  8,  2]
```
as operações serão:
```text
posição 0 → 10 + 5  = 15
posição 1 → 20 + 8  = 28
posição 2 → 30 + 2  = 32
```
Como trabalhamos com a premissa de que ambos os vetores têm o mesmo tamanho, que a função preencherVetor garante que seja verdadeira, podemos utilizar o comprimento do vetor1 como ponto de parada. O resultado de cada soma é impresso no console com System.out.printf.

---

## 5. Método `preencherVetor()`

O método:
```java
public static int[] preencherVetor()
```
é responsável por criar e preencher um vetor de 10 posições com valores inteiros aleatórios. O tipo de retorno `int[]` indica que o método retorna um vetor de inteiros.

---

## 6. Geração dos números aleatórios
Para gerar os números que irão preencher os vetores, utilizamos a classe Random.
Um objeto dessa classe é criado:
```java
Random aleatorio = new Random();
```
Depois, o vetor é percorrido:
```java
for(int i = 0; i < 10; i++)
```
Em cada posição é armazenado um número aleatório:
```java
vetor[i] = aleatorio.nextInt(Integer.MAX_VALUE / 2) + 1;
```
O valor `Integer.MAX_VALUE` representa o maior valor possível para um
`int` em Java:
```text
2147483647
```
Dividindo esse valor por 2:
```text
1073741823
```
O `+ 1` é utilizado porque `nextInt(n)` gera valores de `0` até `n - 1`.
Assim, os valores gerados ficam entre 1 e 1073741823.

--

## 7. Prevenção de overflow
O limite de `Integer.MAX_VALUE / 2` foi utilizado para evitar que a soma de dois elementos ultrapasse o limite de um `int`.
O maior valor possível para cada elemento é 1073741823
Portanto, a maior soma possível é:
1073741823 + 1073741823 = 2147483646
Esse valor ainda está abaixo de:
Integer.MAX_VALUE = 2147483647
Dessa forma, a soma realizada pelo programa permanece dentro do intervalo válido de um `int`.

## 9. Como essa tarefa poderia ser paralelizada para vetores grandes
Neste exercício, cada tarefa recebe um vetor e cada thread executa uma tarefa.
Ou seja: Em um vetor de 1.000.000 de posições:
Thread 1
posição 0 → 999.999
Ela calcula todas as somas sequencialmente.
Com várias threads, o vetor poderia ser dividido em blocos:
Thread 1 → posições 0       até 249.999
Thread 2 → posições 250.000 até 499.999
Thread 3 → posições 500.000 até 749.999
Thread 4 → posições 750.000 até 999.999
Cada thread executaria a mesma lógica:
```java
for (int i = inicio; i < fim; i++) {
    int soma = vet1[i] + vet2[i];
    // imprime resultado
}
```
A diferença é que cada uma recebe um início e um fim diferentes. Quatro threads podem estar fazendo simultaneamente:
Thread 1: vet1[123] + vet2[123]
Thread 2: vet1[500768] + vet2[500768]
Thread 3: vet1[750457] + vet2[750457]
Thread 4: vet1[900001] + vet2[900001]