package com.verticalbit.service.client

import java.util.concurrent.TimeUnit

import com.verticalbit.service.client.config.ClientSettings
import com.typesafe.scalalogging.LazyLogging
import io.grpc.{ManagedChannel, ManagedChannelBuilder}
import io.grpc.stub.AbstractStub

abstract class ClientBase[TStub <: AbstractStub[_]](settings: ClientSettings) extends LazyLogging {
  protected def channel: ManagedChannel = {
    ManagedChannelBuilder.forAddress(settings.host, settings.port).usePlaintext(true).build
  }

  protected def stub: TStub

  def shutdown(): Unit = {
    settings.channel.shutdownTimeout match {
      case Some(t) => channel.shutdown.awaitTermination(t, TimeUnit.MILLISECONDS)
      case None => channel.shutdownNow()
    }
  }
}
