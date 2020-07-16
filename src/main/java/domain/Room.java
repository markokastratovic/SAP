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
public class Room {
    private boolean[] occupancy = new boolean[365];
    
    boolean isOccupied(int startDay , int endDay){
        for (int i = startDay; i <= endDay; i++) {
            if(occupancy[i])return true;
        }
        return false;
    }
    
    public void occupy(int startDay , int endDay){
        for (int i = startDay; i <= endDay; i++) {
            occupancy[i]=true;
        }
    }
    
    public int emptyDays(int startDay , int endDay){
        int before=0;
        int after=0;
        for (int i = startDay; i>=0 && !occupancy[i]; i--) {
            before++;
        }
        for (int i = endDay; i<occupancy.length && !occupancy[i]; i++) {
            after++;
        }
        return Integer.min(before, after);
    }
    
}
