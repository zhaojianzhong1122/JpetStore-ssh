package com.clps.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.clps.util.Util;

class UtilTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetRollnumber() {
		System.out.println(Util.getRollnumber());
	}

}
