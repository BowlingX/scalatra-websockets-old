# Scalatra Websockets with Atmosphere and Apache Shiro #

## Requirements

* sbt 0.11.2

### Mac OS X Install (with brew):

        brew install sbt

## Start Using Example

0. Clone this repository

        git clone git@github.com:BowlingX/scalatra-websockets.git

1. Launch [SBT](http://code.google.com/p/simple-build-tool).

        ./sbt

2. Run Jetty

        container:start

3. Go to http://localhost:8080/ with minimum 2 browsers to see Message broadcasting exchange.


4. Login with Username: "david" and Password: "123"

### Problems with New Atomosphere Version (see https://github.com/Atmosphere/atmosphere/issues/436)

1. Just see that log shows Exception if you use "streaming" as protocol. (default)

2. "long-polling" does nothing

3. "websocket" works on Chrome/Firefox


### Problems with Apache-Shiro:

Change socket.js in /webapp/static/js/socket.js, line 7 to use protocol "websocket"

1. See that Safari throws Exception with websockets if you send a message


