import java.util.*;
import com.textmarks.api2client.*;

public class AutoText {
  public static void main(String[] args) {
    AutoText at = new AutoText();

    try {
      at.sendText();
      System.out.println("Allo");
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void sendText() throws Exception {
    TextMarksV2APIClient tmapi = new TextMarksV2APIClient();
    Map<String,Object> msoParams = new HashMap();
//    tmapi.setApiKey("MyAPIKEY_12345678");
    tmapi.setAuthUser("schneck2@wisc.edu");
    tmapi.setAuthPass("CurtinLab");
    msoParams.put("tm", "DEMOAID148");
    msoParams.put("msg", "Dis is de text bug text bugging you");
//    try {
      tmapi.call("GroupLeader", "broadcast_message", msoParams);
      System.out.println("Allo");
//    } catch (TextMarksV2APIClientTransportException e) {
//      System.out.println(e);
//    }
  }
}
