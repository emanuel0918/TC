import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Automata7 {

    private ArrayList<ArrayList<Integer>> matriz;
    private ArrayList<ArrayList<Integer>> matriz2;
    public ArrayList<Integer> jugadas[];

    public Automata7() {
        jugadas = new ArrayList[2];
        matriz = new ArrayList<>();
        matriz2 = new ArrayList<>();
    }

    public void analizar(char c) {
        ArrayList<ArrayList<Integer>> backup;
        backup = new ArrayList<>();
        ArrayList<Integer> estados;
        if (matriz.isEmpty()) {
            switch (c) {
                case 'R':
                case 'r':
                    estados = new ArrayList<>();
                    estados.add(2);
                    matriz.add(estados);
                    estados = new ArrayList<>();
                    estados.add(4);
                    matriz.add(estados);
                    break;
                case 'B':
                case 'b':
                    estados = new ArrayList<>();
                    estados.add(5);
                    matriz.add(estados);
                    break;
            }
        }
        switch (c) {
            case 'R':
            case 'r':
                for (int i = 0; i < matriz.size(); i++) {
                    switch (matriz.get(i).get(matriz.get(i).size() - 1)) {
                        case 1:
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(2);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(4);
                            backup.add(estados);
                            break;
                        case 2:
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(4);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(6);
                            backup.add(estados);
                            break;
                        case 3:
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(2);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(6);
                            backup.add(estados);
                            break;
                        case 4:
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(2);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(8);
                            backup.add(estados);
                            break;
                        case 5:
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(2);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(4);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(6);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(8);
                            backup.add(estados);
                            break;
                        case 6:
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(2);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(8);
                            backup.add(estados);
                            break;
                        case 7:
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(4);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(8);
                            backup.add(estados);
                            break;
                        case 8:
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(4);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(6);
                            backup.add(estados);
                            break;
                        case 9:
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(6);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(8);
                            backup.add(estados);
                            break;
                    }
                }
                break;
            case 'B':
            case 'b':
                for (int i = 0; i < matriz.size(); i++) {
                    switch (matriz.get(i).get(matriz.get(i).size() - 1)) {
                        case 1:
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(5);
                            backup.add(estados);
                            break;
                        case 2:
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(1);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(3);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(5);
                            backup.add(estados);
                            break;
                        case 3:
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(5);
                            backup.add(estados);
                            break;
                        case 4:
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(1);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(5);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(7);
                            backup.add(estados);
                            break;
                        case 5:
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(1);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(3);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(7);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(9);
                            backup.add(estados);
                            break;
                        case 6:
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(3);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(5);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(9);
                            backup.add(estados);
                            break;
                        case 7:
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(5);
                            backup.add(estados);
                            break;
                        case 8:
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(5);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(7);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(9);
                            backup.add(estados);
                            break;
                        case 9:
                            estados = (ArrayList<Integer>) matriz.get(i).clone();
                            estados.add(5);
                            backup.add(estados);
                            break;
                    }
                }
                break;
        }
        /*for (int i = 0; i < matriz.size(); i++) {
            for (int j = 0; j < matriz.get(i).size(); j++) {
                System.out.print(matriz.get(i).get(j) + " ");
            }
            System.out.println();
        }*/
        matriz.clear();
        matriz = (ArrayList<ArrayList<Integer>>) backup.clone();
    }

    public int finalizar() {
        ArrayList<ArrayList<Integer>> backup;
        backup = new ArrayList<>();
        ArrayList<Integer> estados;
        for (int i = 0; i < matriz.size(); i++) {
            if (matriz.get(i).get(matriz.get(i).size() - 2) == 9) {
                estados = (ArrayList<Integer>) matriz.get(i).clone();
                backup.add(estados);
            }
        }
        matriz.clear();
        matriz = (ArrayList<ArrayList<Integer>>) backup.clone();
        System.out.println("Total de cadenas ganadoras para la ficha 1: " + matriz.size());
        comand("rm ganadoras1.txt");
        comand("echo >> ganadoras1.txt");
        if (!matriz.isEmpty()) {
            PrintWriter writer;
            try {
                writer = new PrintWriter("ganadoras1.txt", "UTF-8");
                for (int i = 0; i < matriz.size(); i++) {
                    for (int j = 0; j < matriz.get(i).size(); j++) {
                        writer.print(matriz.get(i).get(j) + " ");
                    }
                    writer.println("");
                }
                writer.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Automata7.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Automata7.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return matriz.size();
    }

    public void analizar2(char c) {
        ArrayList<ArrayList<Integer>> backup;
        backup = new ArrayList<>();
        ArrayList<Integer> estados;
        if (matriz2.isEmpty()) {
            switch (c) {
                case 'R':
                case 'r':
                    estados = new ArrayList<>();
                    estados.add(4);
                    matriz2.add(estados);
                    estados = new ArrayList<>();
                    estados.add(6);
                    matriz2.add(estados);
                    break;
                case 'B':
                case 'b':
                    estados = new ArrayList<>();
                    estados.add(1);
                    matriz2.add(estados);
                    estados = new ArrayList<>();
                    estados.add(3);
                    matriz2.add(estados);
                    estados = new ArrayList<>();
                    estados.add(5);
                    matriz2.add(estados);
                    break;
            }
        }
        switch (c) {
            case 'R':
            case 'r':
                for (int i = 0; i < matriz2.size(); i++) {
                    switch (matriz2.get(i).get(matriz2.get(i).size() - 1)) {
                        case 1:
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(2);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(4);
                            backup.add(estados);
                            break;
                        case 2:
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(4);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(6);
                            backup.add(estados);
                            break;
                        case 3:
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(2);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(6);
                            backup.add(estados);
                            break;
                        case 4:
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(2);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(8);
                            backup.add(estados);
                            break;
                        case 5:
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(2);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(4);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(6);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(8);
                            backup.add(estados);
                            break;
                        case 6:
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(2);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(8);
                            backup.add(estados);
                            break;
                        case 7:
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(4);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(8);
                            backup.add(estados);
                            break;
                        case 8:
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(4);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(6);
                            backup.add(estados);
                            break;
                        case 9:
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(6);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(8);
                            backup.add(estados);
                            break;
                    }
                }
                break;
            case 'B':
            case 'b':
                for (int i = 0; i < matriz2.size(); i++) {
                    switch (matriz2.get(i).get(matriz2.get(i).size() - 1)) {
                        case 1:
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(5);
                            backup.add(estados);
                            break;
                        case 2:
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(1);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(3);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(5);
                            backup.add(estados);
                            break;
                        case 3:
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(5);
                            backup.add(estados);
                            break;
                        case 4:
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(1);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(5);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(7);
                            backup.add(estados);
                            break;
                        case 5:
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(1);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(3);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(7);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(9);
                            backup.add(estados);
                            break;
                        case 6:
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(3);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(5);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(9);
                            backup.add(estados);
                            break;
                        case 7:
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(5);
                            backup.add(estados);
                            break;
                        case 8:
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(5);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(7);
                            backup.add(estados);
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(9);
                            backup.add(estados);
                            break;
                        case 9:
                            estados = (ArrayList<Integer>) matriz2.get(i).clone();
                            estados.add(5);
                            backup.add(estados);
                            break;
                    }
                }
                break;
        }
        /*for (int i = 0; i < matriz2.size(); i++) {
            for (int j = 0; j < matriz2.get(i).size(); j++) {
                System.out.print(matriz2.get(i).get(j) + " ");
            }
            System.out.println();
        }*/
        matriz2.clear();
        matriz2 = (ArrayList<ArrayList<Integer>>) backup.clone();
    }

    public int finalizar2() {
        ArrayList<ArrayList<Integer>> backup;
        backup = new ArrayList<>();
        ArrayList<Integer> estados;
        for (int i = 0; i < matriz2.size(); i++) {
            if (matriz2.get(i).get(matriz2.get(i).size() - 2) == 8) {
                estados = (ArrayList<Integer>) matriz2.get(i).clone();
                backup.add(estados);
            }
        }
        matriz2.clear();
        matriz2 = (ArrayList<ArrayList<Integer>>) backup.clone();
        System.out.println("Total de cadenas ganadoras para la ficha 2: " + matriz2.size());
        comand("rm ganadoras2.txt");
        comand("echo >> ganadoras2.txt");
        if (!matriz2.isEmpty()) {
            PrintWriter writer;
            try {
                writer = new PrintWriter("ganadoras2.txt", "UTF-8");
                for (int i = 0; i < matriz2.size(); i++) {
                    for (int j = 0; j < matriz2.get(i).size(); j++) {
                        writer.print(matriz2.get(i).get(j) + " ");
                    }
                    writer.println("");
                }
                writer.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Automata7.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Automata7.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return matriz2.size();
    }
    public void jugada1(){
        Random rand = new Random();
        int jugada1=rand.nextInt(matriz.size());
        jugadas[0]=(ArrayList<Integer>)matriz.get(jugada1).clone();
    }
    public void jugada2(){
        Random rand = new Random();
        int jugada2=rand.nextInt(matriz2.size());
        jugadas[1]=(ArrayList<Integer>)matriz2.get(jugada2).clone();
    }

    public boolean jugadas() {
        if (!matriz.isEmpty()) {
            boolean intersectan = false;
            int x, y = 0, z;
            for (x = 0; x < matriz.size(); x++) {
                for (y = 0; y < matriz2.size(); y++) {
                    for (z = 0; z <= matriz.get(x).size() - 1; z++) {
                        if (matriz.get(x).get(z).equals(matriz2.get(y).get(z))) {
                            intersectan = true;
                            break;
                        }
                    }
                    if (!intersectan) {
                        break;
                    }
                }
            }
            if (!intersectan) {
                jugadas[0] = (ArrayList<Integer>) matriz.get(x).clone();
                jugadas[1] = (ArrayList<Integer>) matriz.get(y).clone();
            }

            return !intersectan;//Si se intersectan, no continuara
        } else {
            return false;
        }
    }

    public char random_RB() {
        char letra = 0;
        Random rand = new Random();
        if (rand.nextInt(2) == 0) {
            letra = 'B';
        } else {
            letra = 'R';
        }
        return letra;
    }

    public void comand(String cmd) {
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader stdInput
                    = new BufferedReader(new InputStreamReader(p.getInputStream()));
        } catch (java.io.IOException ex) {
            ex.printStackTrace();
        }
    }

    public String scan() {
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
