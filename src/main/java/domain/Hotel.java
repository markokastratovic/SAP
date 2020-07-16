/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Marko
 */
public class Hotel {

    private Room[] rooms;

    public Hotel(int size) {
        rooms = new Room[size];
        for (int i = 0; i < size; i++) {
            rooms[i] = new Room();
        }
    }

    //metoda rezervise sobu tako da maksimizira iskoriscenost soba
    //specijalan slucaj kad novi interval savrseno staje u neku od soba (soba zauzeta u danima startDay-1  i endDay+1) nije razmatran radi manjeg broja poredjenja
    public boolean bookRoom(int startDay, int endDay) {
        if (startDay < 0 || endDay > 364 || startDay > endDay) {
            throw new RuntimeException("Invalid day interval, please input numbers in [0,364]");
        }
        int minEmptyDays = Integer.MAX_VALUE;
        int minEmptyDaysRoomIndex = -1;
        for (int i = 0; i < rooms.length; i++)  {
            if (!rooms[i].isOccupied(startDay, endDay)) {
                int currentRoomEmptyDays = rooms[i].emptyDays(startDay, endDay);
                if (minEmptyDays > currentRoomEmptyDays) {
                    minEmptyDays = currentRoomEmptyDays;
                    minEmptyDaysRoomIndex = i;
                    if (minEmptyDays == 0) {
                        break;
                    }
                }

            }
        }
        if (minEmptyDaysRoomIndex != -1) {
            rooms[minEmptyDaysRoomIndex].occupy(startDay, endDay);
            return true;
        }
        return false;
    }

}
