package com.artem.zinchenko.demo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Launcher {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gentleware");
        new Demo(emf).run();
        emf.close();
    }
}
