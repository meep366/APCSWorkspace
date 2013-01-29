import javax.swing.JFrame;

/**
 * The main class for the <i>SafeTrade</i> application.
 */
public class SafeTrade
{
  public static void main(String[] args)
  {
    StockExchange exchange = new StockExchange();
    exchange.listStock("DS", "DanceStudios.com", 12.33);
    exchange.listStock("NSTL", "Nasty Loops Inc.", 0.25);
    exchange.listStock("GGGL", "Giggle.com", 10.00);
    exchange.listStock("MATI", "M and A Travel Inc.", 28.20);
    exchange.listStock("DDLC", "Dulce De Leche Corp.", 57.50);
    exchange.listStock("SAFT", "SafeTrade.com Inc.", 322.45);

    Brokerage safeTrade = new Brokerage(exchange);
    safeTrade.addUser("stockman", "sesame");
    safeTrade.login("stockman", "sesame");
    safeTrade.addUser("mstrade", "bigsecret");
    safeTrade.login("mstrade", "bigsecret");

    LoginWindow window = new LoginWindow("Safe Trade", safeTrade);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setBounds(0, 0, 360, 140);
    window.setVisible(true);
  }
}
