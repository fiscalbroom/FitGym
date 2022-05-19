package FitGym;

import java.util.ArrayList;

public class Palestra {
    /**
     Attributi dell classe palestra
     Utilizziamo 2 arrayList, uno per gli abbonati e uno per gli attrezzi
    **/
    private ArrayList<Attrezzi> attrezzi;

    private ArrayList<Abbonato> abbonati;

    public Palestra() {
        attrezzi = new ArrayList<>();
        abbonati = new ArrayList<>();
    }

    public void aggiungiAttrezzo(Attrezzi attrezzo){
        attrezzi.add(attrezzo);
    }

    public void rimuoviAttrezzo(Attrezzi attrezzo){
        attrezzi.remove(attrezzo);
    }

    public void aggiungiAbbonato(Abbonato abbonato){
        abbonati.add(abbonato);
    }

    public Abbonato getAbbonatoDaCodiceTessera(String codice){
        for (Abbonato a : abbonati){
            if(a.getCodiceTessera().equals(codice));
            {
                return a;
            }
        }
        return null;
    }

    public Attrezzi getAttrezzoDaCodice(String codice){
        for(Attrezzi at : attrezzi){
            if(at.getCodice().equals(codice));{
                return at;
            }
        }
        return null;
    }

    public void rimuoviAbbonatoDaCodice(String codice){
        for(Abbonato a : abbonati){
            if(a.getCodiceTessera().equals(codice)){
                if(a.getAttrezziInUso().size()>0){
                    System.out.println("L'abbonato ha degli attrezzi in uso, dunque non può essere rimosso");
                }else{
                    abbonati.remove(a);
                }
                return;
            }
        }
    }

    public void rimuoviAttrezzoDaCodice(String codice){
        for (Attrezzi at : attrezzi){
            if(at.getCodice().equals(codice)){
                attrezzi.remove(at);
                return;
            }
        }
        return;
    }

    public void stampaAbbonati(){
        for(Abbonato a : abbonati){
            System.out.println(a);
        }
    }

    public void stampaAttrezzi(){
        for(Attrezzi at : attrezzi){
            System.out.println(at);
        }
    }

    public void usaAttrezzo(Abbonato a, Attrezzi at){
        if(at.getQuantità()<1){
            System.out.println("Gli attrezzi sono attualmente tutti in uso");
            return;
        }
        at.rimuoviAttrezzo();
        a.AttrezziInUso(at);

    }
}
