package serverless.demo.app

class TaskTriggerController
{
	static allowedMethods = [ launchTask: 'POST' ]
	
	TaskTriggerService taskTriggerService
	
	def launchTask()
	{
		String taskId = params.id
		String payload = request?.reader?.text
		
		
		def results = taskTriggerService.launchTask( payload, taskId )
		
		render results
	}
}
