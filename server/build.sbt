name := "echo-service-server"

Settings.base
Settings.infrastructure
Settings.grpc.runtime
Settings.testing(true)

fork in run := true
