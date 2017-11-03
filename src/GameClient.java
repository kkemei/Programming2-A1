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
    private int bike2X = 25;
    private int bike2Y = 50;
    private int bike2W = 10;
    private int bike2H = 30;
//    String name = "Kip";
    private String [] names = new String[21];
    private String numOfPlayers;
    private int number;


    private GameClient() {

        numOfPlayers = JOptionPane.showInputDialog(null,
                "How many players (no more than 22)");
        number =  Integer.parseInt(numOfPlayers);
        for (int i = 0; i < number;
             i++) {
            names[i] = JOptionPane.showInputDialog(null,
                    "Enter players name");
            JOptionPane.showMessageDialog(null, "Hello, welcome to LightCycles " + names[i]);
            System.out.print(names[i]);

        setSize(new Dimension(500, 500));
        setBackground(Color.BLACK);
        addKeyListener(new KeyAdapter() {
//            @Override
            public void keyPressed(KeyEvent evt) {
                KeyPressed(evt);
            }
        });
//        Boundaries();
    }}

    public void paint(Graphics g) {
        super.paint(g);
        if (number == 1) {
            g.setColor(Color.RED);
            g.fillRect(bikeX, bikeY, bikeW, bikeH);
//            g.drawLine(bikeX,bikeY,bike2X,bike2Y);
            g.drawString(names[0],bikeX, bikeY);
        } else {
            g.setColor(Color.RED);
            g.fillRect(bikeX, bikeY, bikeW, bikeH);
            g.drawString(names[0],bikeX, bikeY);
            g.setColor(Color.blue);
            g.fillOval(bike2X, bike2Y, bike2W, bike2H);
            g.drawString(names[1],bike2X, bike2Y);
        }
        g.setColor(Color.RED);
        g.drawLine(250,250,bikeX,bikeY);
        g.setColor(Color.BLUE);
        g.drawLine(25,50,bike2X,bike2Y);

    }

    public void KeyPressed(KeyEvent evt) {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                bikeY += 5;
                bikeW = 10;
                bikeH = 30;

                System.out.print("("+bikeX+","+bikeY+")");
                System.out.print(names[0]+" DOWN ("+bikeX+","+bikeY+")");

                if (bikeY > 480) {
                    JOptionPane.showMessageDialog(null,"GAME OVER");
                }
                break;
            case KeyEvent.VK_UP:
                bikeY -= 5;
                bikeW = 10;
                bikeH = 30;
                System.out.print("("+bikeX+","+bikeY+")");
                System.out.print(names[0]+" UP ("+bikeX+","+bikeY+")");

                if (bikeY < 0) {
                    JOptionPane.showMessageDialog(null,"GAME OVER");
                }
                break;
            case KeyEvent.VK_LEFT:
                bikeX -= 5;
                bikeW = 30;
                bikeH = 10;
                System.out.print("("+bikeX+","+bikeY+")");
                System.out.print(names[0]+" LEFT ("+bikeX+","+bikeY+")");

                if (bikeX < 0) {
                    JOptionPane.showMessageDialog(null,"GAME OVER");

                }

                break;
            case KeyEvent.VK_RIGHT:
                bikeX += 5;
                bikeW = 30;
                bikeH = 10;
                System.out.print("("+bikeX+","+bikeY+")");
                System.out.print(names[0]+" RIGHT ("+bikeX+","+bikeY+")");

                if (bikeX > 480) {
                    JOptionPane.showMessageDialog(null,"GAME OVER");
                }

                break;
            case KeyEvent.VK_S:
                bike2Y += 5;
                bike2W = 10;
                bike2H = 30;
                System.out.print("("+bike2X+","+bike2Y+")");
                System.out.print(names[1]+" DOWN ("+bike2X+","+bike2Y+")");

                if (bike2Y > 480) {
                    JOptionPane.showMessageDialog(null,"GAME OVER "+ names[1]);
                }
                break;
            case KeyEvent.VK_W:
                bike2Y -= 5;
                bike2W = 10;
                bike2H = 30;
                System.out.print("("+bike2X+","+bike2Y+")");
                System.out.print(names[1]+" UP ("+bike2X+","+bike2Y+")");

                if (bike2Y < 0) {
                    JOptionPane.showMessageDialog(null,"GAME OVER "+ names[1]);
                }
                break;
            case KeyEvent.VK_A:
                bike2X -= 5;
                bike2W = 30;
                bike2H = 10;
                System.out.print("("+bike2X+","+bike2Y+")");
                System.out.print(names[1]+" LEFT ("+bike2X+","+bike2Y+")");

                if (bike2X < 0) {
                    JOptionPane.showMessageDialog(null,"GAME OVER "+ names[1]);
                }
                break;
            case KeyEvent.VK_D:
                bike2X += 5;
                bike2W = 30;
                bike2H = 10;
                System.out.print("("+bike2X+","+bike2Y+")");
                System.out.print(names[1]+" Right ("+bike2X+","+bike2Y+")");

                if (bike2X > 480) {
                    JOptionPane.showMessageDialog(null,"GAME OVER "+ names[1]);
                }
                break;
        }

        repaint();
    }

//    public void Boundaries(){
//        if (bikeX < 0) {
//            JOptionPane.showMessageDialog(null,"GAME OVER");
//        }
//
//    }

//    public void EnterName() {
////        String name;
//        name = JOptionPane.showInputDialog(null,
//                "Enter a name");
//        JOptionPane.showMessageDialog(null,"Hello, welcome to LightCycles "+name);
//        System.out.print(name);
////        return name;


//        numOfPlayers = JOptionPane.showInputDialog(null,
//                "How many players (no more than 22)");
//        number =  Integer.parseInt(numOfPlayers);
//        for (int i = 0; i < number;
//             i++) {
//            names[i] = JOptionPane.showInputDialog(null,
//                    "Enter players name");
//            JOptionPane.showMessageDialog(null, "Hello, welcome to LightCycles " + names[i]);
//            System.out.print(names[i]);
//            return;
//    }}

    public static void main(String[] args) {
//        new GameClient().EnterName();

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
