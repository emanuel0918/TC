import java.awt.*;
import javax.swing.*;

public class PumppingLemma extends JPanel {

    private int n;
    private String cadena;
    private int x_rect;
    private int y_rect;
    private int y_space;
    private int x_space;

    public PumppingLemma(String s,int i) {
        cadena=s;
        n = i;
        x_rect = 40;
        y_rect = 30;
        y_space = 80;
        x_space = 120;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.drawString(cadena, x_space + 70, y_space);
        g2.drawLine(x_space+72, y_space+2, x_space+72, y_space+20);
        int[] vx2 = {x_space+72, x_space+76, x_space+68};
        int[] vy2 = {y_space+30, y_space+20, y_space+20};
        g2.fillPolygon(vx2, vy2, 3);

        for (int i = 0; i < n; i++) {

            //Contorno del espacio de la pila
            g2.setColor(Color.BLACK);
            g2.drawRect(x_space + 50, (i + 1) * y_rect + y_space, x_rect, y_rect);
            g2.setColor(Color.GREEN);
            g2.fillRect(x_space + 51, (i + 1) * y_rect + 1 + y_space, x_rect - 1, y_rect - 1);
            g2.setColor(Color.BLACK);
            g2.drawString("X",x_space + 50+17, (i + 1) * y_rect + y_space+20);
            
        }
        g2.setColor(Color.BLACK);
        g2.drawRect(x_space + 50, (n + 1) * y_rect + y_space, x_rect, y_rect);
        g2.setColor(Color.ORANGE);
        g2.fillRect(x_space + 51, (n + 1) * y_rect + 1 + y_space, x_rect - 1, y_rect - 1);
        g2.setColor(Color.BLACK);
        g2.drawString("Z0",x_space + 50+13, (n+ 1) * y_rect + y_space+20);
    }
}
