package com.example

@Grab('org.yaml:snakeyaml:1.17')
import org.yaml.snakeyaml.Yaml
	
class Pipeline {
    // def script
    def configurationFile

    Pipeline(configurationFile) {
        // this.script = script
        this.configurationFile = configurationFile
    }

    def execute() {
		println("trying a thing")
    }
}
