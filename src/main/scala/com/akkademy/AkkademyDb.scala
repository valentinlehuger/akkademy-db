package com.akkademy

import akka.actor.Actor
import akka.event.{Logging, LoggingAdapter}

import scala.collection.mutable
import com.akkademy.messages.SetRequest


class AkkademyDb extends Actor {

  val map: mutable.HashMap[String, Object] = new mutable.HashMap[String, Object]
  val log: LoggingAdapter = Logging(context.system, this)

  override def receive: PartialFunction[Any, Unit] = {
    case SetRequest(key, value) => {
      log.info("received SetRequest - key: {} value: {}", key, value)
      map.put(key, value)
    }
    case o => log.info("received unknown message: {}", o)
  }

}
