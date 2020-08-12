import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;


public class Ajedrez extends JFrame{
    private JLabel ficha[];
    private JLabel trofeo;
    private JLabel ganaste1;
    private JLabel ganaste2;
    private JLabel tablero[];
    private int index1;
    public Ajedrez(){
        index1=0;
        int size=500;
        int cuadro=size/3+2;
        //Interfaz
        setLayout(null);
        setTitle("Ajedrez");
        setLocation(80, 15);
        setSize(size,size);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Componentes
        //Tablero
        tablero=new JLabel[9];
        int ij;
        for(int i =0;i<3;i++){
            for(int j =0;j<3;j++){
                ij=i*3+j;
                tablero[ij]=new JLabel();
                tablero[ij].setOpaque(true);
                add(tablero[ij]);
                tablero[ij].setBounds(j*cuadro,i*cuadro,cuadro,cuadro);
                if(ij%2==1){
                    tablero[ij].setBackground(Color.red);
                }else{
                    tablero[ij].setBackground(Color.black);
                }
            }
        }
        //Fichas
        ficha=new JLabel[2];
        for(int i=0;i<2;i++){
            ficha[i]=new JLabel();
            ficha[i].setSize(cuadro, cuadro);
            ficha[i].setOpaque(false);
            ficha[i].setIcon(escalarImagen("f1"+(i+1)+".png",ficha[i].getWidth(),ficha[i].getHeight()));
        }
        //Ganaste
        float dim_trofeo=size/7;
        float x_trofeo=(cuadro-dim_trofeo)/2;
        float y_trofeo=size/6;
        trofeo=new JLabel();
        trofeo.setOpaque(false);
        trofeo.setIcon(escalarImagen("trofeo.png",(int)(dim_trofeo),(int)(dim_trofeo)));
        tablero[4].add(trofeo);
        trofeo.setBounds((int)(x_trofeo), (int)(y_trofeo), (int)(dim_trofeo), (int)(dim_trofeo));
        trofeo.hide();
        float dimx_ganaste=cuadro;
        float dimy_ganaste=y_trofeo;
        ganaste1=new JLabel();
        ganaste1.setOpaque(false);
        ganaste1.setIcon(escalarImagen("ganaste7.png",(int)(dimx_ganaste),(int)(dimy_ganaste)));
        tablero[4].add(ganaste1);
        ganaste1.setBounds(0, 0, (int) (dimx_ganaste),(int)(dimy_ganaste));
        ganaste1.hide();
        ganaste2=new JLabel();
        ganaste2.setOpaque(false);
        ganaste2.setIcon(escalarImagen("ganaste8.png",(int)(dimx_ganaste),(int)(dimy_ganaste)));
        tablero[4].add(ganaste2);
        ganaste2.setBounds(0, 0, (int) (dimx_ganaste),(int)(dimy_ganaste));
        ganaste2.hide();
        
    }
    public void ganar (){
        ganaste1.show();
        trofeo.show();
        boolean animar=true;
        while(true){
            esperar(1f);
            if(animar){
                ganaste1.hide();
                ganaste2.show();
                animar=false;
            }else{
                ganaste2.hide();
                ganaste1.show();
                animar=true;
            }
            repaint();
        }
    }
    public void setFicha(int t,int f){
        tablero[t].add(ficha[f]);
    }
    private ImageIcon escalarImagen(String imagen_path,int width,int height){
        String ruta=System.getProperty("user.dir");
        ruta="";
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File(ruta+imagen_path));
        } catch (java.io.IOException ex) {
            ex.printStackTrace();
        }
        Image image_scaled = bufferedImage.getScaledInstance(width,height,
                Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(image_scaled);
        return imageIcon;
    }
    public void esperar(float s){
        try {
            Thread.sleep((int)(s*1000));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
