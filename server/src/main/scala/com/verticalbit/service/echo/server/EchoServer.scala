package com.verticalbit.service.echo.server

import com.verticalbit.service.echo.EchoService.EchoServiceGrpc
import com.verticalbit.service.echo.EchoService.EchoServiceGrpc.EchoService
import com.verticalbit.service.echo.server.module.DefaultServerModule
import com.verticalbit.service.server.ServerBase
import com.verticalbit.service.server.config.ServerSettings

import scala.concurrent.ExecutionContext

class EchoServer(settings: ServerSettings, service: EchoService)(implicit executor: ExecutionContext) extends ServerBase(settings) {
  protected def definition = EchoServiceGrpc.bindService(service, executor)
}

object EchoServer extends App {
  import scala.concurrent.ExecutionContext.Implicits.global

  val settings = ServerSettings.load("echo-service.server")
  val module = new DefaultServerModule

  val server = new EchoServer(settings, module.service)
  server.start()
  server.blockUntilShutdown()
}
