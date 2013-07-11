import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.sdk.verbs.Sms;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.TwiMLResponse;

/**
 * 
 */

/**
 * @author jack
 *
 */
public class TwilioServlet extends HttpServlet{

	/**
	 * @param args
	 */
	
	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		TwiMLResponse twiml=new TwiMLResponse();
		Sms sms = new Sms("Hello World!!!");
		
		try
		{
			twiml.append(sms);
		}
		catch(TwiMLException e)
		{
			e.printStackTrace();
		}
	
		response.setContentType("application/xml");
		try 
		{
			response.getWriter().print(twiml.toXML());
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
