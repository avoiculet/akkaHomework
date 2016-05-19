package com.example

import org.scalatest.FunSpec
import org.scalatest.Matchers
import org.scalatest.BeforeAndAfterEach
import akka.actor.ActorSystem
import akka.testkit.TestActor
import akka.testkit.TestActorRef
import com.chapter1.StringStoreActor

class StringStoreActorTest extends FunSpec with Matchers with BeforeAndAfterEach{
  describe("StringStoreActor") {
    it("should store the last string it received") {
      implicit val system = ActorSystem()
      val actorRef = TestActorRef(new StringStoreActor)
      actorRef ! "Hello"
      actorRef ! "Bye"
      val realActor = actorRef.underlyingActor;
      realActor.lastStringReceived should(equal("Bye"))
    }
  }
}