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

    public Punt getLinksBoven() {
        int laagsteX = Math.min(startPunt.getX(), eindPunt.getX());
        int laagsteY = Math.min(startPunt.getY(), eindPunt.getY());
        return new Punt(laagsteX, laagsteY);
    }

    public boolean isDalend() {
        return startPunt.getY() > eindPunt.getY();
    }

    public int getbreedte() {
        int breedte;
        breedte = eindPunt.getX() - startPunt.getX();
        return breedte;
    }

    public int getHoogte() {
        int hoogte;
        if (isDalend()) hoogte = startPunt.getY() - eindPunt.getY();
        else {
            hoogte = eindPunt.getY() - startPunt.getY();
        }
        return hoogte;
    }


    @Override
    public Omhullende getOmhullende() {
        return new Omhullende(getLinksBoven(), getbreedte(), getHoogte());
    }

    @Override
    public void teken(Pane root) {
        LijnStuk l = new LijnStuk(startPunt, eindPunt);
        Line line = new Line(l.getStartPunt().getX(), l.getStartPunt().getY(), l.getEindPunt().getX(), l.getEindPunt().getY());
        line.setFill(Color.BLUE);
        root.getChildren().add(line);
    }
}

