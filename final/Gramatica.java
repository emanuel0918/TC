import java.io.*;
import java.util.Random;

public class Gramatica {

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
        Analizador analizador;
        String s_opc;
        char c;
        int opc = 0;
        do {
            System.out.println("Gramatica de balanceo de parentesis");
            System.out.println("B-> (RB | E");
            System.out.println("R-> ) | (RR");
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
            analizador = new Analizador();
            c = 0;
            comand("rm gramatica.txt");
            comand("echo >> gramatica.txt");
            try {
                PrintWriter writer
                        = new PrintWriter("gramatica.txt", "UTF-8");
                writer.println("B");
                if (opc == 1) {
                    BufferedReader br
                            = new BufferedReader(new InputStreamReader(System.in));
                    do {
                        try {
                            c = (char) br.read();
                            analizador.analizar(c);
                            writer.println(analizador.getDerivacion());
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }while (c != '\n');
                }
                if (opc == 2) {
                    while (c != '\n') {
                        c = random_parentesis();
                        analizador.analizar(c);
                        System.out.print(c);
                        writer.println(analizador.getDerivacion());
                    }
                    System.out.println();
                }
                if(analizador.isBalanceado()){
                    System.out.println(ANSI_GREEN + "Esta balanceado" + ANSI_GREEN);
                    writer.println("Esta balanceado");
                }else{
                    System.out.println(ANSI_RED + "No esta balanceado" + ANSI_RED);
                    writer.println("No esta balanceado");
                }
                writer.println("");
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static char random_parentesis() {
        Random rand = new Random();
        char caracter = 0;
        int random = rand.nextInt(9);
        if (random == 5) {
            caracter = '\n';
        } else {
            caracter = (char) (rand.nextInt(2) + 40);
        }
        return caracter;
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
}
