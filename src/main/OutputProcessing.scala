// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.extensions.bspace

import org.nlogo.api.{ Argument, Context, Reporter }
import org.nlogo.core.{ I18N, LogoList }
import org.nlogo.core.Syntax._

object GetOutputMetric extends Reporter {
  override def getSyntax = {
    reporterSyntax(right = List(StringType, StringType, NumberType), ret = ListType | StringType)
  }

  override def report(args: Array[Argument], context: Context): LogoList = {
    val file = scala.io.Source.fromFile(args(0).getString)

    val lines = file.getLines.dropWhile(x => !x.split(",")(0).contains("final value") &&
                                             !x.split(",")(0).contains("all run data"))
    val headers = lines.next.split(",")
    val runs = headers.count(BehaviorSpaceExtension.removeQuotes(_) == "[step]")
    val index = headers.indexWhere(BehaviorSpaceExtension.removeQuotes(_) == args(1).getString)

    var result = Iterator[String]()

    if (index < 0) {
      BehaviorSpaceExtension.nameError(I18N.gui.getN("tools.behaviorSpace.extension.noMetric",
                                                     args(1).getString), context)
    }

    else if (args(2).getIntValue <= 0 || args(2).getIntValue > runs) {
      BehaviorSpaceExtension.nameError(I18N.gui.getN("tools.behaviorSpace.extension.noRun",
                                                     args(2).getIntValue.toString), context)
    }

    else {
      result = lines.map(x => BehaviorSpaceExtension.removeQuotes(x.split(",")((headers.length - 1) / runs *
                              (args(2).getIntValue - 1) + index)))
    }

    val logo = LogoList.fromIterator(result)

    file.close

    return logo
  }
}
