package ru.netology.javaqa.javaqamvn.services;

import java.util.HashMap;

public class Game {
    private HashMap<String, Integer> nameList = new HashMap<>();

    public void register(String name, Integer strength) {
        nameList.put(name, strength);
    }

    public int findByName(String playerName1) {
        if (!nameList.containsKey(playerName1)) {
            throw new NotRegisteredException(
                    "Player with Name: " + playerName1 + " not registered");
        } else {
            return nameList.get(playerName1);
        }
    }

    public int round(String playerName1, String playerName2) {
        int Pl1 = findByName(playerName1);
        int Pl2 = findByName(playerName2);

        if (Pl1 < Pl2) {
            return 2;
        } else if (Pl1 > Pl2) {
            return 1;
        } else {
            return 0;
        }
    }
}
