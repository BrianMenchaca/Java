package ejercicio02Revision2;

import static org.junit.Assert.*;

import org.junit.Test;

public class ElPonyTest {

	Jinete jinete = new Jinete();
	
//	@Test
//	void testJinete1() {
//		Assert.assertEquals(2, jinete.jinetes(new int[] {43, 23, 40, 13}));
//	}
//	
//	@Test
//	void testJinete2() {
//		Assert.assertEquals(3, jinete.jinetes(new int[] {33, 8, 16, 47, 30, 30, 46}));
//	}
//	
//	@Test
//	void testJinete3() {
//		Assert.assertEquals(3, jinete.jinetes(new int[] {51, 51, 51}));
//	}
//	
//	@Test
//	void testJinete4(){
//		Assert.assertEquals(4, jinete.jinetes(new int[] {6, 24, 6, 8, 28, 8, 23, 47, 17, 29, 37, 18, 40, 49}));
//	}
	
	@Test
	public void test0() {
		assertEquals(1, Jinete.jinetes(new int[] { 50, 50 }));
	}

	@Test
	public void test1() {
		assertEquals(1, Jinete.jinetes(new int[] { 18, 15 }));
	}

	@Test
	public void test2() {
		assertEquals(3, Jinete.jinetes(new int[] { 33, 8, 16, 47, 30, 30, 46 }));
	}

	@Test
	public void test3() {
		assertEquals(2, Jinete.jinetes(new int[] { 43, 23, 40, 13 }));
	}

	@Test
	public void test4() {
		assertEquals(3, Jinete.jinetes(new int[] { 51, 51, 51 }));
	}

	@Test
	public void test5() {
		assertEquals(4, Jinete.jinetes(new int[] { 6, 24, 6, 8, 28, 8, 23, 47, 17, 29, 37, 18, 40, 49 }));
	}

	@Test
	public void test6() {
		assertEquals(1, Jinete.jinetes(new int[] { 99, 1 }));
	}
	
	@Test
	public void test7() {
		assertEquals(0, Jinete.jinetes(new int[] { 0 }));
	}
	
	@Test
	public void test8() {
		assertEquals(0, Jinete.jinetes(new int[] {}));
	}

}
