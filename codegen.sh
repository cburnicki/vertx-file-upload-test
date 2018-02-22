java -cp vertx-swagger-codegen-1.6.jar:swagger-codegen-cli-2.3.1.jar \
  io.swagger.codegen.SwaggerCodegen generate  \
  -l java-vertx \
  -o ./app \
  -i ./petstore.json  \
  --group-id test.fileupload  \
  --artifact-id app \
  --invoker-package test.fileupload \
  --api-package test.fileupload \
  --model-package test.fileupload.model
