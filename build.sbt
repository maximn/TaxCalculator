name := "TaxCalculator"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.11.4"

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)

libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "2.4.14" % "test")