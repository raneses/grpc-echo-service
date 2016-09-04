import sbt.Keys._
import sbt._

object Settings {
  def base: Seq[Setting[_]] = Seq(
    organization := "com.verticalbit",
    scalaVersion := "2.11.8",
    scalacOptions ++= Seq(
      "-deprecation",
      "-encoding", "UTF-8",
      "-feature",
      "-language:existentials",
      "-language:higherKinds",
      "-language:implicitConversions",
      "-language:postfixOps",
      "-target:jvm-1.8",
      "-unchecked",
      "-Xfuture"
    ),
    resolvers += Resolver.jcenterRepo,
    libraryDependencies ++= Seq(
      "org.scala-lang.modules" %% "scala-java8-compat" % "0.7.0"
    )
  )

  def infrastructure: Seq[Setting[_]] = Seq(
    libraryDependencies ++= Seq(
      "ch.qos.logback" % "logback-classic" % "1.1.7",
      "com.iheart" %% "ficus" % "1.2.6",
      "com.softwaremill.macwire" %% "macros" % "2.2.3" % Provided,
      "com.softwaremill.macwire" %% "proxy" % "2.2.3",
      "com.softwaremill.macwire" %% "util" % "2.2.3",
      "com.typesafe.scala-logging" %% "scala-logging" % "3.4.0"
    )
  )

  object grpc {
    def codegen: Seq[Setting[_]] = {
      import com.trueaccord.scalapb.ScalaPbPlugin._

      protobufSettings ++ Seq(
        version in protobufConfig := "3.0.0",
        libraryDependencies ++= Seq(
          "com.trueaccord.scalapb" %% "scalapb-runtime-grpc" % (scalapbVersion in protobufConfig).value
        ),
        runProtoc in protobufConfig := { args =>
          com.github.os72.protocjar.Protoc.runProtoc("-v300" +: args.toArray)
        }
      )
    }

    def runtime: Seq[Setting[_]] = Seq(
      libraryDependencies ++= Seq(
        "io.grpc" % "grpc-all" % "1.0.0"
      )
    )
  }

  def testing(integration: Boolean = false): Seq[Setting[_]] = {
    val scope = if (integration) "test,it" else "test"
    (if (integration) Defaults.itSettings else Nil) ++
    Seq(
      libraryDependencies ++= Seq(
        "org.mockito" % "mockito-core" % "1.10.19" % scope,
        "org.scalacheck" %% "scalacheck" % "1.13.2" % scope,
        "org.scalatest" %% "scalatest" % "3.0.0" % scope
      )
    )
  }
}
