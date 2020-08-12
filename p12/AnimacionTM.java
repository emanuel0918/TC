import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.*;

public class AnimacionTM extends JFrame implements AdjustmentListener {

    private JScrollPane scroll;
    private JPanel panel;

    public AnimacionTM() {
        setTitle("Animacion");
        setLocation(200, 50);
        setSize(800, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        scroll = new JScrollPane();
        scroll.setBounds(0, 0, getWidth(), getHeight());
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().addAdjustmentListener(this);
        add(scroll);
    }

    public void animar(String s, int i) {
        panel = new Turingmachine(s,i);
        panel.setPreferredSize(new Dimension(s.length() * 50+200, 500));
        scroll.setViewportView(panel);
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent ae) {
        //animar();
        setVisible(true);
    }
}
