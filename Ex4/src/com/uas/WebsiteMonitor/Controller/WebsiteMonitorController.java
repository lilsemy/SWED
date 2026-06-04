package com.uas.WebsiteMonitor.Controller;

import com.uas.WebsiteMonitor.User.User;
import com.uas.WebsiteMonitor.monitor.*;
import com.uas.WebsiteMonitor.util.Notification;
import com.uas.WebsiteMonitor.util.PreferredCommunicationChannel;

import java.util.ArrayList;
import java.util.List;

public class WebsiteMonitorController {
    private List<WebsiteMonitor> activeMonitors;
    private int WebsiteMonitorID = 0;

    public void triggerUpdateCheck(){
        for (WebsiteMonitor monitor : activeMonitors){
            monitor.checkForUpdate();
        }
    }

    public WebsiteMonitor createSub(String url, int frequency, PreferredCommunicationChannel prefComChannel, User user){
        WebsiteMonitor webMon = new WebsiteMonitor(url, frequency, prefComChannel, user, WebsiteMonitorID++);
        activeMonitors.add(webMon);
        return webMon;
    }

    //Neue Funktion: So that User can get their Montors in form of an URL List (could be used on GUI to select one and to enable editing and deleting)
    public List<String> getUserUrl(User user){
        List<String> urls = new ArrayList<String>();
        for(WebsiteMonitor monitor : activeMonitors){
            if(monitor.getUser() == user){
                urls.add(monitor.getUrl());
            }
        }
        return urls;
    }

    public void editSub(String url, int newFreq, PreferredCommunicationChannel newPrefCom, User user){
        for (WebsiteMonitor monitor : activeMonitors){
            if((monitor.getUrl() == url) && (monitor.getUser() == user)) {
                monitor.editSettings(newFreq, newPrefCom);
            }
        }
    }

    public void deleteSub(String url, User user){
        for (WebsiteMonitor monitor : activeMonitors){
            if((monitor.getUrl() == url) && (monitor.getUser() == user)) {
                activeMonitors.remove(monitor);
            }
        }
    }
}
