package test2;

import java.util.Observable;
import java.util.Observer;

public class Property<V> extends Observable implements Observer {

	private V value;

	public void bind(Property<V> property) {
		this.addObserver(property);
	}

	public void setValue(V value) {
		this.value = value;
		this.setChanged();
		this.notifyObservers(value);
	}

	public V getValue() {
		return this.value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable arg0, Object arg1) {
		this.setValue((V) arg1);

	}
}
