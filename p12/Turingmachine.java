import java.awt.*;
import javax.swing.*;

public class Turingmachine extends JPanel {

    private int n;
    private int index;
    private String cadena;
    private int x_rect;
    private int y_rect;
    private int y_space;
    private int x_space;

    public Turingmachine(String s, int i) {
        cadena =s;
        n =cadena.length();
        index=i;
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
        g2.drawRect(x_space + 50+40*(index),  y_rect + y_space, x_rect, y_rect);
        g2.setColor(Color.ORANGE);
        g2.fillRect(x_space + 51+40*(index),  y_rect + 1 + y_space, x_rect - 1, y_rect - 1);
        g2.setColor(Color.BLACK);
        g2.drawString("q",x_space + 50+17+40*(index), y_rect + y_space+20);
        g2.drawLine(x_space+72+40*(index), y_space+60, x_space+72+40*(index), y_space+80);
        g2.fillPolygon(new int[]{x_space+72+40*(index), x_space+76+40*(index), x_space+68+40*(index)},
                new int[] {y_space+90, y_space+80, y_space+80}, 3);
        g2.drawLine(x_space, y_space+90, x_space+n*40+180, y_space+90);
        g2.drawLine(x_space, y_space+120, x_space+n*40+180, y_space+120);
        g2.drawString(".",x_space+40+17, y_rect + y_space+80);
        g2.drawString(".",x_space+50+17, y_rect + y_space+80);
        g2.drawString(".",x_space+60+17, y_rect + y_space+80);
        g2.drawLine(x_space+40+50, y_space+90, x_space+40+50, y_space+120);

        for (int i = 0; i < n; i++) {

            //Contorno del espacio de la pila
            g2.setColor(Color.BLACK);
            g2.drawString(cadena.charAt(i)+"",x_space+40*(i+1)+50+17, y_rect + y_space+80);
            g2.drawLine(x_space+40*(i+2)+50, y_space+90, x_space+40*(i+2)+50, y_space+120);
        }
        g2.drawString(".",x_space+40*(n+2)+17, y_rect + y_space+80);
        g2.drawString(".",x_space+40*(n+2)+27, y_rect + y_space+80);
        g2.drawString(".",x_space+40*(n+2)+37, y_rect + y_space+80);
    }
}
