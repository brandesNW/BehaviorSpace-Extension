// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.extensions.bspace

import org.nlogo.api.{ Argument, Command, Context, LabProtocol, LabVariableParser, RefValueSet }
import org.nlogo.core.Syntax._
import org.nlogo.nvm.Procedure

object SetPreExperimentCommands extends Command {
  override def getSyntax = {
    commandSyntax(right = List(DelayedCommandBlockType))
  }

  def perform(args: Array[Argument], context: Context) {
    if (BehaviorSpaceExtension.currentExperiment.isEmpty)
      return BehaviorSpaceExtension.nameError(context, "noCurrent")

    if (!BehaviorSpaceExtension.validateForEditing(BehaviorSpaceExtension.currentExperiment, context)) return

    BehaviorSpaceExtension.experiments(BehaviorSpaceExtension.currentExperiment).preExperimentCommands = args(0).getString
  }
}

object SetSetupCommands extends Command {
  override def getSyntax = {
    commandSyntax(right = List(DelayedCommandBlockType))
  }

  def perform(args: Array[Argument], context: Context) {
    if (BehaviorSpaceExtension.currentExperiment.isEmpty)
      return BehaviorSpaceExtension.nameError(context, "noCurrent")
        
    if (!BehaviorSpaceExtension.validateForEditing(BehaviorSpaceExtension.currentExperiment, context)) return

    BehaviorSpaceExtension.experiments(BehaviorSpaceExtension.currentExperiment).setupCommands = args(0).getString
  }
}

object SetGoCommands extends Command {
  override def getSyntax = {
    commandSyntax(right = List(DelayedCommandBlockType))
  }

  def perform(args: Array[Argument], context: Context) {
    if (BehaviorSpaceExtension.currentExperiment.isEmpty)
      return BehaviorSpaceExtension.nameError(context, "noCurrent")
        
    if (!BehaviorSpaceExtension.validateForEditing(BehaviorSpaceExtension.currentExperiment, context)) return

    BehaviorSpaceExtension.experiments(BehaviorSpaceExtension.currentExperiment).goCommands = args(0).getString
  }
}

object SetPostRunCommands extends Command {
  override def getSyntax = {
    commandSyntax(right = List(DelayedCommandBlockType))
  }

  def perform(args: Array[Argument], context: Context) {
    if (BehaviorSpaceExtension.currentExperiment.isEmpty)
      return BehaviorSpaceExtension.nameError(context, "noCurrent")
        
    if (!BehaviorSpaceExtension.validateForEditing(BehaviorSpaceExtension.currentExperiment, context)) return

    BehaviorSpaceExtension.experiments(BehaviorSpaceExtension.currentExperiment).postRunCommands = args(0).getString
  }
}

object SetPostExperimentCommands extends Command {
  override def getSyntax = {
    commandSyntax(right = List(DelayedCommandBlockType))
  }

  def perform(args: Array[Argument], context: Context) {
    if (BehaviorSpaceExtension.currentExperiment.isEmpty)
      return BehaviorSpaceExtension.nameError(context, "noCurrent")
        
    if (!BehaviorSpaceExtension.validateForEditing(BehaviorSpaceExtension.currentExperiment, context)) return

    BehaviorSpaceExtension.experiments(BehaviorSpaceExtension.currentExperiment).postExperimentCommands = args(0).getString
  }
}

object SetRepetitions extends Command {
  override def getSyntax = {
    commandSyntax(right = List(NumberType))
  }

  def perform(args: Array[Argument], context: Context) {
    if (BehaviorSpaceExtension.currentExperiment.isEmpty)
      return BehaviorSpaceExtension.nameError(context, "noCurrent")
        
    if (!BehaviorSpaceExtension.validateForEditing(BehaviorSpaceExtension.currentExperiment, context)) return

    BehaviorSpaceExtension.experiments(BehaviorSpaceExtension.currentExperiment).repetitions = args(0).getIntValue
  }
}

object SetSequentialRunOrder extends Command {
  override def getSyntax = {
    commandSyntax(right = List(BooleanType))
  }

  def perform(args: Array[Argument], context: Context) {
    if (BehaviorSpaceExtension.currentExperiment.isEmpty)
      return BehaviorSpaceExtension.nameError(context, "noCurrent")
        
    if (!BehaviorSpaceExtension.validateForEditing(BehaviorSpaceExtension.currentExperiment, context)) return

    BehaviorSpaceExtension.experiments(BehaviorSpaceExtension.currentExperiment).sequentialRunOrder = args(0).getBooleanValue
  }
}

object SetRunMetricsEveryStep extends Command {
  override def getSyntax = {
    commandSyntax(right = List(BooleanType))
  }

  def perform(args: Array[Argument], context: Context) {
    if (BehaviorSpaceExtension.currentExperiment.isEmpty)
      return BehaviorSpaceExtension.nameError(context, "noCurrent")
        
    if (!BehaviorSpaceExtension.validateForEditing(BehaviorSpaceExtension.currentExperiment, context)) return

    BehaviorSpaceExtension.experiments(BehaviorSpaceExtension.currentExperiment).runMetricsEveryStep = args(0).getBooleanValue
  }
}

object SetRunMetricsCondition extends Command {
  override def getSyntax = {
    commandSyntax(right = List(DelayedReporterBlockType))
  }

  def perform(args: Array[Argument], context: Context) {
    if (BehaviorSpaceExtension.currentExperiment.isEmpty)
      return BehaviorSpaceExtension.nameError(context, "noCurrent")
        
    if (!BehaviorSpaceExtension.validateForEditing(BehaviorSpaceExtension.currentExperiment, context)) return

    BehaviorSpaceExtension.experiments(BehaviorSpaceExtension.currentExperiment).runMetricsCondition = args(0).getString
  }
}

object SetTimeLimit extends Command {
  override def getSyntax = {
    commandSyntax(right = List(NumberType))
  }

  def perform(args: Array[Argument], context: Context) {
    if (BehaviorSpaceExtension.currentExperiment.isEmpty)
      return BehaviorSpaceExtension.nameError(context, "noCurrent")
        
    if (!BehaviorSpaceExtension.validateForEditing(BehaviorSpaceExtension.currentExperiment, context)) return

    BehaviorSpaceExtension.experiments(BehaviorSpaceExtension.currentExperiment).timeLimit = args(0).getIntValue
  }
}

object SetStopCondition extends Command {
  override def getSyntax = {
    commandSyntax(right = List(DelayedReporterBlockType))
  }

  def perform(args: Array[Argument], context: Context) {
    if (BehaviorSpaceExtension.currentExperiment.isEmpty)
      return BehaviorSpaceExtension.nameError(context, "noCurrent")
        
    if (!BehaviorSpaceExtension.validateForEditing(BehaviorSpaceExtension.currentExperiment, context)) return

    BehaviorSpaceExtension.experiments(BehaviorSpaceExtension.currentExperiment).exitCondition = args(0).getString
  }
}

object SetMetrics extends Command {
  override def getSyntax = {
    commandSyntax(right = List(ListType | StringType)) // weird parse error if code instead of strings, fix later
  }

  def perform(args: Array[Argument], context: Context) {
    if (BehaviorSpaceExtension.currentExperiment.isEmpty)
      return BehaviorSpaceExtension.nameError(context, "noCurrent")
        
    if (!BehaviorSpaceExtension.validateForEditing(BehaviorSpaceExtension.currentExperiment, context)) return

    BehaviorSpaceExtension.experiments(BehaviorSpaceExtension.currentExperiment).metrics = args(0).getList.toList.map(_.toString)
  }
}

object SetVariables extends Command {
  override def getSyntax = {
    commandSyntax(right = List(ListType | StringType))
  }

  def perform(args: Array[Argument], context: Context) {
    if (BehaviorSpaceExtension.currentExperiment.isEmpty)
      return BehaviorSpaceExtension.nameError(context, "noCurrent")
        
    if (!BehaviorSpaceExtension.validateForEditing(BehaviorSpaceExtension.currentExperiment, context)) return

    LabVariableParser.parseVariables(args(0).getList.mkString("\n"),
                                     BehaviorSpaceExtension.experiments(BehaviorSpaceExtension.currentExperiment).repetitions,
                                     context.workspace.world,
                                     context.workspace.asInstanceOf[org.nlogo.workspace.AbstractWorkspace]) match {
      case (Some((constants: List[RefValueSet], subExperiments: List[List[RefValueSet]])), _) =>
        BehaviorSpaceExtension.experiments(BehaviorSpaceExtension.currentExperiment).constants = constants
        BehaviorSpaceExtension.experiments(BehaviorSpaceExtension.currentExperiment).subExperiments = subExperiments
      case (None, message: String) =>
        return BehaviorSpaceExtension.nameError(context, message)
    }
  }
}

object SetParallelRuns extends Command {
  override def getSyntax = {
    commandSyntax(right = List(NumberType))
  }

  def perform(args: Array[Argument], context: Context) {
    if (BehaviorSpaceExtension.currentExperiment.isEmpty)
      return BehaviorSpaceExtension.nameError(context, "noCurrent")
        
    if (!BehaviorSpaceExtension.validateForEditing(BehaviorSpaceExtension.currentExperiment, context)) return

    BehaviorSpaceExtension.experiments(BehaviorSpaceExtension.currentExperiment).threadCount = args(0).getIntValue
  }
}

object SetTable extends Command {
  override def getSyntax = {
    commandSyntax(right = List(StringType))
  }

  def perform(args: Array[Argument], context: Context) {
    if (BehaviorSpaceExtension.currentExperiment.isEmpty)
      return BehaviorSpaceExtension.nameError(context, "noCurrent")
        
    if (!BehaviorSpaceExtension.validateForEditing(BehaviorSpaceExtension.currentExperiment, context)) return

    BehaviorSpaceExtension.experiments(BehaviorSpaceExtension.currentExperiment).table = args(0).getString
  }
}

object SetSpreadsheet extends Command {
  override def getSyntax = {
    commandSyntax(right = List(StringType))
  }

  def perform(args: Array[Argument], context: Context) {
    if (BehaviorSpaceExtension.currentExperiment.isEmpty)
      return BehaviorSpaceExtension.nameError(context, "noCurrent")
        
    if (!BehaviorSpaceExtension.validateForEditing(BehaviorSpaceExtension.currentExperiment, context)) return

    BehaviorSpaceExtension.experiments(BehaviorSpaceExtension.currentExperiment).spreadsheet = args(0).getString
  }
}

object SetStats extends Command {
  override def getSyntax = {
    commandSyntax(right = List(StringType))
  }

  def perform(args: Array[Argument], context: Context) {
    if (BehaviorSpaceExtension.currentExperiment.isEmpty)
      return BehaviorSpaceExtension.nameError(context, "noCurrent")
        
    if (!BehaviorSpaceExtension.validateForEditing(BehaviorSpaceExtension.currentExperiment, context)) return

    BehaviorSpaceExtension.experiments(BehaviorSpaceExtension.currentExperiment).stats = args(0).getString
  }
}

object SetLists extends Command {
  override def getSyntax = {
    commandSyntax(right = List(StringType))
  }

  def perform(args: Array[Argument], context: Context) {
    if (BehaviorSpaceExtension.currentExperiment.isEmpty)
      return BehaviorSpaceExtension.nameError(context, "noCurrent")
        
    if (!BehaviorSpaceExtension.validateForEditing(BehaviorSpaceExtension.currentExperiment, context)) return

    BehaviorSpaceExtension.experiments(BehaviorSpaceExtension.currentExperiment).lists = args(0).getString
  }
}

object SetUpdateView extends Command {
  override def getSyntax = {
    commandSyntax(right = List(BooleanType))
  }

  def perform(args: Array[Argument], context: Context) {
    if (BehaviorSpaceExtension.currentExperiment.isEmpty)
      return BehaviorSpaceExtension.nameError(context, "noCurrent")
        
    if (!BehaviorSpaceExtension.validateForEditing(BehaviorSpaceExtension.currentExperiment, context)) return

    BehaviorSpaceExtension.experiments(BehaviorSpaceExtension.currentExperiment).updateView = args(0).getBooleanValue
  }
}

object SetUpdatePlots extends Command {
  override def getSyntax = {
    commandSyntax(right = List(BooleanType))
  }

  def perform(args: Array[Argument], context: Context) {
    if (BehaviorSpaceExtension.currentExperiment.isEmpty)
      return BehaviorSpaceExtension.nameError(context, "noCurrent")
        
    if (!BehaviorSpaceExtension.validateForEditing(BehaviorSpaceExtension.currentExperiment, context)) return

    BehaviorSpaceExtension.experiments(BehaviorSpaceExtension.currentExperiment).updatePlotsAndMonitors = args(0).getBooleanValue
  }
}
