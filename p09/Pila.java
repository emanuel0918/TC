import java.util.ArrayList;

public class Pila {
    private ArrayList<String> pila;
    private int tope;
    public Pila(){
        pila= new ArrayList<>();
        tope=-1;
    }
    public void push(String n){
        pila.add(++tope, n);
    }
    public String pop(){
        String n="";
        if(!estaVacia()){
            n=pila.get(tope);
            pila.remove(tope--);
        }
        return n;
    }
    public String top(){
        String n="";
        if(!estaVacia()){
            n=pila.get(tope);
        }
        return n;
    }
    public boolean estaVacia(){
        return tope==-1;
    }
}
