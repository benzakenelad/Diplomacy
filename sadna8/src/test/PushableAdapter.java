package test;

import test.Moveable.Direction;

public class PushableAdapter implements Pushable {

	private Moveable moveable;

	public PushableAdapter(Moveable moveable) {
		this.moveable = moveable;
	}

	@Override
	public void push(int heading) {
		if (heading >= 45 && heading <= 134)
			moveable.moveMe(Direction.right);
		else if (heading >= 135 && heading <= 224)
			moveable.moveMe(Direction.down);
		else if (heading >= 225 && heading <= 314)
			moveable.moveMe(Direction.left);
		else
			moveable.moveMe(Direction.up);
	}

}
