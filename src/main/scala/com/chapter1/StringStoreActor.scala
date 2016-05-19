package com.chapter1

import akka.actor.Actor
import akka.event.Logging

class StringStoreActor extends Actor {
  var lastStringReceived = "";
  val log = Logging(context.system,this)
  override def receive = {
    case string: String => 
      lastStringReceived = string
      log.info("Received message: {}",string)
      
    case o => log.info("Received unknown message: {}",o)
  }
}