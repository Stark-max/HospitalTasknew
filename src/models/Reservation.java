package models;

public class Reservation {

    private String name;
    private Integer roomNumber;
    private Integer capacity;

    public Reservation(String person){
        name=person;
    }

    public Reservation(String person,int room){
        name = person;
        roomNumber=room;
    }

    public void setRoom(int newRoom){
        roomNumber = newRoom;
    }
    public void setName(String newName){
        name = newName;
    }
    public void setCapacity(int newCapacity){
        capacity = newCapacity;
    }
    public String toString(){
        return(name+" "+roomNumber+" "+capacity);
    }
    public int getRoom(){
        return roomNumber;
    }
    public String getName(){
        return name;
    }
    public int getCapacity(){
        return capacity;
    }
}
