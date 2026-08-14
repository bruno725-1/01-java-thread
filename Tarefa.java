// 1. Criar uma classe que implementa a interface Runnable:
class Tarefa implements Runnable {
    private static int proximoId = 1;
    private int id;
    private int[][] mat1;
    private int[][] mat2;

    public Tarefa(int[][] m1, int[][] m2) {
        id = proximoId++;
        mat1 = m1;
        mat2 = m2;
    }

    @Override
    public void run() {
        int soma = 0;
        // Percorrer todas as linhas das matrizes
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[i].length; j++) {
                soma = mat1[i][j] + mat2[i][j];
                System.out.printf("Soma dos valores da posição %d,%d das matrizes da tarefa %d: %d%n", i, j, id, soma);
            }
        }
        System.out.printf("TAREFA %d FINALIZADA!%n", id);
    }
}
