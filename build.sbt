name := "play-playground"

version := "1.0"

val cats                = "org.typelevel"          %% "cats"                  % "0.9.0"
val simulacrum          = "com.github.mpilquist"   %% "simulacrum"            % "0.11.0"
val playSlick           = "com.typesafe.play"      %% "play-slick"            % "3.0.0"
val playSlickEvolutions = "com.typesafe.play"      %% "play-slick-evolutions" % "3.0.0"
val scalaGuice          = "net.codingwell"         %% "scala-guice"           % "4.1.0"
val mysql               = "mysql"                  % "mysql-connector-java"   % "6.0.5"
val playTest            = "com.typesafe.play"      %% "play-test"             % "2.6.0" % "test"
val scalaTest           = "org.scalatest"          %% "scalatest"             % "3.0.0" % "test"
val scalaTestPlusPlay   = "org.scalatestplus.play" %% "scalatestplus-play"    % "3.0.0" % "test"
val mockito             = "org.mockito"            % "mockito-core"           % "2.2.11" % "test"

val appDeps = List(
  cats,
  simulacrum,
  playSlick,
  playSlickEvolutions,
  scalaGuice,
  mysql,
  guice
)

val testDeps = List(
  playTest,
  scalaTest,
  scalaTestPlusPlay,
  mockito
)

val appSettings = List(
  PlayKeys.playMonitoredFiles ++= (sourceDirectories in (Compile, TwirlKeys.compileTemplates)).value,
  libraryDependencies ++= appDeps ::: testDeps,
  scalacOptions ++= List(
    "-deprecation",
    "-feature",
    "-unchecked",
    "-Xlint",
    "-Ywarn-adapted-args",
    "-Ywarn-inaccessible",
    "-Ywarn-nullary-override",
    "-Ywarn-numeric-widen"
  )
)

val commonSettings = List(
  scalaVersion := "2.12.2",
  addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.3"),
  addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full),
  resolvers += Resolver.sonatypeRepo("releases")
)

lazy val playPlayground = (project in file(".")).settings(commonSettings).dependsOn(app).aggregate(app)

lazy val app =
  project.enablePlugins(PlayScala).disablePlugins(PlayLayoutPlugin).settings(appSettings ++ commonSettings)
