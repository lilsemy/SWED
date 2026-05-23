package com.uas.WebsiteMonitor.User;

import com.uas.WebsiteMonitor.Controller.WebsiteMonitorController;
import com.uas.WebsiteMonitor.util.Notification;
import com.uas.WebsiteMonitor.util.PreferredCommunicationChannel;

public class User {
    private int id;
    private final WebsiteMonitorController controller;

    public User(int id, WebsiteMonitorController controller) {
        this.id = id;
        this.controller = controller;
    }

    public void requestNewSub(String url, int frequency, PreferredCommunicationChannel prefComChannel){
        controller.createSub(url, frequency, prefComChannel, this);
    }

    public void manageSubs(String url, int newFreq, PreferredCommunicationChannel newPrefComChannel){
        controller.editSub(url, newFreq, newPrefComChannel, this);
    }

    public void getNotification(Notification notification){
        System.out.println(notification);
    }

}
