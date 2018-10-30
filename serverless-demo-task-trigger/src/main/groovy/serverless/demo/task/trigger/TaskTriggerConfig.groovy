package serverless.demo.task.trigger

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class TaskTriggerConfig
{
	@Bean
	public TaskProcessor taskProcessor()
	{
		return new TaskProcessor()
	}
}
