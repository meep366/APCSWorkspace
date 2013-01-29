import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.Box;
import javax.swing.AbstractButton;

import javax.swing.border.EmptyBorder;

/**
 * Provides GUI for a trader.
 */
public class TraderWindow extends JFrame
    implements ActionListener
{
  private static final String PROMPT = ">> ";

  private Trader myTrader;

  private JButton quoteBtn, orderBtn;
  private JRadioButton buyBtn, sellBtn, limitBtn, marketBtn;
  private JTextField symbText, nsText, priceText;
  private JTextArea msgArea;

  /**
   * Constructs a new trading window for a trader.
   * @param trader a trader that will own this window.
   */
  public TraderWindow(Trader trader)
  {
    super(trader.getName());

    addWindowListener(new WindowAdapter()
      { public void windowClosing(WindowEvent e) { myTrader.quit(); }});

    myTrader = trader;

    JPanel panel = new JPanel();
    GridBagLayout gbLayout = new GridBagLayout();
    panel.setLayout(gbLayout);
    panel.setBorder(new EmptyBorder(10, 10, 10, 10));

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;

    JLabel label = new JLabel("Stock symbol:  ", JLabel.RIGHT);
    gbc.gridy = 0; gbc.gridx = 0; gbc.gridwidth = 2; gbc.gridheight = 1;
    gbLayout.setConstraints(label, gbc); panel.add(label);
    symbText = new JTextField(5);
    symbText.setBackground(Color.yellow);
    gbc.gridy = 0; gbc.gridx = 2; gbc.gridwidth = 1;
    gbLayout.setConstraints(symbText, gbc); panel.add(symbText);

    JLabel filler = new JLabel(" ");
    gbc.gridy = 1; gbc.gridx = 0; gbc.gridwidth = 3;
    gbLayout.setConstraints(filler, gbc); panel.add(filler);

    quoteBtn = new JButton("Get quote");
    quoteBtn.addActionListener(this);
    gbc.gridy = 2; gbc.gridx = 1; gbc.gridwidth = 2;
    gbLayout.setConstraints(quoteBtn, gbc); panel.add(quoteBtn);

    filler = new JLabel("----------------------------------------");
    gbc.gridy = 3; gbc.gridx = 0; gbc.gridwidth = 3;
    gbLayout.setConstraints(filler, gbc); panel.add(filler);

    label = new JLabel("Buy  ", JLabel.RIGHT);
    gbc.gridy = 4; gbc.gridx = 0; gbc.gridwidth = 1;
    gbLayout.setConstraints(label, gbc); panel.add(label);
    label = new JLabel("Sell  ", JLabel.RIGHT);
    gbc.gridy = 5;
    gbLayout.setConstraints(label, gbc); panel.add(label);

    ButtonGroup gr = new ButtonGroup();
    buyBtn = new JRadioButton("", true);
    sellBtn = new JRadioButton();
    gr.add(buyBtn);
    gr.add(sellBtn);
    gbc.gridy = 4; gbc.gridx = 1; gbc.gridwidth = 1;
    gbLayout.setConstraints(buyBtn, gbc); panel.add(buyBtn);
    gbc.gridy = 5;
    gbLayout.setConstraints(sellBtn, gbc); panel.add(sellBtn);

    label = new JLabel("No. of shares:", JLabel.CENTER);
    gbc.gridy = 4; gbc.gridx = 2; gbc.gridwidth = 1;
    gbLayout.setConstraints(label, gbc); panel.add(label);
    nsText = new JTextField(5);
    nsText.setBackground(Color.yellow);
    gbc.gridy = 5;
    gbLayout.setConstraints(nsText, gbc); panel.add(nsText);

    filler = new JLabel(" ");
    gbc.gridy = 6; gbc.gridx = 0; gbc.gridwidth = 3;
    gbLayout.setConstraints(filler, gbc); panel.add(filler);

    label = new JLabel("Market  ", JLabel.RIGHT);
    gbc.gridy = 7; gbc.gridx = 0; gbc.gridwidth = 1;
    gbLayout.setConstraints(label, gbc); panel.add(label);
    label = new JLabel("Limit  ", JLabel.RIGHT);
    gbc.gridy = 8;
    gbLayout.setConstraints(label, gbc); panel.add(label);

    gr = new ButtonGroup();
    marketBtn = new JRadioButton("", true);
    limitBtn = new JRadioButton();
    marketBtn.addActionListener(this);
    limitBtn.addActionListener(this);
    gr.add(marketBtn);
    gr.add(limitBtn);
    gbc.gridy = 7; gbc.gridx = 1; gbc.gridwidth = 1;
    gbLayout.setConstraints(marketBtn, gbc); panel.add(marketBtn);
    gbc.gridy = 8;
    gbLayout.setConstraints(limitBtn, gbc); panel.add(limitBtn);

    label = new JLabel("Price:", JLabel.CENTER);
    gbc.gridy = 7; gbc.gridx = 2; gbc.gridwidth = 1;
    gbLayout.setConstraints(label, gbc); panel.add(label);
    priceText = new JTextField(5);
    priceText.setBackground(Color.yellow);
    gbc.gridy = 8;
    gbLayout.setConstraints(priceText, gbc); panel.add(priceText);

    filler = new JLabel(" ");
    gbc.gridy = 9; gbc.gridx = 0; gbc.gridwidth = 3;
    gbLayout.setConstraints(filler, gbc); panel.add(filler);

    orderBtn = new JButton("Place order");
    orderBtn.addActionListener(this);
    gbc.gridy = 10; gbc.gridx = 1; gbc.gridwidth = 2;
    gbLayout.setConstraints(orderBtn, gbc); panel.add(orderBtn);

    msgArea = new JTextArea(10, 30);
    msgArea.setLineWrap(true);
    msgArea.setWrapStyleWord(true);
    msgArea.setEditable(false);
    msgArea.setBorder(new EmptyBorder(5, 10, 5, 10));
    JScrollPane areaScrollPane = new JScrollPane(msgArea);
    areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    areaScrollPane.setBorder(new EmptyBorder(5, 0, 5, 0));

    Box b = Box.createHorizontalBox();
    b.add(panel);
    b.add(areaScrollPane);
    Container c = getContentPane();
    c.add(b);

    int x = (int)(Math.random()* 500);
    int y = (int)(Math.random()* 300);
    setBounds(x, y, 500, 280);
    setVisible(true);
  }

  /**
   * Displays a message in this window's text area.
   * @param msg the message to be displayed.
   */
  public void showMessage(String msg)
  {
    msgArea.append(msg + "\n\n");
  }

  /**
   * Processes GUI events in this window.
   * @param e an event.
   */
  public void actionPerformed(ActionEvent e)
  {
    AbstractButton b = (AbstractButton)e.getSource();

    if (b == quoteBtn)
    {
      getQuote();
    }
    else if (b == orderBtn)
    {
      placeOrder();
    }
    else if (b == marketBtn)
    {
      priceText.setText("");
    }
    else if (b == limitBtn)
    {
      priceText.selectAll();
      priceText.requestFocus();
    }
  }

  //******************** Private methods ************************

  // Obtains the stock symbol from this trade window and asks the trader --
  // the owner of this window -- to request a quote for that stock
  // by calling <code>myTrader.getQuote(symbol)</code>.
  private void getQuote()
  {
    String symbol = symbText.getText().trim().toUpperCase();
    if (symbol.length() == 0)
    {
      JOptionPane.showMessageDialog(this, "Missing stock symbol",
           "Input error", JOptionPane.ERROR_MESSAGE);
      return;
    }
    myTrader.getQuote(symbol);
  }

  // Obtains the order information from this trade window and asks the trader --
  // the owner of this window -- to place this order
  // by calling <code>myTrader.placeOrder(tradeOrder)</code>.
  private void placeOrder()
  {
    String errorMsg = null;
    String symbol = symbText.getText().trim().toUpperCase();

    boolean buyOrder = buyBtn.isSelected();

    String nsStr = nsText.getText().trim();

    boolean limitOrder = limitBtn.isSelected();
    boolean marketOrder = marketBtn.isSelected();

    String priceStr = priceText.getText().trim();

    if (symbol.length() == 0)
      errorMsg = "Missing stock symbol";
    else if (nsStr.length() == 0)
      errorMsg = "Enter the number of shares";
    else if (limitOrder &&  priceStr.length() == 0)
      errorMsg = "Enter the price";
    else if (marketOrder &&  priceStr.length() > 0)
      errorMsg = "Do not enter price for a Market order";

    if (errorMsg != null)
    {
      JOptionPane.showMessageDialog(this, errorMsg,
           "Input error", JOptionPane.ERROR_MESSAGE);
      return;
    }

    int numShares = 0;
    try
    {
      numShares = Integer.parseInt(nsStr);
    }
    catch (NumberFormatException ex)
    {
      errorMsg = "Invalid number of shares";
    }
    if (numShares <= 0)
      errorMsg = "Invalid number of shares";

    double price = 0.0;
    if (limitOrder)
    {
      try
      {
        price = Double.parseDouble(priceStr);
      }
      catch (NumberFormatException ex)
      {
        errorMsg = "Invalid price";
      }
    }
    else if (limitOrder && price <= 0.0)
      errorMsg = "Invalid price";

    if (errorMsg != null)
    {
      JOptionPane.showMessageDialog(this, errorMsg,
           "Input error", JOptionPane.ERROR_MESSAGE);
      return;
    }

    TradeOrder tradeOrder = new TradeOrder(myTrader, symbol, buyOrder,
                   marketOrder, numShares, price);
    myTrader.placeOrder(tradeOrder);
  }
}
