package com.duan.action.job;

import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DemoJob {

    @XxlJob("demoJobHandler")
    public void demoJobHandler() {
        log.info("XXL-JOB, Hello World.");
        System.out.println("XXL-JOB, Hello World.");
    }

    @XxlJob("demoSubJogHandler")
    public void demoSubJogHandler(){
        System.out.println("子任务执行了  在主任务之后");
    }
}
