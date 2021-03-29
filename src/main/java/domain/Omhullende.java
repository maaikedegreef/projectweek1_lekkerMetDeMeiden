package domain;

public class Omhullende {

    private Punt positieLinksBoven;
    private int breedte , hoogte;

    public Omhullende(Punt positieLinksBoven, int breedte, int hoogte) {

        if(positieLinksBoven == null) throw new DomainException("pisitielinksboven is null");
        if(breedte < 0) throw new DomainException("breedte is kleiner dan 0");
        if(hoogte < 0) throw new DomainException("hoogte is kleiner dan 0");
        this.positieLinksBoven = positieLinksBoven;
        this.breedte = breedte;
        this.hoogte = hoogte;
    }

    public Punt getPositieLinksBoven() {
        return positieLinksBoven;
    }

    public int getBreedte() {
        return breedte;
    }

    public int getHoogte() {
        return hoogte;
    }
    public int getMinimumX(){
        return this.positieLinksBoven.getX();
    }
    public int getMinimumY(){
        return this.positieLinksBoven.getY();
    }
    public int getMaximumX(){
        return this.positieLinksBoven.getX() + breedte;
    }
    public int getMaximumY(){
        return this.positieLinksBoven.getY() + this.getHoogte();
    }
    @Override
    public boolean equals(Object object){
        if(object instanceof Omhullende){
            if(((Omhullende) object).positieLinksBoven.equals(this.positieLinksBoven) &&
                    ((Omhullende) object).getHoogte() == this.getBreedte() &&
                    ((Omhullende) object).getHoogte() == this.getHoogte()){
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return "Omhullende: " + "(" + positieLinksBoven.getX()  + ", " + positieLinksBoven.getY() +  ") - " +  breedte + " - " + hoogte ;
    }
}
