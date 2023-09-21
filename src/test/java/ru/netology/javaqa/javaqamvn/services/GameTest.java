package ru.netology.javaqa.javaqamvn.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
    Game game = new Game();

    //player3 = ("Roma", 65);
    @BeforeEach
    void registerPlayers() {
        game.register("Nikita", 50);
        game.register("Masha", 50);
        game.register("Ruslan", 87);
    }

    @Test
    void findByNameTest() {
        int expected = 50;
        int actual = game.findByName("Nikita");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void noFindByNameTest() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.findByName("Roma");
        });
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