package com.sovereign.scoreboardservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients


@SpringBootApplication
@EnableFeignClients("com.sovereign")
@EnableEurekaClient
class ScoreboardServiceApplication : SpringBootServletInitializer() {
	//private val authenticationService: AuthenticationService = AuthenticationService()


	companion object {

		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(ScoreboardServiceApplication::class.java, *args)
		}
	}
}
