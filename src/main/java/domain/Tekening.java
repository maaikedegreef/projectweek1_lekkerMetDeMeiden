package domain;

import javafx.scene.layout.Pane;
import ui.Drawable;

import java.util.ArrayList;

public class Tekening implements Drawable {

    private String name;
    private ArrayList<Vorm> vormen = new ArrayList<>();
    public static final int MIN_X = 0;
    public static final int MAX_X = 399;
    public static final int MIN_Y = 0;
    public static final int MAX_Y = 399;

    public Tekening(String naam) {
        if (isValidNaam(naam)) this.name = naam;
        else throw new IllegalArgumentException("Ongeldige naam");
    }

    public static boolean isValidNaam(String naamTekening) {
       return (naamTekening != null && !naamTekening.isBlank());
    }

    public String getNaam() {
        return name;
    }

    public void voegToe (Vorm vorm) {
        if(vorm == null) return;
        Omhullende lol = vorm.getOmhullende();

        if (vorm.getOmhullende().getMinimumX() < MIN_X
                || vorm.getOmhullende().getMinimumY() < MIN_Y
                || vorm.getOmhullende().getMaximumX() > MAX_X
                || vorm.getOmhullende().getMaximumY() > MAX_Y) {
            throw new DomainException("Vorm valt buiten tekening");
        } vormen.add(vorm);
    }

    public Vorm getVorm(int index){
        if(index < 0) throw new DomainException("de index is negatief");
        if(index >= vormen.size()) throw new DomainException("de index  is negatief");
        return vormen.get(index);
    }
    public int getAantalVormen(){
        return vormen.size();
    }
    public void verwijder(Vorm vorm){
        if(vorm == null) return;
        vormen.remove(vorm);
    }
    public boolean bevat(Vorm vorm){
        if(vorm == null) return false;
        return vormen.contains(vorm);
    }

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

    @Override
    public void teken(Pane root) {
        vormen.forEach(x -> {if (x.isZichtbaar()) x.teken(root);});
    }
}