package serverless.demo.app

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.messaging.Source
import org.springframework.cloud.task.launcher.TaskLaunchRequest
import org.springframework.messaging.support.GenericMessage

@EnableBinding( Source.class )
class TaskTriggerService
{
	@Autowired
	Source source
	
	def launchTask( String payload, String taskId )
	{
		println "${taskId}: ${payload}"
		
		//maven://[groupid]:[artifactid]:jar:[version]
		String redUrl = "maven://serverless-demo:serverless-demo-task-red:jar:0.0.1-SNAPSHOT"
		String blueUrl = "maven://serverless-demo:serverless-demo-task-blue:jar:0.0.1-SNAPSHOT"
		List<String> input = new ArrayList<String>( Arrays.asList( payload.split( "," ) ) )
		def results
		
		if ( taskId.equals( "red" ) )
		{
			TaskLaunchRequest request = new TaskLaunchRequest( redUrl, input, null, null, "" )
			GenericMessage<TaskLaunchRequest> message = new GenericMessage<>( request )
			this.source.output().send( message )
			results = [ contentType: 'text/plain', text: "Success = ${ taskId }: ${ input }\n" ]
		}
		else if ( taskId.equals( "blue" ) )
		{
			TaskLaunchRequest request = new TaskLaunchRequest( blueUrl, input, null, null, "" )
			GenericMessage<TaskLaunchRequest> message = new GenericMessage<>( request )
			this.source.output().send( message )
			results = [ contentType: 'text/plain', text: "Success = ${ taskId }: ${ input }\n" ]
		}
		else
		{
			results = [ contentType: 'text/plain', text: "Failure = ${ taskId }: ${ input }\n" ]
		}

		results
	}
}
