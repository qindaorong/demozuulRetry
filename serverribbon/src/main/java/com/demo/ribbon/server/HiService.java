package com.demo.ribbon.server;

import com.demo.ribbon.dto.ServerDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * HiService
 *
 * @author qindaorong
 * @create 2018-03-15 3:42 PM
 **/
@Service
public class HiService {
    
    @Autowired
    RestTemplate restTemplate;
    
    @Autowired
    private SpringClientFactory springClientFactory;
    
    
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://PROVIDER/hi?name="+name,String.class);
    }
    
    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
    
    
    /**
     *
     * @param serverIp
     * @return
     */
    public String turnOffTraffic(String serverIp) {
        IRule rule =springClientFactory.getInstance("PROVIDER", ZoneAvoidanceRule.class);
        List<Server> serverList= rule.getLoadBalancer().getReachableServers();
        
        for(Server server : serverList){
            if(server.getHost().lastIndexOf(serverIp) != -1 ){
                //serverList.remove(server);
                rule.getLoadBalancer().markServerDown(server);
            }
        }
        
        System.out.println(serverList);
        return serverIp;
    }
    
    
    /**
     * 添加运行server实例
     * @param serverDto
     * @return
     */
    public String turnOnTraffic(ServerDto serverDto) {
    
        Server server = new Server(serverDto.getHost(),serverDto.getPort());
        
        List<Server> serverList = new ArrayList<Server>();
        serverList.add(server);
        
        IRule rule =springClientFactory.getInstance("PROVIDER", ZoneAvoidanceRule.class);
        ILoadBalancer iLoadBalancer= rule.getLoadBalancer();

        iLoadBalancer.addServers(serverList);

        return "ok";
    }
    
    /**
     * 添加运行server实例
     * @return
     */
    public String showReachableServers() {
    
        IRule rule =springClientFactory.getInstance("PROVIDER", ZoneAvoidanceRule.class);
        List<Server> serverList= rule.getLoadBalancer().getReachableServers();
        
        String listString = serverList.toString();
        
        return listString;
    }
    
    
}
