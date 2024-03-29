import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

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
    private int number;

    private final static String INET_ADDR = "224.0.0.3";
    private final static int PORT = 8888;


    private GameClient() throws UnknownHostException, InterruptedException{
        String numOfPlayers;
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
            public void keyPressed(KeyEvent evt) {
                try {
                    KeyPressed(evt);
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (number == 1) {
            g.setColor(Color.RED);
            g.fillRect(bikeX, bikeY, bikeW, bikeH);
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

    private void KeyPressed(KeyEvent evt) throws UnknownHostException, InterruptedException {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                bikeY += 5;
                bikeW = 10;
                bikeH = 30;
//                System.out.print(names[0]+" DOWN ("+bikeX+","+bikeY+")");
                if (bikeY > 480) {
                    JOptionPane.showMessageDialog(null,"GAME OVER "+ names[0]);
                }
                if (bikeX == bike2X & bikeY == bike2Y || bikeX == bike3X & bikeY == bike3Y || bike2X == bike3X & bike2Y == bike3Y) {
                    JOptionPane.showMessageDialog(null,"GAME OVER. You Crashed");
                }
                InetAddress addr = InetAddress.getByName(INET_ADDR);
                try (DatagramSocket serverSocket = new DatagramSocket()) {
                        String msg = names[0]+" DOWN ("+bikeX+","+bikeY+")";
                        DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(),
                                msg.getBytes().length, addr, PORT);
                        serverSocket.send(msgPacket);
                        System.out.println("Client sent packet with msg: " + msg);
                        Thread.sleep(1);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case KeyEvent.VK_UP:
                bikeY -= 5;
                bikeW = 10;
                bikeH = 30;
//                System.out.print(names[0]+" UP ("+bikeX+","+bikeY+")");
                if (bikeY < 0) {
                    JOptionPane.showMessageDialog(null,"GAME OVER "+ names[0]);
                }
                if (bikeX == bike2X & bikeY == bike2Y || bikeX == bike3X & bikeY == bike3Y || bike2X == bike3X & bike2Y == bike3Y) {
                    JOptionPane.showMessageDialog(null,"GAME OVER. You Crashed");
                }
                InetAddress addr2 = InetAddress.getByName(INET_ADDR);
                try (DatagramSocket serverSocket = new DatagramSocket()) {
                        String msg = names[0]+" UP ("+bikeX+","+bikeY+")";
                        DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(),
                                msg.getBytes().length, addr2, PORT);
                        serverSocket.send(msgPacket);
                        System.out.println("Client sent packet with msg: " + msg);
                        Thread.sleep(10);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case KeyEvent.VK_LEFT:
                bikeX -= 5;
                bikeW = 30;
                bikeH = 10;
//                System.out.print(names[0]+" LEFT ("+bikeX+","+bikeY+")");
                if (bikeX < 0) {
                    JOptionPane.showMessageDialog(null,"GAME OVER "+ names[0]);
                }
                if (bikeX == bike2X & bikeY == bike2Y || bikeX == bike3X & bikeY == bike3Y || bike2X == bike3X & bike2Y == bike3Y) {
                    JOptionPane.showMessageDialog(null,"GAME OVER. You Crashed");
                }
                InetAddress addr3 = InetAddress.getByName(INET_ADDR);
                try (DatagramSocket serverSocket = new DatagramSocket()) {
                        String msg = names[0]+" LEFT ("+bikeX+","+bikeY+")";
                        DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(),
                                msg.getBytes().length, addr3, PORT);
                        serverSocket.send(msgPacket);
                        System.out.println("Client sent packet with msg: " + msg);
                        Thread.sleep(10);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case KeyEvent.VK_RIGHT:
                bikeX += 5;
                bikeW = 30;
                bikeH = 10;
//                System.out.print(names[0]+" RIGHT ("+bikeX+","+bikeY+")");
                if (bikeX > 480) {
                    JOptionPane.showMessageDialog(null,"GAME OVER "+ names[0]);
                }
                if (bikeX == bike2X & bikeY == bike2Y || bikeX == bike3X & bikeY == bike3Y || bike2X == bike3X & bike2Y == bike3Y) {
                JOptionPane.showMessageDialog(null,"GAME OVER. You Crashed");
                }
                InetAddress addr4 = InetAddress.getByName(INET_ADDR);
                try (DatagramSocket serverSocket = new DatagramSocket()) {
                        String msg = names[0]+" RIGHT ("+bikeX+","+bikeY+")";
                        DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(),
                                msg.getBytes().length, addr4, PORT);
                        serverSocket.send(msgPacket);
                        System.out.println("Client sent packet with msg: " + msg);
                        Thread.sleep(10);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case KeyEvent.VK_S:
                bike2Y += 5;
                bike2W = 10;
                bike2H = 30;
//                System.out.print(names[1]+" DOWN ("+bike2X+","+bike2Y+")");
                if (bike2Y > 480) {
                    JOptionPane.showMessageDialog(null,"GAME OVER "+ names[1]);
                }
                if (bikeX == bike2X & bikeY == bike2Y || bikeX == bike3X & bikeY == bike3Y || bike2X == bike3X & bike2Y == bike3Y) {
                    JOptionPane.showMessageDialog(null,"GAME OVER. You Crashed");
                }
                InetAddress addr5 = InetAddress.getByName(INET_ADDR);
                try (DatagramSocket serverSocket = new DatagramSocket()) {
                        String msg = names[1]+" DOWN ("+bikeX+","+bikeY+")";
                        DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(),
                                msg.getBytes().length, addr5, PORT);
                        serverSocket.send(msgPacket);
                        System.out.println("Client sent packet with msg: " + msg);
                        Thread.sleep(10);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case KeyEvent.VK_W:
                bike2Y -= 5;
                bike2W = 10;
                bike2H = 30;
//                System.out.print(names[1]+" UP ("+bike2X+","+bike2Y+")");
                if (bike2Y < 0) {
                    JOptionPane.showMessageDialog(null,"GAME OVER "+ names[1]);
                }
                if (bikeX == bike2X & bikeY == bike2Y || bikeX == bike3X & bikeY == bike3Y || bike2X == bike3X & bike2Y == bike3Y) {
                    JOptionPane.showMessageDialog(null,"GAME OVER. You Crashed");
                }
                InetAddress addr6 = InetAddress.getByName(INET_ADDR);
                try (DatagramSocket serverSocket = new DatagramSocket()) {
                    String msg = names[1]+" UP ("+bikeX+","+bikeY+")";
                    DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(),
                            msg.getBytes().length, addr6, PORT);
                    serverSocket.send(msgPacket);
                    System.out.println("Client sent packet with msg: " + msg);
                    Thread.sleep(10);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case KeyEvent.VK_A:
                bike2X -= 5;
                bike2W = 30;
                bike2H = 10;
//                System.out.print(names[1]+" LEFT ("+bike2X+","+bike2Y+")");
                if (bike2X < 0) {
                    JOptionPane.showMessageDialog(null,"GAME OVER "+ names[1]);
                }
                if (bikeX == bike2X & bikeY == bike2Y || bikeX == bike3X & bikeY == bike3Y || bike2X == bike3X & bike2Y == bike3Y) {
                    JOptionPane.showMessageDialog(null,"GAME OVER. You Crashed");
                }
                InetAddress addr7 = InetAddress.getByName(INET_ADDR);
                try (DatagramSocket serverSocket = new DatagramSocket()) {
                    String msg = names[1]+" LEFT ("+bikeX+","+bikeY+")";
                    DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(),
                            msg.getBytes().length, addr7, PORT);
                    serverSocket.send(msgPacket);
                    System.out.println("Client sent packet with msg: " + msg);
                    Thread.sleep(10);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case KeyEvent.VK_D:
                bike2X += 5;
                bike2W = 30;
                bike2H = 10;
//                System.out.print(names[1]+" Right ("+bike2X+","+bike2Y+")");
                if (bike2X > 480) {
                    JOptionPane.showMessageDialog(null,"GAME OVER "+ names[1]);
                }
                if (bikeX == bike2X & bikeY == bike2Y || bikeX == bike3X & bikeY == bike3Y || bike2X == bike3X & bike2Y == bike3Y) {
                    JOptionPane.showMessageDialog(null,"GAME OVER. You Crashed");
                }
                InetAddress addr8 = InetAddress.getByName(INET_ADDR);
                try (DatagramSocket serverSocket = new DatagramSocket()) {
                    String msg = names[1]+" RIGHT ("+bikeX+","+bikeY+")";
                    DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(),
                            msg.getBytes().length, addr8, PORT);
                    serverSocket.send(msgPacket);
                    System.out.println("Client sent packet with msg: " + msg);
                    Thread.sleep(10);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case KeyEvent.VK_K:
                bike3Y += 5;
                bike3W = 10;
                bike3H = 30;
//                System.out.print(names[2]+" DOWN ("+bike3X+","+bike3Y+")");
                if (bike3Y > 480) {
                    JOptionPane.showMessageDialog(null,"GAME OVER "+ names[2]);
                }
                if (bikeX == bike2X & bikeY == bike2Y || bikeX == bike3X & bikeY == bike3Y || bike2X == bike3X & bike2Y == bike3Y) {
                    JOptionPane.showMessageDialog(null,"GAME OVER. You Crashed");
                }
                InetAddress addr9 = InetAddress.getByName(INET_ADDR);
                try (DatagramSocket serverSocket = new DatagramSocket()) {
                    String msg = names[2]+" DOWN ("+bikeX+","+bikeY+")";
                    DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(),
                            msg.getBytes().length, addr9, PORT);
                    serverSocket.send(msgPacket);
                    System.out.println("Client sent packet with msg: " + msg);
                    Thread.sleep(10);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case KeyEvent.VK_I:
                bike3Y -= 5;
                bike3W = 10;
                bike3H = 30;
//                System.out.print(names[2]+" UP ("+bike3X+","+bike3Y+")");
                if (bike3Y < 0) {
                    JOptionPane.showMessageDialog(null,"GAME OVER "+ names[2]);
                }
                if (bikeX == bike2X & bikeY == bike2Y || bikeX == bike3X & bikeY == bike3Y || bike2X == bike3X & bike2Y == bike3Y) {
                    JOptionPane.showMessageDialog(null,"GAME OVER. You Crashed");
                }
                InetAddress addr10 = InetAddress.getByName(INET_ADDR);
                try (DatagramSocket serverSocket = new DatagramSocket()) {
                    String msg = names[2]+" UP ("+bikeX+","+bikeY+")";
                    DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(),
                            msg.getBytes().length, addr10, PORT);
                    serverSocket.send(msgPacket);
                    System.out.println("Client sent packet with msg: " + msg);
                    Thread.sleep(10);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case KeyEvent.VK_J:
                bike3X -= 5;
                bike3W = 30;
                bike3H = 10;
//                System.out.print(names[2]+" LEFT ("+bike3X+","+bike3Y+")");
                if (bike3X < 0) {
                    JOptionPane.showMessageDialog(null,"GAME OVER "+ names[2]);
                }
                if (bikeX == bike2X & bikeY == bike2Y || bikeX == bike3X & bikeY == bike3Y || bike2X == bike3X & bike2Y == bike3Y) {
                    JOptionPane.showMessageDialog(null,"GAME OVER. You Crashed");
                }
                InetAddress addr11 = InetAddress.getByName(INET_ADDR);
                try (DatagramSocket serverSocket = new DatagramSocket()) {
                    String msg = names[2]+" LEFT ("+bikeX+","+bikeY+")";
                    DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(),
                            msg.getBytes().length, addr11, PORT);
                    serverSocket.send(msgPacket);
                    System.out.println("Client sent packet with msg: " + msg);
                    Thread.sleep(10);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case KeyEvent.VK_L:
                bike3X += 5;
                bike3W = 30;
                bike3H = 10;
//                System.out.print(names[2]+" RIGHT ("+bike3X+","+bike3Y+")");
                if (bike3X > 480) {
                    JOptionPane.showMessageDialog(null,"GAME OVER "+ names[2]);
                }
                if (bikeX == bike2X & bikeY == bike2Y || bikeX == bike3X & bikeY == bike3Y || bike2X == bike3X & bike2Y == bike3Y) {
                    JOptionPane.showMessageDialog(null,"GAME OVER. You Crashed");
                }
                InetAddress addr12 = InetAddress.getByName(INET_ADDR);
                try (DatagramSocket serverSocket = new DatagramSocket()) {
                    String msg = names[2]+" RIGHT ("+bikeX+","+bikeY+")";
                    DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(),
                            msg.getBytes().length, addr12, PORT);
                    serverSocket.send(msgPacket);
                    System.out.println("Client sent packet with msg: " + msg);
                    Thread.sleep(10);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
        }
        repaint();
    }

    public static void main(String[] args) throws InterruptedException, UnknownHostException {
        JFrame frame = new JFrame("Light Cycles");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        GameClient ex = new GameClient() ;
        frame.getContentPane().add(ex);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        ex.requestFocus();
    }
}
