package refactoring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class Rover {

	private ViewPoint viewPoint;

	public Rover(ViewPoint viewPoint) {
		this.viewPoint = viewPoint;
	}

	public ViewPoint viewPoint() {
		return viewPoint;
	}

	public enum Order {
		Forward, Backward, Left, Right;

		public static Order of(String label) {
			return of(label.charAt(0));
		}

		public static Order of(char label) {
			if (label == 'F') return Forward;
			if (label == 'B') return Backward;
			if (label == 'L') return Left;
			if (label == 'R') return Right;
			return null;
		}
	}

	Map<Order, Action> actions = new HashMap<>();
	{
		actions.put(Order.Forward, () -> viewPoint.forward());
		actions.put(Order.Backward, () -> viewPoint.backward());
		actions.put(Order.Left, () -> viewPoint.turnLeft());
		actions.put(Order.Right, () -> viewPoint.turnRight());
	}

	@FunctionalInterface
	public interface Action {
		void execute();
	}

	public void go(String instructions){
		Stream<Order> orders = Arrays.stream(instructions.split("")).map(Order::of).filter(Objects::nonNull);
		orders.forEach(order -> actions.get(order).execute());
	}

	public void go(Order... orders){
		for (Order order: orders) execute(order);
	}

	private void execute(Order order) {
		actions.get(order).execute();
	}





}

