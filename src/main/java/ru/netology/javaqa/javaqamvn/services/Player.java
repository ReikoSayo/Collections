package ru.netology.javaqa.javaqamvn.services;

import lombok.*;
@Data
@Getter
public class Player {
    private int id;
    private String name;
    private int strength;

    public Player(int id, String name, int strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
    }

    public int compareTo(Player o) {
        if (this.strength < o.strength) {
            return 2;
        } else if (this.strength > o.strength) {
            return 1;
        } else {
            return 0;
        }
    }
}
