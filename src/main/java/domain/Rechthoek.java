package domain;

public class Rechthoek {

   private int breedte;
   private int hoogte;
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

    public boolean equals(Object object){

        if(object instanceof Rechthoek){
            if(((Rechthoek) object).getBreedte() == this.getBreedte() && ((Rechthoek) object).getHoogte() == this.getHoogte()
            && ((Rechthoek) object).getlinkerBovenhoek().equals(this.linkerBovenhoek)) return true;
        }
          return false;
        }


    @Override
    public String toString() {
        return "Rechthoek{" +
                "breedte=" + breedte +
                ", hoogte=" + hoogte +
                ", linkerBovenHoek=" + linkerBovenhoek +
                '}';
    }
}
