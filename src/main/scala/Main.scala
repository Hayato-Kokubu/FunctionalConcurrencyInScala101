//import monix.eval.Task
import monix.execution.Scheduler.Implicits.global


import monix.eval._
import monix.reactive._

object Main extends App {

  val items = 0 until 1000

  // The list of all tasks needed for execution
  val tasks = items.map(i => Task(i * 2))


  val aggregate = Task.gather(tasks).map(_.toList)
  val aggregateNoOrder = Task.gatherUnordered(tasks).map(_.toList)
  // Evaluation:
  aggregate.foreach(println)
  aggregateNoOrder.foreach(println)

}
