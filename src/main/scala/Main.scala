import monix.eval.Task
import cats.Monad

object Main extends App {

  implicitly[Monad[Task]] // 正体はTask.catsAsync




}
