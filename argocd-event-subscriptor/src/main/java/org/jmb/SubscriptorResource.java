package org.jmb;

import io.quarkus.logging.Log;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class SubscriptorResource {
    
    @POST
    //@Consumes(MediaType.APPLICATION_JSON)
    public void receiveEvent(String event) {
        Log.info(event);
    }
}
