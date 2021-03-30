package domain;

import java.util.ArrayList;
import java.util.Collections;

public class Driehoek extends Vorm{
    private Punt hoekpunt1, hoekpunt2, hoekpunt3;

    public Driehoek(Punt hoekpunt1, Punt hoekpunt2, Punt hoekpunt3) {
        if (puntenVallenSamen(hoekpunt1, hoekpunt2, hoekpunt3)) throw new DomainException("Punten mogen niet samenvallen!");
        if (liggenOp1Lijn(hoekpunt1, hoekpunt2, hoekpunt3)) throw new DomainException("Punten mogen niet op 1 lijn liggen!");
        setHoekpunt1(hoekpunt1);
        setHoekpunt2(hoekpunt2);
        setHoekpunt3(hoekpunt3);
    }

    public Punt getHoekpunt1() {
        return hoekpunt1;
    }

    public Punt getHoekpunt2() {
        return hoekpunt2;
    }

    public Punt getHoekpunt3() {
        return hoekpunt3;
    }

    public boolean liggenOp1Lijn(Punt punt1, Punt punt2, Punt punt3) {
        return (punt2.getX() - punt1.getX()) * (punt3.getY() - punt1.getY()) == ((punt3.getX() - punt1.getX()) * (punt2.getY() - punt1.getY()));
    }

//    public void sorteerHoekpunten() {
//        ArrayList<Punt> hoekpunten = new ArrayList<>();
//        hoekpunten.add(hoekpunt1);
//        hoekpunten.add(hoekpunt2);
//        hoekpunten.add(hoekpunt3);
//        for (Punt hoekpunt : hoekpunten) {
//        for (int i = 0; i < hoekpunten.size(); i++) {
//            if (hoekpunten.get(i).getX() < hoekpunten.get(i+1).getX()) Collections.swap();
//        }
//        }
//    }

//    public void sorteerHoekpunten() {
//        ArrayList<Punt> hoekpunten = new ArrayList<>();
//        hoekpunten.add(hoekpunt1);
//        hoekpunten.add(hoekpunt2);
//        hoekpunten.add(hoekpunt3);
//        for (Punt hoekpunt : hoekpunten) {
//            for (int i = 0; i < hoekpunten.size(); i++) {
//                if (hoekpunten.get(i).getX() < hoekpunten.get(i+1).getX()) Collections.swap();
//            }
//        }
//    }
//
//    private boolean vergelijkHoekpunten(Punt punt1, Punt punt2) {
//        if (punt1.getX() < punt2.getX()) Collections.swap();
//
//    }

    public void setHoekpunt1(Punt hoekpunt1) {
        if (hoekpunt1 == null) {
            throw new DomainException("Hoekpunt kan niet leeg zijn.");
        }
        if (puntenVallenSamen(hoekpunt1, hoekpunt2, hoekpunt3)) throw new DomainException("Punten mogen niet samenvallen!");
        if (liggenOp1Lijn(hoekpunt1, hoekpunt2, hoekpunt3)) throw new DomainException("Punten mogen niet op 1 lijn liggen!");

        this.hoekpunt1 = hoekpunt1;
    }

    public void setHoekpunt2(Punt hoekpunt2) {
        if (hoekpunt2 == null) {
            throw new DomainException("Hoekpunt kan niet leeg zijn.");
        }
        if (puntenVallenSamen(hoekpunt1, hoekpunt2, hoekpunt3)) throw new DomainException("Punten mogen niet samenvallen!");
        if (liggenOp1Lijn(hoekpunt1, hoekpunt2, hoekpunt3)) throw new DomainException("Punten mogen niet op 1 lijn liggen!");

        this.hoekpunt2 = hoekpunt2;
    }

    public void setHoekpunt3(Punt hoekpunt3) {
        if (hoekpunt3 == null) {
            throw new DomainException("Hoekpunt kan niet leeg zijn.");
        }
        if (puntenVallenSamen(hoekpunt1, hoekpunt2, hoekpunt3)) throw new DomainException("Punten mogen niet samenvallen!");
        if (liggenOp1Lijn(hoekpunt1, hoekpunt2, hoekpunt3)) throw new DomainException("Punten mogen niet op 1 lijn liggen!");

        this.hoekpunt3 = hoekpunt3;
    }

    private boolean puntenVallenSamen(Punt punt1, Punt punt2, Punt punt3) {
        if (punt1.equals(punt2) || punt1.equals(punt3) || punt2.equals(punt3)) return true;
        return false;
    }

//    @Override
//    public boolean equals(Object o) {
//        boolean result = false;
//        if (o instanceof Driehoek) {
//            Driehoek d = (Driehoek) o;
//            if (this.middelPunt.equals(c.middelPunt) && this.radius == c.radius) {
//                result = true;
//            }
//        }
//        return result;
//    }

    @Override
    public String toString() {
        return "Driehoek: hoekpunt1: (" + hoekpunt1.getX() + ", " + hoekpunt1.getY() + ") - hoekpunt2: (" + hoekpunt2.getX() + ", " + hoekpunt2.getY() + ") -" +
                " hoekpunt3: (" + hoekpunt3.getX() + ", " + hoekpunt3.getY() + ")";
    }

//    @Override
//    public Omhullende getOmhullende() {
//        return new Omhullende(new Punt(hoekpunten[0].getX(), hoekpunten[0].gety()), Math.sqrt(Math.pow((hoekpunt1.getX()-hoekpunt2.getX()), 2) + Math.pow((hoekpunt1.getY()-hoekpunt2.getY()), 2)), Math.sqrt(Math.pow((hoekpunt2.getX()-hoekpunt2.getX()), 2) + Math.pow((hoekpunt1.getY()-hoekpunt2.getY()), 2)));
//    }
}
