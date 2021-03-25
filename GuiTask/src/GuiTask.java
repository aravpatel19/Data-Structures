import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;

public class GuiTask extends JPanel implements ActionListener{

    JFrame frame;
    //JMenuBar - JMenu - JMenuItem
    JMenuBar menu;
    JPanel buttonPanel, bigPanel;
    GridLayout buttonLayout, bigLayout;
    JButton north, south, east, west, reset;
    JMenu fontOptions, fontSizeOptions, bgColorOptions, fgColorOptions, borderOptions;
    JMenuItem[] fontOption, fontSizeOption, bgColorOption, fgColorOption, borderOption;
    JTextArea textArea;
    Font currFont;
    int currFontSize;
    Color currBGColor, currFGColor, currBorderColor;
    String[] fontNames, fontSizeNames, bgColorNames, fgColorNames, borderNames;
    Font[] fonts;
    int[] fSizes;
    Color[] bgColor, fgColor, borderColors, tbColor;

    public GuiTask(){
        frame = new JFrame("Arav's Gui Thing");
        frame.setLayout(new BorderLayout());
        menu = new JMenuBar();
        fontOptions = new JMenu("Font");
        fontSizeOptions = new JMenu("Font Size");
        fgColorOptions = new JMenu("Text Color");
        bgColorOptions = new JMenu("Background Color");
        borderOptions = new JMenu("Border Color");

        menu.setLayout(new GridLayout(1, 6));

        menu.add(fontOptions);
        fontNames = new String[]{"Times New Roman", "Arial", "Consolas"};
        fonts = new Font[fontNames.length];
        fSizes = new int[]{18, 24, 36, 48};
        fontOption = new JMenuItem[fontNames.length];
        for(int i=0; i<fontNames.length; i++){
            //                     Name, Type, Size
            fonts[i] = new Font(fontNames[i], Font.PLAIN, fSizes[0]);
            fontOption[i] = new JMenuItem(fontNames[i]);
            fontOption[i].setFont(fonts[i]);
            fontOption[i].addActionListener(this);
            fontOptions.add(fontOption[i]);
        }
        currFont = fonts[0];

        menu.add(fontSizeOptions);
        fontSizeNames = new String[]{"18", "24", "36", "48"};
        fontSizeOption = new JMenuItem[fontSizeNames.length];
        for(int i=0; i<fontSizeNames.length; i++){
            fontSizeOption[i] = new JMenuItem(fontSizeNames[i]);
            fontSizeOption[i].setFont(currFont);
            fontSizeOption[i].addActionListener(this);
            fontSizeOptions.add(fontSizeOption[i]);
        }
        currFontSize = fSizes[0];

        borderColors = new Color[]{Color.MAGENTA};
        tbColor = new Color[]{Color.BLACK};

        menu.add(fgColorOptions);
        fgColorNames = new String[]{"Black", "Green", "Red", "Blue"};
        fgColor = new Color[]{Color.BLACK, Color.GREEN, Color.RED, Color.BLUE};
        fgColorOption = new JMenuItem[fgColorNames.length];
        for(int i=0; i<fgColorNames.length; i++){
            fgColorOption[i] = new JMenuItem(fgColorNames[i]);
            fgColorOption[i].setFont(currFont);
            fgColorOption[i].addActionListener(this);
            fgColorOptions.add(fgColorOption[i]);
        }
        currFGColor = fgColor[0];

        menu.add(bgColorOptions);
        bgColorNames = new String[]{"White", "Pink", "Green", "Orange"};
        bgColor = new Color[]{Color.WHITE, Color.PINK, Color.GREEN, Color.ORANGE};
        bgColorOption = new JMenuItem[bgColorNames.length];
        for(int i=0; i<bgColorNames.length; i++){
            bgColorOption[i] = new JMenuItem(bgColorNames[i]);
            bgColorOption[i].setFont(currFont);
            bgColorOption[i].addActionListener(this);
            bgColorOptions.add(bgColorOption[i]);
        }
        currBGColor = bgColor[0];

        menu.add(borderOptions);
        borderNames = new String[]{"Magenta", "Black", "Cyan", "Red"};
        borderColors = new Color[]{Color.MAGENTA, Color.BLACK, Color.CYAN, Color.RED};
        borderOption = new JMenuItem[borderNames.length];
        for(int i=0; i<borderNames.length; i++){
            borderOption[i] = new JMenuItem(borderNames[i]);
            borderOption[i].setFont(currFont);
            borderOption[i].addActionListener(this);
            borderOptions.add(borderOption[i]);
        }
        currBorderColor = borderColors[0];


        reset = new JButton("Reset");
        reset.addActionListener(this);
        menu.add(reset);


        north = new JButton("North");
        south = new JButton("South");
        east = new JButton("East");
        west = new JButton("West");

        buttonPanel = new JPanel();
        buttonLayout = new GridLayout(1, 4);
        buttonPanel.setLayout(buttonLayout);
        buttonPanel.add(north);
        buttonPanel.add(south);
        buttonPanel.add(east);
        buttonPanel.add(west);

        north.addActionListener(this);
        south.addActionListener(this);
        east.addActionListener(this);
        west.addActionListener(this);

        north.setBorder(new LineBorder(borderColors[0]));
        south.setBorder(new LineBorder(borderColors[0]));
        east.setBorder(new LineBorder(borderColors[0]));
        west.setBorder(new LineBorder(borderColors[0]));
        reset.setBorder(new LineBorder(borderColors[0]));


        textArea = new JTextArea();
        textArea.setBackground(bgColor[0]);
        textArea.setForeground(fgColor[0]);
        textArea.setFont(fonts[0]);

        bigLayout = new GridLayout(1, 2);
        bigPanel = new JPanel();
        bigPanel.setLayout(bigLayout);
        bigPanel.add(buttonPanel);
        bigPanel.add(menu);

        frame.add(bigPanel, BorderLayout.NORTH);
        frame.add(textArea, BorderLayout.CENTER);
        frame.setSize(1500, 1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[]args){
        GuiTask app = new GuiTask();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == north){
            frame.remove(bigPanel);

            buttonLayout = new GridLayout(1, 4);
            bigLayout = new GridLayout(1, 2);

            buttonPanel.setLayout(buttonLayout);
            bigPanel.setLayout(bigLayout);

            bigPanel.remove(menu);
            bigPanel.remove(buttonPanel);

            menu.setLayout(new GridLayout(1, 6));
            menuMethod();

            bigPanel.add(buttonPanel);
            bigPanel.add(menu);

            frame.add(bigPanel, BorderLayout.NORTH);
        }
        if(e.getSource() == south){
            frame.remove(bigPanel);

            buttonLayout = new GridLayout(1, 4);
            bigLayout = new GridLayout(1, 2);

            buttonPanel.setLayout(buttonLayout);
            bigPanel.setLayout(bigLayout);

            bigPanel.remove(menu);
            bigPanel.remove(buttonPanel);

            menu.setLayout(new GridLayout(1, 6));
            menuMethod();

            bigPanel.add(buttonPanel);
            bigPanel.add(menu);

            frame.add(bigPanel, BorderLayout.SOUTH);
        }
        if(e.getSource() == east){
            frame.remove(bigPanel);

            buttonLayout = new GridLayout(4, 1);
            bigLayout = new GridLayout(2, 1);

            buttonPanel.setLayout(buttonLayout);
            bigPanel.setLayout(bigLayout);
            menu.setLayout(new GridLayout(6, 1));

            bigPanel.remove(menu);
            bigPanel.remove(buttonPanel);
            menuMethod();

            bigPanel.add(buttonPanel);
            bigPanel.add(menu);

            frame.add(bigPanel, BorderLayout.EAST);
        }
        if(e.getSource() == west){
            frame.remove(bigPanel);

            buttonLayout = new GridLayout(4, 1);
            bigLayout = new GridLayout(2, 1);

            buttonPanel.setLayout(buttonLayout);
            bigPanel.setLayout(bigLayout);
            menu.setLayout(new GridLayout(6, 1));

            bigPanel.remove(menu);
            bigPanel.remove(buttonPanel);
            menuMethod();

            bigPanel.add(buttonPanel);
            bigPanel.add(menu);

            frame.add(bigPanel, BorderLayout.WEST);
        }

        //change fonts
        for(int i=0; i<fontNames.length; i++){
            if(e.getSource() == fontOption[i]){
                currFont = new Font(fonts[i].getName(), Font.PLAIN, currFontSize);
                textArea.setFont(currFont);
                north.setFont(currFont);
                south.setFont(currFont);
                east.setFont(currFont);
                west.setFont(currFont);
                fontOptions.setFont(currFont);
                fontSizeOptions.setFont(currFont);
                fgColorOptions.setFont(currFont);
                bgColorOptions.setFont(currFont);
                borderOptions.setFont(currFont);

            }
        }

        //change font sizes
        for(int i=0; i<fontSizeNames.length; i++){
            if(e.getSource() == fontSizeOption[i]){
                currFontSize = fSizes[i];
                currFont = new Font(currFont.getName(), Font.PLAIN, currFontSize);
                textArea.setFont(currFont);
            }
        }

        //change text color
        for(int i=0; i<fgColorNames.length; i++){
            if(e.getSource() == fgColorOption[i]){
                currFGColor = fgColor[i];
                textArea.setForeground(currFGColor);
            }
        }

        //change background color
        for(int i=0; i<bgColorNames.length; i++){
            if(e.getSource() == bgColorOption[i]){
                currBGColor = bgColor[i];
                textArea.setBackground(currBGColor);
            }
        }

        //change border color
        for(int i=0; i<borderNames.length; i++){
            if(e.getSource() == borderOption[i]){
                currBorderColor = borderColors[i];
                north.setBorder(new LineBorder(currBorderColor));
                south.setBorder(new LineBorder(currBorderColor));
                east.setBorder(new LineBorder(currBorderColor));
                west.setBorder(new LineBorder(currBorderColor));
                reset.setBorder(new LineBorder(currBorderColor));
            }
        }

        if(e.getSource() == reset){
            frame.remove(bigPanel);

            buttonLayout = new GridLayout(1, 4);
            bigLayout = new GridLayout(1, 2);

            buttonPanel.setLayout(buttonLayout);
            bigPanel.setLayout(bigLayout);

            bigPanel.remove(menu);
            bigPanel.remove(buttonPanel);

            menu.setLayout(new GridLayout(1, 6));
            menuMethod();

            bigPanel.add(buttonPanel);
            bigPanel.add(menu);

            frame.add(bigPanel, BorderLayout.NORTH);

            textArea.setText(null);
            textArea.setBackground(bgColor[0]);
            textArea.setForeground(fgColor[0]);
            Font temp = new Font(fontNames[0], Font.PLAIN, fSizes[0]);
            textArea.setFont(temp);
            north.setFont(temp);
            south.setFont(temp);
            east.setFont(temp);
            west.setFont(temp);
            reset.setFont(temp);
            fontOptions.setFont(temp);
            fontSizeOptions.setFont(temp);
            bgColorOptions.setFont(temp);
            fgColorOptions.setFont(temp);
            borderOptions.setFont(temp);
            north.setBorder(new LineBorder(borderColors[0]));
            south.setBorder(new LineBorder(borderColors[0]));
            east.setBorder(new LineBorder(borderColors[0]));
            west.setBorder(new LineBorder(borderColors[0]));
            reset.setBorder(new LineBorder(borderColors[0]));
        }

        frame.revalidate();
    }
    public void menuMethod(){
        menu.remove(fontOptions);
        menu.remove(fontSizeOptions);
        menu.remove(fgColorOptions);
        menu.remove(bgColorOptions);
        menu.remove(borderOptions);
        menu.remove(reset);
        menu.add(fontOptions);
        menu.add(fontSizeOptions);
        menu.add(fgColorOptions);
        menu.add(bgColorOptions);
        menu.add(borderOptions);
        menu.add(reset);
    }
}
