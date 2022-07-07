name := "TaxCalculator"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.12.16"

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)

libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.+" % "test")