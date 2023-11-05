package lab7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

public class MyPredicates {
	// Remove every object, obj, from coll for which p.test(obj)
	// is true. (This does the same thing as coll.removeIf(p).)
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iter = coll.iterator();
		while (iter.hasNext()) {
			T element = iter.next();
			if (p.test(element)) {
				iter.remove();
			}
		}
	}

	// Remove every object, obj, from coll for which
	// pr.test(obj) is false. (That is, retain the
	// objects for which the predicate is true.)
	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iter = coll.iterator();
		while (iter.hasNext()) {
			T element = iter.next();
			if (!p.test(element)) {
				iter.remove();
			}
		}
	}

	// Return a Set that contains all unique objects, obj,
	// from the collection, coll, such that p.test(obj)
	// is true.
	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		Set<T> re = new HashSet<>();

		for (T t : coll) {
			if (p.test(t)) {
				re.add(t);
			}
		}

		return re;
	}

	// Return the index of the first item in list
	// for which the predicate is true, if any.
	// If there is no such item, return -1.
	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		int index = 0;

		for (T t : coll) {
			if (p.test(t)) {
				return index;
			}

			index++;
		}
		return -1;
	}

	public static void main(String[] args) {
		MyPredicates myPredicate = new MyPredicates();
		Even predicate = new Even();

		Integer[] arrInteger = { 1, 3, 8, 7, 0, 2 };
		Collection<Integer> coll = new ArrayList<>(Arrays.asList(arrInteger));
		System.out.println(coll);
		System.out.println("Method remove:");
		myPredicate.remove(coll, predicate);
		System.out.println(coll);

		System.out.println("=======================");

		System.out.println("Method retain:");
		Integer[] arrInteger_retain = { 1, 3, 8, 7, 0, 2 };
		Collection<Integer> coll_retain = new ArrayList<>(Arrays.asList(arrInteger_retain));
		System.out.println(coll_retain);
		myPredicate.retain(coll_retain, predicate);
		System.out.println(coll_retain);

		System.out.println("Method collect:");
		Integer[] arrInteger_collect = { 0, 1, 3, 3, 8, 8, 5, 7, 0, 2 };
		Collection<Integer> coll_collect = new ArrayList<>(Arrays.asList(arrInteger_collect));
		System.out.println(coll_collect);
		System.out.println(myPredicate.collect(coll_collect, predicate));

		System.out.println("Method find:");
		Integer[] arrInteger_find = { 1, 3, 3, 9, 8, 7, 0, 2 };
		Collection<Integer> coll_find = new ArrayList<>(Arrays.asList(arrInteger_find));
		System.out.println(coll_find);
		System.out.println(myPredicate.find(coll_find, predicate));
	}
}
