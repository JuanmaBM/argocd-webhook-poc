package org.jmb;

import io.quarkus.logging.Log;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/")
public class SubscriptorResource {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void receiveEvent(String event) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode jsonNode = objectMapper.readTree(event);
            Map<String, Object> app = objectMapper.convertValue(jsonNode.get("app"), Map.class);
            Map<String, Object> metadata = objectMapper.convertValue(jsonNode.get("metadata"), Map.class);
            Map<String, Object> status = objectMapper.convertValue(jsonNode.get("status"), Map.class);

            Log.info("app: ");
            Log.info(app);
            Log.info("metadata: ");
            Log.info(metadata);
            Log.info("status: ");
            Log.info(status);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
