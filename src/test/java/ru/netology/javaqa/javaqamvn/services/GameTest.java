package ru.netology.javaqa.javaqamvn.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Nikita", 50);
    Player player2 = new Player(2, "Masha", 50);
    Player player3 = new Player(3, "Roma", 65);
    Player player4 = new Player(4, "Ruslan", 87);

    @BeforeEach
    void registerPlayers() {
        game.register(player1);
        game.register(player2);
        game.register(player4);
    }

    @Test
    void findByNameTest() {
        Player expected = player1;
        Player actual = game.findByName("Nikita");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void noFindByNameTest() {
        Player expected = null;
        Player actual = game.findByName("Roma");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void roundTestP2moreP1() {
        int expected = 2;
        int actual = game.round("Nikita", "Ruslan");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void roundTestP1moreP2() {
        int expected = 1;
        int actual = game.round("Ruslan", "Nikita");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void roundTestP1equalP2() {
        int expected = 0;
        int actual = game.round("Masha", "Nikita");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void roundTestExcepsion1() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Roma", "Nikita");
        });
    }

    @Test
    void roundTestExcepsion2() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Masha", "Roma");
        });
    }
}