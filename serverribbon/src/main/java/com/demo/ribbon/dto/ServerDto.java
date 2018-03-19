package com.demo.ribbon.dto;

import java.io.Serializable;

/**
 * ServerDto
 *
 * @author qindaorong
 * @create 2018-03-16 9:28 AM
 **/
public class ServerDto implements Serializable {
    
    private String host;
    
    private int port;
    
    private boolean isAliveFlag;
    
    public String getHost() {
        return host;
    }
    
    public void setHost(String host) {
        this.host = host;
    }
    
    public int getPort() {
        return port;
    }
    
    public void setPort(int port) {
        this.port = port;
    }
    
    public boolean isAliveFlag() {
        return isAliveFlag;
    }
    
    public void setAliveFlag(boolean aliveFlag) {
        isAliveFlag = aliveFlag;
    }
}
