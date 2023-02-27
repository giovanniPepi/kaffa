package exercise2and3

import org.junit.jupiter.api.Test
import java.awt.Point
import java.awt.Rectangle
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Exercise2 {

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
		fun `should return true for intersects`(){
			assertTrue(aRect.overlaps(bRect))
			assertTrue(aRect.overlaps(cRect))
		}

		@Test
		fun `should return false for intersects`(){
			assertFalse(bRect.overlaps(cRect))
		}

	}


