import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class GameClient extends Canvas {

    private int bikeX = 250;
    private int bikeY = 250;
    private int bikeW = 10;
    private int bikeH = 30;
    String name = "Kip";

    public GameClient() {
        setSize(new Dimension(500, 500));
        setBackground(Color.BLACK);
        addKeyListener(new KeyAdapter() {
//            @Override
            public void keyPressed(KeyEvent evt) {
                KeyPressed(evt);
            }
        });
        Boundaries();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.fillRect(bikeX, bikeY, bikeW, bikeH);
        g.setColor(Color.blue);
        g.fillOval(bikeX, bikeY+10, bikeW, bikeH);
    }

    public void KeyPressed(KeyEvent evt) {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                bikeY += 5;
                bikeW = 10;
                bikeH = 30;
                System.out.print("("+bikeX+","+bikeY+")");
                System.out.print(name+" ("+bikeX+","+bikeY+")");
                break;
            case KeyEvent.VK_UP:
                bikeY -= 5;
                bikeW = 10;
                bikeH = 30;
                System.out.print("("+bikeX+","+bikeY+")");
                break;
            case KeyEvent.VK_LEFT:
                bikeX -= 5;
                bikeW = 30;
                bikeH = 10;
                System.out.print("("+bikeX+","+bikeY+")");

                if (bikeX < 0) {
                    JOptionPane.showMessageDialog(null,"GAME OVER");

                }

                break;
            case KeyEvent.VK_RIGHT:
                bikeX += 5;
                bikeW = 30;
                bikeH = 10;
                System.out.print("("+bikeX+","+bikeY+")");

                if (bikeX > 480) {
                    JOptionPane.showMessageDialog(null,"GAME OVER");
                }

                break;
        }

        repaint();
    }

    public void Boundaries(){
        if (bikeX < 0) {
            JOptionPane.showMessageDialog(null,"GAME OVER");
        }

    }

    private void EnterName() {
//        String name;
        name = JOptionPane.showInputDialog(null,
                "Enter a name");
        JOptionPane.showMessageDialog(null,"Hello, welcome to LightCycles "+name);
        System.out.print(name);
//        return name;
    }

    public static void main(String[] args) {
        new GameClient().EnterName();
        JFrame frame = new JFrame("Light Cycles");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameClient ex = new GameClient();
        frame.getContentPane().add(ex);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        ex.requestFocus();
    }
}
