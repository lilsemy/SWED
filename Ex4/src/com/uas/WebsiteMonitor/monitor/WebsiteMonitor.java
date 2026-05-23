package com.uas.WebsiteMonitor.monitor;

import com.uas.WebsiteMonitor.Controller.WebsiteMonitorController;
import com.uas.WebsiteMonitor.User.User;
import com.uas.WebsiteMonitor.util.Notification;
import com.uas.WebsiteMonitor.util.PreferredCommunicationChannel;
import com.uas.WebsiteMonitor.website.Website;
import java.time.LocalDateTime;

public class WebsiteMonitor {
    private LocalDateTime lastChecked;
    private int frequency;
    private PreferredCommunicationChannel prefCommChannel;
    private User user;
    private int id;
    private Website website;
    private final WebsiteMonitorController controller;

    public WebsiteMonitor(String url, int frequency, PreferredCommunicationChannel prefCommChannel, User user, int id, WebsiteMonitorController controller) {
        this.frequency = frequency;
        this.prefCommChannel = prefCommChannel;
        this.user = user;
        this.id = id;
        this.lastChecked = null;
        this.controller = new WebsiteMonitorController();
    }

    public String getUrl() {
        return website.getUrl();
    }

    public User getUser() {return user;}

    public int getId() {return id;}

    public Notification createNotfication(String message){
        Notification notification = new Notification(message);
        return notification;
    }

    public void checkForUpdate(){
        if(website.checkForUpdate()){
            String data = website.getData();
            Notification notification = createNotfication(data);

        }
    }

    public void editSettings(int newFreq, PreferredCommunicationChannel newPrefComChannel){
        if (newFreq != 0){
            this.frequency = newFreq;
        } else if (newPrefComChannel != null){
            this.prefCommChannel = newPrefComChannel;
        }
        else {
            throw new IllegalArgumentException("The Frequency and the PreferredCommunicationChannel have already given values!");
        }
    }
}
