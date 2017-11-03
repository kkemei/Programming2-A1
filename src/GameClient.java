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
    private int bike2X = 20;
    private int bike2Y = 50;
    private int bike2W = 10;
    private int bike2H = 30;
    private int bike3X = 450;
    private int bike3Y = 400;
    private int bike3W = 10;
    private int bike3H = 30;
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
        } if (number == 2){
            g.setColor(Color.RED);
            g.fillRect(bikeX, bikeY, bikeW, bikeH);
            g.drawString(names[0],bikeX, bikeY);
            g.setColor(Color.blue);
            g.fillOval(bike2X, bike2Y, bike2W, bike2H);
            g.drawString(names[1],bike2X, bike2Y);
        } else {
            g.setColor(Color.RED);
            g.fillRect(bikeX, bikeY, bikeW, bikeH);
            g.drawString(names[0],bikeX, bikeY);
            g.setColor(Color.blue);
            g.fillOval(bike2X, bike2Y, bike2W, bike2H);
            g.drawString(names[1],bike2X, bike2Y);
            g.setColor(Color.GREEN);
            g.fillRoundRect(bike3X,bike3Y,bike3W,bike3H, 10,10);
            g.drawString(names[2],bike3X, bike3Y);
        }
        g.setColor(Color.RED);
        g.drawLine(250,250,bikeX,bikeY);
        g.setColor(Color.BLUE);
        g.drawLine(20,50,bike2X,bike2Y);
        g.setColor(Color.GREEN);
        g.drawLine(450,400,bike3X,bike3Y);

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
                    JOptionPane.showMessageDialog(null,"GAME OVER "+ names[0]);
                }
                if (bikeX == bike2X & bikeY == bike2Y || bikeX == bike3X & bikeY == bike3Y || bike2X == bike3X & bike2Y == bike3Y) {
                    JOptionPane.showMessageDialog(null,"GAME OVER. You Crashed");
                }
                break;
            case KeyEvent.VK_UP:
                bikeY -= 5;
                bikeW = 10;
                bikeH = 30;
                System.out.print("("+bikeX+","+bikeY+")");
                System.out.print(names[0]+" UP ("+bikeX+","+bikeY+")");

                if (bikeY < 0) {
                    JOptionPane.showMessageDialog(null,"GAME OVER "+ names[0]);
                }
                if (bikeX == bike2X & bikeY == bike2Y || bikeX == bike3X & bikeY == bike3Y || bike2X == bike3X & bike2Y == bike3Y) {
                    JOptionPane.showMessageDialog(null,"GAME OVER. You Crashed");
                }
                break;
            case KeyEvent.VK_LEFT:
                bikeX -= 5;
                bikeW = 30;
                bikeH = 10;
                System.out.print("("+bikeX+","+bikeY+")");
                System.out.print(names[0]+" LEFT ("+bikeX+","+bikeY+")");

                if (bikeX < 0) {
                    JOptionPane.showMessageDialog(null,"GAME OVER "+ names[0]);

                }
                if (bikeX == bike2X & bikeY == bike2Y || bikeX == bike3X & bikeY == bike3Y || bike2X == bike3X & bike2Y == bike3Y) {
                    JOptionPane.showMessageDialog(null,"GAME OVER. You Crashed");
                }
                break;
            case KeyEvent.VK_RIGHT:
                bikeX += 5;
                bikeW = 30;
                bikeH = 10;
                System.out.print("("+bikeX+","+bikeY+")");
                System.out.print(names[0]+" RIGHT ("+bikeX+","+bikeY+")");

                if (bikeX > 480) {
                    JOptionPane.showMessageDialog(null,"GAME OVER "+ names[0]);
                }
                if (bikeX == bike2X & bikeY == bike2Y || bikeX == bike3X & bikeY == bike3Y || bike2X == bike3X & bike2Y == bike3Y) {
                JOptionPane.showMessageDialog(null,"GAME OVER. You Crashed");
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
                if (bikeX == bike2X & bikeY == bike2Y || bikeX == bike3X & bikeY == bike3Y || bike2X == bike3X & bike2Y == bike3Y) {
                    JOptionPane.showMessageDialog(null,"GAME OVER. You Crashed");
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
                if (bikeX == bike2X & bikeY == bike2Y || bikeX == bike3X & bikeY == bike3Y || bike2X == bike3X & bike2Y == bike3Y) {
                    JOptionPane.showMessageDialog(null,"GAME OVER. You Crashed");
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
                if (bikeX == bike2X & bikeY == bike2Y || bikeX == bike3X & bikeY == bike3Y || bike2X == bike3X & bike2Y == bike3Y) {
                    JOptionPane.showMessageDialog(null,"GAME OVER. You Crashed");
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
                if (bikeX == bike2X & bikeY == bike2Y || bikeX == bike3X & bikeY == bike3Y || bike2X == bike3X & bike2Y == bike3Y) {
                    JOptionPane.showMessageDialog(null,"GAME OVER. You Crashed");
                }
                break;
            case KeyEvent.VK_K:
                bike3Y += 5;
                bike3W = 10;
                bike3H = 30;
                System.out.print("("+bike3X+","+bike3Y+")");
                System.out.print(names[2]+" DOWN ("+bike3X+","+bike3Y+")");

                if (bike3Y > 480) {
                    JOptionPane.showMessageDialog(null,"GAME OVER "+ names[2]);
                }
                if (bikeX == bike2X & bikeY == bike2Y || bikeX == bike3X & bikeY == bike3Y || bike2X == bike3X & bike2Y == bike3Y) {
                    JOptionPane.showMessageDialog(null,"GAME OVER. You Crashed");
                }
                break;
            case KeyEvent.VK_I:
                bike3Y -= 5;
                bike3W = 10;
                bike3H = 30;
                System.out.print("("+bike3X+","+bike3Y+")");
                System.out.print(names[2]+" UP ("+bike3X+","+bike3Y+")");

                if (bike3Y < 0) {
                    JOptionPane.showMessageDialog(null,"GAME OVER "+ names[2]);
                }
                if (bikeX == bike2X & bikeY == bike2Y || bikeX == bike3X & bikeY == bike3Y || bike2X == bike3X & bike2Y == bike3Y) {
                    JOptionPane.showMessageDialog(null,"GAME OVER. You Crashed");
                }
                break;
            case KeyEvent.VK_J:
                bike3X -= 5;
                bike3W = 30;
                bike3H = 10;
                System.out.print("("+bike3X+","+bike3Y+")");
                System.out.print(names[2]+" LEFT ("+bike3X+","+bike3Y+")");

                if (bike3X < 0) {
                    JOptionPane.showMessageDialog(null,"GAME OVER "+ names[2]);
                }
                if (bikeX == bike2X & bikeY == bike2Y || bikeX == bike3X & bikeY == bike3Y || bike2X == bike3X & bike2Y == bike3Y) {
                    JOptionPane.showMessageDialog(null,"GAME OVER. You Crashed");
                }
                break;
            case KeyEvent.VK_L:
                bike3X += 5;
                bike3W = 30;
                bike3H = 10;
                System.out.print("("+bike3X+","+bike3Y+")");
                System.out.print(names[2]+" RIGHT ("+bike3X+","+bike3Y+")");

                if (bike3X > 480) {
                    JOptionPane.showMessageDialog(null,"GAME OVER "+ names[2]);
                }
                if (bikeX == bike2X & bikeY == bike2Y || bikeX == bike3X & bikeY == bike3Y || bike2X == bike3X & bike2Y == bike3Y) {
                    JOptionPane.showMessageDialog(null,"GAME OVER. You Crashed");
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameClient ex = new GameClient();
        frame.getContentPane().add(ex);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        ex.requestFocus();
    }
}
