name := "sbt-msx"

version := "0.0.1"

organization := "com.roperzh.sbt"

scalaVersion := "2.10.4"

sbtPlugin := true

libraryDependencies ++= Seq(
  "org.webjars" % "mkdirp" % "0.3.5",
  "org.webjars.npm" % "msx" % "0.4.1"
)

resolvers ++= Seq(
  "Typesafe Releases Repository" at "http://repo.typesafe.com/typesafe/releases/",
  Resolver.url("sbt snapshot plugins", url("http://repo.scala-sbt.org/scalasbt/sbt-plugin-snapshots"))(Resolver.ivyStylePatterns),
  Resolver.sonatypeRepo("snapshots"),
  "Typesafe Snapshots Repository" at "http://repo.typesafe.com/typesafe/snapshots/",
  Resolver.mavenLocal
)

addSbtPlugin("com.typesafe.sbt" %% "sbt-js-engine" % "1.0.1")

publishMavenStyle := false

publishTo := {
  if (isSnapshot.value) Some(Classpaths.sbtPluginSnapshots)
  else Some(Classpaths.sbtPluginReleases)
}

scriptedSettings

scriptedLaunchOpts <+= version apply { v => s"-Dproject.version=$v" }

publishTo := Some(Resolver.url("sbt-plugin-releases", new URL("http://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns))

publishMavenStyle := false

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

crossPaths := false

pomExtra := (
  <url>http://github.com/roperzh/sbt-msx</url>
  <licenses>
    <license>
      <name>MIT</name>
      <url>http://opensource.org/licenses/MIT</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:roperzh/sbt-msx.git</url>
    <connection>scm:git:git@github.com:roperzh/sbt-msx.git</connection>
  </scm>
  <developers>
    <developer>
      <id>roperzh</id>
      <name>Roberto Dip</name>
      <url>https://github.com/roperzh</url>
    </developer>
  </developers>
)