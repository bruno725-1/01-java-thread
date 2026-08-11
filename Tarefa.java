// 1. Criar uma classe que implementa a interface Runnable:
class Tarefa implements Runnable {
    private static int proximoId = 1;
    private int id;
    private String estringue;

    public Tarefa(String s) {
        id = proximoId++;
        estringue = s;
    }

    @Override
    public void run() {
        System.out.printf("A string %s da tarefa %d tem %d caracteres%n", estringue, id, estringue.length());
        System.out.printf("TAREFA %d FINALIZADA!%n", id);
    }
}
