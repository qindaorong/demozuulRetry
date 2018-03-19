package com.demo.ribbon.constants;

import java.util.Vector;

/**
 * MarkDownServerConstants
 *
 * @author qindaorong
 * @create 2018-03-16 10:09 AM
 **/
public class MarkDownServerConstants {
    
    private static MarkDownServerConstants markDownServerCanstants = new MarkDownServerConstants();
    
    private Vector<String> markDownServerVector = new Vector<String>();

    private MarkDownServerConstants(){
        super();
    }
    
    /**
     * 获得实例
     * @return
     */
    public static MarkDownServerConstants getMarkDownServerConstantsInstance(){
        return markDownServerCanstants;
    }
    
    /**
     * 添加标记关闭流量标记
     * @param host
     */
    public void addMarkDownServer(String host){
        markDownServerVector.add(host);
    }
    
    /**
     * 移除关闭标记
     * @param host
     */
    public void removeMarkDownServer(String host){
        markDownServerVector.remove(host);
    }
    
    /**
     * 移除关闭标记
     * @param host
     */
    public boolean isMarkDown(String host){
        boolean isMarkDown = markDownServerVector.contains(host);
        return isMarkDown;
    }
    
}
