// 1. Criar a classe principal:
import java.util.Random;
public class Principal {
    public static void main(String[] args) {
        // 2. Criar instâncias da classe Tarefa:
        Tarefa tarefa1 = new Tarefa(preencherVetor(), preencherVetor());
        Tarefa tarefa2 = new Tarefa(preencherVetor(), preencherVetor());
        Tarefa tarefa3 = new Tarefa(preencherVetor(), preencherVetor());
        Tarefa tarefa4 = new Tarefa(preencherVetor(), preencherVetor());

        // 3. Passar as tarefas para objetos do tipo Thread:
        Thread t1 = new Thread(tarefa1);
        Thread t2 = new Thread(tarefa2);
        Thread t3 = new Thread(tarefa3);
        Thread t4 = new Thread(tarefa4);

        // Iniciar a execução paralela das tarefas (NUNCA chamar o método run() diretamente):
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    public static int[] preencherVetor() {
        int[] vetor = new int[10];
        Random aleatorio = new Random();
        for(int i = 0; i < 10; i++)
            vetor[i] = aleatorio.nextInt(Integer.MAX_VALUE / 2) + 1;

        return vetor;
    }
}
