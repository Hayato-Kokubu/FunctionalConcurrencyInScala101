import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object Main extends App {

//  val fur1 = Future.apply{println("fur1 culc!!"); 1}
//  val fur2 = Future.apply{println("fur2 culc!!"); 2}
//
//
//  val fur3 =
//    for{
//      n <- fur1
//      m <- fur2
//    }yield n + m


  val fur3 = for{
    n <- Future.apply{println("fur1 culc!!"); 1}
    m <- Future.apply{println("fur2 culc!!"); 2}
  }yield n + m


  Await.result(fur3, 1.second)



}
