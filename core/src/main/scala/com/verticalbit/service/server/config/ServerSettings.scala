package com.verticalbit.service.server.config

import com.typesafe.config.ConfigFactory

case class ServerSettings(port: Int)

object ServerSettings {
  import net.ceedubs.ficus.Ficus._
  import net.ceedubs.ficus.readers.ArbitraryTypeReader._

  def load(key: String): ServerSettings = {
    ConfigFactory.load().as[ServerSettings](key)
  }
}
