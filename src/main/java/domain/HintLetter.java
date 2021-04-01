package domain;

public class HintLetter {
    private char letter;
    private boolean isGeraden;

    public HintLetter(char letter) {
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
}
