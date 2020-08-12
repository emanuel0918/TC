import java.io.*;
import java.util.Random;

public class MainTuring {
    public static void main(String[] args) {
        AnimacionTM animacion;
        MaquinaTuring maquina;
        String s_opc;
        String cadena;
        String cadena_turing;
        char c;
        int index;
        int opc;
        do {
            System.out.println("Gramatica de balanceo de parentesis");
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
            cadena_turing="";
            cadena="";
            animacion = new AnimacionTM();
            index=1;
            animacion.animar("B",index);
            animacion.setVisible(true);
            maquina = new MaquinaTuring();
            c = 0;
            comand("rm turing.txt");
            comand("echo >> turing.txt");
            try {
                PrintWriter writer
                        = new PrintWriter("turing.txt", "UTF-8");
                writer.print("{ Sx0 ");
                if (opc == 1) {
                    BufferedReader br
                            = new BufferedReader(new InputStreamReader(System.in));
                    while (c != '\n') {
                        try {
                            c = (char) br.read();
                            cadena+=c+"";
                            maquina.analizar(c);
                            cadena_turing+=maquina.getCaracter()+"";
                            if(maquina.getMovimiento()=='R'){
                                index++;
                            }else if(maquina.getMovimiento()=='L'){
                                index--;
                            }
                            writer.print(maquina.getEstado()+" ");
                            animacion.animar(cadena,index-1);
                            animacion.setVisible(true);
                            esperar(1f);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    animacion.setVisible(false);
                }
                if (opc == 2) {
                    while (c != '\n') {
                        c = random_01B();
                        System.out.print(c);
                        cadena+=c+"";
                        maquina.analizar(c);
                        cadena_turing+=maquina.getCaracter()+"";
                        if(maquina.getMovimiento()=='R'){
                            index++;
                        }else if(maquina.getMovimiento()=='L'){
                            index--;
                        }
                        writer.print(maquina.getEstado()+" ");
                        animacion.animar(cadena,index-1);
                        animacion.setVisible(true);
                        esperar(1f);
                    }
                    System.out.println();
                    animacion.setVisible(false);
                }
                writer.println("}");
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
	System.exit(0);
    }

    public static char random_01B() {
        Random rand = new Random();
        char caracter;
        int random=rand.nextInt(10);
        if(random==9){
            caracter='\n';
        }else if (random<5){
            caracter='B';
        }else{
            caracter=(char) (rand.nextInt(2) + 48);
        }
        return caracter;
    }

    public static void comand(String cmd) {
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader stdInput
                    = new BufferedReader(new InputStreamReader(p.getInputStream()));
        } catch (java.io.IOException ex) {
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
