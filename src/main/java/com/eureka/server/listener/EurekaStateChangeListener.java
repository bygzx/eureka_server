package com.eureka.server.listener;

import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author eric
 * @date 2019/6/4 15:07
 **/
@Slf4j
@Component
public class EurekaStateChangeListener {

    @EventListener
    public void listen(EurekaInstanceCanceledEvent eurekaInstanceCanceledEvent) {
        //服务断线事件
        log.info("****************服务下线****************");
        String appName = eurekaInstanceCanceledEvent.getAppName();
        String serverId = eurekaInstanceCanceledEvent.getServerId();
        System.out.println(appName);
        System.out.println(serverId);
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        log.info("****************服务注册****************");
        System.out.println(instanceInfo);
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        event.getAppName();
        event.getServerId();
        log.info("****************服务续约事件****************");
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        log.info("****************注册中心启动事件****************");
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        //Server启动
        log.info("****************服务启动****************");
    }
}
