package exercise2and3

import java.awt.Rectangle

fun Rectangle.overlaps(r: Rectangle): Boolean {
	val x5: Int = x.coerceAtLeast(r.x)
	val y5: Int = y.coerceAtLeast(r.y)

	val x6: Int = (x + width).coerceAtMost(r.x + r.width)
	val y6: Int = (y + height).coerceAtMost(r.y + r.height)

	if (x5 > x6 || y5 > y6) {
		return false // no intersection
	}

	return true
}
