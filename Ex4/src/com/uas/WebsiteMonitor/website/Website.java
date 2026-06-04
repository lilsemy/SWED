package com.uas.WebsiteMonitor.website;

public class Website {
    private String url;
    private String data;
    private boolean isUpdated;

    public Website(String url) {
        this.url = url;
    }

    public String getUrl() {return url;}

    public boolean checkForUpdate(){
        if (isUpdated == true) {
            isUpdated = false;
            return true;
        } else{
            return false;
        }
    }

    public String getData(){
        return data;
    }
}
