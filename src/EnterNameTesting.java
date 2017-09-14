import javax.swing.*;

public class EnterNameTesting {
    public static void main(String args[]) {
        String name;
        name = JOptionPane.showInputDialog(null,
                "Enter a name");
        JOptionPane.showMessageDialog(null,"Hello, welcome to LightCycles player "+name);
        System.out.print(name);
    }
}