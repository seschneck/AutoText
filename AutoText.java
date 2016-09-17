import java.util.*;
import com.textmarks.api2client.*;

public class AutoText {
  public static void main(String[] args) {
    AutoText at = new AutoText();

    try {
      String msg = "Testing the text sender thingy";
      at.sendText(msg);
      System.out.println("Text Sent:  " + msg);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void sendText(String msg) throws Exception {
    TextMarksV2APIClient tmapi = new TextMarksV2APIClient();
    Map<String,Object> msoParams = new HashMap();
    tmapi.setAuthUser("schneck2@wisc.edu");
    tmapi.setAuthPass("CurtinLab");
    msoParams.put("tm", "DEMOAID148");
    msoParams.put("msg", msg);
    msoParams.put("to", "6082932413");
//    tmapi.call("GroupLeader", "broadcast_message", msoParams);
    tmapi.call("GroupLeader", "send_one_message", msoParams);
  }
}
