package com.uas.WebsiteMonitor;

import com.uas.WebsiteMonitor.Controller.WebsiteMonitorController;
import com.uas.WebsiteMonitor.User.User;
import com.uas.WebsiteMonitor.comparisonStrategy.Comparison;
import com.uas.WebsiteMonitor.comparisonStrategy.TextComp;
import com.uas.WebsiteMonitor.comparisonStrategy.ContentSizeComp;
import com.uas.WebsiteMonitor.util.PreferredCommunicationChannel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WebsiteMonitorTest {

    private WebsiteMonitorController controller;
    private User testUser;
    private String testUrl;
    private Comparison testComp;

    @BeforeEach
    public void setUp() {
        controller = new WebsiteMonitorController();
        testUser = new User(1, controller);
        testUrl = "frankfurt-university.de";
        testComp = new TextComp();
    }

    //Successfully editing Sub (Equivalence Class 1)
    @Test
    public void testSuccesfulEditSub() {
        controller.createSub(testUrl, 2, PreferredCommunicationChannel.Email, testComp, testUser);
        assertDoesNotThrow(() -> {
            controller.editSub(testUrl, 12, null, null, testUser);
        });
    }

    //Giving the System a wrong URL (Equivalence Class 2)
    @Test
    public void testInvalidURLEditSub() {
        controller.createSub(testUrl, 2, PreferredCommunicationChannel.Email, testComp, testUser);
        assertDoesNotThrow(() -> {
            controller.editSub("GoetheUni.de", 60, PreferredCommunicationChannel.SMS, new ContentSizeComp(), testUser);
        });
    }

    //Giving the System a wrong Frequency (Equivalence Class 3)
    @Test
    public void testInvalidFreqEditSub() {
        controller.createSub(testUrl, 2, PreferredCommunicationChannel.Email, testComp, testUser);
        assertDoesNotThrow(() -> {
            controller.editSub(testUrl, -10, null, null, testUser);
        });
    }
}