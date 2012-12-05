import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StringTest extends JFrame
        implements ActionListener
{
  private JTextField input, result;

  public StringTest()
  {
    super("String test");
    Box box1 = Box.createVerticalBox();
    box1.add(new JLabel("Input:"));
    box1.add(Box.createVerticalStrut(10));
    box1.add(new JLabel("Result:"));

    input = new JTextField(20);
    input.setBackground(Color.WHITE);
    input.addActionListener(this);
    input.selectAll();

    result = new JTextField(20);
    result.setBackground(Color.WHITE);
    result.setEditable(false);

    Box box2 = Box.createVerticalBox();
    box2.add(input);
    box2.add(Box.createVerticalStrut(10));
    box2.add(result);

    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    c.add(box1);
    c.add(box2);
    input.requestFocus();
  }

  public void actionPerformed(ActionEvent e)
  {
    String str = input.getText();

    // ... insert code to process str or call a method here
    
    
    
    
    str = ending(str);
    
    
    
    
    

    result.setText(str);
    input.selectAll();
  }
  
  public String removeDashes(String ssn)
  {
	  ssn=ssn.replace("-","");
	  return ssn;
  }
  public String writeFirstLast(String str)
  {
	  String st1=str.substring(0,str.indexOf(",")).trim();
	  String st2=str.substring(str.indexOf(",")+1).trim();
	  str=st2+st1;
	  return st2+" "+st1;
  }
  
  public String reverse(String str)
  {
	  String st="";
	  for(int i=0;i<str.length();i++)
	  {
		  st=st+str.charAt(str.length()-(i+1));
	  }
	  return st;
  }
  
  public String dateChange(String date)
  {
	  String st1=date.substring(0,date.indexOf('/'));
	  String st2=date.substring(date.lastIndexOf('/',2)+1,date.lastIndexOf('/',5));
	  String st3=date.substring(date.lastIndexOf('/')+1);
	  date=st1+"-"+st2+"-"+st3;
	  return date;
  }
  
  public String creditCard(String ccNumber)
  {
	  String last4=ccNumber.substring(15);
	  String last5=ccNumber.charAt(13)+last4;
	  return last5;
  }
  
  public String scroll(String str)
  {
	  return str.substring(1)+str.charAt(0);
  }
  
  public String ending(String str)
  {
	  if(str.indexOf("*/")>0 && str.indexOf("/*")>0)
	  {
		  return str.substring(0,str.indexOf("/*"))+str.substring(str.lastIndexOf("*/")+2);
	  }
	  return str;
  }
  
  public String removeTag(String str)
  {
	  if(str.charAt(0)=='<' && str.charAt(str.length()-1)=='>' && str.charAt(2)=='>' && str.charAt(str.length()-4)=='>'
			  && str.charAt(str.length()-3)=='/')
	  {
		  if(str.charAt(1)==str.charAt(str.length()-2))
		  {
			  str=str.substring(3,str.length()-4);
			  return str;
		  }
	  }
	  return str;
  }
  
  
  
  public boolean isPalindrome(String str)
  {
	  str=str.toLowerCase();
	  str=str.replace(",","");
	  str=str.replace("'", "");
	  str=str.replace(".", "");
	  str=str.replace(";", "");
	  str=str.replace(" ", "");
	  str=str.replace("’", "");
	  str=str.replace(":", "");
	  str=str.replace("\"", "");
	  if(str.equals(reverse(str)))
		  return true;
	  return false;
	  
	 
  }
  

  public static void main(String[] args)
  {
    StringTest window = new StringTest();
    window.setBounds(100, 100, 300, 100);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setVisible(true);
    
  }
}

