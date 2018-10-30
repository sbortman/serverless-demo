package serverless.demo.task.Red

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.task.configuration.EnableTask
import org.springframework.context.annotation.Bean


@EnableTask
@SpringBootApplication
class TaskRedApplication
{
	@Bean
	RedTask RedServiceTask()
	{
		return new RedTask()
	}
	
	class RedTask implements CommandLineRunner
	{
		
		@Override
		void run( String... strings ) throws Exception
		{
			// prints all input parameters
			if ( null != strings )
			{
				System.out.println( "Red parameter length: " + strings.length )
			}
			
			for ( int i = 0; i < strings.length; ++i )
			{
				System.out.println( "Red Arg " + i + " : " + strings[i] )
			}
		}
		
	}
	
	static void main( String[] args )
	{
		SpringApplication.run TaskRedApplication, args
	}
}
