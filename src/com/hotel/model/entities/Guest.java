package com.hotel.model.entities;

import java.time.LocalDateTime;

public class Guest extends User{




    public Guest() {

        System.out.println("Guest constructor ");
    }
    public void  register(String email,String pass){

        System.out.println("Guest registration ");
    }
    public void  viewRooms(){
        System.out.println("Guest viewRooms ");
    }

}
