package com.verticalbit.service.echo.server.module

import com.verticalbit.service.echo.EchoService.EchoServiceGrpc.EchoService

trait ServerModule {
  def service: EchoService
}
