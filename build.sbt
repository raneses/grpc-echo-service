lazy val root = (project in file(".")).settings(rootSettings: _*).aggregate(core, client, server)

lazy val core = project
lazy val client = project.dependsOn(core).configs(IntegrationTest)
lazy val server = project.dependsOn(core).configs(IntegrationTest).enablePlugins(BuildInfoPlugin)

lazy val rootSettings =
  Settings.base ++
  Seq(name := "echo-service")
