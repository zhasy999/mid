package com.example.mid.Dao;

import com.example.mid.Customer;
import com.example.mid.Dao.Detail;
import com.example.mid.Dao.DetailMapper;
import com.example.mid.Dao.Service;
import com.example.mid.Dao.ServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

@Component
public class Application {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public void run(AnnotationConfigApplicationContext context) throws SQLException {


        Scanner sc = new Scanner(System.in);
        Customer customer = context.getBean("customer",Customer.class);
        System.out.println("Welcome to our AutoServie");
        System.out.println("Choose your car type" +
                "\n1.Truck" +
                "\n2.Sedan");
        int carType = sc.nextInt();
        while (true) {
            System.out.println("1.Choose details" +
                    "\n2.Choose services" +
                    "\n3.Show total");
            int key = sc.nextInt();
            ResultSet rs;

            if (key == 1) {

                List<Detail> productList = jdbcTemplate.query(
                        "select * from details", new DetailMapper());

                for (Detail p : productList) {
                    System.out.println(p.toString());
                }

                int p = sc.nextInt();

                Detail detail= jdbcTemplate.query(
                        "select * from details where id=" + p + ";", new DetailMapper()).get(0);

                customer.addDetail(detail);


            } else if (key == 2) {
                List<Service> serviceList = jdbcTemplate.query(
                        "select * from services",
                        new ServiceMapper());

                for (Service s: serviceList) {
                    System.out.println(s.toString());
                }

                int s = sc.nextInt();
                Service service = jdbcTemplate.query(
                        "select * from services where id=" + s + ";",
                        new ServiceMapper()
                ).get(0);

                customer.addService(service);

            } else if (key == 3) {
                customer.showList();
                if(carType==1)
                    System.out.println("Price for sedan: " + customer.PaymentForSedans());
                else if(carType==2)
                    System.out.println("Price for truck: " + customer.PaymentForTrucks());
                break;
            }
        }
    }

}
