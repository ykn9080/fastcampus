package com.fastcampus.ch3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class Car{
    String color;
    int oil;
    @Autowired Engine engine;
    @Autowired Door[] doors;


    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", oil=" + oil +
                ", engine=" + engine +
                ", doors=" + Arrays.toString(doors) +
                '}';
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setDoors(Door[] doors) {
        this.doors = doors;
    }
}

@Component class Engine{}

@Component class Door{}

public class SpringDiTest {
    public static void main(String[] args) {
        ApplicationContext ac=new GenericXmlApplicationContext("classpath:config1.xml");
        Car car=(Car)ac.getBean("car");
        Engine engine=(Engine)ac.getBean("engine");
        Door doors=(Door)ac.getBean("door");
        car.setColor("blue");
        car.setOil(200);
//        car.setEngine(engine);
//        car.setDoors(new Door[]{doors,doors,doors,doors});
        System.out.println("car = " + car);
        System.out.println("engine = " + engine);
    }

}
