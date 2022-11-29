package Recursion;

import java.util.HashSet;
import java.util.Set;
import javafx.util.Pair;

public class RobotRoomCleaner {

	public static void main(String[] args) {
		//For compiling download javafx jar

	}

	Robot robot;
	Set<Pair<Integer, Integer>> visited = new HashSet();
	int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	private void moveBack() {
		robot.turnRight();
		robot.turnRight();
		robot.move();
		robot.turnRight();
		robot.turnRight();
	}

	private void backTracing(int col, int row, int dir) {

		visited.add(new Pair(col, row));
		robot.clean();

		for (int i = 0; i < 4; i++) {
			int newDir = (dir + i) % 4;
			int newCol = col + directions[newDir][0];
			int newRow = row + directions[newDir][1];

			if (!visited.contains(new Pair(newCol, newRow)) && robot.move()) {
				backTracing(newCol, newRow, newDir);
				moveBack();
			}
			robot.turnRight();
		}
	}

	public void cleanRoom(Robot robot) {
		this.robot = robot;
		backTracing(0, 0, 0);
	}

	
	
	
	/*************************************************************************************/
	class Robot implements IRobot {

		@Override
		public boolean move() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void turnLeft() {
			// TODO Auto-generated method stub

		}

		@Override
		public void turnRight() {
			// TODO Auto-generated method stub

		}

		@Override
		public void clean() {
			// TODO Auto-generated method stub

		}

	}

	// This is the robot's control interface.
	// You should not implement it, or speculate about its implementation
	interface IRobot {
		// Returns true if the cell in front is open and robot moves into the cell.
		// Returns false if the cell in front is blocked and robot stays in the current
		// cell.
		public boolean move();

		// Robot will stay in the same cell after calling turnLeft/turnRight.
		// Each turn will be 90 degrees.
		public void turnLeft();

		public void turnRight();

		// Clean the current cell.
		public void clean();
	}

}
