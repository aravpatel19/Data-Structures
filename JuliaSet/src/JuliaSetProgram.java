import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;

public class JuliaSetProgram extends JPanel implements AdjustmentListener, MouseListener{

    JFrame frame;
    int red, green, blue;

    /*
    JScrollBar redBar, blueBar, greenBar;
    JLabel redLabel, greenLabel, blueLabel;
    */

    double a, b, zoom;
    JScrollBar aBar, bBar, zoomBar, hueBar, satBar, brightBar, eyeBar, eBrightBar;
    JPanel scrollPanel, labelPanel, bigPanel;
    JLabel aLabel, bLabel, zoomLabel, hueLabel, satLabel, brightLabel, eyeLabel, eBrightLabel;
    JScrollPane juliaPane;

    int pixelSize = 1;

    float maxIter = 300f;

    float hue = 1.0f;
    float eye = .33f;
    float saturation = 1.0f;
    float brightness = 1.0f;
    float eBrightness = 0f;

    DecimalFormat df = new DecimalFormat("#.###");



    public JuliaSetProgram(){
        frame = new JFrame("Julia Set Program");
        frame.add(this);
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
        redBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 225);
        red = redBar.getValue();
        redBar.addAdjustmentListener(this);

        greenBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 225);
        green = greenBar.getValue();
        greenBar.addAdjustmentListener(this);

        blueBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 225);
        blue = blueBar.getValue();
        blueBar.addAdjustmentListener(this);

        GridLayout grid = new GridLayout(3, 1);

        redLabel = new JLabel("Red");
        blueLabel = new JLabel("Blue");
        greenLabel = new JLabel("Green");

        labelPanel = new JPanel();
        labelPanel.setLayout(grid);
        labelPanel.add(redLabel);
        labelPanel.add(greenLabel);
        labelPanel.add(blueLabel);

        scrollPanel = new JPanel();
        scrollPanel.setLayout(grid);
        scrollPanel.add(redBar);
        scrollPanel.add(greenBar);
        scrollPanel.add(blueBar);

        bigPanel = new JPanel();
        bigPanel.setLayout(new BorderLayout());
        bigPanel.add(labelPanel, BorderLayout.WEST);
        bigPanel.add(scrollPanel, BorderLayout.CENTER);

        frame.add(bigPanel, BorderLayout.SOUTH);
        */
        aBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, -2000, 2000);
        a = Double.parseDouble(df.format(aBar.getValue() / 1000.0));
        aBar.addAdjustmentListener(this);
        aBar.addMouseListener(this);
        aLabel = new JLabel("A: 0.000");

        bBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, -2000, 2000);
        b = Double.parseDouble(df.format(bBar.getValue() / 1000.0));
        bBar.addAdjustmentListener(this);
        bBar.addMouseListener(this);
        bLabel = new JLabel("B: 0.000");

        zoomBar = new JScrollBar(JScrollBar.HORIZONTAL, 1000, 0, 0, 10000);
        zoom = Double.parseDouble(df.format(zoomBar.getValue() / 1000.0));
        zoomBar.addAdjustmentListener(this);
        zoomBar.addMouseListener(this);
        zoomLabel = new JLabel("Zoom: "+zoom);

        hueBar = new JScrollBar(JScrollBar.HORIZONTAL, 1000, 0, 0, 1000);
        hue = Float.parseFloat(df.format(hueBar.getValue() / 1000.0));
        hueBar.addAdjustmentListener(this);
        hueBar.addMouseListener(this);
        hueLabel = new JLabel("Hue: "+hue);

        satBar = new JScrollBar(JScrollBar.HORIZONTAL, 1000, 0, 0, 1000);
        saturation = Float.parseFloat(df.format(satBar.getValue() / 1000.0));
        satBar.addAdjustmentListener(this);
        satBar.addMouseListener(this);
        satLabel = new JLabel("Saturation: "+saturation);

        brightBar = new JScrollBar(JScrollBar.HORIZONTAL, 1000, 0, 0, 1000);
        brightness = Float.parseFloat(df.format(brightBar.getValue() / 1000.0));
        brightBar.addAdjustmentListener(this);
        brightBar.addMouseListener(this);
        brightLabel = new JLabel("Brightness: "+brightness);

        eyeBar = new JScrollBar(JScrollBar.HORIZONTAL, 333, 0, 0, 1000);
        eye = Float.parseFloat(df.format(eyeBar.getValue() / 1000.0));
        eyeBar.addAdjustmentListener(this);
        eyeBar.addMouseListener(this);
        eyeLabel = new JLabel("Eye Hue: "+eye);


        eBrightBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 1000);
        eBrightness = Float.parseFloat(df.format(eBrightBar.getValue() / 1000.0));
        eBrightBar.addAdjustmentListener(this);
        eBrightBar.addMouseListener(this);
        eBrightLabel = new JLabel("Eye Brightness: "+eBrightness);

        GridLayout grid = new GridLayout(8, 1);

        labelPanel = new JPanel();
        labelPanel.setLayout(grid);
        labelPanel.add(aLabel);
        labelPanel.add(bLabel);
        labelPanel.add(zoomLabel);
        labelPanel.add(hueLabel);
        labelPanel.add(satLabel);
        labelPanel.add(brightLabel);
        labelPanel.add(eyeLabel);
        labelPanel.add(eBrightLabel);

        scrollPanel = new JPanel();
        scrollPanel.setLayout(grid);
        scrollPanel.add(aBar);
        scrollPanel.add(bBar);
        scrollPanel.add(zoomBar);
        scrollPanel.add(hueBar);
        scrollPanel.add(satBar);
        scrollPanel.add(brightBar);
        scrollPanel.add(eyeBar);
        scrollPanel.add(eBrightBar);

        bigPanel = new JPanel();
        bigPanel.setLayout(new BorderLayout());
        bigPanel.add(labelPanel, BorderLayout.WEST);
        bigPanel.add(scrollPanel, BorderLayout.CENTER);

        /*
        juliaPane = new JScrollPane(this, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        juliaPane.addMouseListener(this);
        juliaPane.getVerticalScrollBar().addMouseListener(this);
        juliaPane.getHorizontalScrollBar().addMouseListener(this);


        this.setPreferredSize(new Dimension(frame.getWidth()*2, frame.getHeight()*2));
         */

        frame.add(bigPanel, BorderLayout.SOUTH);
        //frame.add(juliaPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        //g.setColor(new Color(red, green, blue));
        g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
        drawJulia(g);
    }
    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {

       /*
       if(e.getSource() == redBar)
            red = redBar.getValue();
        if(e.getSource() == greenBar)
            green = greenBar.getValue();
        if(e.getSource() == blueBar)
            blue = blueBar.getValue();
        */
        if(e.getSource() == aBar){
            a = Double.parseDouble(df.format(aBar.getValue() / 1000.0));
            aLabel.setText("A: "+a);
        }
        if(e.getSource() == bBar){
            b = Double.parseDouble(df.format(bBar.getValue() / 1000.0));
            bLabel.setText("B: "+b);
        }
        if(e.getSource() == zoomBar){
            zoom = Double.parseDouble(df.format(zoomBar.getValue() / 1000.0));
            zoomLabel.setText("Zoom: "+zoom);
        }
        if(e.getSource() == hueBar){
            hue = Float.parseFloat(df.format(hueBar.getValue() / 1000.0));
            hueLabel.setText("Hue: "+hue);
        }
        if(e.getSource() == satBar){
            saturation = Float.parseFloat(df.format(satBar.getValue() / 1000.0));
            satLabel.setText("Saturation: "+ saturation);
        }
        if(e.getSource() == brightBar){
            brightness = Float.parseFloat(df.format(brightBar.getValue() / 1000.0));
            brightLabel.setText("Brightness: "+brightness);
        }
        if(e.getSource() == eyeBar){
            eye = Float.parseFloat(df.format(eyeBar.getValue() / 1000.0));
            eyeLabel.setText("Eye Hue: "+eye);
        }
        if(e.getSource() == eBrightBar){
            eBrightness = Float.parseFloat(df.format(eBrightBar.getValue() / 1000.0));
            eBrightLabel.setText("Eye Brightness: "+eBrightness);
        }

        repaint();
    }

    public void drawJulia(Graphics g){

        int w = frame.getWidth();
        int h = frame.getHeight();
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        //nested for loop running through all the pixels
        for(int i=0; i<w; i+=pixelSize){
            for(int j=0; j<h; j+=pixelSize){
                //int zoom= 1;
                float it = maxIter;
                double zx = 1.5 * ((i - (w/2))/(0.5 * zoom * w));
                double zy = (j - (h/2)) / (0.5 * zoom * h);

                while((zx*zx) + (zy*zy) < 6 && it > 0){

                    double temp = ((zx*zx) - (zy*zy)) + a;
                    zy = (2 * zx * zy) + b;
                    zx = temp;
                    it--;

                    int c;
                    // hue:  0.33 = green  0.66 = blue    1 = red
                    if(it > 0)
                        c = Color.HSBtoRGB( hue * (maxIter / it) % 1, saturation, brightness);
                    else{
                        c = Color.HSBtoRGB(eye, 1, eBrightness);
                    }
                    image.setRGB(i, j, c);
                }
            }
        }
        g.drawImage(image, 0, 0, null);

    }

    public static void main(String[]args){
        JuliaSetProgram app = new JuliaSetProgram();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        pixelSize = 3;
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        pixelSize = 1;
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

