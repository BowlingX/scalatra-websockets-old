organization := "com.myself.design"

name := "scalatra-websockets"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.9.1"

seq(webSettings :_*)

libraryDependencies ++= Seq(
    "commons-logging" % "commons-logging" % "1.1.1" % "provided",
    "org.slf4j" % "log4j-over-slf4j" % "1.6.4",
    "ch.qos.logback" % "logback-classic" % "1.0.2",
    "org.specs2" %% "specs2" % "1.8.2" % "test",
   "org.scala-tools.testing" %% "scalacheck" % "1.9" % "test",
   "junit" % "junit" % "4.10" % "test",
   "org.fusesource.scalamd" % "scalamd" % "1.5",
   "org.scalatra" % "scalatra" % "2.1.0-SNAPSHOT" changing(),
   "org.scalatra" % "scalatra-scalatest" % "2.1.0-SNAPSHOT" changing(),
   "org.scalatra" % "scalatra-scalate" % "2.1.0-SNAPSHOT" changing(),
   "org.scalatra" %% "scalatra-akka2" % "2.1.0-SNAPSHOT" changing(),
   "org.scalatra" % "scalatra-specs2" % "2.1.0-SNAPSHOT" % "test" changing(),
   "org.eclipse.jetty" % "jetty-webapp" % "8.1.0.v20120127" % "container",
   "org.eclipse.jetty" % "jetty-websocket" % "8.1.0.v20120127",
   "javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided",
   "net.liftweb" %% "lift-json" % "2.4-M4",
   "net.sf.ehcache" %  "ehcache-core"  % "2.5.1",
   "org.atmosphere" % "atmosphere-runtime" % "0.9.3",
   "org.apache.shiro" % "shiro-core" % "1.2.0",
   "org.apache.shiro" % "shiro-web" % "1.2.0",
   "org.apache.shiro" % "shiro-ehcache" % "1.2.0"
)


ivyXML :=
<dependency org="org.eclipse.jetty.orbit" name="javax.servlet" rev="3.0.0.v201112011016">
<artifact name="javax.servlet" type="orbit" ext="jar"/>
</dependency>

resolvers ++= Seq("snapshots" at "http://scala-tools.org/repo-snapshots",
                    "releases"  at "http://scala-tools.org/repo-releases",
                    "releases" at "https://oss.sonatype.org/content/repositories/releases/",
                    "snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
                    // See http://code.google.com/p/guice-maven/
                    "releases" at "http://guice-maven.googlecode.com/svn/trunk",
                    "releases"  at "http://repo.typesafe.com/typesafe/releases/",
                    "snapshots" at "http://repository.apache.org/snapshots/",
                    "SourceforgeReleases" at "https://oss.sonatype.org/content/repositories/sourceforge-releases/",
                    "SourceforgeSnapshots" at "https://oss.sonatype.org/content/repositories/sourceforge-snapshots/",
                    "Terracotta Snapshots" at "http://snapshots.terracotta.org/",
                    "terracotta-releases" at "http://www.terracotta.org/download/reflector/releases"
 )


resolvers += "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"
