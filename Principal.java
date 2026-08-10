// 1. Criar a classe principal:
public class Principal {
    public static void main(String[] args) {
        // 2. Criar instâncias da classe Tarefa:
        Tarefa tarefa1 = new Tarefa(10, 5, '+');
        Tarefa tarefa2 = new Tarefa(20, 3, '-');
        Tarefa tarefa3 = new Tarefa(2, 3, '*');
        Tarefa tarefa4 = new Tarefa(50000, 10, '/');

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
}
