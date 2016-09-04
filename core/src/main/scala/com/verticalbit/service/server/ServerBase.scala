package com.verticalbit.service.server

import com.verticalbit.service.server.config.ServerSettings
import com.typesafe.scalalogging.LazyLogging
import io.grpc.{ServerBuilder, ServerServiceDefinition}

import scala.concurrent.ExecutionContext

abstract class ServerBase(settings: ServerSettings)(implicit executor: ExecutionContext) extends LazyLogging { self =>
  protected[this] var server: io.grpc.Server = _
  protected def definition: ServerServiceDefinition

  protected def start(): Unit = {
    server = ServerBuilder.forPort(settings.port)
      .addService(definition)
      .build
      .start

    logger.info(s"gRPC server started -> port: {}", settings.port)

    Runtime.getRuntime.addShutdownHook(new Thread {
      override def run(): Unit = {
        logger.info("gRPC server stopping, JVM shutting down")
        self.stop()
        logger.info("gRPC server stopped")
      }
    })
  }

  protected def stop(): Unit = {
    if (server != null) {
      server.shutdown()
    }
  }

  protected def blockUntilShutdown(): Unit = {
    if (server != null) {
      server.awaitTermination()
    }
  }
}
