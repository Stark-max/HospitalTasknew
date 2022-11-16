import controllers.Menu;
import models.Hotel;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.console();
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("Hotel.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(menu);
            objectOutputStream.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}