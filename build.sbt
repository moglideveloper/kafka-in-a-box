val build = SBuild("kafka", "docker-box", "0.0.1")
  .testDependencies( scala_test() )

val hdfsDockerProject = ( project in file(".") )
  .settings( build.settings )
  .enablePlugins(LogicOverCode)
