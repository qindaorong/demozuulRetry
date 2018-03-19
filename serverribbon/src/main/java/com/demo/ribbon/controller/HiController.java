package com.demo.ribbon.controller;

import com.demo.ribbon.dto.ServerDto;
import com.demo.ribbon.server.HiService;
import com.netflix.loadbalancer.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * HiController
 *
 * @author qindaorong
 * @create 2018-03-15 3:43 PM
 **/
@RestController
public class HiController {
    
    @Autowired
    HiService hiService;
    
    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        return hiService.hiService(name);
    }
    
    @RequestMapping(value = "/turnOffTraffic")
    public String turnOffTraffic(@RequestParam String serverIp){
        return hiService.turnOffTraffic(serverIp);
    }
    
    @RequestMapping(value = "/turnOnTraffic")
    public String turnOnTraffic(@RequestBody ServerDto serverDto){
        return hiService.turnOnTraffic(serverDto);
    }
    
    @RequestMapping(value = "/showReachableServers")
    public String showReachableServers(){
        return hiService.showReachableServers();
    }
}
