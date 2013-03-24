sbtPlugin := true

name := "sbt-native-packager"

organization := "com.sara.sbt"

version := "0.5.0"

scalacOptions in Compile += "-deprecation"

site.settings

com.jsuereth.sbtsite.SiteKeys.siteMappings <+= (baseDirectory) map { dir => 
  val nojekyll = dir / "src" / "site" / ".nojekyll"
  nojekyll -> ".nojekyll"
}

site.sphinxSupport()

ghpages.settings

git.remoteRepo := "git@github.com:sbt/sbt-native-packager.git"

publishTo := Some(Resolver.url("Sara Ivy", url("http://www.saraframework.com/artifactory/ivy"))(Resolver.ivyStylePatterns))

credentials ++= Seq(Credentials("Sara Server", "www.saraframework.com", "saradeveloper", "teamkp"))

publishMavenStyle := false
