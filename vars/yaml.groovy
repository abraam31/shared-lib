def call(String configFile) {
	script {
		datas = readYaml (file: configFile) 
		
		// notifications vars 
		env.notificationRecipient = datas.notifications.email.recipients.toString()
		env.notificationOnStart = datas.notifications.email.on_start.toString()
		env.notificationOnFailure = datas.notifications.email.on_failure.toString()
		env.notificationOnSuccess = datas.notifications.email.on_success.toString()

		// test vars 
		env.testFolder = datas.test[0].testFolder.toString()

		env.performanceTestCommand = datas.test[0].testCommand.toString()
		env.regressionTestCommand = datas.test[1].testCommand.toString()
		env.integrationTestCommand = datas.test[2].testCommand.toString()

		// build vars 
		env.buildCommand = datas.build.buildCommand.toString()
		env.buildProjectFolder = datas.build.projectFolder.toString()
		
		// Database vars 
		env.databaseCommand = datas.database.databaseCommand.toString()
		env.databaseProjectFolder = datas.database.databaseFolder.toString()

		// deploy vars 
		env.deployProjectFolder = datas.build.projectFolder.toString()
		env.deployCommand = datas.deploy.deployCommand.toString()
	}
}