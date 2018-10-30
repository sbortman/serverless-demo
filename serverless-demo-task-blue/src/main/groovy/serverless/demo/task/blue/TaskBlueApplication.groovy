package serverless.demo.task.blue

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.task.configuration.EnableTask
import org.springframework.context.annotation.Bean


@EnableTask
@SpringBootApplication
class TaskBlueApplication
{
	@Bean
	BlueTask BlueServiceTask()
	{
		return new BlueTask()
	}
	
	class BlueTask implements CommandLineRunner
	{
		
		@Override
		void run( String... strings ) throws Exception
		{
			// prints all input parameters
			if ( null != strings )
			{
				System.out.println( "Blue parameter length: " + strings.length )
			}
			
			for ( int i = 0; i < strings.length; ++i )
			{
				System.out.println( "Blue Arg " + i + " : " + strings[i] )
			}
		}
		
	}
	
	static void main( String[] args )
	{
		SpringApplication.run TaskBlueApplication, args
	}
}
