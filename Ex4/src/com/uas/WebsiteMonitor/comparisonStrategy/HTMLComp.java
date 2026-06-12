package com.uas.WebsiteMonitor.comparisonStrategy;

public class HTMLComp implements Comparison {
    @Override
    public boolean hasChanged(String oldData, String newData) {
        return !oldData.equals(newData);
    }
}
