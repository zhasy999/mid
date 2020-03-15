package com.example.mid;

import com.example.mid.Dao.Application;
import com.example.mid.config.SpringConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws  SQLException{
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        Application app = context.getBean("application",Application.class);
        app.run(context);
    }
}
