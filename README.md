# Reproduce ClassCastException during file upload:

Execute `codegen.sh` and have a look at the wrong cast to class `File` in `app/src/main/java/test/fileupload/PetApiVerticle.java`. This refers to the (fixed?) bug in https://github.com/phiz71/vertx-swagger/issues/93

# Reproduce the vertx NPE during fileUpload

Minimal setup to reproduce a failing file upload in vertx

- Run gradle task run to deploy the verticle
- Execute `./upload.sh`

--> NPE thrown in BodyHandlerImpl (@ `context.vertx().fileSystem()` since `context.vertx()` returns null)

PROBLEM SOLVED: https://stackoverflow.com/questions/48805529/routingcontext-vertx-is-null-in-vertxs-bodyhandler-nullpointerexception-duri
