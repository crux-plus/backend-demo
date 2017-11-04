package actors

import akka.actor.Actor
import akka.actor.Props

object TestActor {
  def props = Props[TestActor]
}

class TestActor extends Actor {
  def receive = {
    case "test" =>
      sender() ! "it works"
  }
}
