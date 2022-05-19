package FitGym;


/**
 * Questa classe serve solamente a creare un "caricamento"
 * del programma, in modo da renderlo più realistico
 *
 * Molto semplicemente scorre un array di caratteri utilizzando
 * un ciclo for con una variabile che va da 0 a 100, determinando
 * la percentuale del caricamento, e modificando il carattere stampato
 *
 * Lo /r alla fine del System.out.println serve semplicemente a cancellare
 * la riga stampata e sostituirla con la successiva, spostando il
 * cursore all'inizio della riga
 */
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

