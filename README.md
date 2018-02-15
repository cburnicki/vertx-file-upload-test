# Reproduce the vertx NPE during fileUpload

Minimal setup to reproduce a failing file upload in vertx

- Run gradle task run to deploy the verticle
- Execute `./upload.sh`

--> NPE thrown in BodyHandlerImpl (@ `context.vertx().fileSystem()` since `context.vertx()` returns null)

PROBLEM SOLVED: https://stackoverflow.com/questions/48805529/routingcontext-vertx-is-null-in-vertxs-bodyhandler-nullpointerexception-duri
