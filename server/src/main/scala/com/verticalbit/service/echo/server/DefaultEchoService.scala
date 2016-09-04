package com.verticalbit.service.echo.server

import com.verticalbit.service.echo.EchoService._

import scala.concurrent.{ExecutionContext, Future}

class DefaultEchoService(implicit executor: ExecutionContext) extends EchoServiceGrpc.EchoService {
  def echo(request: EchoRequest): Future[EchoResponse] = Future {
    EchoResponse(request.message)
  }
}
