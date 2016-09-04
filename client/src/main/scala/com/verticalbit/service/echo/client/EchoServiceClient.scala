package com.verticalbit.service.echo.client

import com.verticalbit.service.client.ClientBase
import com.verticalbit.service.client.config.ClientSettings
import com.verticalbit.service.echo.EchoService.EchoServiceGrpc.EchoServiceStub
import com.verticalbit.service.echo.EchoService._

import scala.concurrent.Future

class EchoServiceClient(settings: ClientSettings) extends ClientBase[EchoServiceStub](settings) {
  val stub: EchoServiceStub = EchoServiceGrpc.stub(channel)

  def echo(request: EchoRequest): Future[EchoResponse] = {
    stub.echo(request)
  }
}
