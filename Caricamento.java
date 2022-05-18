package FitGym;

public class Caricamento {

    public Caricamento() {
    }

    public void caricamentoConsole() throws InterruptedException {

        /*
        Dovrebbe sembrare un gabbiano che vola, ma non lo sembra :(
         */
        char[] animationChars = new char[]{'︷', '︵', '︹', '︺', '︶', '︸'};

        for (int i = 0; i <= 100; i++) {
            System.out.print("Caricamento: " + i + "% " + animationChars[i % 6] + "\r");

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Caricamento completato!");
    }
}

