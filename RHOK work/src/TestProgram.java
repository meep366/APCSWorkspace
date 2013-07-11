import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Sms;
import com.twilio.sdk.verbs.TwiMLResponse;

/**
 * 
 */

/**
 * @author jack
 *
 */
public class TestProgram {

	/**
	 * @param args
	 */
	
	public static final String ACCOUNT_SID="ACdea9c1da40008c55a3fe7be8362953aa";
	public static final String AUTH_TOKEN="0e9d15f3e9e8f02e2cc78cc5ce31a2e9";
	
	
	public static void main(String[] args) throws TwilioRestException{
		
		TwilioRestClient client=new TwilioRestClient(ACCOUNT_SID,AUTH_TOKEN);
		
		Map<String,String> params=new TreeMap<String,String>();
		params.put("Body","I'm awesome");
		params.put("To", "+14044969905");
		params.put("From", "+14045864334");
		
		SmsFactory messageFactory = client.getAccount().getSmsFactory();
		Sms message=messageFactory.create(params);
		System.out.println(message.getSid());
		
	}
	
}

