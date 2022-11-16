package models;

import java.io.Serializable;
import java.util.ArrayList;

public class Hotel implements Serializable {
    private ArrayList<Reservation> rooms;
    private Integer rnum = 1;
    Reservation reservationObject;

    public Hotel() {
        rooms = new ArrayList<>();
        rooms.ensureCapacity(5);
        for (int i = 0; i < 5; i++) {
            rooms.add(null);
        }
    }

    public Hotel(int numRooms) {
        rooms = new ArrayList<>();
        rooms.ensureCapacity(numRooms);
        for (int i = 0; i < numRooms; i++) {
            rooms.add(null);
        }
    }

    public boolean buildRooms(int num) {
        if (num <= 0) {
            return false;
        }
        rooms.ensureCapacity(rooms.size() + num);
        for (int i = 0; i < num; i++) {
            rooms.add(null);
        }
        return true;
    }

    public int reserveRoom(String person) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i) == null) {
                reservationObject = new Reservation(person);
                reservationObject.setRoom(rnum);
                rooms.set(i,reservationObject);
                rnum++;
                return rnum-1;
            }
        }
        return -1;
    }

    public boolean reserveRoom(String person, int roomNum){
        try{
            if(rooms.get(roomNum-1)==null){
                reservationObject = new Reservation(person, roomNum);
                rooms.set(roomNum - 1, reservationObject);
                rnum++;
                return true;
            }
        }catch (Exception vb){
            return false;
        }
        return false;
    }

    public void cancelReservations(String person) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i) != null) {
                if (rooms.get(i).getName().equals(person)) {
                    rooms.set(i,null);
                }
            }
        }
    }

    public void printReservations(){
        for(int i=0;i<rooms.size();i++){
            if(rooms.get(i)!=null){
                System.out.println(rooms.get(i));
            }else{
                System.out.println((i+1)+ "is not reserved");
            }
        }
    }
}
