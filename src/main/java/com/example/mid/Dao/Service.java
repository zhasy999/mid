package com.example.mid.Dao;

public class Service {
    private int id;
    private String name;
    private double price;
    public Service(int id,String name,double price){
        this.id=id;
        this.name=name;
        this.price=price;
    }
    public double getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
