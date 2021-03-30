package domain;

import java.util.ArrayList;
import java.util.Collections;

public class Tekening {

    private String name;
    private ArrayList<Vorm> vormen = new ArrayList<>();
    public static final int MIN_X = 0;
    public static final int MAX_X = 399;
    public static final int MIN_Y = 0;
    public static final int MAX_Y = 399;

    public Tekening(String naam) {
        if (isValidNaam(naam)) this.name = naam;

    }

    public static boolean isValidNaam(String naamTekening) {
       if(naamTekening == null) throw new IllegalArgumentException("naam is null");
       if(naamTekening.trim().equals("")) throw new IllegalArgumentException("ongeldig");
       return true;
    }

    public String getNaam() {
        return name;
    }

    public void voegToe(Vorm vorm){
        if(vorm == null) return;
        vormen.add(vorm);
    }
    public Vorm getVorm(int index){
        if(index < 0) throw new IllegalArgumentException("de index is negatief");
        if(index >= vormen.size()) throw new IllegalArgumentException("de index  is negatief");
        return vormen.get(index);
    }
    public int getAantalVormen(){
        return vormen.size();
    }
    public void verwijder(Vorm vorm){
        if(vorm == null) return;
        if(vormen.contains(vorm))vormen.remove(vorm);
    }
    public boolean bevat(Vorm vorm){
        if(vorm == null) return false;
        return vormen.contains(vorm);
    }
    /**
     *
     * In de UMl is er geen getVormen maar zou hier wel handig zijn...
     *
     * */
    @Override
    public boolean equals(Object object){
        if(object instanceof Tekening && ((Tekening) object).getAantalVormen() == this.getAantalVormen()){
            for (Vorm vorm: ((Tekening) object).vormen) {
                 if(!(this.vormen.contains(vorm))) return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Tekening{" + "name='" + name + '\'' + ", vormen=" + vormen + '}';
    }
}