package domain;

import java.util.Objects;

public class LijnStuk extends Vorm {

    private Punt startPunt,eindPunt;

    public LijnStuk(Punt startPunt, Punt eindPunt) {
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
}

