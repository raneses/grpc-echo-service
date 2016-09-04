package com.verticalbit.service.echo.server.module

import com.softwaremill.macwire._
import com.verticalbit.service.echo.EchoService.EchoServiceGrpc.EchoService
import com.verticalbit.service.echo.server

import scala.concurrent.ExecutionContext

class DefaultServerModule(implicit executor: ExecutionContext) extends ServerModule {
  lazy val service: EchoService = wire[server.DefaultEchoService]
}
