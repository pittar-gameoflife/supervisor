package ca.pitt.demo.gameoflife.supervisor.model;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LIfeformFactory {
	
	private static final int OFFSET_BEFORE= -1;
	private static final int OFFSET_AFTER = 1;

	public Lifeform newLifeform(World world, int x, int y) {
		Lifeform aLifeform = new Lifeform();
		aLifeform.setAlive(1 == world.getState()[x][y]);
		aLifeform.setX(x);
		aLifeform.setY(y);
		int count = 0;
	    for (int i = OFFSET_BEFORE; i <= OFFSET_AFTER; i++) {
	    	// nx = neighbour x position
    		int nx = x + i;
	    	for (int j = OFFSET_BEFORE; j <= OFFSET_AFTER; j++) {
	    		// ny = neighbosur y position
	    		int ny = y + j;
	    		if (!((i == 0) && (j == 0))) {
	    			boolean isInBounds = world.isInBounds(nx, ny);
	    			if (isInBounds) {
	    				if (1 == world.getState()[nx][ny]) {
	    					count++;
	    				}
	    			}
	    		}
	    	}
	    }
	    aLifeform.setNeighbours(count);
	    return aLifeform;
	}
	
}
