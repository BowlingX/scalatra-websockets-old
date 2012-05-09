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


5. See that Safari throws Exception with websockets if you send a message


6. You may change socket.js, line 7 to and safari works:

         request.transport = "long-polling"


7. TODO: Send Messages to different Users

