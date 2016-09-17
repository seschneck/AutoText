/*
* AutoText - Program for sending automated text messages for
*            research program(s) in Curtin lab.
* 
* First draft/POC
* 
* 9/11/16
*
* There's supposed to be a copyright notice here, but I don't know
* how to copyright anything, and truly there's nothing here worth
* protecting just yet.
*/
import java.util.*;
import com.textmarks.api2client.*;

// So far, this is the main (and only) class.  Its main method
// makes an instance of itself and uses it to send text messages.
public class AutoText {
  public static void main(String[] args) {
    // Extract CLI params
    if (args.length != 3) {
      usage();
      System.exit(1);
    }

    String user = args[0];
    String pwd = args[1];
    String group = args[2];

    // Create main object
    AutoText at = new AutoText();

    // We seem to need to wrap the text call in a try-catch block
    try {
      at.sendText(user, pwd, group);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  // This method uses the TextMark API to send a text.  Use
  // authentication info and text content to populate an
  // api object, then use that object in a library call to
  // send the text.
  //
  // Susan's demo/test credentials:
  //   User:  schneck2@wisc.edu
  //   Pwd:           CurtinLab
  //   Group:        DEMOAID148
  //
  // I haven't figured out what the "ApiKey" param is, but
  // it's optional, and apparently unnecessary for our
  // purposes.
  public void sendText(String user, String pwd, String group) throws Exception {
    // Set up objects
    TextMarksV2APIClient tmapi = new TextMarksV2APIClient();
    Map<String,Object> msoParams = new HashMap();
    
    // Populate authentication data
    // tmapi.setApiKey("MyAPIKEY_12345678");  // What is this?
    tmapi.setAuthUser(user);
    tmapi.setAuthPass(pwd);
    msoParams.put("tm", group);
    msoParams.put("msg", "Text test");

    // Send the text
    tmapi.call("GroupLeader", "broadcast_message", msoParams);
    System.out.println("Text sent");
  }

  private static void usage() {
    System.out.println("Usage:  AutoText user pwd group");
  }
}
