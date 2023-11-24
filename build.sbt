val AirframeVersion = "23.11.3"
ThisBuild / scalaVersion := "3.3.2"

lazy val root = (project in file("."))
  .settings(
    name := "airframe-scala3"
  )
  .aggregate(api, server)

lazy val server =
  project
    .in(file("server"))
    .settings(
      // For using the project root as a working folder
      reStart / baseDirectory := (ThisBuild / baseDirectory).value,
      libraryDependencies ++= Seq(
        "org.wvlet.airframe" %% "airframe-http-netty" % AIRFRAME_VERSION,
        "org.wvlet.airframe" %% "airframe-launcher" % AIRFRAME_VERSION
      )
    )
