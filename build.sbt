lazy val commonSettings = Seq(
    organization := "com.example",
    scalaVersion := "2.11.8",
    version := "0.0.1-SNAPSHOT"
  )

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    commonSettings,
    name := "backend-demo",
    libraryDependencies ++= Seq(
      "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test,
      "com.typesafe.akka" %% "akka-actor" % "2.5.4"
    ),
    resolvers += Resolver.sonatypeRepo("snapshots")
  )
