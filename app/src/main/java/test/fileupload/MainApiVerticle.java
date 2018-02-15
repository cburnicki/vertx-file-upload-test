package test.fileupload;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;
import io.vertx.ext.web.FileUpload;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

import java.util.List;
import java.util.stream.Collectors;

public class MainApiVerticle extends AbstractVerticle {

    final Router router = Router.router(vertx);

    @Override
    public void start(Future<Void> startFuture) throws Exception {

        router.route().handler(BodyHandler.create());
        router.route().handler(ctx -> {
           JsonArray uploadedFiles = new JsonArray(
                   ctx.fileUploads().stream().map(FileUpload::fileName).collect(Collectors.toList())
           );
           ctx.response().end(uploadedFiles.encodePrettily());
        });

        vertx.createHttpServer()
                .requestHandler(router::accept)
                .listen(8080);
        startFuture.complete();
    }
}
