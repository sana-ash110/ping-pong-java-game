import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class GameArena extends JPanel {

    Ball ball;
    Paddle paddle;
    BallView ballView;
    PaddleView paddleView;

    int paddleWidth = 140;
    int paddleHeight = 20;

    public GameArena() {
        setFocusable(true);

        ball = new Ball(50, 50, 2, 2);

        // paddle x initialized at center, y will be updated dynamically
        int paddleX = 180;
        paddle = new Paddle(paddleX, 0, paddleWidth, paddleHeight);

        ballView = new BallView();
        paddleView = new PaddleView();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int step = 20;

                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    paddle.x -= step;
                    if (paddle.x < 0) paddle.x = 0;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    paddle.x += step;
                    if (paddle.x + paddle.width > getWidth())
                        paddle.x = getWidth() - paddle.width;
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Stick paddle to bottom dynamically
        paddle.y = getHeight() - paddle.height - 10;

        ballView.paint(g);
        paddleView.paint(g);
    }

    class BallView {
        int diameter = 20;

        void paint(Graphics g) {
            g.setColor(Color.RED);
            g.fillOval(ball.getx(), ball.gety(), diameter, diameter);
        }
    }

    class PaddleView {
        void paint(Graphics g) {
            g.setColor(Color.BLUE);
            g.fillRect(paddle.x, paddle.y, paddle.width, paddle.height);
        }
    }
}