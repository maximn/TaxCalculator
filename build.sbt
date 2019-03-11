name := "TaxCalculator"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.12.6"

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)

libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "4.5.1" % "test")