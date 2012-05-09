package com.myself.websockets

import org.scalatra.ScalatraServlet
import org.scalatra.scalate.ScalateSupport
import org.apache.shiro.SecurityUtils


class WebServlet extends ScalatraServlet with ScalateSupport {

  get("/logout") {
    SecurityUtils.getSubject().logout()
    redirect("/")
  }

  notFound {
    // Try to render a ScalateTemplate if no route matched
    findTemplate(requestPath) map {
      path =>
        contentType = "text/html"
        layoutTemplate(path)
    } orElse serveStaticResource() getOrElse resourceNotFound()
  }
}
