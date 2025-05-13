package ro.irian.labs.pizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "ro.irian.labs")
//@EntityScan(basePackages = "ro.irian.labs")
public class L2E4JPAEntity {

    public static void main(String[] args) {
        SpringApplication.run(L2E4JPAEntity.class, args);
    }

}
