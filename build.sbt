name := "TaxCalculator"

version := "1.0.0-SNAPSHOT"

scalaVersion := "3.3.4"

resolvers ++= Resolver.sonatypeOssRepos("snapshots") ++ Resolver.sonatypeOssRepos("releases")

libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "5.5.6" % "test")
