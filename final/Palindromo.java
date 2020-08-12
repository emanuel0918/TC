import java.io.*;
import java.util.Random;

public class Palindromo {

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
        char c;
        String cadena = "";
        String s_opc;
        int opc = 0;
        do {
            System.out.println("Palindromo");
            System.out.println("P-> aPa | b | E");
            System.out.println("1)Verificar si una cadena cualquiera es palindromo");
            System.out.println("2)Generar palindromo de manera manual");
            System.out.println("3)Generar palindromo de manera cualquiera");
            System.out.println("4)Salir");
            System.out.println("Ingrese una opcion");
            s_opc = scan();
            try {
                opc = Integer.parseInt(s_opc);
            } catch (NumberFormatException ex) {
                opc = 0;
            }
        } while (!(opc >= 1 && opc <= 4));
        if (opc >= 1 && opc <= 3) {
            comand("rm palindromo.txt");
            comand("echo >> palindromo.txt");
            comand("rm derivaciones.txt");
            comand("echo >> derivaciones.txt");
            try {
                PrintWriter writer_palindromo
                        = new PrintWriter("palindromo.txt", "UTF-8");
                PrintWriter writer_derivaciones
                        = new PrintWriter("derivaciones.txt", "UTF-8");
                if (opc == 1) {
                    c = 0;
                    int length = 0;
                    boolean esPalindromo = true;
                    boolean epsilon;
                    BufferedReader br
                            = new BufferedReader(new InputStreamReader(System.in));
                    while (c != '\n') {
                        try {
                            c = (char) br.read();
                            if (c != '\n') {
                                cadena += c;
                                length++;
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    for (int i = 0, l = length - 1; i < length; i++, l--) {
                        if (cadena.charAt(i) != cadena.charAt(l)) {
                            esPalindromo = false;
                        }
                    }
                    if (esPalindromo) {
                        if (length % 2 == 0) {
                            epsilon = true;
                        } else {
                            epsilon = false;
                        }
                        cadena = cadena.substring((length + 1) / 2);
                        System.out.println(ANSI_GREEN + "Es palindromo" + ANSI_GREEN);
                        String palindromo = "";
                        if (epsilon) {
                            palindromo += 'E' + "";
                            writer_palindromo.println("E");
                        }
                        for (int i = 0; i < cadena.length(); i++) {
                            c = cadena.charAt(i);
                            switch (palindromo) {
                                case "":
                                    if (c != 'E') {
                                        writer_derivaciones.println("P -> b");
                                    }
                                    palindromo = c + "";
                                    break;
                                case "E":
                                    writer_derivaciones.println("P -> E");
                                    palindromo = c + "" + c;
                                    writer_derivaciones.println("P -> aPa");
                                    break;
                                default:
                                    writer_derivaciones.println("P -> aPa");
                                    palindromo = c + palindromo + c;
                                    break;
                            }
                            writer_palindromo.println(palindromo);
                        }
                    } else {
                        cadena = "";
                        System.out.println(ANSI_RED + "No es palindromo" + ANSI_RED);
                    }
                }
                if (opc == 2) {
                    c = 0;
                    BufferedReader br
                            = new BufferedReader(new InputStreamReader(System.in));
                    while (c != '\n') {
                        try {
                            c = (char) br.read();
                            if (c != '\n') {
                                switch (cadena) {
                                    case "":
                                        if (c != 'E') {
                                            writer_derivaciones.println("P -> b");
                                        }
                                        cadena = c + "";
                                        break;
                                    case "E":
                                        writer_derivaciones.println("P -> E");
                                        cadena = c + "" + c;
                                        writer_derivaciones.println("P -> aPa");
                                        break;
                                    default:
                                        writer_derivaciones.println("P -> aPa");
                                        cadena = c + cadena + c;
                                        break;
                                }
                                writer_palindromo.println(cadena);
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                if (opc == 3) {
                    Random rand = new Random();
                    int random = rand.nextInt(10);
                    for (int i = 0; i < random; i++) {
                        c = random_alphabet();
                        switch (cadena) {
                            case "":
                                if (c != 'E') {
                                    writer_derivaciones.println("P -> b");
                                }
                                cadena = c + "";
                                break;
                            case "E":
                                writer_derivaciones.println("P -> E");
                                cadena = c + "" + c;
                                writer_derivaciones.println("P -> aPa");
                                break;
                            default:
                                writer_derivaciones.println("P -> aPa");
                                cadena = c + cadena + c;
                                break;
                        }
                        writer_palindromo.println(cadena);
                        System.out.print(c);
                    }
                    System.out.println();
                }
                writer_derivaciones.close();
                writer_palindromo.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static char random_alphabet() {
        Random rand = new Random();
        return ((char) (rand.nextInt(26) + 97));
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
