package test;

import java.util.Iterator;
import java.util.LinkedList;

public class Q1 {

	public class Ring<E> extends LinkedList<E> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public class RingIterator implements Iterator<E> {

			public Iterator<E> it;

			public RingIterator(Iterator<E> it) {
				this.it = it;
			}

			@Override
			public boolean hasNext() {
				if (it.hasNext())
					return true;
				else
					return false;
			}

			@Override
			public E next() {
				if (!hasNext()) {
					it = Ring.super.iterator();
				}
				return it.next();
			}
		} // end of inner RingIterator class

		@Override
		public Iterator<E> iterator() {
			return new RingIterator(super.iterator());
		}
	}

	public void APItest() {

		Ring<String> r = new Ring<>();
		r.add("a");
		r.add("b");
		r.add("c");
		r.add("d");
		Iterator<String> it = r.iterator();
		for (int i = 0; i < r.size() + 2; i++)
			System.out.print(it.next() + ",");
		System.out.println(); // a,b,c,d,a,b,
	}

}
