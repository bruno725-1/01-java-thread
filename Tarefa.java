// 1. Criar uma classe que implementa a interface Runnable:
class Tarefa implements Runnable {
    private static int proximoId = 1;
    private int id;
    private int[] vet1;
    private int[] vet2;

    public Tarefa(int[] v1, int[] v2) {
        id = proximoId++;
        vet1 = v1;
        vet2 = v2;
    }

    @Override
    public void run() {
        int soma = 0;
        for(int i = 0; i < vet1.length; i++) {
            soma = vet1[i] + vet2[i];
            System.out.printf("Soma dos valores da posição %d dos vetores da tarefa %d: %d%n", i, id, soma);
        }
        System.out.printf("TAREFA %d FINALIZADA!%n", id);
    }
}
