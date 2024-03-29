package domain;
import javafx.scene.paint.Color;
import ui.Drawable;

import java.util.Objects;

public abstract class Vorm implements Drawable {
    private Color kleur;
    private boolean zichtbaar = false;

    public Vorm(){

    }

    public boolean isZichtbaar() {
      return zichtbaar;
    }
    public void setZichtbaar(boolean status){
        this.zichtbaar = status;
    }

    public Vorm(Color kleur) {
        this.kleur = Objects.requireNonNullElse(kleur, Color.WHITE);
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
