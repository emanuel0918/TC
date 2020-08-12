import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

    private JPanel contentPane;

    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setBounds(90, 30, 1000, 470);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Automata7 automata = new Automata7();

        String s_opc = "";
        int opc = 0;
        do {
            System.out.println("Ajedrez");
            System.out.
                    println("1)Generar cadena de manera manual");
            System.out.
                    println("2)Generar cadena de manera aleatoria");
            System.out.println("3)Salir");
            s_opc = automata.scan();
            try {
                opc = Integer.parseInt(s_opc);
            } catch (Exception ex) {
                opc = 0;
            }
        } while (!(opc >= 1 && opc <= 3));
        if (opc >= 1 && opc <= 2) {
            if (opc == 1) {
                char c = 0;
                BufferedReader br
                        = new BufferedReader(new InputStreamReader(System.in));
                while (c != '\n') {
                    try {
                        c = (char) br.read();
                        if (c != '\n') {
                            automata.analizar(c);
                            automata.analizar2(c);
                        }
                    } catch (java.io.IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
            if (opc == 2) {
                char c = 0;
                Random rand = new Random();
                int random = rand.nextInt(10);
                for (int i = 0; i < random; i++) {
                    c = automata.random_RB();
                    automata.analizar(c);
                    automata.analizar2(c);
                    System.out.print(c);
                }
                System.out.println();
            }
        }
        int numero = automata.finalizar();
        int numero2 = automata.finalizar2();
        if (numero > 0 ) {
            /*if (automata.jugadas()) {
                Ajedrez run = new Ajedrez();
                run.setVisible(true);
                run.setFicha(0, 0);
                run.setFicha(1, 1);
                run.repaint();
                run.esperar(1.5f);
                for (int j = 0; j < automata.jugadas[0].size() - 1; j++) {
                    run.setFicha(automata.jugadas[0].get(j) - 1, 0);
                    run.setFicha(automata.jugadas[1].get(j) - 1, 1);
                    run.repaint();
                    run.esperar(1.5f);
                }

                run.ganar();
            } else {
                System.out.println("Las jugadas se intersectan");
                System.exit(0);
            }*/
            automata.jugada1();
            Ajedrez ajedrez1 = new Ajedrez();
            ajedrez1.setVisible(true);
            ajedrez1.setFicha(0, 0);
            ajedrez1.repaint();
            ajedrez1.esperar(1.5f);
            for (int j = 0; j < automata.jugadas[0].size() - 1; j++) {
                ajedrez1.setFicha(automata.jugadas[0].get(j) - 1, 0);
                ajedrez1.repaint();
                ajedrez1.esperar(1.5f);
            }

            ajedrez1.ganar();
        }
        
        if (numero2 > 0 ) {
            automata.jugada2();
            Ajedrez ajedrez2 = new Ajedrez();
            ajedrez2.setVisible(true);
            ajedrez2.setFicha(1, 1);
            ajedrez2.repaint();
            ajedrez2.esperar(1.5f);
            for (int j = 0; j < automata.jugadas[1].size() - 1; j++) {
                ajedrez2.setFicha(automata.jugadas[1].get(j) - 1, 1);
                ajedrez2.repaint();
                ajedrez2.esperar(1.5f);
            }

            ajedrez2.ganar();
        }
            System.exit(0);
    }

    //Grafos
    public void paint(Graphics g) {
        super.paint(g);

        //GrafoAjedrez
        //-------------**********************---------------
        g.setColor(Color.black);
        g.drawLine(104, 91, 121, 91);
        g.drawLine(117, 87, 121, 91);
        g.drawLine(117, 95, 121, 91);
        g.drawString("start", 69, 95);
        //estado q1
        g.drawOval(122, 66, 50, 50);
        g.drawString("q1", 141, 95);
        //arista de q1 a q2
        g.drawLine(172, 85, 222, 85);
        g.drawLine(177, 81, 172, 85);
        g.drawLine(177, 89, 172, 85);
        g.drawString("b", 195, 80);
        //arista de q2 a q1
        g.drawLine(172, 97, 222, 97);
        g.drawLine(217, 93, 222, 97);
        g.drawLine(217, 101, 222, 97);
        g.drawString("r", 195, 112);
        //arista de q1 a q4
        g.drawLine(141, 116, 141, 182);
        g.drawLine(137, 177, 141, 182);
        g.drawLine(145, 177, 141, 182);
        g.drawString("r", 127, 151);
        //arista de q4 a q1
        g.drawLine(153, 116, 153, 182);
        g.drawLine(149, 121, 153, 116);
        g.drawLine(157, 121, 153, 116);
        g.drawString("b", 160, 151);
        //arista de q5 a q1
        g.drawArc(11, 97, 220, 220, 9, 57);
        g.drawLine(170, 114, 168, 107);
        g.drawLine(174, 107, 168, 107);
        g.drawString("b", 207, 134);
        //arista de q1 a q5
        g.drawArc(160, -18, 220, 220, 190, 56);
        g.drawLine(219, 194, 226, 192);
        g.drawLine(223, 186, 226, 192);
        g.drawString("b", 175, 171);
        //arista de q2 a q4
        g.drawArc(159, 95, 220, 220, 113, 57);
        g.drawLine(166, 181, 161, 186);
        g.drawLine(158, 179, 160, 186);
        g.drawString("r", 178, 132);
        //arista de q4 a q2
        g.drawArc(14, -20, 220, 220, 293, 56);
        g.drawLine(235, 118, 232, 112);
        g.drawLine(227, 116, 232, 112);
        g.drawString("r", 210, 174);
        //estado q2
        g.drawOval(222, 66, 50, 50);
        g.drawString("q2", 241, 95);
        //arista de q2 a q3
        g.drawLine(272, 85, 322, 85);
        g.drawLine(277, 81, 272, 85);
        g.drawLine(277, 89, 272, 85);
        g.drawString("r", 295, 80);
        //arista de q3 a q2
        g.drawLine(272, 97, 322, 97);
        g.drawLine(317, 93, 322, 97);
        g.drawLine(317, 101, 322, 97);
        g.drawString("b", 295, 112);
        //arista de q2 a q5
        g.drawLine(241, 116, 241, 182);
        g.drawLine(237, 177, 241, 182);
        g.drawLine(245, 177, 241, 182);
        g.drawString("b", 227, 151);
        //arista de q5 a q2
        g.drawLine(253, 116, 253, 182);
        g.drawLine(249, 121, 253, 116);
        g.drawLine(257, 121, 253, 116);
        g.drawString("r", 260, 151);
        //arista de q6 a q2
        g.drawArc(111, 97, 220, 220, 9, 57);
        g.drawLine(270, 114, 268, 107);
        g.drawLine(274, 107, 268, 107);
        g.drawString("r", 307, 134);
        //arista de q2 a q6
        g.drawArc(260, -18, 220, 220, 190, 56);
        g.drawLine(319, 194, 326, 192);
        g.drawLine(323, 186, 326, 192);
        g.drawString("r", 275, 171);
        //arista de q3 a q5
        g.drawArc(259, 95, 220, 220, 113, 57);
        g.drawLine(266, 181, 261, 186);
        g.drawLine(258, 179, 260, 186);
        g.drawString("b", 278, 132);
        //arista de q5 a q3
        g.drawArc(114, -20, 220, 220, 293, 56);
        g.drawLine(335, 118, 332, 112);
        g.drawLine(327, 116, 332, 112);
        g.drawString("b", 310, 174);
        //arista de q3 a q6
        g.drawLine(341, 116, 341, 182);
        g.drawLine(337, 177, 341, 182);
        g.drawLine(345, 177, 341, 182);
        g.drawString("r", 327, 151);
        //arista de q6 a q3
        g.drawLine(353, 116, 353, 182);
        g.drawLine(349, 121, 353, 116);
        g.drawLine(357, 121, 353, 116);
        g.drawString("b", 360, 151);
        //estado q3
        g.drawOval(322, 66, 50, 50);
        g.drawString("q3", 341, 95);
        //estado q4
        g.drawOval(122, 182, 50, 50);
        g.drawString("q4", 141, 211);
        //arista de q4 a q7
        g.drawLine(141, 232, 141, 298);
        g.drawLine(137, 293, 141, 298);
        g.drawLine(145, 293, 141, 298);
        g.drawString("b", 127, 267);
        //arista de q7 a q4
        g.drawLine(153, 232, 153, 298);
        g.drawLine(149, 237, 153, 232);
        g.drawLine(157, 237, 153, 232);
        g.drawString("r", 160, 267);
        //arista de q8 a q4
        g.drawArc(11, 213, 220, 220, 9, 57);
        g.drawLine(170, 230, 168, 223);
        g.drawLine(174, 223, 168, 223);
        g.drawString("r", 207, 250);
        //arista de q4 a q8
        g.drawArc(160, 98, 220, 220, 190, 56);
        g.drawLine(219, 310, 226, 308);
        g.drawLine(223, 302, 226, 308);
        g.drawString("r", 175, 287);
        //arista de q5 a q7
        g.drawArc(159, 211, 220, 220, 113, 57);
        g.drawLine(166, 297, 161, 302);
        g.drawLine(158, 295, 160, 302);
        g.drawString("b", 178, 248);
        //arista de q7 a q5
        g.drawArc(14, 96, 220, 220, 293, 56);
        g.drawLine(235, 234, 232, 228);
        g.drawLine(227, 232, 232, 228);
        g.drawString("b", 210, 290);
        //arista de q5 a q8
        g.drawLine(241, 232, 241, 298);
        g.drawLine(237, 293, 241, 298);
        g.drawLine(245, 293, 241, 298);
        g.drawString("r", 227, 267);
        //arista de q8 a q5
        g.drawLine(253, 232, 253, 298);
        g.drawLine(249, 237, 253, 232);
        g.drawLine(257, 237, 253, 232);
        g.drawString("b", 260, 267);
        //arista de q9 a q5
        g.drawArc(111, 213, 220, 220, 9, 57);
        g.drawLine(270, 230, 268, 223);
        g.drawLine(274, 223, 268, 223);
        g.drawString("b", 307, 250);
        //arista de q5 a q9
        g.drawArc(260, 98, 220, 220, 190, 56);
        g.drawLine(319, 310, 326, 308);
        g.drawLine(323, 302, 326, 308);
        g.drawString("b", 275, 287);
        //arista de q6 a q8
        g.drawArc(259, 211, 220, 220, 113, 57);
        g.drawLine(266, 297, 261, 302);
        g.drawLine(258, 295, 260, 302);
        g.drawString("r", 278, 248);
        //arista de q8 a q6
        g.drawArc(114, 96, 220, 220, 293, 56);
        g.drawLine(335, 234, 332, 228);
        g.drawLine(327, 232, 332, 228);
        g.drawString("r", 310, 290);
        //arista de q6 a q9
        g.drawLine(341, 232, 341, 298);
        g.drawLine(337, 293, 341, 298);
        g.drawLine(345, 293, 341, 298);
        g.drawString("b", 327, 267);
        //arista de q9 a q6
        g.drawLine(353, 232, 353, 298);
        g.drawLine(349, 237, 353, 232);
        g.drawLine(357, 237, 353, 232);
        g.drawString("r", 360, 267);
        //arista de q5 a q4
        g.drawLine(172, 201, 222, 201);
        g.drawLine(177, 197, 172, 201);
        g.drawLine(177, 205, 172, 201);
        g.drawString("r", 195, 196);
        //arista de q4 a q5
        g.drawLine(172, 213, 222, 213);
        g.drawLine(217, 209, 222, 213);
        g.drawLine(217, 217, 222, 213);
        g.drawString("b", 195, 228);
        //estado q5
        g.drawOval(222, 182, 50, 50);
        g.drawString("q5", 241, 211);
        //arista de q6 a q5
        g.drawLine(272, 201, 322, 201);
        g.drawLine(277, 197, 272, 201);
        g.drawLine(277, 205, 272, 201);
        g.drawString("b", 295, 196);
        //arista de q5 a q6
        g.drawLine(272, 213, 322, 213);
        g.drawLine(317, 209, 322, 213);
        g.drawLine(317, 217, 322, 213);
        g.drawString("r", 295, 228);
        //estado q6
        g.drawOval(322, 182, 50, 50);
        g.drawString("q6", 341, 211);
        //estado q7
        g.drawOval(122, 298, 50, 50);
        g.drawString("q7", 141, 327);
        //arista de q7 a q8
        g.drawLine(172, 317, 222, 317);
        g.drawLine(177, 313, 172, 317);
        g.drawLine(177, 321, 172, 317);
        g.drawString("b", 195, 312);
        //arista de q8 a q7
        g.drawLine(172, 329, 222, 329);
        g.drawLine(217, 325, 222, 329);
        g.drawLine(217, 333, 222, 329);
        g.drawString("r", 195, 344);
        //estado q8
        g.drawOval(222, 298, 50, 50);
        g.drawString("q8", 241, 327);
        //arista de q8 a q9
        g.drawLine(272, 317, 322, 317);
        g.drawLine(277, 313, 272, 317);
        g.drawLine(277, 321, 272, 317);
        g.drawString("r", 295, 312);
        //arista de q9 a q8
        g.drawLine(272, 329, 322, 329);
        g.drawLine(317, 325, 322, 329);
        g.drawLine(317, 333, 322, 329);
        g.drawString("b", 295, 344);
        //estado q9
        g.drawOval(322, 298, 50, 50);
        g.drawOval(327, 303, 40, 40);
        g.drawString("q9", 341, 327);

        //GrafoAjedrez 2
        //-------------**********************---------------
        g.setColor(Color.black);
        g.drawLine(747, 49, 747, 66);
        g.drawLine(743, 62, 747, 66);
        g.drawLine(751, 62, 747, 66);
        g.drawString("start", 708, 62);
        //estado q1
        g.drawOval(622, 66, 50, 50);
        g.drawString("q1", 641, 95);
        //arista de q1 a q2
        g.drawLine(672, 85, 722, 85);
        g.drawLine(677, 81, 672, 85);
        g.drawLine(677, 89, 672, 85);
        g.drawString("b", 695, 80);
        //arista de q2 a q1
        g.drawLine(672, 97, 722, 97);
        g.drawLine(717, 93, 722, 97);
        g.drawLine(717, 101, 722, 97);
        g.drawString("r", 695, 112);
        //arista de q1 a q4
        g.drawLine(641, 116, 641, 182);
        g.drawLine(637, 177, 641, 182);
        g.drawLine(645, 177, 641, 182);
        g.drawString("r", 627, 151);
        //arista de q4 a q1
        g.drawLine(653, 116, 653, 182);
        g.drawLine(649, 121, 653, 116);
        g.drawLine(657, 121, 653, 116);
        g.drawString("b", 160, 151);
        //arista de q5 a q1
        g.drawArc(511, 97, 220, 220, 9, 57);
        g.drawLine(670, 114, 668, 107);
        g.drawLine(674, 107, 668, 107);
        g.drawString("b", 707, 134);
        //arista de q1 a q5
        g.drawArc(660, -18, 220, 220, 190, 56);
        g.drawLine(719, 194, 726, 192);
        g.drawLine(723, 186, 726, 192);
        g.drawString("b", 675, 171);
        //arista de q2 a q4
        g.drawArc(659, 95, 220, 220, 113, 57);
        g.drawLine(666, 181, 661, 186);
        g.drawLine(658, 179, 660, 186);
        g.drawString("r", 678, 132);
        //arista de q4 a q2
        g.drawArc(514, -20, 220, 220, 293, 56);
        g.drawLine(735, 118, 732, 112);
        g.drawLine(727, 116, 732, 112);
        g.drawString("r", 710, 174);
        //estado q2
        g.drawOval(722, 66, 50, 50);
        g.drawString("q2", 741, 95);
        //arista de q2 a q3
        g.drawLine(772, 85, 822, 85);
        g.drawLine(777, 81, 772, 85);
        g.drawLine(777, 89, 772, 85);
        g.drawString("r", 795, 80);
        //arista de q3 a q2
        g.drawLine(772, 97, 822, 97);
        g.drawLine(817, 93, 822, 97);
        g.drawLine(817, 101, 822, 97);
        g.drawString("b", 795, 112);
        //arista de q2 a q5
        g.drawLine(741, 116, 741, 182);
        g.drawLine(737, 177, 741, 182);
        g.drawLine(745, 177, 741, 182);
        g.drawString("b", 727, 151);
        //arista de q5 a q2
        g.drawLine(753, 116, 753, 182);
        g.drawLine(749, 121, 753, 116);
        g.drawLine(757, 121, 753, 116);
        g.drawString("r", 760, 151);
        //arista de q6 a q2
        g.drawArc(611, 97, 220, 220, 9, 57);
        g.drawLine(770, 114, 768, 107);
        g.drawLine(774, 107, 768, 107);
        g.drawString("r", 807, 134);
        //arista de q2 a q6
        g.drawArc(760, -18, 220, 220, 190, 56);
        g.drawLine(819, 194, 826, 192);
        g.drawLine(823, 186, 826, 192);
        g.drawString("r", 775, 171);
        //arista de q3 a q5
        g.drawArc(759, 95, 220, 220, 113, 57);
        g.drawLine(766, 181, 761, 186);
        g.drawLine(758, 179, 760, 186);
        g.drawString("b", 778, 132);
        //arista de q5 a q3
        g.drawArc(614, -20, 220, 220, 293, 56);
        g.drawLine(835, 118, 832, 112);
        g.drawLine(827, 116, 832, 112);
        g.drawString("b", 810, 174);
        //arista de q3 a q6
        g.drawLine(841, 116, 841, 182);
        g.drawLine(837, 177, 841, 182);
        g.drawLine(845, 177, 841, 182);
        g.drawString("r", 827, 151);
        //arista de q6 a q3
        g.drawLine(853, 116, 853, 182);
        g.drawLine(849, 121, 853, 116);
        g.drawLine(857, 121, 853, 116);
        g.drawString("b", 860, 151);
        //estado q3
        g.drawOval(822, 66, 50, 50);
        g.drawString("q3", 841, 95);
        //estado q4
        g.drawOval(622, 182, 50, 50);
        g.drawString("q4", 641, 211);
        //arista de q4 a q7
        g.drawLine(641, 232, 641, 298);
        g.drawLine(637, 293, 641, 298);
        g.drawLine(645, 293, 641, 298);
        g.drawString("b", 627, 267);
        //arista de q7 a q4
        g.drawLine(653, 232, 653, 298);
        g.drawLine(649, 237, 653, 232);
        g.drawLine(657, 237, 653, 232);
        g.drawString("r", 660, 267);
        //arista de q8 a q4
        g.drawArc(511, 213, 220, 220, 9, 57);
        g.drawLine(670, 230, 668, 223);
        g.drawLine(674, 223, 668, 223);
        g.drawString("r", 207, 250);
        //arista de q4 a q8
        g.drawArc(660, 98, 220, 220, 190, 56);
        g.drawLine(719, 310, 726, 308);
        g.drawLine(723, 302, 726, 308);
        g.drawString("r", 175, 287);
        //arista de q5 a q7
        g.drawArc(659, 211, 220, 220, 113, 57);
        g.drawLine(666, 297, 661, 302);
        g.drawLine(658, 295, 660, 302);
        g.drawString("b", 678, 248);
        //arista de q7 a q5
        g.drawArc(514, 96, 220, 220, 293, 56);
        g.drawLine(735, 234, 732, 228);
        g.drawLine(727, 232, 732, 228);
        g.drawString("b", 710, 290);
        //arista de q5 a q8
        g.drawLine(741, 232, 741, 298);
        g.drawLine(737, 293, 741, 298);
        g.drawLine(745, 293, 741, 298);
        g.drawString("r", 727, 267);
        //arista de q8 a q5
        g.drawLine(753, 232, 753, 298);
        g.drawLine(749, 237, 753, 232);
        g.drawLine(757, 237, 753, 232);
        g.drawString("b", 760, 267);
        //arista de q9 a q5
        g.drawArc(611, 213, 220, 220, 9, 57);
        g.drawLine(770, 230, 768, 223);
        g.drawLine(774, 223, 768, 223);
        g.drawString("b", 807, 250);
        //arista de q5 a q9
        g.drawArc(760, 98, 220, 220, 190, 56);
        g.drawLine(819, 310, 826, 308);
        g.drawLine(823, 302, 826, 308);
        g.drawString("b", 775, 287);
        //arista de q6 a q8
        g.drawArc(759, 211, 220, 220, 113, 57);
        g.drawLine(766, 297, 761, 302);
        g.drawLine(758, 295, 760, 302);
        g.drawString("r", 778, 248);
        //arista de q8 a q6
        g.drawArc(614, 96, 220, 220, 293, 56);
        g.drawLine(835, 234, 832, 228);
        g.drawLine(827, 232, 832, 228);
        g.drawString("r", 810, 290);
        //arista de q6 a q9
        g.drawLine(841, 232, 841, 298);
        g.drawLine(837, 293, 841, 298);
        g.drawLine(845, 293, 841, 298);
        g.drawString("b", 827, 267);
        //arista de q9 a q6
        g.drawLine(853, 232, 853, 298);
        g.drawLine(849, 237, 853, 232);
        g.drawLine(357, 237, 353, 232);
        g.drawString("r", 860, 267);
        //arista de q5 a q4
        g.drawLine(672, 201, 722, 201);
        g.drawLine(677, 197, 672, 201);
        g.drawLine(677, 205, 672, 201);
        g.drawString("r", 695, 196);
        //arista de q4 a q5
        g.drawLine(672, 213, 722, 213);
        g.drawLine(717, 209, 722, 213);
        g.drawLine(717, 217, 722, 213);
        g.drawString("b", 695, 228);
        //estado q5
        g.drawOval(722, 182, 50, 50);
        g.drawString("q5", 741, 211);
        //arista de q6 a q5
        g.drawLine(772, 201, 822, 201);
        g.drawLine(777, 197, 772, 201);
        g.drawLine(777, 205, 772, 201);
        g.drawString("b", 795, 196);
        //arista de q5 a q6
        g.drawLine(772, 213, 822, 213);
        g.drawLine(817, 209, 822, 213);
        g.drawLine(817, 217, 822, 213);
        g.drawString("r", 795, 228);
        //estado q6
        g.drawOval(822, 182, 50, 50);
        g.drawString("q6", 841, 211);
        //estado q7
        g.drawOval(622, 298, 50, 50);
        g.drawString("q7", 641, 327);
        //arista de q7 a q8
        g.drawLine(672, 317, 722, 317);
        g.drawLine(677, 313, 672, 317);
        g.drawLine(677, 321, 672, 317);
        g.drawString("b", 695, 312);
        //arista de q8 a q7
        g.drawLine(672, 329, 722, 329);
        g.drawLine(717, 325, 722, 329);
        g.drawLine(717, 333, 722, 329);
        g.drawString("r", 795, 344);
        //estado q8
        g.drawOval(722, 298, 50, 50);
        g.drawOval(727, 303, 40, 40);
        g.drawString("q8", 741, 327);
        //arista de q8 a q9
        g.drawLine(772, 317, 822, 317);
        g.drawLine(777, 313, 772, 317);
        g.drawLine(777, 321, 772, 317);
        g.drawString("r", 795, 312);
        //arista de q9 a q8
        g.drawLine(772, 329, 822, 329);
        g.drawLine(817, 325, 822, 329);
        g.drawLine(817, 333, 822, 329);
        g.drawString("b", 295, 344);
        //estado q9
        g.drawOval(822, 298, 50, 50);
        g.drawString("q9", 841, 327);
    }

}
