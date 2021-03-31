package domain;

public class HintLetter {
    private char letter;
    private boolean isGeraden;

    public HintLetter(char letter) {
        if (letter==' ') throw new DomainException("Letter mag niet leeg zijn.");
        this.letter = java.lang.Character.toLowerCase(letter);
        isGeraden = false;
    }

    public char getLetter() {
        return letter;
    }

    public boolean raad(char letter){
        letter = java.lang.Character.toLowerCase(letter);
        if (this.letter==letter && !isGeraden){
            isGeraden = true;
            return true;
        }
        return false;
    }

    public char toChar(){
        if(isGeraden){
            return letter;
        }
        return 95;
    }

    public boolean isGeraden(){
        return isGeraden;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HintLetter that = (HintLetter) o;
        return (letter == that.letter);
    }
}
