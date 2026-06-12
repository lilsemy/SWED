package com.uas.WebsiteMonitor.monitor;

import com.uas.WebsiteMonitor.User.User;
import com.uas.WebsiteMonitor.comparisonStrategy.Comparison;
import com.uas.WebsiteMonitor.util.Notification;
import com.uas.WebsiteMonitor.util.ObserverInt;
import com.uas.WebsiteMonitor.util.PreferredCommunicationChannel;

public interface WebsiteMonitorInt {

    public String getUrl();

    public User getUser();

    public int getId();

    public Notification createNotfication(String message);

    public void checkForUpdate();

    public void editSettings(int newFreq, PreferredCommunicationChannel newPrefComChannel, Comparison comparison);

    public void attach(ObserverInt obs);

    public void detach(ObserverInt obs);

    public void notify(Notification notification);
}
