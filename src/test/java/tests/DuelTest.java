package tests;

import com.example.yugioh.duel.Duel;
import com.example.yugioh.player.Player;
import org.junit.jupiter.api.Test;

import java.io.IOException;


public class DuelTest {
    @Test
    void DueT() throws IOException {
        Player p1 = new Player("Lyna");
        Player p2 = new Player("Lili");

        Duel d = new Duel(p1, p2);

        d.game();

    }
}
