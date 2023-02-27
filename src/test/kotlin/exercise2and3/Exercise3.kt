package exercise2and3

import org.junit.jupiter.api.Test
import java.awt.Point
import java.awt.Rectangle
import kotlin.test.assertEquals

class Exercise3 {

	private val a1 = Point(3, 5)
	private val a2 = Point(11, 11)
	private val aRect = Rectangle(a1).apply { this.add(a2) }

	private val b1 = Point(7, 2)
	private val b2 = Point(13, 7)
	private val bRect = Rectangle(b1).apply { this.add(b2) }

	private val c1 = Point(11, 11)
	private val c2 = Point(15, 13)
	private val cRect = Rectangle(c1).apply { this.add(c2) }

	@Test
	fun `should return 1 for IntersectionArea(A, C)`() {
		assertEquals(1, aRect.getIntersectionArea(cRect))
	}

	@Test
	fun `should return 15 for IntersectionArea(A, B)`() {
		assertEquals(15, aRect.getIntersectionArea(bRect))
	}

	@Test
	fun `should return 0 for IntersectionArea (B, C)`() {
		assertEquals(0, bRect.getIntersectionArea(cRect))
	}
}


