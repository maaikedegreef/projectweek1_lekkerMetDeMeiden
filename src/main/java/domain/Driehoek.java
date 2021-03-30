package domain;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Collections;

public class Driehoek extends Vorm{
    private Punt hoekpunt1, hoekpunt2, hoekpunt3;

    public Driehoek(Punt hoekpunt1, Punt hoekpunt2, Punt hoekpunt3) {
        if (hoekpunt1==null||hoekpunt2==null||hoekpunt3==null) throw new DomainException("Punten mogen niet leeg zijn");
        if (puntenVallenSamen(hoekpunt1, hoekpunt2, hoekpunt3)) throw new DomainException("Punten mogen niet samenvallen!");
        if (liggenOp1Lijn(hoekpunt1, hoekpunt2, hoekpunt3)) throw new DomainException("Punten mogen niet op 1 lijn liggen!");
        this.hoekpunt1 = hoekpunt1;
        this.hoekpunt2 = hoekpunt2;
        this.hoekpunt3 = hoekpunt3;
    }

    public Punt getHoekPunt1() {
        return hoekpunt1;
    }

    public Punt getHoekPunt2() {
        return hoekpunt2;
    }

    public Punt getHoekPunt3() {
        return hoekpunt3;
    }

    public boolean liggenOp1Lijn(Punt punt1, Punt punt2, Punt punt3) {
        return (punt2.getX() - punt1.getX()) * (punt3.getY() - punt1.getY()) == ((punt3.getX() - punt1.getX()) * (punt2.getY() - punt1.getY()));
    }

    public void sorteerHoekpunten() {
        ArrayList<Punt> hoekpunten = new ArrayList<>();
        hoekpunten.add(hoekpunt1);
        hoekpunten.add(hoekpunt2);
        hoekpunten.add(hoekpunt3);
        ArrayList<Punt> gesorteerdeHoekpunten = new ArrayList<>();

        while (!hoekpunten.isEmpty()){
            gesorteerdeHoekpunten.add(vindKleinsteHoekPunt(hoekpunten));
            hoekpunten.remove(vindKleinsteHoekPunt(hoekpunten));
        }

        hoekpunt1 = gesorteerdeHoekpunten.get(0);
        hoekpunt2 = gesorteerdeHoekpunten.get(1);
        hoekpunt3 = gesorteerdeHoekpunten.get(2);

    }

    public Punt vindKleinsteHoekPunt(ArrayList<Punt> hoekpunten){
        Punt kleinsteHoekpunt = hoekpunten.get(0);
        for (Punt p: hoekpunten){
            if (p.getX() == kleinsteHoekpunt.getX()){
                if (p.getY() < kleinsteHoekpunt.getY()){
                    kleinsteHoekpunt = p;
                }
            } else if (p.getX() < kleinsteHoekpunt.getX()){
                kleinsteHoekpunt = p;
            }
        }
        return kleinsteHoekpunt;
    }


    public Punt vindPuntGrootsteY(){
        ArrayList<Punt> hoekpunten = new ArrayList<>();
        hoekpunten.add(hoekpunt1);
        hoekpunten.add(hoekpunt2);
        hoekpunten.add(hoekpunt3);

        Punt grootsteHoekpunt = hoekpunten.get(0);
        for (Punt p: hoekpunten){
            if (p.getY() == grootsteHoekpunt.getY()){
                if (p.getY() > grootsteHoekpunt.getY()){
                    grootsteHoekpunt = p;
                }
            } else if (p.getY() > grootsteHoekpunt.getY()){
                grootsteHoekpunt = p;
            }
        }
        return grootsteHoekpunt;
    }
    public Punt vindPuntKleinsteY(){
        ArrayList<Punt> hoekpunten = new ArrayList<>();
        hoekpunten.add(hoekpunt1);
        hoekpunten.add(hoekpunt2);
        hoekpunten.add(hoekpunt3);

        Punt kleinsteHoekpunt = hoekpunten.get(0);
        for (Punt p: hoekpunten){
            if (p.getY() == kleinsteHoekpunt.getY()){
                if (p.getY() < kleinsteHoekpunt.getY()){
                    kleinsteHoekpunt = p;
                }
            } else if (p.getY() < kleinsteHoekpunt.getY()){
                kleinsteHoekpunt = p;
            }
        }
        return kleinsteHoekpunt;

    }

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

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof Driehoek) {
            Driehoek d = (Driehoek) o;
            d.sorteerHoekpunten();
            this.sorteerHoekpunten();
            if (hoekpunt1.equals(d.getHoekPunt1()) && hoekpunt2.equals(d.getHoekPunt2()) && hoekpunt3.equals(d.getHoekPunt3()) ) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        sorteerHoekpunten();
        return "Driehoek: hoekpunt1: (" + hoekpunt1.getX() + ", " + hoekpunt1.getY() + ") - hoekpunt2: (" + hoekpunt2.getX() + ", " + hoekpunt2.getY() + ") -" +
                " hoekpunt3: (" + hoekpunt3.getX() + ", " + hoekpunt3.getY() + ")";
    }


    @Override
    public Omhullende getOmhullende() {
        return new Omhullende(getLinksBoven(),getBreedte(), getHoogte());
    }


    public Punt getLinksBoven() {
        this.sorteerHoekpunten();
        return new Punt(hoekpunt1.getX(), vindPuntGrootsteY().getY());
    }

    public int getBreedte() {
        this.sorteerHoekpunten();
        return (hoekpunt3.getX() - hoekpunt1.getX());
    }

    public int getHoogte() {
        return (getLinksBoven().getY() - vindPuntKleinsteY().getY());
    }


    @Override
    public void teken(Pane root) {

    }
}
