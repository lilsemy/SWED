package com.uas.WebsiteMonitor.User;

import com.uas.WebsiteMonitor.Controller.WebsiteMonitorController;
import com.uas.WebsiteMonitor.comparisonStrategy.Comparison;
import com.uas.WebsiteMonitor.monitor.WebsiteMonitor;
import com.uas.WebsiteMonitor.util.Notification;
import com.uas.WebsiteMonitor.util.ObserverInt;
import com.uas.WebsiteMonitor.util.PreferredCommunicationChannel;

public class User implements ObserverInt {
    private int id;
    private final WebsiteMonitorController controller;

    public User(int id, WebsiteMonitorController controller) {
        this.id = id;
        this.controller = controller;
    }

    @Override
    public void update(Notification notification) {
        getNotification(notification);
    }

    public void requestNewSub(String url, int frequency, PreferredCommunicationChannel prefComChannel, Comparison comparison){
        WebsiteMonitor mon = controller.createSub(url, frequency, prefComChannel, comparison, this);
        mon.attach(this);
    }

    public void manageSubs(String url, int newFreq, PreferredCommunicationChannel newPrefComChannel, Comparison newComparison){
        controller.editSub(url, newFreq, newPrefComChannel, newComparison, this);
    }

    public void getNotification(Notification notification){
        System.out.println(notification);
    }

}
