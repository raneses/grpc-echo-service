// Protobuf plugin
addSbtPlugin("com.trueaccord.scalapb" % "sbt-scalapb" % "0.5.40")
libraryDependencies += "com.github.os72" % "protoc-jar" % "3.0.0"

// Build info plugin
addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.6.1")

// Native packager plugin
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.1.0")

// Release plugin
addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.3")

// Scalastyle plugin
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.6.0")

// Scoverage code coverage plugin
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.3.5")

// FindBugs plugin
addSbtPlugin("de.johoop" % "findbugs4sbt" % "1.4.0")

// Dependency updates plugin
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.1.10")

// Dependency visualization plugin
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.8.2")
