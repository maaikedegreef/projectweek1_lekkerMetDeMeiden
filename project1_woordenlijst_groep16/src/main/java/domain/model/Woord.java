package domain.model;

public class Woord {
    private String inhoud, niveau;

    /**Constructor
     * @param inhoud - inhoud is het woord zelf - mag niet leeg zijn
     * @param niveau - moeilijkheid om het te raden - “beginner” of “expert”
     * */
    public Woord(String inhoud, String niveau) {
        this(inhoud);
        setNiveau(niveau);
    }

    public Woord(String inhoud) {
        setInhoud(inhoud);
    }

    private void setInhoud(String inhoud) {
        if (inhoud == null || inhoud.isEmpty()) throw new DomainException("inhoud mag niet leeg zijn");
        this.inhoud = inhoud;
    }

    private void setNiveau(String niveau) {
        if (niveau == null || niveau.isEmpty()) return;
        if (!niveau.equals("beginner") && !niveau.equals("expert")) throw new IllegalArgumentException("ongeldig niveau");
        this.niveau = niveau;
    }

    public String getInhoud() {
        return inhoud;
    }

    public String getNiveau() {
        return niveau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Woord other = (Woord) o;

        return (this.inhoud.equals(other.inhoud));
    }
}
