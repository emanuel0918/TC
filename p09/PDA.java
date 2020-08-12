public class PDA {

    private Pila pila;
    private char estado;

    public PDA() {
        pila = new Pila();
        estado = 'q';
        pila.push("Z0");
    }

    public char getEstado() {
        return estado;
    }
    public void analizar(char input) {
        if(estado!='e'){
            switch (input) {
                case '0':
                    switch(estado){
                        case 'q':
                            pila.push("X");
                            break;
                        default:
                            estado='e';
                            break;
                    }
                    break;
                case '1':
                    switch(estado){
                        case 'q':
                            estado='p';
                            pila.pop();
                            break;
                        case 'p':
                            pila.pop();
                            break;
                        default:
                            estado='e';
                            break;
                    }
                    break;
                default:
                    estado='e';
            }
            if(pila.top().equals("Z0") && estado!='e'){
                estado='f';
            }
        }
    }
}
