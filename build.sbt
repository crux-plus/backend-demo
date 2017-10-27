val play = "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2"

lazy val commonSettings = Seq(
    organization := "com.example",
    scalaVersion := "2.11.8",
    version := "0.0.1-SNAPSHOT"
  )

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    commonSettings,
    name := "playframework-demo",
    libraryDependencies += play,
    resolvers += Resolver.sonatypeRepo("snapshots")
  )
