import models.Hotel;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("Hotel.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(hotel);
            objectOutputStream.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}