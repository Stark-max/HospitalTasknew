package controllers;

import models.Hotel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Menu {
    private static String readLine() {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        try {
            return stdin.readLine();
        } catch (Exception e) {
            System.out.println("Invalid Input");
        }
        return null;
    }

    public void console() {
        Hotel hotelObj = new Hotel();
        String name;
        String num;
        int roomnum;
        while (true) {
            System.out.print("Command: ");
            System.out.flush();
            String command = readLine();
            if ((command == null) || command.equalsIgnoreCase("quit")) {
                System.out.println("Good bye");
                break;
            }
            if (command.equalsIgnoreCase("reserve")) {
                System.out.print("Name: ");
                System.out.flush();
                name = readLine();
                roomnum = -1;
                if (!((name == null) || (name.equals("")))) {
                    roomnum = hotelObj.reserveRoom(name);
                }
                if (roomnum == -1) {
                    System.out.println("No reservation for you!");
                } else {
                    System.out.println(name + " reserved room " + roomnum);
                }
            }
            if (command.equalsIgnoreCase("reserveN")) {
                System.out.print("Name: ");
                System.out.flush();
                name = readLine();
                System.out.print("Room number: ");
                System.out.flush();
                num = readLine();
                if ((name == null) || (name.equals("")) || (num == null)) {
                    roomnum = -1;
                } else {
                    try {
                        roomnum = Integer.parseInt(num);
                    } catch (Exception e)  {
                        roomnum = -1;
                    }
                }
                if (!hotelObj.reserveRoom(name, roomnum)) {
                    System.out.println("No reservation for you!");
                } else {
                    System.out.println(name + " reserved room " + roomnum);
                }
            } else if (command.equalsIgnoreCase("cancel")) {
                System.out.print("Name: ");
                System.out.flush();
                name = readLine();
                if (!((name == null) || (name.equals("")))) {
                    hotelObj.cancelReservations(name);
                    System.out.println(name + " now has no reservations.");
                } else {
                    System.out.println("Who?");
                }
            } else if (command.equalsIgnoreCase("print")) {
                hotelObj.printReservations();
            } else if (command.equalsIgnoreCase("build")) {
                System.out.print("How many: ");
                System.out.flush();
                num = readLine();
                roomnum = -1;
                if (num != null) {
                    try {
                        roomnum = Integer.parseInt(num);
                    } catch (Exception e) {
                        roomnum = -1;
                    }
                }
                if (hotelObj.buildRooms(roomnum)) {
                    System.out.println("Added " + roomnum + " more rooms");
                } else {
                    System.out.println("No more rooms for you");
                }
            } else {
                System.out.println("Available commands:");
                System.out.println("print - show all reservations");
                System.out.println("reserve - reserve a room for someone");
                System.out.println("reserveN - reserve a particular room");
                System.out.println("cancel - cancel someone's reservations");
                System.out.println("build - build some more rooms for the hotel");
            }
        }
    }
}
