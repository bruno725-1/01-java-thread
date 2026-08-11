// 1. Criar a classe principal:
public class Principal {
    public static void main(String[] args) {
        // 2. Criar instâncias da classe Tarefa:
        Tarefa tarefa1 = new Tarefa("Olá, Mundo!");
        Tarefa tarefa2 = new Tarefa("A ligeira raposa marrom saltou sobre o cachorro cansado ");
        Tarefa tarefa3 = new Tarefa("Cruzeiro, Cruzeiro querido\nTão combatido, jamais vencido!");
        Tarefa tarefa4 = new Tarefa("Este texto está cifrado, só que não");

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
