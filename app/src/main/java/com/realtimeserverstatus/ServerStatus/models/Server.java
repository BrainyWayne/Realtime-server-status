package com.realtimeserverstatus.ServerStatus.models;

public class Server {
    String name;
    String description;
    int cpu;
    int memory;
    int pingstatus;


    public Server(String name, String description, int cpu, int memory, int pingstatus){
        this.name = name;
        this.description = description;
        this.cpu = cpu;
        this.memory = memory;
        this.pingstatus = pingstatus;
    }

    public Server(String name, String description, int cpu){
        this.name = name;
        this.description = description;
        this.cpu = cpu;

    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }



    public int getCpu(){
        return cpu;
    }
    public int getMemory(){
        return memory;
    }
    public int getPingstatus(){
        return pingstatus;
    }

}
