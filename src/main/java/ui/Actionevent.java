package ui;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Actionevent {

    public static void normalevent(GridPane root, int ycoordinate , TextField texfield , TextField nexttextfield , Label nextLabel , Alert alert , String errormessage){
        texfield.setOnAction(eventIngaveBreedte ->{
            /* de tekst halen en een integer maken */
            try{
                Integer.parseInt(texfield.getText());
                root.add(nextLabel , 0 ,ycoordinate);
                root.add(nexttextfield , 1 ,ycoordinate);
            }catch (NumberFormatException e){
                texfield.clear();
                alert.setTitle("Warning");
                alert.setContentText(errormessage);
                alert.showAndWait();
            }
        } );

    }
}
