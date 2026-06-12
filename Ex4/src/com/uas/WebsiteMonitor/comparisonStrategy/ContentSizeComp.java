package com.uas.WebsiteMonitor.comparisonStrategy;

public class ContentSizeComp implements Comparison {
    @Override
    public boolean hasChanged(String oldData, String newData) {
        return oldData.length() != newData.length();
    }
}