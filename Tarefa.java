// 1. Criar uma classe que implementa a interface Runnable:
import java.util.Random;

class Tarefa implements Runnable {
    @Override
    public void run() {
        Random aleatorio = new Random();
        int numeroSecreto = aleatorio.nextInt(10) + 1;
        for (int i = 1; i <= 3; i++) {
            int palpite = aleatorio.nextInt(10) + 1;
            System.out.printf("Palpite %d: %d%n", i, palpite);
            if (palpite > numeroSecreto) {
                System.out.println("O palpite foi maior");
            } else if (palpite < numeroSecreto) {
                System.out.println("O palpite foi menor");
            } else {
                System.out.println("Acertou miserave!");
                break;
            }
            try {
                // 2. Simular uma tarefa que demora 1 segundo:
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Tarefa foi interrompida.");
            }
        }
        System.out.println("TAREFA FINALIZADA!");
    }
}
