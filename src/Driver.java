import javax.swing.JFrame;

public class Driver {

    public Driver() {
        JFrame fr = new JFrame();
        GameArena gameArena = new GameArena();

        fr.add(gameArena);
        fr.setSize(500, 500);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);

        BallMovementCtrl ctrl = new BallMovementCtrl(gameArena, gameArena.ball);
        Thread t = new Thread(ctrl);
        t.start();
    }

    public static void main(String[] args) {
        new Driver();
    }
}