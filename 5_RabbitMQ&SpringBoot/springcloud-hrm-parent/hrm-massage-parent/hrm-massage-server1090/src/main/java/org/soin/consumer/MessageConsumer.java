package org.soin.consumer;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.soin.constant.BaseConstant;
import org.soin.to.CourseEmailTo;
import org.soin.to.CourseSmsTo;
import org.soin.to.CourseStationMessageTo;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class MessageConsumer {

    /**
     * @Payload  将序列化的Json字符串，反序列化为对象
     * @param smsTo
     * @param message
     * @param channel
     */
    @RabbitListener(queues = BaseConstant.CourseConstant.QUEUE_COURSE_SMS)
    public void handlerSmsMessage(@Payload CourseSmsTo smsTo, Message message, Channel channel){
        // 1.循环电话
        // 2.调用三方短信平台，发短信
        log.info("发送消息：{}", smsTo);
        // 3.手动签收消息
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            e.printStackTrace();
            log.info("消费消息：{}，失败！", smsTo);
        }
    }

    @RabbitListener(queues = BaseConstant.CourseConstant.QUEUE_COURSE_EMAIL)
    public void handlerEmailMessage(@Payload CourseEmailTo to, Message message, Channel channel){
        // 1.循环邮箱
        // 2.调用三方发送邮件
        log.info("发送消息：{}", to);
        // 3.手动签收消息
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            e.printStackTrace();
            log.info("消费消息：{}，失败！", to);
        }
    }

    @RabbitListener(queues = BaseConstant.CourseConstant.QUEUE_COURSE_STATION_MESSAGE)
    public void handlerStationMessage(@Payload CourseStationMessageTo to, Message message, Channel channel){
        // 1.循环userIds
        // 2.连接数据库，保存数据
        log.info("处理消息：{}", to);
        // 3.手动签收消息
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            e.printStackTrace();
            log.info("消费消息：{}，失败！", to);
        }
    }
}
