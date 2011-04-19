package org.xmlcml.euclid.test;

import org.junit.Test;

public class TestStringTestBase {
	@Test
	public void testAssertEqualsTrue() {
		StringTestBase.assertEquals("", "foo bar foo2 bar2", new String[] {
				"foo", "bar", "foo2", "bar2" });
	}

	@Test(expected = AssertionError.class)
	public void testAssertEqualsFalse() {
		StringTestBase.assertEquals("", "foo bar foo2 bar2", new String[] {
				"foo", "bar", "foo2", "bar3" });
	}
	@Test(expected = AssertionError.class)
	public void testAssertEqualsNull() {
		StringTestBase.assertEquals("", "foo bar foo2 bar2", null);
	}
	@Test(expected = AssertionError.class)
	public void testAssertEqualsNull2() {
		StringTestBase.assertEquals("", (String)null, new String[] {
				"foo", "bar", "foo2", "bar3" });
	}
}
