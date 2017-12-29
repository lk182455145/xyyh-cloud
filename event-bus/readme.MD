#spring-cloud-bus
## rabbitmq使用
* 修改application.yml
```yaml
spring:
  rabbitmq:
    host: 127.0.0.1
    port: 5672
    username: lidong
    password: lidong
    virtual-host: /
```
* 配置rabbitmq ,增加一个队列
```java
@Configuration
public class Aqueue {

	@Bean
	public Queue queue() {
		return new Queue("good");
	}

}
```
* 定义一个生产者,当启用activemq之后，会自动创建一个AmqpTemplate ,可以被注入到任何需要的地方
```java
/**
 * 定义一个生产者
 * 
 * @author LiDong
 *
 */
@RestController
@RequestMapping("/test")
public class SendController {
	@Autowired
	private AmqpTemplate template;

	@GetMapping
	public String testSend() {
		// 使用AmqpTemplate发送消息
		template.convertAndSend("good", "good");
		return "success";
	}
}
```
* 定义消费者，通过RabbitHandler指定消费者，通过指定RabbitListener指定消费的队列
```java
@Component
public class Consumer {

	/**
	 * 定义一个消费者
	 * @param message
	 */
	@RabbitHandler
	@RabbitListener(queues = "good")
	public void handler(String message) {
		System.out.println("recive message from " + message);
	}
}
```

启动测试，在浏览器中输入 http://localhost:8080/test即可发送一条消息到队列中。 该对了可以被消费者处理


