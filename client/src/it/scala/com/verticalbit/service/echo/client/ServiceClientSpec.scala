package com.verticalbit.service.echo.client

import com.typesafe.scalalogging.LazyLogging
import org.scalatest._
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time._

abstract class ServiceClientSpec extends WordSpec with Matchers with ScalaFutures with LazyLogging {
  implicit val patience: PatienceConfig = PatienceConfig(timeout = Span(10, Seconds))
}
