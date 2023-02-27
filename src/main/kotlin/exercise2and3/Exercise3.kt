package exercise2and3

import java.awt.Rectangle

fun Rectangle.getIntersectionArea(r: Rectangle): Int {
	val x5: Int = x.coerceAtLeast(r.x)
	val y5: Int = y.coerceAtLeast(r.y)
	val x6: Int = (x + width).coerceAtMost(r.x + r.width)
	val y6: Int = (y + height).coerceAtMost(r.y + r.height)
	val area = (x6 - x5 + 1) * (y6 - y5 + 1)
	return if (area < 0) {
		0
	} else {
		area
	}

}
