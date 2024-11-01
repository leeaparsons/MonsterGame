import org.example.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    @Test
    public void testGetName() {
        Player player = new Player();
        player.setName("Bob");
        assertEquals("Bob", player.getName());
    }
    @Test
    public void testSetName() {
        Player player = new Player();
        player.setName("Catherine");
        assertEquals("Catherine", player.getName());
    }
    @Test
    public void testGetScore() {
        Player player = new Player();
        player.setScore(100);
        assertEquals(100, player.getScore());
    }
    @Test
    public void testSetScore() {
        Player player = new Player();
        player.setScore(100);
        assertEquals(100, player.getScore());
    }
}
