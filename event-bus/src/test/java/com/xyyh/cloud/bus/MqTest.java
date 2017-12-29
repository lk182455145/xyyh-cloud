package com.xyyh.cloud.bus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BusApplication.class)
public class MqTest {
	@Autowired
	private AmqpTemplate template;

	@Test
	public void testSend() {
		template.convertAndSend("a", "b", "c");
	}

}
