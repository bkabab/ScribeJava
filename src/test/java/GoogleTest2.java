import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.GoogleApi;
import org.scribe.model.*;
import org.scribe.oauth.OAuthService;


public class GoogleTest2 {
	  private static final String NETWORK_NAME = "Google";
	  private static final String AUTHORIZE_URL = "https://www.google.com/accounts/OAuthAuthorizeToken?oauth_token=";
	  private static final String PROTECTED_RESOURCE_URL = "https://docs.google.com/feeds/default/private/full/";
	  private static final String SCOPE = "https://docs.google.com/feeds/"; 
	  
	@Test
	public void test_runpass(){
		assertTrue(GoogleTest.GoogleAuth());
	}

	 public static boolean GoogleAuth()
	  {
	  OAuthService service = new ServiceBuilder()
                                 .provider(GoogleApi.class)
                                 .apiKey("anonymous")
                                 .apiSecret("anonymous")
                                 .scope(SCOPE)
                                 .build();
   Scanner in = new Scanner(System.in);

   System.out.println("=== " + NETWORK_NAME + "'s OAuth Workflow ===");
   System.out.println();

   // Obtain the Request Token
   System.out.println("Fetching the Request Token...");
   Token requestToken = service.getRequestToken();
   System.out.println("Got the Request Token!");
   System.out.println("(if your curious it looks like this: " + requestToken + " )");
   System.out.println();

   System.out.println("Authorize Scribe here:");
   System.out.println(AUTHORIZE_URL + requestToken.getToken());
   System.out.println("And paste the verifier here");
   System.out.print(">>");
   Verifier verifier = new Verifier(in.nextLine());
   System.out.println();

   // Trade the Request Token and Verfier for the Access Token
   System.out.println("Trading the Request Token for an Access Token...");
   Token accessToken = service.getAccessToken(requestToken, verifier);
   System.out.println("Got the Access Token!");
   System.out.println("This is the access token " + accessToken);
   System.out.println();

   // Now let's go and ask for a protected resource!
   System.out.println("Accessing a protected resource...");
   OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
   service.signRequest(accessToken, request);
   request.addHeader("GData-Version", "3.0");
   Response response = request.send();
   System.out.println("Got it! Lets see what we found...");
   System.out.println();
   System.out.println(response.getCode());
   System.out.println(response.getBody());

   System.out.println();
   System.out.println("Authentication procedure complete !");
	return true;
	  }
	
	
	
	
}

