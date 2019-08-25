//import monix.eval.Task
import monix.execution.Scheduler.Implicits.global


import monix.eval._
import monix.reactive._

object Main extends App {

  val items = 0 until 1000

  // The list of all tasks needed for execution
  val tasks = items.map(i => Task(i * 2))

  val batched = tasks.sliding(10,10) // Iteratore がつく
    .map(b => Task.gather(b)).toIterable

  val aggregate = Task.gather(tasks).map(_.toList)
  // Evaluation:
  aggregate.foreach(println)

}
