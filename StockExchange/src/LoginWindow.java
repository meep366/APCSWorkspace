import java.awt.Container;
import java.awt.GridLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import javax.swing.border.EmptyBorder;

/**
 * Provides GUI for registering and logging in users.
 */
public class LoginWindow extends JFrame
{
  private static JFrame thisWindow;
  private static Login server;

  private JTextField nameField;
  private JPasswordField passwordField;

  /**
   * Constructs a new login window.
   * @param title title bar text.
   * @param server an object that keeps track of all the registered and
   * logged-in users.
   */
  public LoginWindow(String title, Login server)
  {
    super(title);
    this.server = server;
    thisWindow = this;

    JLabel nameLabel = new JLabel("Login name:", JLabel.RIGHT);
    nameField = new JTextField(20);

    LoginListener loginListener = new LoginListener();
    JLabel passwordLabel = new JLabel("Password:", JLabel.RIGHT);
    passwordField = new JPasswordField(20);
    passwordField.addActionListener(loginListener);

    JButton loginBtn = new JButton("Login");
    loginBtn.addActionListener(loginListener);

    JButton registerBtn = new JButton("New user...");
    registerBtn.addActionListener(new RegistrationListener());

    JPanel fieldsPanel = new JPanel(new GridLayout(3, 3, 10, 10));
    fieldsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

    fieldsPanel.add(nameLabel);
    fieldsPanel.add(nameField);
    fieldsPanel.add(new JPanel());  // filler

    fieldsPanel.add(new JLabel("Password:", JLabel.RIGHT));
    fieldsPanel.add(passwordField);
    fieldsPanel.add(new JPanel());  // filler

    fieldsPanel.add(new JPanel());  // filler
    fieldsPanel.add(loginBtn);
    fieldsPanel.add(registerBtn);

    Container c = getContentPane();
    c.add(fieldsPanel);
  }

  /******************************************************************/
  /***      passwordField and "Login" button events handling      ***/
  /******************************************************************/

  private class LoginListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      String name = nameField.getText().trim().toLowerCase();
      String password = (new String(passwordField.getPassword())).trim().toLowerCase();
      tryLogin(name, password);
      nameField.setText("");
      passwordField.setText("");
    }

    private void tryLogin(String name, String password)
    {
      String errorMsg = "";
      int result = server.login(name, password);

      if (result < 0)
      {
        if (result == -1)
          errorMsg = "User unknown";
        else if (result == -2)
          errorMsg = "Invalid password";
        else if (result == -3)
          errorMsg = "User already logged in";
        else
          errorMsg = "Unknown error code";

        JOptionPane.showMessageDialog(thisWindow, errorMsg,
                        "Login failed", JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  /******************************************************************/
  /*********      "New user..." button events handling      *********/
  /******************************************************************/

  private class RegistrationListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      while (!registered());
    }

    private boolean registered()
    {
      JLabel regNameLabel = new JLabel("Login name (4-10 chars):", JLabel.RIGHT);
      JTextField regNameField = new JTextField(20);
      JLabel regPasswordLabel = new JLabel("Password (2-10 chars):", JLabel.RIGHT);
      JPasswordField regPasswordField = new JPasswordField(20);
      JLabel regPasswordLabel2 = new JLabel("Confirm password:", JLabel.RIGHT);
      JPasswordField regPasswordField2 = new JPasswordField(20);

      JPanel fieldsPanel = new JPanel();
      fieldsPanel.setLayout(new GridLayout(3, 2, 10, 10));
      fieldsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
      fieldsPanel.add(regNameLabel);
      fieldsPanel.add(regNameField);
      fieldsPanel.add(regPasswordLabel);
      fieldsPanel.add(regPasswordField);
      fieldsPanel.add(regPasswordLabel2);
      fieldsPanel.add(regPasswordField2);

      final String optionNames[] = {"Register", "Cancel"};

      if (JOptionPane.showOptionDialog(thisWindow, fieldsPanel,
          "New user registration", JOptionPane.OK_CANCEL_OPTION,
          JOptionPane.PLAIN_MESSAGE, null, optionNames,
          optionNames[0]) != 0)
        return true;  // User pressed "Cancel"

      String name = regNameField.getText().trim().toLowerCase();
      String password = (new String(regPasswordField.getPassword())).trim().toLowerCase();
      String password2 = (new String(regPasswordField2.getPassword())).trim().toLowerCase();

      String errorMsg = "";
      int result = password.compareTo(password2);

      if (result != 0)
      {
        errorMsg = "Passwords mismatch, re-enter";
      }
      else
      {
        result = server.addUser(name, password);
        if (result < 0)
        {
          if (result == -1)
            errorMsg = "Login name must be 4-10 characters long";
          else if (result == -2)
            errorMsg = "Password must be 2-10 characters long";
          else if (result == -3)
            errorMsg = "Login name already taken, choose another one";
          else
            errorMsg = "Unknown error code";
        }
      }

      if (result != 0)
      {
        JOptionPane.showMessageDialog(thisWindow, errorMsg,
                    "Registration failed", JOptionPane.ERROR_MESSAGE);
        nameField.setText("");
        passwordField.setText("");
        return false;
      }
      else
      {
        JOptionPane.showMessageDialog(thisWindow, "Added " + name,
                    "Registration successful", JOptionPane.INFORMATION_MESSAGE);
        nameField.setText(name);
        passwordField.setText(password);
        return true;
      }
    }
  }
}
