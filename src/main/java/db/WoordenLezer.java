package db;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class WoordenLezer {

    private ArrayList<String> ingelezenwoorden = new ArrayList<>();
    public WoordenLezer(){

    }
    public void leeswoorden() throws FileNotFoundException {
        ArrayList<String> ingescandewoorden = new ArrayList<>();

        Scanner scanner = new Scanner(new File("src/main/resources/hangman.txt"));
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            ingelezenwoorden.add(line);
        }
    }

    public ArrayList<String> getIngelezenwoorden() {
        return ingelezenwoorden;
    }
}
