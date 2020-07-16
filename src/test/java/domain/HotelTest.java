/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Marko
 */
public class HotelTest {
    
    @Test
    public void test1a() {
        Hotel hotel = new Hotel(3);
        assertThrows(RuntimeException.class, ()-> hotel.bookRoom(-1, 5));
    }
    
    @Test
    public void test1b() {
        Hotel hotel = new Hotel(3);
        assertThrows(RuntimeException.class, ()-> hotel.bookRoom(200, 400));
    }
    
    @Test
    public void test2() {
        Hotel hotel = new Hotel(3);
        assertEquals(true,hotel.bookRoom(0,5));
        assertEquals(true,hotel.bookRoom(7,13));
        assertEquals(true,hotel.bookRoom(3,9));
        assertEquals(true,hotel.bookRoom(5,7));
        assertEquals(true,hotel.bookRoom(6,6));
        assertEquals(true,hotel.bookRoom(0,4));
    }
    
    @Test
    public void test3() {
        Hotel hotel = new Hotel(3);
        assertEquals(true,hotel.bookRoom(1,3));
        assertEquals(true,hotel.bookRoom(2,5));
        assertEquals(true,hotel.bookRoom(1,9));
        assertEquals(false,hotel.bookRoom(0,15));
    }
    
    @Test
    public void test4() {
        Hotel hotel = new Hotel(3);
        assertEquals(true,hotel.bookRoom(1,3));
        assertEquals(true,hotel.bookRoom(0,15));
        assertEquals(true,hotel.bookRoom(1,9));
        assertEquals(false,hotel.bookRoom(2,5));
        assertEquals(true,hotel.bookRoom(4,9));
    }
    
    @Test
    public void test5() {
        Hotel hotel = new Hotel(2);
        assertEquals(true,hotel.bookRoom(1,3));
        assertEquals(true,hotel.bookRoom(0,4));
        assertEquals(false,hotel.bookRoom(2,3));
        assertEquals(true,hotel.bookRoom(5,5));
        assertEquals(true,hotel.bookRoom(4,10));
        assertEquals(true,hotel.bookRoom(10,10));
        assertEquals(true,hotel.bookRoom(6,7));
        assertEquals(false,hotel.bookRoom(8,10));
        assertEquals(true,hotel.bookRoom(8,9));
    }
}
