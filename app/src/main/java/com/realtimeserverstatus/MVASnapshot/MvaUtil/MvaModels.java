package com.realtimeserverstatus.MVASnapshot.MvaUtil;


public class MvaModels {
    String year;
    int total;



    public MvaModels(String year, int total){
        this.year = year;
        this.total = total;

    }

    public String getYear(){
        return year;
    }




    public int getTotal(){
        return total;
    }


}
