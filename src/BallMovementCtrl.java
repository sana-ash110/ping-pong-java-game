import javax.swing.JOptionPane;

public class BallMovementCtrl implements Runnable {

    Ball ball;
    GameArena arena;
    int minX = 0, minY = 0;

    public BallMovementCtrl(GameArena arena, Ball ball) {
        this.arena = arena;
        this.ball = ball;
    }

    @Override
    public void run() {
        while (true) {
            int maxX = arena.getWidth() - 20;
            int maxY = arena.getHeight() - 20;

            // Bounce left/right walls
            if (ball.getx() <= minX || ball.getx() >= maxX) {
                ball.setXSpeed(ball.getXSpeed() * -1);
            }

            // Bounce top wall
            if (ball.gety() <= minY) {
                ball.setYSpeed(ball.getYSpeed() * -1);
            }

            // Ball missed paddle → Game Over
            if (ball.gety() > arena.getHeight()) {
                JOptionPane.showMessageDialog(arena, "Game Over");
                System.exit(0);
            }

            // Ball-paddle collision (only when falling)
            if (ball.getYSpeed() > 0 &&
                ball.gety() + 20 >= arena.paddle.y &&
                ball.getx() + 20 >= arena.paddle.x &&
                ball.getx() <= arena.paddle.x + arena.paddle.width) {

                ball.setYSpeed(ball.getYSpeed() * -1);
            }

            // Update ball position
            ball.setx(ball.getx() + ball.getXSpeed());
            ball.sety(ball.gety() + ball.getYSpeed());

            // Repaint panel
            arena.repaint();

            try {
                Thread.sleep(10);
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        }
    }
}