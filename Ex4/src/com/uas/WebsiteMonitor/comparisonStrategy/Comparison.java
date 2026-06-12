package com.uas.WebsiteMonitor.comparisonStrategy;

public interface Comparison {
    boolean hasChanged(String oldData, String newData);
}
