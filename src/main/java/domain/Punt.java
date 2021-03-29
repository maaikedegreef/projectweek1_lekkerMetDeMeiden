package domain;

public class Punt {

    private int x;
    private int y;

    public Punt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    @Override
    public boolean equals(Object object){
        if(object instanceof Punt){
            return ((Punt) object).getX() == this.getX() && ((Punt) object).getY() == this.getY();
        }
        return false;
    }
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
