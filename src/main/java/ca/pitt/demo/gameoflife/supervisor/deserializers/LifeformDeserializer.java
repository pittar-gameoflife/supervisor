package ca.pitt.demo.gameoflife.supervisor.deserializers;

import ca.pitt.demo.gameoflife.supervisor.model.Lifeform;
import io.quarkus.kafka.client.serialization.JsonbDeserializer;

public class LifeformDeserializer extends JsonbDeserializer<Lifeform> {

	public LifeformDeserializer() {
		super(Lifeform.class);
	}
	
}
