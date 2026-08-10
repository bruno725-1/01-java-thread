// 1. Criar uma classe que implementa a interface Runnable:
class Tarefa implements Runnable {
    private int n1;
    private int n2;
    private char operacao;

    public Tarefa(int n1, int n2, char operacao) {
        this.n1 = n1;
        this.n2 = n2;
        this.operacao = operacao;
    }

    @Override
    public void run() {
        int resultado = 0;
        for (int i = 1; i <= 3; i++) {
            switch(operacao) {
                case '+':
                    resultado = n1 + n2 + i;
                    System.out.printf("Soma entre %d, %d e %d = %d%n", n1, n2, i, resultado);
                    break;
                case '-':
                    resultado = n1 - n2 - i;
                    System.out.printf("Subtração entre %d, %d e %d = %d%n", n1, n2, i, resultado);
                    break;
                case '*':
                    resultado = n1 * n2 * i;
                    System.out.printf("Multiplicação entre %d, %d e %d = %d%n", n1, n2, i, resultado);
                    break;
                case '/':
                    resultado = n1 / n2 / i;
                    System.out.printf("Divisão entre %d, %d e %d = %d%n", n1, n2, i, resultado);
                    break;
            }
            try {
                // 2. Simular uma tarefa que demora 1 segundo:
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println("Tarefa foi interrompida.");
            }
        }
        System.out.println("TAREFA " + operacao + " FINALIZADA!");
    }
}
