package ca.pitt.demo.gameoflife.supervisor.model;

import java.io.Serializable;

public class Lifeform implements Serializable {
	
	/** Default serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	private boolean alive = false;
	
	private int x;
	
	private int y;
	
	private int neighbours;
	
	
	public Lifeform() {
		this.alive = false;
		this.x = 0;
		this.y = 0;
		this.neighbours = 0;
	}
	
	public boolean isAlive() {
		return this.alive;
	}
	
	public void setAlive(boolean isAlive) {
		this.alive = isAlive;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(int neighbours) {
		this.neighbours = neighbours;
	}
	
	@Override
	public boolean equals(Object obj) {
	    // self check
	    if (this == obj)
	        return true;
	    // null check
	    if (obj == null)
	        return false;
	    // type check and cast
	    if (getClass() != obj.getClass())
	        return false;
	    Lifeform rhs = (Lifeform) obj;
		return (this.x == rhs.getX()) && (this.y == rhs.getY()) && (this.alive == rhs.isAlive()) && (this.getNeighbours() == rhs.getNeighbours());
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ") with " + neighbours + " neighbours is alive? " + alive;
	}
	
}
