package SnackBar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VendingMachine extends JPanel
                            implements ActionListener
{
  private static final int FULL_STOCK = 5;
  private JButton deposit25c, deposit10c, deposit5c, go;
  private JTextField display;
  private Vendor vendor;
  boolean trayFull;
  private String changeString;
  Color brandColor;
  String brandName;

  public VendingMachine(String brand, Color color, int price, ImageIcon coin)
  {
    setBackground(Color.WHITE);
    brandColor = color;
    brandName = brand;

    JTextField banner = new JTextField("  " + brandName +
                                       "  " + price + "c  ");
    banner.setEditable(false);
    banner.setFont(new Font("Serif", Font.BOLD, 14));
    banner.setHorizontalAlignment(JTextField.CENTER);

    deposit25c = new JButton(" 25 ", coin);
    deposit25c.addActionListener(this);
    deposit10c = new JButton(" 10 ", coin);
    deposit10c.addActionListener(this);
    deposit5c = new JButton("  5 ", coin);
    deposit5c.addActionListener(this);
    go = new JButton("   ");
    go.setBackground(Color.RED);
    go.addActionListener(this);
    JPanel buttons = new JPanel(new GridLayout(3, 1, 5, 0));
    buttons.setBackground(Color.BLUE);
    buttons.add(deposit25c);
    buttons.add(deposit10c);
    buttons.add(deposit5c);

    display = new JTextField("0  ");
    display.setFont(new Font("Monospaced", Font.BOLD, 16));
    display.setBackground(Color.YELLOW);
    display.setEditable(false);
    display.setHorizontalAlignment(JTextField.RIGHT);

    Box b1 = Box.createVerticalBox();
    b1.add(banner);
    b1.add(Box.createVerticalStrut(5));
    b1.add(display);
    b1.add(Box.createVerticalStrut(12));
    Box b2 = Box.createHorizontalBox();
    b2.add(Box.createHorizontalStrut(60));
    Box b3 = Box.createVerticalBox();
    b3.add(go);
    b3.add(Box.createVerticalStrut(8));
    b3.add(buttons);
    b2.add(b3);
    b1.add(b2);
    b1.add(Box.createVerticalStrut(5));
    add(b1);

    vendor = new Vendor(price, FULL_STOCK);
  }

  public void reload()
  {
    vendor.setStock(FULL_STOCK);
    display.setText(" " + vendor.getDeposit() + "  ");
    repaint();
  }

  public void actionPerformed(ActionEvent e)
  {
    JButton b = (JButton)e.getSource();

    if (b == deposit25c)
      vendor.addMoney(25);
    else if (b == deposit10c)
      vendor.addMoney(10);
    else if (b == deposit5c)
      vendor.addMoney(5);
    else if (b == go)
    {
      trayFull = vendor.makeSale();
      
      
      changeString=vendor.getChangeString();
      int change = vendor.getChange();
      
      
      if (trayFull)          // Successful sale
      {
        repaint();
        
        
        
        
        JOptionPane.showMessageDialog(null,
          "Enjoy your " + brandName + "\n" + " Change " + change + "c = " + changeString,
          "Enjoy " + brandName, JOptionPane.PLAIN_MESSAGE);
        trayFull = false;
        
        
        
      }
      else if (change > 0)   // Refund
      {
        JOptionPane.showMessageDialog(null,
          "Take " + change + "c back",
          "Money back", JOptionPane.ERROR_MESSAGE);
      }
    }

    if (vendor.getStock() > 0)
      display.setText(" " + vendor.getDeposit() + "  ");
    else
      display.setText("Call service ");

    repaint();
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    final int x0 = getWidth() / 12;
    final int y0 = getHeight() / 2;
    final int yStep = 14;

    g.setColor(Color.BLACK);
    g.drawRect(x0, y0, 28, FULL_STOCK * yStep + 4);

    int y = y0 + 4, x = x0 + 4;
    int stock = vendor.getStock();
    int count = FULL_STOCK;

    while (count > 0)
    {
      if (count <= stock)
        drawCan(g, x, y);
      y += yStep;
      count--;
    }

    g.setColor(Color.BLUE);
    y += yStep;
    g.drawRect(x0, y - 4, 28, 18);

    if (trayFull)
      drawCan(g, x, y);
  }

  private void drawCan(Graphics g, int x, int y)
  {
    g.setColor(brandColor);
    g.fillRoundRect(x, y, 20, 10, 4, 4);
    g.setColor(Color.WHITE);
    g.drawLine(x + 2, y + 4, x + 14, y + 4);
    g.drawLine(x + 2, y + 6, x + 14, y + 6);
  }
}

