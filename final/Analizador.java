public class Analizador {
    private boolean balanceado;
    private String derivacion;
    private int index;
    
    public Analizador(){
        balanceado=true;
        derivacion="B";
        index=0;
    }

    public boolean isBalanceado() {
        return balanceado;
    }

    public String getDerivacion() {
        return derivacion;
    }

    
    public void analizar(char c) {
        try{
            String derivada="";
            switch(derivacion.charAt(index)){
                case 'B':
                    switch(c){
                        case '(':
                            derivada="(RB";
                            balanceado=false;
                            break;
                        case '\n':
                            derivada="";
                            balanceado=true;
                            break;
                        default:
                            balanceado=false;
                            break;
                    }
                    break;
                case 'R':
                    switch(c){
                        case '(':
                            derivada="(RR";
                            balanceado=false;
                            break;
                        case ')':
                            derivada=")";
                            balanceado=true;
                            break;
                        default:
                            balanceado=false;
                            break;
                    }
                    break;
                default:
                    balanceado=false;
                    break;
            }
            derivacion=derivacion.substring(0, index)+
                    derivada+derivacion.substring(index+1);
            index++;
        }catch(Exception e){
        }
    }
}
