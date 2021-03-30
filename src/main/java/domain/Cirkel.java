package domain;

public class Cirkel extends Vorm {
    private Punt middelPunt;
    private int radius;

    public Cirkel(Punt middelPunt, int radius){
        setMiddelpunt(middelPunt);
        setRadius(radius);
    }

    private void setMiddelpunt(Punt middelPunt) {
        if (middelPunt == null) throw new DomainException("Middelpunt mag niet leeg zijn.");
        this.middelPunt = middelPunt;
    }

    private void setRadius(int radius) {
        if (radius <= 0) throw new DomainException("Straal moet minstens 1 zijn.");
        this.radius = radius;
    }

    public Punt getMiddelPunt() {
        return middelPunt;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof Cirkel) {
            Cirkel c = (Cirkel) o;
            if(this.middelPunt.equals(c.middelPunt) && this.radius == c.radius) {
                result = true;
            }
        }
        return result;
    }
    @Override
    public String toString() {
        return "Cirkel: middelpunt: (" + middelPunt.getX() + ", " + middelPunt.getY() + ") - straal: " + radius ;
    }

    @Override
    public Omhullende getOmhullende() {
        return new Omhullende(new Punt(middelPunt.getX() - radius, middelPunt.getY() - radius), 2*radius, 2*radius);
    }
}

