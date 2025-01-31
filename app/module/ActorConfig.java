package module;

import actors.HelloActor;
import com.google.inject.AbstractModule;
import play.libs.akka.AkkaGuiceSupport;

public class ActorConfig extends AbstractModule implements AkkaGuiceSupport {
    @Override
    protected void configure() {
        bindActor(HelloActor.class, "hello-actor");
    }
}


