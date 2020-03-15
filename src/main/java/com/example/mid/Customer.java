package com.example.mid;

import com.example.mid.Dao.Detail;
import com.example.mid.Dao.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationEventPublisher;

import java.util.ArrayList;

@Component
public class Customer {
    private double amount=0;
    private ArrayList<String> s=new ArrayList<>();

    public double PaymentForSedans() {
        return amount;
    }
    public double PaymentForTrucks() {
        return amount*1.5;
    }

    public double addService(Service c) {
        amount+=c.getPrice();
        s.add("Service: "+c.getName());
        return amount;
    }

    public double addDetail(Detail p) {
        amount+=p.getPrice();
        s.add("Detail: "+p.getName());
        return amount;
    }

    public void showList() {
        for(String show:s) {
            System.out.println(show);
        }
    }

}
