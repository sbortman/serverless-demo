package serverless.demo.task.launcher

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher

@EnableTaskLauncher
@SpringBootApplication
class TaskLauncherApplication
{

	static void main(String[] args) {
		SpringApplication.run TaskLauncherApplication, args
	}
}
