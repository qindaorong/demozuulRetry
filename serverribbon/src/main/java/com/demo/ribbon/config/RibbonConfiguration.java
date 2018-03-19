package com.demo.ribbon.config;

import com.demo.ribbon.constants.MarkDownServerConstants;
import com.demo.ribbon.util.RandamUtil;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RibbonConfiguration
 *
 * @author qindaorong
 * @create 2018-03-16 10:02 AM
 **/
@Configuration
public class RibbonConfiguration {
    @Bean
    public IRule ribbonRule(){
        //随机负载
        return new DemoRule();
    }
    
    
    class  DemoRule extends AbstractLoadBalancerRule {
        
        private Logger log = LoggerFactory.getLogger(DemoRule.class);
        
        @Override
        public void initWithNiwsConfig(IClientConfig clientConfig) {
        
        }
    
        @Override
        public Server choose(Object key) {

            return null;
        }
    
        public Server choose(ILoadBalancer lb, Object key) {
    
            if (lb == null) {
                log.warn("no load balancer");
                return null;
            }
    
            Server server = null;
            int count = 0;
            while (server == null && count++ < 10) {
                List<Server> reachableServers = lb.getReachableServers();
                List<Server> allServers = lb.getAllServers();
                int upCount = reachableServers.size();
                int serverCount = allServers.size();
        
                if ((upCount == 0) || (serverCount == 0)) {
                    log.warn("No up servers available from load balancer: " + lb);
                    return null;
                }
        
                int nextServerIndex = RandamUtil.randomCommon(0,allServers.size()-1,1)[0];
                server = allServers.get(nextServerIndex);
        
                if (server == null) {
                /* Transient. */
                    Thread.yield();
                    continue;
                }
        
                if (server.isAlive() && (server.isReadyToServe())) {
                    return (server);
                }
        
                // Next.
                server = null;
            }
    
            if (count >= 10) {
                log.warn("No available alive servers after 10 tries from load balancer: "
                  + lb);
            }
            return server;
        }
    

    
    
    }
}
