public class MaquinaTuring {

    private String estado;
    private char caracter;
    private char movimiento;
    public MaquinaTuring(){
        estado="Sx0";
    }

    public String getEstado() {
        return estado;
    }

    public char getCaracter() {
        return caracter;
    }

    public char getMovimiento() {
        return movimiento;
    }
    
    public void analizar(char entrada) {
        switch (entrada) {
            case '0':
                switch (estado) {
                    case "Sx0":
                        estado = "Sx0";
                        caracter='0';
                        movimiento='R';
                        break;
                    case "S01":
                        estado = "Sx0";
                        caracter='1';
                        movimiento='R';
                        break;
                    case "S11":
                        estado = "Sx0";
                        caracter='1';
                        movimiento='R';
                        break;
                    case "SB":
                        estado = "SB";
                        caracter='0';
                        movimiento='L';
                        break;
                }
                break;
            case '1':
                switch (estado) {
                    case "Sx0":
                        estado = "S01";
                        caracter='1';
                        movimiento='R';
                        break;
                    case "S01":
                        estado = "S11";
                        caracter='1';
                        movimiento='R';
                        break;
                    case "S11":
                        estado = "S11";
                        caracter='0';
                        movimiento='R';
                        break;
                    case "SB":
                        estado = "SB";
                        caracter='1';
                        movimiento='L';
                        break;
                }
                break;
            case 'B':
                switch (estado) {
                    case "Sx0":
                        estado = "SB";
                        caracter='0';
                        movimiento='L';
                        break;
                    case "SB":
                        estado = "Sx0";
                        caracter='0';
                        movimiento='R';
                        break;
                }
                break;
        }
    }
    
}
