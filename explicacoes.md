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