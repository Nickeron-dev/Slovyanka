package com.project.slovyanka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Illia Koshkin
 * Це клас що запускає увесь веб-застосунок.
 */
@SpringBootApplication
public class SlovyankaApplication {

    /**
     * Саме цей метод запускає все.
     * @param args приймає аргументи з командного рядка(терміналу)
     */
    public static void main(String[] args) {
        SpringApplication.run(SlovyankaApplication.class, args);
    }

}
