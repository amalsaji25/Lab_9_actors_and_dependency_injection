package controllers;

import actors.HelloActorProtocol;
import akka.actor.*;
import play.mvc.*;
import scala.compat.java8.FutureConverters;
import javax.inject.*;
import java.util.concurrent.CompletionStage;

import static akka.pattern.Patterns.ask;

@Singleton
public class Application extends Controller {

    final ActorRef helloActor;

    @Inject
    public Application(@Named("hello-actor") ActorRef helloActor) {
        this.helloActor = helloActor;
    }

    public CompletionStage<Result> sayHello(String name) {
        return FutureConverters.toJava(ask(helloActor, new HelloActorProtocol.SayHello(name), 1000))
                .thenApply(response -> ok((String) response));
    }
}
