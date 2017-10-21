package ckup;//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.JFrame;
//
//public class HandlingEvents extends Canvas {
//
//    int myX = 400;
//    int myY = 400;
//
//    public HandlingEvents() {
//        setSize(new Dimension(500, 500));
//        addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent evt) {
//                KeyPressed(evt);
//            }
//        });
//    }
//
//    public void paint(Graphics g) {
//        g.fillOval(myX, myY, 30, 30);
//    }
//
//    public void KeyPressed(KeyEvent evt) {
//        switch (evt.getKeyCode()) {
//            case KeyEvent.VK_DOWN:
//                myY += 5;
//                break;
//            case KeyEvent.VK_UP:
//                myY -= 5;
//                break;
//            case KeyEvent.VK_LEFT:
//                myX -= 5;
//                break;
//            case KeyEvent.VK_RIGHT:
//                myX += 5;
//                break;
//        }
//
//        repaint();
//    }
//
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Light Cycles");
////        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        HandlingEvents ex = new HandlingEvents();
//        frame.getContentPane().add(ex);
//        frame.pack();
//        frame.setResizable(false);
//        frame.setVisible(true);
//        ex.requestFocus();
//    }
//}