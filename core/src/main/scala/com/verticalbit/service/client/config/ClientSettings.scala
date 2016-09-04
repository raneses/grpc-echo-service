package com.verticalbit.service.client.config

import com.typesafe.config.ConfigFactory

case class ClientSettings(host: String, port: Int, channel: ChannelSettings)

object ClientSettings {
  import net.ceedubs.ficus.Ficus._
  import net.ceedubs.ficus.readers.ArbitraryTypeReader._

  def load(key: String): ClientSettings = {
    ConfigFactory.load().as[ClientSettings](key)
  }
}
