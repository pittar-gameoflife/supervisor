package ca.pitt.demo.gameoflife.supervisor.deserializers;

import ca.pitt.demo.gameoflife.supervisor.model.World;
import io.quarkus.kafka.client.serialization.JsonbDeserializer;

public class WorldDeserializer extends JsonbDeserializer<World> {

	public WorldDeserializer() {
		super(World.class);
	}
	
}
