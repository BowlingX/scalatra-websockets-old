package com.myself.websockets

import org.scalatra._
import org.apache.shiro.SecurityUtils
import org.atmosphere.cpr._
import org.apache.shiro.subject.Subject
import org.atmosphere.cpr.AtmosphereResource.TRANSPORT._

class CometServlet extends ScalatraServlet {

  class EventsLogger extends AtmosphereResourceEventListener {
    def onThrowable(event: AtmosphereResourceEvent) {
    }

    def onBroadcast(event: AtmosphereResourceEvent) {
    }

    def onDisconnect(event: AtmosphereResourceEvent) {
    }

    def onResume(event: AtmosphereResourceEvent) {
    }

    def onSuspend(event: AtmosphereResourceEvent) {
    }
  }

  get("/status") {
    val currentUser = SecurityUtils.getSubject
    // Save current User to request, because this request will be suspended and forked in another thread.
    // See: http://jfarcand.wordpress.com/2011/07/13/quick-tip-using-apache-shiro-with-your-atmospheres-websocketcomet-app/
    request.setAttribute("subject", currentUser)
    contentType = "application/json"
    val m: Meteor = Meteor.build(request)
    m.addListener(new EventsLogger())
    // Create or retrieve Broadcaster for current User
    val b = BroadcasterFactory.getDefault.lookup(currentUser.getPrincipal.toString, true)
    // Set Scope explicitly to Application for access on different threads
    b.setScope(Broadcaster.SCOPE.APPLICATION)
    m.setBroadcaster(b)

    m resumeOnBroadcast (m.transport() == LONG_POLLING)
    m suspend -1

    ""
  }

  post("/status") {
    // TODO: Read User From InputStream
    contentType = "application/json"
    val subject = Option(request.getAttribute("subject").asInstanceOf[Subject])
      .getOrElse(SecurityUtils.getSubject)
    BroadcasterFactory.getDefault.lookup(subject.getPrincipal.toString).broadcast("Broadcast a Testmessage")
    ""
  }

}
