
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static final int PORT = 6666;

    public static void main(String[] args) {
        System.out.println("Server started on port: " + PORT);
        while (true) {
            try (ServerCalculator server = new ServerCalculator();) {
                server.start(PORT);
                server.calculateSum();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
