package br.com.escola.model.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AlunoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testAssertTrue() {
		assert(true);
	}

	@Test
	public void testAssertFalse() {
		assert(false);
	}

	@Test
	public void testFailOnPurpose() {
		fail("Intentional failure."); // A failure different from "assert(false)"
	}

}
