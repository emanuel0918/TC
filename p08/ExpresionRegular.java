import java.io.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExpresionRegular {
    public static void main(String[] args) {
        String cadena;
        int primer_union,veces,segunda_union;
        String union1,union2;
        Random r= new Random();
        comand("rm expresion_regular.txt");
        comand("echo >> expresion_regular.txt");
        PrintWriter writer;
            try {
                writer = new PrintWriter("expresion_regular.txt", "UTF-8");
                System.out.println("Expresion regular (0+10)*(E+1)");
                System.out.println("Generando 6 expresiones regulares en el archivo TXT...");
                for(int i=0;i<6;i++){
                    cadena="";
                    union1="";
                    union2="";
                    primer_union = r.nextInt(2);
                    veces=r.nextInt(100);
                    switch(primer_union){
                        case 0:
                            union1="10";
                            break;
                        case 1:
                            union1="0";
                            break;
                    }
                    writer.println("De la union de 0+10 se ha usado "+union1);
                    writer.println("Se repite "+veces+" veces");
                    for(int j=0;j<veces;j++){
                        cadena+=union1;
                    }
                    segunda_union= r.nextInt(2);
                    switch(segunda_union){
                        case 0:
                            union2="E";
                            break;
                        case 1:
                            union2="1";
                            break;
                    }
                    writer.println("De la segunda union de E+1 se ha usado "+union2);
                    cadena+=union2;
                    writer.println("La cadena "+(i+1)+" es: "+cadena);
                    writer.println("**********************************************");
                }
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExpresionRegular.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ExpresionRegular.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public static char random_01() {
        char letra = 0;
        Random rand = new Random();
        if (rand.nextInt(2) == 0) {
            letra = '0';
        } else {
            letra = '1';
        }
        return letra;
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
