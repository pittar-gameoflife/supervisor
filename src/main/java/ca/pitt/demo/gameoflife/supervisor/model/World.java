package ca.pitt.demo.gameoflife.supervisor.model;

import com.google.gson.Gson;

public class World {

	private int[][] state;
	
	private int width = 60;
	
	private int height = 40;
	
	private int generation = 0;
	
	private int responseCount = 0;
	
	public World() {
		state = new int[width][height];
		for (int i=0; i<width; i++) {
			for (int j=0; j<height; j++) {
				state[i][j] = 0;
			}
		}
	}
	
	public int[][] getState() {
		return state;
	}
	
	public void setState(int[][] aState) {
		this.state = aState;
	}
	
	public void setCell(int x, int y, int value) {
		state[x][y] = value;
	}
	
	public void setLifeform(Lifeform aLifeform) {
		responseCount++;
		int newState = aLifeform.isAlive() ? 1 : 0;
		state[aLifeform.getX()][aLifeform.getY()] = newState;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

	public boolean isInBounds(int x, int y) {
		return (x >= 0) && (x < width) && (y >= 0) && (y < height);
	}
	
	public boolean isComplete() {
		return (responseCount == (width * height));
	}
	
	public String print() {
		Gson gson = new Gson();
		return gson.toJson(state);
	}
	
	
	@Override
	public String toString() {
		return print();
	}
}
