import com.uas.WebsiteMonitor.Controller.WebsiteMonitorController;
import com.uas.WebsiteMonitor.User.User;
import com.uas.WebsiteMonitor.comparisonStrategy.Comparison;
import com.uas.WebsiteMonitor.comparisonStrategy.TextComp;
import com.uas.WebsiteMonitor.util.PreferredCommunicationChannel;

public class Main {

    public static void main(String[] args) {
        int id = 0;
        WebsiteMonitorController websiteMonitorController = new WebsiteMonitorController();

        User user1 = new User(id++, websiteMonitorController);
        String url = args[0];
        user1.requestNewSub(url, 2, PreferredCommunicationChannel.Email, new TextComp());


        User user2 = new User(id++, websiteMonitorController);
    }
}