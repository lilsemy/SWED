package com.uas.WebsiteMonitor.monitor;

import com.uas.WebsiteMonitor.User.User;
import com.uas.WebsiteMonitor.comparisonStrategy.Comparison;
import com.uas.WebsiteMonitor.util.Notification;
import com.uas.WebsiteMonitor.util.ObserverInt;
import com.uas.WebsiteMonitor.util.PreferredCommunicationChannel;
import com.uas.WebsiteMonitor.website.Website;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WebsiteMonitor implements  WebsiteMonitorInt {
    private LocalDateTime lastChecked;
    private int frequency;
    private PreferredCommunicationChannel prefCommChannel;
    private User user;
    private int id;
    private Website website;
    private List<ObserverInt> observers = new ArrayList<>();
    private String oldData;
    private Comparison comparison;

    public WebsiteMonitor(String url, int frequency, PreferredCommunicationChannel prefCommChannel, Comparison comparison, User user, int id) {
        this.frequency = frequency;
        this.prefCommChannel = prefCommChannel;
        this.user = user;
        this.id = id;
        this.lastChecked = null;
        this.website = new Website(url);
        this.oldData = website.getData();
        this.comparison = comparison;
        System.out.println("WebsiteMonitor created with URL: " + url);
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
            String currentData = website.getData();
            if (comparison.hasChanged(oldData, currentData)){
                Notification notification = createNotfication(currentData);
                this.notify(notification);
                oldData = currentData;
            }
        }
    }

    public void editSettings(int newFreq, PreferredCommunicationChannel newPrefComChannel, Comparison newComparison){
        if (newFreq != 0){
            this.frequency = newFreq;
        } else if (newPrefComChannel != null){
            this.prefCommChannel = newPrefComChannel;
        } else if (newComparison != null){
            this.comparison = newComparison;
        }
        else {
            throw new IllegalArgumentException("The Frequency and the PreferredCommunicationChannel have already given values!");
        }
    }

    public void attach(ObserverInt obs){
        if (!observers.contains(obs)){
            observers.add(obs);
        }
    }

    public void detach(ObserverInt obs){
        observers.remove(obs);
    }

    public void notify(Notification notification) {
        for (ObserverInt obs : observers) {
            obs.update(notification);
        }
    }
}
