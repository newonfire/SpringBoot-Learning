package com.didispace.mq.provider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Destination;

import com.didispace.mq.util.QueueList;
import com.didispace.mq.vo.ParamVo;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

@RestController
/**
 * 建议json字符串格式传输，否则容易导致消费者解析消息异常
 */
public class DemoController {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@RequestMapping(value = "/")
	public String home() throws IOException {
		Map<String, String> msg = new HashMap<String, String>();
		msg.put("key", "hi,activeMQ");
		jmsMessagingTemplate.convertAndSend(QueueList.BUSINESS1, JSON.toJSONString(msg));
		return "hello springboot";
	}

	@RequestMapping(value = "/2")
	public String home2() throws IOException {
		Map<String, String> msg = new HashMap<>();
		msg.put("key", "##hi,activeMQ2");
		ParamVo paramVo = new ParamVo();
		paramVo.setUserId(123l);
		paramVo.setUserName("demo");
		jmsMessagingTemplate.convertAndSend(QueueList.BUSINESS2, JSON.toJSONString(paramVo));
		return "hello springboot";
	}
	
	@RequestMapping(value = "/3")
	public String home3() throws IOException {
		
		Destination dest=new ActiveMQQueue(QueueList.BUSINESS2);
		
		ParamVo paramVo = new ParamVo();
		paramVo.setUserId(1123l);
		paramVo.setUserName("demo");
		jmsMessagingTemplate.convertAndSend(dest, JSON.toJSONString(paramVo));
		return "hello springboot";
	}
	
	@RequestMapping(value = "/4")
	public String sendtoptic() throws IOException {
		Destination dest=new ActiveMQTopic(QueueList.TOPIC);
		jmsMessagingTemplate.convertAndSend(dest, "abc");
		return "hello springboot4";
	}

}
