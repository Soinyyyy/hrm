package org.soin.config;

import org.soin.constant.BaseConstant;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 绑定队列到交换机
 * @param queue
 * @param exchange
 * @return
 */
@Configuration
public class RabbitmqConfig {
    /**
     * 交换机配置
     * @return
     */
    @Bean(BaseConstant.CourseConstant.EXCHANGE_TOPICS_COURSE)
    public Exchange EXCHANGE_TOPICS_INFORM() {
        return ExchangeBuilder.topicExchange(BaseConstant.CourseConstant.EXCHANGE_TOPICS_COURSE).durable(true).build();
    }

    //邮件
    @Bean(BaseConstant.CourseConstant.QUEUE_COURSE_EMAIL)
    public Queue QUEUE_COURSE_EMAIL() {
        Queue queue = new Queue(BaseConstant.CourseConstant.QUEUE_COURSE_EMAIL,true);
        return queue;
    }

    //站内信
    @Bean(BaseConstant.CourseConstant.QUEUE_COURSE_STATION_MESSAGE)
    public Queue QUEUE_COURSE_STATION_MESSAGE() {
        Queue queue = new Queue(BaseConstant.CourseConstant.QUEUE_COURSE_STATION_MESSAGE,true);
        return queue;
    }

    //短信
    @Bean(BaseConstant.CourseConstant.QUEUE_COURSE_SMS)
    public Queue QUEUE_COURSE_SMS() {
        Queue queue = new Queue(BaseConstant.CourseConstant.QUEUE_COURSE_SMS,true);
        return queue;
    }

    /**
     * 绑定队列到交换机
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding BINDING_QUEUE_INFORM_SMS(@Qualifier(BaseConstant.CourseConstant.QUEUE_COURSE_SMS) Queue queue,
                                            @Qualifier(BaseConstant.CourseConstant.EXCHANGE_TOPICS_COURSE) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("#.sms").noargs();
    }
    @Bean
    public Binding BINDING_QUEUE_INFORM_EMAIL(@Qualifier(BaseConstant.CourseConstant.QUEUE_COURSE_EMAIL) Queue queue,
                                              @Qualifier(BaseConstant.CourseConstant.EXCHANGE_TOPICS_COURSE) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("#.email").noargs();
    }
    @Bean
    public Binding BINDING_QUEUE_STATION_MESSAGE(@Qualifier(BaseConstant.CourseConstant.QUEUE_COURSE_STATION_MESSAGE) Queue queue,
                                              @Qualifier(BaseConstant.CourseConstant.EXCHANGE_TOPICS_COURSE) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("#.station").noargs();
    }
}