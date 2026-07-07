name := "TaxCalculator"

version := "1.0.0-SNAPSHOT"

scalaVersion := "3.3.4"

resolvers ++= Resolver.sonatypeOssRepos("snapshots") ++ Resolver.sonatypeOssRepos("releases")

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "5.5.6" % "test",
  "org.specs2" %% "specs2-junit" % "5.5.6" % "test"
)

// Emit JUnit XML to target/test-reports/ so the TestGlance action can parse results.
Test / testOptions += Tests.Argument(TestFrameworks.Specs2, "junitxml")
