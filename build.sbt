val build = SBuild("kafka", "kafka-docker-box", "0.0.1")
  .sourceDirectories("core")
  .testDependencies( scalatest() )

scalacOptions ++= Seq(
  "-target:11"
)

javacOptions ++= Seq("-source", "11", "-target", "11")

val hdfsDockerProject = ( project in file(".") )
  .settings( build.settings )
  .enablePlugins(PackPlugin)

