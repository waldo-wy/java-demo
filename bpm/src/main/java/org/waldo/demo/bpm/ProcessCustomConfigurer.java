package org.waldo.demo.bpm;

import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.ProcessEngineConfigurationConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

/**
 * 流程个性化配置
 *
 * @author waldo.wy 2017/10/26 下午6:16
 */
@Configuration
public class ProcessCustomConfigurer implements ProcessEngineConfigurationConfigurer {

    @Bean
    public List<ActivitiEventListener> globalEventListener() {
        return Collections.emptyList();
    }

    @Override
    public void configure(SpringProcessEngineConfiguration processEngineConfiguration) {
        processEngineConfiguration.setEventListeners(globalEventListener());
    }

}
