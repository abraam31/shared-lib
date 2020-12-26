def call(String configFile) {
	script {
		datas = readYaml (file: configFile) 
		
		// notifications vars 
		notificationRecipient = datas.notifications.email.recipients.toString()
		notificationOnStart = datas.notifications.email.on_start.toString()
		notificationOnFailure = datas.notifications.email.on_failure.toString()
		notificationOnSuccess = datas.notifications.email.on_success.toString()

		// test vars 
		testFolder = datas.test[0].testFolder.toString()

		performanceTestCommand = datas.test[0].testCommand.toString()
		regressionTestCommand = datas.test[1].testCommand.toString()
		integrationTestCommand = datas.test[2].testCommand.toString()

		// build vars 
		buildCommand = datas.build.buildCommand.toString()
		buildProjectFolder = datas.build.projectFolder.toString()
		
		// Database vars 
		databaseCommand = datas.database.databaseCommand.toString()
		databaseProjectFolder = datas.database.databaseFolder.toString()

		// deploy vars 
		deployProjectFolder = datas.build.projectFolder.toString()
		deployCommand = datas.deploy.deployCommand.toString()
		echo "Send on start: ${notificationOnStart}"
	}
}