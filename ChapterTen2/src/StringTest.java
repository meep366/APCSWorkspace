import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import javax.swing.*;

/**
 * @author croftj
 * Date of Completion: 10/4/12
 * Assignment Java Ch.10 and practices 1-4
 * Attribution: none
 * 
 * All work here is honestly obtain and is my own.
 * 
 * Basic string tester class to test miscellaneous String methods
 * 
 */






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
    
    
    
    
    str = reverse(str);
    System.out.println(isPalindrome(str));
    
    
    

    result.setText(str);
    input.selectAll();
  }
  
  //@param ssn-Social Security #
  //@return Social Security # w/o dashes
  public String removeDashes(String ssn)    //takes a Social Security number and removes the dashes
  {
	  ssn=ssn.replace("-","");
	  return ssn;
  }
  
//@param str-name in last,first format
//@return name in first last format
  public String writeFirstLast(String str)   //takes a name in last, first notation and puts it in first last notation
  {
	  String st1=str.substring(0,str.indexOf(",")).trim();
	  String st2=str.substring(str.indexOf(",")+1).trim();
	  str=st2+st1;
	  return st2+" "+st1;
  }
  
//@param str-any string to be reversed
//@return reversed string
  public String reverse(String str) //takes a string and reverses it
  {
	  String st="";
	  for(int i=0;i<str.length();i++)
	  {
		  st=st+str.charAt(str.length()-(i+1));
	  }
	  return st;
  }
  
  
//@param date-date in mm/dd/yyyy format
//@return date in mm-dd-yyyy format
  public String dateChange(String date)  //takes a date in mm/dd/yyyy format and puts it in mm-dd-yyyy format
  {
	  String st1=date.substring(0,date.indexOf('/'));
	  String st2=date.substring(date.lastIndexOf('/',2)+1,date.lastIndexOf('/',5));
	  String st3=date.substring(date.lastIndexOf('/')+1);
	  date=st1+"-"+st2+"-"+st3;
	  return date;
  }
  
//@param ccNumber-credit card #
//@return last five digits of ccNumber
  public String creditCard(String ccNumber) //finds the last four and five digits of a credit card number
  {
	  String last4=ccNumber.substring(15);
	  String last5=ccNumber.charAt(13)+last4;
	  return last5;
  }
  
//@param str-string to be scrolled
//@return scrolled string
  public String scroll(String str)  //takes the first character of a string and puts it at the end
  {
	  return str.substring(1)+str.charAt(0);
  }
  
  
//@param str-string to be checked for a comment
//@return string w/o comment, if possible
  public String ending(String str)  //checks for a comment in a string, and removes it and its surrounding symbols if it's there, otherwise returns the original
  {
	  if(str.indexOf("*/")>0 && str.indexOf("/*")>0)
	  {
		  return str.substring(0,str.indexOf("/*"))+str.substring(str.lastIndexOf("*/")+2);
	  }
	  return str;
  }
  
  
//@param str-string to be checked for an HTML tag
//@return string w/o HTML tag, if possible
  public String removeTag(String str) //checks for an HTML tag and removes the tag if it finds it, otherwise returns teh original
  {
	  if(str.charAt(0)=='<' && str.charAt(str.length()-1)=='>' && str.charAt(2)=='>' && str.charAt(str.length()-4)=='<'
			  && str.charAt(str.length()-3)=='/')  //checks for proper HTML tag
	  {
		  if(str.charAt(1)==str.charAt(str.length()-2))
		  {
			  str=str.substring(3,str.length()-4);
			  return str;
		  }
	  }
	  return str;
  }
  
  
//@param str-string to be checked for digits only
//@return true if only digits, false otherwise
  public boolean digits(String str) //checks if all the characters in a string are digits
  {
	  for(int i=0;i<str.length();i++)
	  {
		  char c = str.charAt(i);
		  if(!Character.isDigit(c))
		  {
			  return false;
		  }
	  }
	  return true;
  }
  
  

  public void comparing()  //checks to see if two inputed strings both have the same sign for subtraction and compareTo
  {
	  Scanner kboard = new Scanner(System.in); //taking input
	  String s1=kboard.next();
	  String s2=kboard.next();
	  
	  
	  int n1=Integer.parseInt(s1);
	  int n2=Integer.parseInt(s2);
	  System.out.println(s1.compareTo(s2));
	  System.out.println(n1-n2);
  }
  
  
//@param isbn-ISBN number to be validated
//@return true if valid, false if not
  public static boolean isValidISBN(String isbn) //checks to see if an ISBN number is valid
  {
	  if(isbn.length()!=13) 
		  return false;
	  
	  int sum=0;
	  for(int i=0;i<13;i++) //keeps track of sum and multiplies by 3 as necessary
	  {
		  if(i%2==0)
			  sum+=Character.digit(isbn.charAt(i),10);
		  else
			  sum+=3*Character.digit(isbn.charAt(i),10);
	  }
	  System.out.println(sum);
	  if(sum%10==0)
		  return true;
	  else
		  return false;
  }
  
  
  
//@param str-string to be checked if it's a palindrome
//@return true if palindrome, false if not
  public boolean isPalindrome(String str) //checks to see if a string is a palindrome
  {
	  str=str.toLowerCase();
	  for(int i=0;i<str.length();i++)  //takes out non-letter characters
	  {
		  char c=str.charAt(i);
		  if(!Character.isLetter(c))
			  str=str.replace(Character.toString(c),"");
	  }
	  
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

