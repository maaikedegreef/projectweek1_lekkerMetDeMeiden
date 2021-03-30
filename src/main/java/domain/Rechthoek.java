package domain;

import javafx.scene.layout.Pane;
import ui.Drawable;

public class Rechthoek extends Vorm {

   private int breedte , hoogte;
   private Punt linkerBovenhoek;

    public Rechthoek( Punt linkerBovenHoek, int breedte, int hoogte) {
        if(linkerBovenHoek == null) throw new DomainException("linkerbovenhoek is null");
        if(breedte < 0) throw new DomainException("breedte is kleiner dan 0");
        if(breedte == 0) throw new DomainException("breedte is 0");
        if(hoogte < 0) throw new DomainException("Hoogte is kleiner dan 0");
        if(hoogte == 0) throw new DomainException("Hoogte is 0");

        this.breedte = breedte;
        this.hoogte = hoogte;
        this.linkerBovenhoek = linkerBovenHoek;
    }

    public int getBreedte() {
        return breedte;
    }

    public int getHoogte() {
        return hoogte;
    }
    public Punt getlinkerBovenhoek() {
        return linkerBovenhoek;
    }

    @Override
    public Omhullende getOmhullende(){
        return new Omhullende(this.linkerBovenhoek , this.getBreedte(), this.getHoogte());
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof Rechthoek){
            return ((Rechthoek) object).getBreedte() == this.getBreedte() && ((Rechthoek) object).getHoogte() == this.getHoogte()
                    && ((Rechthoek) object).getlinkerBovenhoek().equals(this.linkerBovenhoek);
        }
          return false;
        }

    @Override
    public String toString() {
        return "Rechthoek: linkerbovenhoek: ("+ linkerBovenhoek.getX() + "," + linkerBovenhoek.getY() + ") - breedte: " + breedte + " - hoogte: " + hoogte +
                "\n" + this.getOmhullende().toString();
    }


    @Override
    public void teken(Pane root) {

    }
}
