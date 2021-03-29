package domain;

public class Speler {
    private String naam;
    private int score;

    public Speler(String naam) {
        if (naam == null || naam.trim().isEmpty()) {
            throw new DomainException("Naam mag niet leeg zijn");
        }

        this.naam = naam;
        this.score = 0;
    }
    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof Speler) {
            Speler s = (Speler) o;
            if(this.naam.equals(s.naam) && this.score == s.score) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return naam + " heeft als score " + score;
    }

    public void addToScore(int score) {
        if (this.score + score < 0) throw new DomainException("Je kan geen negatieve score hebben.");
        this.score += score;
    }

    public int getScore() {
        return score;
    }

    public String getNaam() {
        return naam;
    }


}
