import java.io.*;
import java.util.Random;

public class PushdownAutomata {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        String cadena = "";
        PDA pda = new PDA();
        String s_opc;
        int opc = 0;
        do {
            System.out.println("PDA");
            System.out.println("1)Generar cadena de manera manual");
            System.out.println("2)Generar cadena de manera aleatoria");
            System.out.println("3)Salir");
            System.out.println("Ingrese una opcion");
            s_opc = scan();
            try {
                opc = Integer.parseInt(s_opc);
            } catch (NumberFormatException ex) {
                opc = 0;
            }
        } while (!(opc >= 1 && opc <= 3));
        if (opc >= 1 && opc <= 2) {
            comand("rm estados.txt");
            comand("echo >> estados.txt");
            try {
                PrintWriter writer
                        = new PrintWriter("estados.txt", "UTF-8");
                writer.print("{ i, ");

                if (opc == 1) {
                    char c = 0;
                    BufferedReader br
                            = new BufferedReader(new InputStreamReader(System.in));
                    while (c != '\n') {
                        try {
                            c = (char) br.read();
                            if (c != '\n') {
                                cadena += c;
                                pda.analizar(c);
                                if (pda.getEstado() == 'f') {
                                    writer.print("p, ");
                                } else {
                                    writer.print("" + pda.getEstado() + ", ");
                                }
                            }
                        } catch (java.io.IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                if (opc == 2) {
                    char c = 0;
                    Random rand = new Random();
                    int random = rand.nextInt(4);
                    if (random == 0) {
                        random = rand.nextInt(100);
                        for (int i = 0; i < random; i++) {
                            c = random_01();
                            cadena += c;
                            pda.analizar(c);
                            if (pda.getEstado() == 'f') {
                                writer.print("p, ");
                            } else {
                                writer.print("" + pda.getEstado() + ", ");
                            }
                            System.out.print(c);
                        }
                        System.out.println();
                    } else {
                        random = rand.nextInt(50);
                        for (int i = 0; i < random; i++) {
                            c = '0';
                            cadena += c;
                            pda.analizar(c);
                            if (pda.getEstado() == 'f') {
                                writer.print("p, ");
                            } else {
                                writer.print("" + pda.getEstado() + ", ");
                            }
                            System.out.print(c);
                        }
                        for (int i = 0; i < random; i++) {
                            c = '1';
                            cadena += c;
                            pda.analizar(c);
                            if (pda.getEstado() == 'f') {
                                writer.print("p, ");
                            } else {
                                writer.print("" + pda.getEstado() + ", ");
                            }
                            System.out.print(c);
                        }
                        System.out.println();
                    }
                }
                writer.println("f }");
                writer.close();
                if (pda.getEstado() == 'f') {
                    System.out.println(ANSI_GREEN + "La cadena pertenece al lenguaje" + ANSI_GREEN);

                    AnimacionPda animacion = new AnimacionPda();
                    animacion.animar(cadena, 0);
                    animacion.setVisible(true);
                    esperar(1f);
                    int i = 0;
                    do {
                        animacion.animar(cadena.substring(i + 1), (i + 1));
                        animacion.setVisible(true);
                        esperar(1f);
                        i++;
                    } while (cadena.charAt(i) == '0');
                    cadena = cadena.substring(i);
                    for (int j = 0; j < cadena.length(); j++) {
                        i--;
                        animacion.animar(cadena.substring(j + 1), i);
                        animacion.setVisible(true);
                        esperar(1f);
                    }
                } else {
                    System.out.println(ANSI_RED + "La cadena no pertenece al lenguaje" + ANSI_RED);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static char random_01() {
        Random rand = new Random();
        return ((char) (rand.nextInt(2) + 48));
    }

    public static void comand(String cmd) {
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader stdInput
                    = new BufferedReader(new InputStreamReader(p.getInputStream()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String scan() {
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
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return scan;
    }

    public static void esperar(float s) {
        try {
            Thread.sleep((int) (s * 1000));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
