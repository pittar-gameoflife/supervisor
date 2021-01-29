package ca.pitt.demo.gameoflife.supervisor.streaming;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.OnOverflow;

import ca.pitt.demo.gameoflife.supervisor.model.LIfeformFactory;
import ca.pitt.demo.gameoflife.supervisor.model.Lifeform;
import ca.pitt.demo.gameoflife.supervisor.model.World;

@ApplicationScoped
public class BroadcastGrid {
	
	private World nextGeneration = null;
	
	@Inject
	private LIfeformFactory lifeformFactory;
	
	@Inject
	@Channel("life-questions")
	@OnOverflow(value = OnOverflow.Strategy.BUFFER, bufferSize = 4800)
	Emitter<Lifeform> lifeQuestions;

	@Inject
	@Channel("display-grids")
	Emitter<World> displayWorld;
	
	@Incoming("work-grids")
	public void process(World world) {		
		nextGeneration = new World();
		nextGeneration.setGeneration(world.getGeneration() + 1);
		
		if (null != world) {
			for (int i = 0; i < world.getWidth(); i++) {
				for (int j = 0; j < world.getHeight(); j++) {
					lifeQuestions.send(lifeformFactory.newLifeform(world, i, j));
				}
			}
		}
	}

	@Incoming("life-answers")
	public void answer(Lifeform aLifeform) {
		nextGeneration.setLifeform(aLifeform);
		if (nextGeneration.isComplete()) {
			displayWorld.send(nextGeneration);
		}
	}
	

}
