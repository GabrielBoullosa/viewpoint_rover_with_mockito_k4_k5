package refactoring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static refactoring.Rover.Order.*;

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
		actions.put(Forward, ViewPoint::forward);
		actions.put(Backward, ViewPoint::backward);
		actions.put(Left, ViewPoint::turnLeft);
		actions.put(Right, ViewPoint::turnRight);
	}

	@FunctionalInterface
	public interface Action {
		ViewPoint execute(ViewPoint viewPoint);
	}

	private void set(ViewPoint vp){
		if(vp == null) return;
		viewPoint = vp;
	}

	public void go(String instructions){
		set(go(Arrays.stream(instructions.split("")).map(Order::of)));
	}

	public void go(Order... orders){
		set(go(stream(orders)));
	}

	private ViewPoint go(Stream<Order> orders) {
		return orders.filter(Objects::nonNull)
				.reduce(viewPoint, this::execute, (v1,v2)->null);
	}

	private ViewPoint execute(ViewPoint viewPoint, Order order) {
		if(viewPoint == null) return null;
		return actions.get(order).execute(viewPoint);
	}



}

