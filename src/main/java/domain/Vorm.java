package domain;
import javafx.scene.paint.Color;
import ui.Drawable;

public abstract class Vorm implements Drawable {
    private Color kleur;

    public Vorm(){

    }
    public Vorm(Color kleur) {
        if (kleur == null) { kleur = Color.WHITE;
        }
        else {
            this.kleur = kleur;
        }
    }

    public Color getKleur() {
        return kleur;
    }

    public void setKleur(Color kleur) {
        this.kleur = kleur;
    }


    public abstract Omhullende getOmhullende();

    public abstract String toString();

}
