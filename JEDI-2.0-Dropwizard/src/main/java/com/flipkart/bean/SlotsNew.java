package com.flipkart.bean;

public class SlotsNew {
    String slotId ;
    int capacity;
    String slotTime;
    int gymId;

    public SlotsNew(){

    }
    public SlotsNew(String slotId, int capacity, String slotTime, int gymId) {
        this.slotId = slotId;
        this.capacity = capacity;
        this.slotTime = slotTime;
        this.gymId = gymId;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getSlotTime() {
        return slotTime;
    }

    public void setSlotTime(String slotTime) {
        this.slotTime = slotTime;
    }

    public int getGymId() {
        return gymId;
    }

    public void setGymId(int gymId) {
        this.gymId = gymId;
    }


}