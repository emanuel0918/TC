import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.*;

public class AnimacionPda extends JFrame implements AdjustmentListener {

    private JScrollPane scroll;
    private JPanel panel;

    public AnimacionPda() {
        setTitle("Animacion");
        setLocation(200, 50);
        setSize(400, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        scroll = new JScrollPane();
        scroll.setBounds(0, 0, getWidth(), getHeight());
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().addAdjustmentListener(this);
        add(scroll);
    }

    public void animar(String s, int n) {
        panel = new PumppingLemma(s,n);
        panel.setPreferredSize(new Dimension(400, (n+2)*40));
        scroll.setViewportView(panel);
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent ae) {
        //animar();
        setVisible(true);
    }
}
