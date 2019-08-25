// We need a scheduler whenever asynchronous
// execution happens, substituting your ExecutionContext


import monix.execution.Scheduler.Implicits.global


import scala.concurrent.Await
import scala.concurrent.duration._

import monix.reactive.Observable

import monix.eval.Task


object Main extends App {

  // A specification for evaluating a sum,
  // nothing gets triggered at this point! <- to execute this I must do something
  val task = Task{1 + 1}


  // runToFuture が見つからないためコメントアウト
  //  val future = task.runToFuture
  // これで、Future が得られるとのこと


  // Nothing happens here, as observable is lazily
  // evaluated only when the subscription happens!
  val tick = {
    Observable.interval(1.second) // Observable[Long]
      .filter(_ % 2 == 0)
      // Obserable has map and flatMap
      .map(_ * 2)
      .flatMap(x => Observable.fromIterable(Seq(x,x)))
      // only take the first 5 elements, then stop
      .take(5)
      // to print the generated events to console
      .dump("Out")
  }

  // ↑ now tick is not executed.

  val cancelable = tick.subscribe() // Cancelable


//  Thread.sleep(10000)

  cancelable.cancel()





}
