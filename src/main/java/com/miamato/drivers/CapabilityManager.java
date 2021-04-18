package com.miamato.drivers;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;


public class CapabilityManager {

    public static ChromeOptions getChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("acceptInsecureCerts", true);
        chromeOptions.addArguments("start-maximized");
        return chromeOptions;
    }

    public static EdgeOptions getEdgeOptions(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setCapability("acceptInsecureCerts", true);
        edgeOptions.addArguments("start-maximized");
        return edgeOptions;
    }

}
