name := """play-eventdriven"""
organization := "moip"

version := "1.0.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.2"

libraryDependencies += guice


libraryDependencies += "com.google.code.gson" % "gson" % "2.7"
libraryDependencies += "io.confluent" % "kafka-avro-serializer" % "3.3.0"
libraryDependencies += "io.confluent" % "kafka-streams-avro-serde" % "3.3.0"
libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.4"
libraryDependencies += "org.apache.avro" % "avro" % "1.7.7"
libraryDependencies += "org.apache.kafka" % "kafka-streams" % "0.11.0.0-cp1"

libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.0" % Test



resolvers +=
  "Confluent Repo" at "http://packages.confluent.io/maven/"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "moip.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "moip.binders._"
