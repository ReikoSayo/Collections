package ru.netology.javaqa.javaqamvn.services;

import java.util.ArrayList;
import java.util.Objects;

public class Game {
    private ArrayList<Player> nameList = new ArrayList<>();

    public void register(Player player) {
        nameList.add(player);
    }

    public Player findByName(String playerName1) {
        for (Player name : nameList) {
            if (Objects.equals(name.getName(), playerName1)) {
                return name;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        int result;
        Player Pl1 = findByName(playerName1);
        Player Pl2 = findByName(playerName2);
        if (Pl1 == null) {
            throw new NotRegisteredException(
                    "Player with Name: " + playerName1 + " not registered");
        } else if (Pl2 == null) {
            throw new NotRegisteredException(
                    "Player with Name: " + playerName2 + " not registered");
        } else {
            result = Pl1.compareTo(Pl2);
        }
        return result;
    }
}
