package domain;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.Objects;

public class LijnStuk extends Vorm {

    private Punt startPunt,eindPunt;

    public LijnStuk(Punt startPunt, Punt eindPunt) {
        super(null);
        setStartEnEindPunt(startPunt, eindPunt);
    }

    private void setStartEnEindPunt(Punt startPunt, Punt eindPunt) {
        if (startPunt == null || eindPunt == null) throw new DomainException("StartPunt en eindPunt mogen niet null zijn");
        if (startPunt.equals(eindPunt)) throw new DomainException("StartPunt en eindPunt mogen niet gelijk zijn");
        this.startPunt = startPunt;
        this.eindPunt = eindPunt;
    }

    public Punt getStartPunt() {
        return startPunt;
    }

    public Punt getEindPunt() {
        return eindPunt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LijnStuk lijnStuk = (LijnStuk) o;
        return (startPunt.equals(lijnStuk.startPunt) && eindPunt.equals(lijnStuk.eindPunt)) ||
                (startPunt.equals(lijnStuk.eindPunt) && eindPunt.equals(lijnStuk.startPunt));

    }

    @Override
    public String toString() {
        return "Lijn: " +
                "startPunt: " + startPunt +
                " - eindPunt: " + eindPunt;
    }

    private Punt getLinksBoven() {
        int x,y;
        if (!this.isDalend()) {
            x = Math.min(startPunt.getX(), eindPunt.getX());
            y = Math.max(startPunt.getY(), eindPunt.getY());
        } else {
            x = startPunt.getX();
            y = eindPunt.getY();
        }
        return new Punt(x, y);
    }

    private int getbreedte() {
        return Math.abs(eindPunt.getX() - startPunt.getX());
    }

    public int getHoogte() {
                return Math.abs(eindPunt.getY() - startPunt.getY());
    }

    public boolean isDalend() {
        return startPunt.getY() > eindPunt.getY();
    }

    @Override
    public Omhullende getOmhullende() {
        return new Omhullende(getLinksBoven(), getbreedte(), getHoogte());
    }

    @Override
    public void teken(Pane root) {
        Line line = new Line(this.getStartPunt().getX(), this.getStartPunt().getY(), this.getEindPunt().getX(), this.getEindPunt().getY());
        line.setFill(this.getKleur());
        root.getChildren().add(line);
    }
}

