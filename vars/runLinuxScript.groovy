def call(Map config = [:]) {
	def scriptContent = libraryResource "scripts/${config.name}"
	writeFile file: "${config.name}", text: scriptcontents
	sh '''
		chmod a+x ./${config.name}
		./${config.name}
	   '''
	}

