import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class GenTest {
	static Gen gen1;
	static Gen gen2;
	
	@Disabled
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@BeforeAll
	static void generar() {
		gen1 = new Gen("TTT", (byte) 1);
		gen2 = new Gen("AAA", (byte) 2);
	}
	
	@Test
	void testCompara() {
		Queue cola2 = new LinkedList<>();
		cola2.add('A');
		cola2.add('B');
		
		String actual = gen1.compara(cola2);
		String esperado ="";
		assertEquals(esperado,actual);
		
	}

}
