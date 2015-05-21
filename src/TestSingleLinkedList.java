import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestSingleLinkedList {

	IndexedListI<String> list;

	@Before
	public void set() {
		list = new SingleLinkedList<String>();
		list.add("Bob");
		list.add("Marie");
	}

	@Test
	public void testGetSize() {
		assertEquals(2, list.size());
		list.add("Pipi");
		assertEquals(3, list.size());
	}

	@Test
	public void testIsEmptry() {
		assertFalse(list.isEmpty());
		list.clear();
		assertTrue(list.isEmpty());
	}

	@Test
	public void testAdd() {
		assertFalse(list.contains("Lis"));
		list.add("Lis");
		assertTrue(list.contains("Lis"));
	}

	@Test
	public void testAddAtIndex() {
		assertFalse(list.contains("Sofie"));
		list.add(1, "Sofie");
		assertTrue(list.contains("Sofie"));
		assertEquals("Marie", list.get(2));
	}

	@Test
	public void testRemove() {
		assertTrue(list.contains("Bob"));
		assertEquals("Bob", list.remove(0));
		assertFalse(list.contains("Bob"));
		assertEquals(1, list.size());
	}

	@Test
	public void testReplace() {
		assertTrue(list.contains("Marie"));
		assertEquals("Marie", list.replace(1, "Pipi"));
		assertTrue(list.contains("Pipi"));
	}

	@Test
	public void testToArray() {
		Object[] arr = list.toArray();
		assertEquals(2, arr.length);
	}
}
