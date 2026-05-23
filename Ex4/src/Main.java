import com.uas.WebsiteMonitor.Controller.WebsiteMonitorController;
import com.uas.WebsiteMonitor.User.User;

public static void main(String[] args){
    int id = 0;
    WebsiteMonitorController websiteMonitorController = new WebsiteMonitorController();

    User user1 = new User(id++, websiteMonitorController);
    User user2 = new User(id++, websiteMonitorController);
}
