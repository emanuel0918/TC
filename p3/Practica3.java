
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Practica3 extends JFrame {

    private JPanel contentPane;

    public Practica3() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setBounds(20, 20, 250, 210);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Practica3 programa = new Practica3();
                    String s_opc = "";
                    int opc = 0;
                    int q = 0;
                    do {
                        System.out.println("Automata de paridades de 0's y 1's");
                        System.out.
                                println("1)Generar cadena de manera manual");
                        System.out.
                                println("2)Generar cadena de manera aleatoria");
                        System.out.println("3)Salir");
                        s_opc = programa.scan();
                        try {
                            opc = Integer.parseInt(s_opc);
                        } catch (Exception ex) {
                            opc = 0;
                        }
                    } while (!(opc >= 1 && opc <= 3));
                    if (opc >= 1 && opc <= 2) {
                        programa.comand("rm estados.txt");
                        programa.comand("echo >> estados.txt");
                        try {
                            PrintWriter writer
                                    = new PrintWriter("estados.txt", "UTF-8");
                            writer.print("{ ");
                            if (opc == 1) {
                                char c = 0;
                                BufferedReader br
                                        = new BufferedReader(new InputStreamReader(System.in));
                                while (c != '\n') {
                                    try {
                                        c = (char) br.read();
                                        if (c != '\n') {
                                            writer.print("q" + q + " ");
                                            q = programa.automata(q, c);
                                        }
                                    } catch (java.io.IOException ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            }
                            if (opc == 2) {
                                char c = 0;
                                Random rand = new Random();
                                int random = rand.nextInt(1000000);
                                for (int i = 0; i < random; i++) {
                                    c = programa.random_01();
                                    writer.print("q" + q + " ");
                                    q = programa.automata(q, c);
                                    System.out.print(c);
                                }
                                System.out.println();
                            }
                            writer.println("q" + q + " }");
                            writer.close();
                        } catch (java.io.IOException ex) {
                            ex.printStackTrace();
                        }
                        if (q == 0) {
                            System.out.println("La cadena tiene paridad de 0's y 1's");
                        } else {
                            System.out.println("La cadena no tiene paridad de 0's y 1's");
                        }
                    }
                    programa.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        );
    }

    private int automata(int estado, char entrada) {
        switch (entrada) {
            case '0':
                switch (estado) {
                    case 0:
                        estado = 1;
                        break;
                    case 1:
                        estado = 0;
                        break;
                    case 2:
                        estado = 3;
                        break;
                    case 3:
                        estado = 2;
                        break;
                }
                break;
            case '1':
                switch (estado) {
                    case 0:
                        estado = 2;
                        break;
                    case 1:
                        estado = 3;
                        break;
                    case 2:
                        estado = 0;
                        break;
                    case 3:
                        estado = 1;
                        break;
                }
                break;
        }
        return estado;
    }

    private char random_01() {
        Random rand = new Random();
        return (char) (rand.nextInt(2) + 48);
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.black);
        g.drawLine(8, 107, 20, 107);
        g.drawLine(16, 103, 20, 107);
        g.drawLine(16, 110, 20, 107);
        //estado q0
        g.drawOval(21, 84, 50, 50);
        g.drawOval(26, 89, 40, 40);
        g.drawString("q0", 39, 114);
        //arista de q0 a q1
        g.drawLine(70, 101, 106, 80);
        g.drawLine(104, 85, 106, 80);
        g.drawLine(101, 80, 106, 80);
        g.drawString("0", 94, 99);
        //arista de q0 a q2
        g.drawLine(67, 120, 102, 131);
        g.drawLine(99, 127, 102, 131);
        g.drawLine(97, 133, 102, 131);
        g.drawString("1", 84, 122);
        //estado q1
        g.drawOval(99, 39, 50, 50);
        g.drawString("q1", 118, 65);
        //arista de q1 a q0
        g.drawLine(60, 90, 99, 71);
        g.drawLine(66, 90, 60, 90);
        g.drawLine(61, 83, 60, 90);
        g.drawString("0", 72, 72);
        //arista de q1 a q3
        g.drawLine(148, 69, 190, 89);
        g.drawLine(181, 90, 190, 89);
        g.drawLine(185, 84, 190, 89);
        g.drawString("1", 170, 70);
        //estado q2
        g.drawOval(99, 120, 50, 50);
        g.drawString("q2", 116, 153);
        //arista de q2 a q0
        g.drawLine(60, 129, 99, 143);
        g.drawLine(60, 129, 63, 134);
        g.drawLine(60, 129, 66, 128);
        g.drawString("1", 74, 150);
        //arista de q2 a q3
        g.drawLine(185, 123, 148, 140);
        g.drawLine(185, 123, 182, 129);
        g.drawLine(185, 123, 178, 121);
        g.drawString("0", 174, 147);
        //estado q3
        g.drawOval(180, 84, 50, 50);
        g.drawString("q3", 200, 114);
        //arista de q3 a q2
        g.drawLine(181, 114, 144, 131);
        g.drawLine(151, 133, 144, 131);
        g.drawLine(147, 127, 144, 131);
        g.drawString("1", 155, 119);
        //arista de q3 a q1
        g.drawLine(182, 98, 145, 77);
        g.drawLine(147, 83, 145, 77);
        g.drawLine(152, 76, 145, 77);
        g.drawString("0", 158, 100);
    }

    private void comand(String cmd) {
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader stdInput
                    = new BufferedReader(new InputStreamReader(p.getInputStream()));
        } catch (java.io.IOException ex) {
            ex.printStackTrace();
        }
    }

    private String scan() {
        String scan = "";
        char c = 0;
        BufferedReader br
                = new BufferedReader(new InputStreamReader(System.in));
        while (c != '\n') {
            try {
                c = (char) br.read();
                if (c != '\n') {
                    scan += c;
                }
            } catch (java.io.IOException ex) {
                ex.printStackTrace();
            }
        }
        return scan;
    }
}
