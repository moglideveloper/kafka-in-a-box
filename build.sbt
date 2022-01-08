val build = SBuild("kafka", "kafka-docker-box", "0.0.1")
  .testDependencies( scala_test() )

val hdfsDockerProject = ( project in file(".") )
  .settings( build.settings )
  .enablePlugins(LogicOverCode)
