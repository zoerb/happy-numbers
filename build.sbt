ThisBuild / scalaVersion := "2.12.8"
ThisBuild / version      := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.zoerb"

lazy val root = (project in file("."))
  .settings(
    name := "Happy Numbers",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.5" % Test
    )
  )
