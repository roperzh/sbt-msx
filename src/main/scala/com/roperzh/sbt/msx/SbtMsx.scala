package com.roperzh.sbt.msx

import com.typesafe.sbt.jse.SbtJsTask
import sbt._
import com.typesafe.sbt.web.SbtWeb
import spray.json.{JsBoolean, JsObject}
import sbt.Keys._

object Import {

  object MsxKeys {
    val msx = TaskKey[Seq[File]]("msx", "Invoke the Msx compiler.")
  }

}

object SbtMsx extends AutoPlugin {

  override def requires = SbtJsTask

  override def trigger = AllRequirements

  val autoImport = Import

  import SbtWeb.autoImport._
  import WebKeys._
  import SbtJsTask.autoImport.JsTaskKeys._
  import autoImport.MsxKeys._

  val msxUnscopedSettings = Seq(

    includeFilter := "*.msx",

    jsOptions := JsObject(
    ).toString()
  )

  override def projectSettings = Seq(
  ) ++ inTask(msx)(
    SbtJsTask.jsTaskSpecificUnscopedSettings ++
      inConfig(Assets)(msxUnscopedSettings) ++
      inConfig(TestAssets)(msxUnscopedSettings) ++
      Seq(
        moduleName := "msx",
        shellFile := getClass.getClassLoader.getResource("msx-shell.js"),

        taskMessage in Assets := "Msx compiling",
        taskMessage in TestAssets := "Msx test compiling"
      )
  ) ++ SbtJsTask.addJsSourceFileTasks(msx) ++ Seq(
    msx in Assets := (msx in Assets).dependsOn(webModules in Assets).value,
    msx in TestAssets := (msx in TestAssets).dependsOn(webModules in TestAssets).value
  )

}
