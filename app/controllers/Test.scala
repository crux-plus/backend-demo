package controllers

import javax.inject.Inject
import play.api.libs.concurrent.Futures._
import play.api.mvc.ControllerComponents
import play.api.mvc.AbstractController
import play.api.mvc.Action
import play.api.libs.json.Json
import akka.actor.ActorSystem
import akka.util.Timeout
import akka.pattern.ask
import scala.concurrent.ExecutionContext
import scala.concurrent.duration._
import actors.TestActor

trait MyExecutionContext extends ExecutionContext

class Test @Inject()(system: ActorSystem,
                    cc: ControllerComponents
                    )
  (implicit ec: ExecutionContext) extends AbstractController(cc) {

  implicit val timeout: Timeout = 5.seconds

  val testActor = system.actorOf(TestActor.props, "test-actor")

  def test = Action.async {
    (testActor ask "test").mapTo[String].map { message =>
      Ok(
        Json.obj(
          "status" -> "OK",
          "message" -> message
        )
      )
    }
  }
}
