package com.typesafe.sbt

import packager._

import Keys.packageMsi
import Keys.packageZipTarball
import Keys.packageXzTarball
import sbt._
import sbt.Keys.packageBin

object SbtNativePackager extends Plugin 
    with linux.LinuxPlugin 
    with rpm.RpmPlugin
    with universal.UniversalPlugin {

  def packagerSettings = linuxSettings ++ 
                         rpmSettings ++ 
                         universalSettings
  
  val NativePackagerKeys = packager.Keys
                         
  import SettingsHelper._
  def deploymentSettings = makeDeploymentSettings(Rpm, packageBin in Rpm, "rpm") ++
                           makeDeploymentSettings(Universal, packageBin in Universal, "zip") ++
                           addPackage(Universal, packageZipTarball in Universal, "tgz") ++
                           makeDeploymentSettings(UniversalDocs, packageBin in UniversalDocs, "zip") ++
                           addPackage(UniversalDocs, packageXzTarball in UniversalDocs, "txz")
  
  // TODO - Add a few targets that detect the current OS and build a package for that OS.
}