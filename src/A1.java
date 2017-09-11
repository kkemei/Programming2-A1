import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class A1 extends Canvas {

    private int bikeX = 250;
    private int bikeY = 250;
    int bikeW = 10;
    int bikeH = 30;

    public A1() {
        setSize(new Dimension(500, 500));
        setBackground(Color.BLACK);
        addKeyListener(new KeyAdapter() {
//            @Override
            public void keyPressed(KeyEvent evt) {
                KeyPressed(evt);
            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.fillRect(bikeX, bikeY, bikeW, bikeH);
    }

    private void KeyPressed(KeyEvent evt) {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                bikeY += 5;
                bikeW = 10;
                bikeH = 30;
                break;
            case KeyEvent.VK_UP:
                bikeY -= 5;
                bikeW = 10;
                bikeH = 30;
                break;
            case KeyEvent.VK_LEFT:
                bikeX -= 5;
                bikeW = 30;
                bikeH = 10;
                break;
            case KeyEvent.VK_RIGHT:
                bikeX += 5;
                bikeW = 30;
                bikeH = 10;
                break;
        }

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Light Cycles");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        A1 ex = new A1();
        frame.getContentPane().add(ex);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        ex.requestFocus();
    }
}