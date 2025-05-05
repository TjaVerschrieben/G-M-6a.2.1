import java.util.*;

/**
 * Lottozahlen generieren + überprüfen
 * @author Julia Stuppnig
 * @version 05.05.2025
 */
public class Lotto {
    Set<Integer> lottozahlen;
    int zusatzzahl;

    public Lotto(){
        lottozahlen = new TreeSet<>();

        this.ziehung();
    }

    /**
     * überprüft die abgegebenen zahlen mit den lottozahlen
     * @param tip die abgegebenen zahlen
     * @return die übereingestimmten zahlen
     */
    public int check(Set<Integer> tip){
        int gleiche = 0;

        Iterator<Integer> it = tip.iterator();
        while(it.hasNext()){
            if(lottozahlen.contains(it.next())){
                gleiche++;
            }
        }

        return gleiche;
    }

    /**
     * überprüft die zusatzzahl mit den abgegebenen zahlen
     * @param tip die abgegebenen zahlen
     * @return ob etwas übereinstimmt
     */
    public boolean checkZusatz(Set<Integer> tip){
        if(tip.contains(zusatzzahl)){
            return true;
        }
        return false;
    }

    /**
     * gibt zusatzzahl zurücl
     * @return zusatzzahl
     */
    public int getZusatzzahl(){
        return zusatzzahl;
    }

    /**
     * zieht neue 6 lottozahlen + zusatzzahl
     */
    public void ziehung(){
        Random random = new Random();
        for(int i = 0; i< 6; i++){
            int zufallszahl = random.nextInt(1, 45);
            while (lottozahlen.contains(zufallszahl)) {
                zufallszahl = random.nextInt(1, 45);
            }
            lottozahlen.add(zufallszahl);
        }

        zusatzzahl = random.nextInt(1, 45);
        while(lottozahlen.contains(zusatzzahl)){
            random.nextInt(1, 45);
        }
    }

    /**
     * speichert die lottozahlen geordnet in ein integer array
     * @return das array
     */
    public int[] toArray(){
        Iterator<Integer> it = lottozahlen.iterator();
        int[] geordnet = new int[lottozahlen.size()];

        for(int i = 0; i < lottozahlen.size(); i++) {
            if (it.hasNext()) {
                geordnet[i++] = it.next();
            }
        }
        return geordnet;

    }

    /**
     * stellt das Lotto Objekt als String da
     * @return der String
     */
    public String toString(){
        String rueckgabe = "Lottozahlen: ";
        int[] geordnet = this.toArray();

        for(int i = 0; i<geordnet.length; i++){
            rueckgabe = rueckgabe + geordnet[i];
        }
        rueckgabe = rueckgabe + "Zusatzzahl: " + zusatzzahl;

        return rueckgabe;
    }
}
