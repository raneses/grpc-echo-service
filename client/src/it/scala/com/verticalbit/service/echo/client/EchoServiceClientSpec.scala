package com.verticalbit.service.echo.client

import com.verticalbit.service.client.config.ClientSettings
import com.verticalbit.service.echo.EchoService._

class EchoServiceClientSpec extends ServiceClientSpec {
  "The echo service client" should {
    "echo messages" in {
      val settings = ClientSettings.load("echo-service.client")
      val client = new EchoServiceClient(settings)

      val request = EchoRequest("Hello World")

      whenReady(client.echo(request)) { result =>
        result should be(EchoResponse("Hello World"))
        logger.info("Response received -> message: {}", result.message)
      }
    }
  }
}
