package exercicio2


class Exercise2 {

	fun checkRectangleIntersect(rect1: IntArray, rect2: IntArray): Boolean {
		return !(rect1[0] > rect2[2] || rect1[2] < rect2[0] || rect1[3] < rect2[1] || rect1[1] > rect2[3])
	}
}
fun main(args: Array<String>){
	val rect1 = intArrayOf(3, 5, 11, 11)
	val rect2 = intArrayOf(7, 2, 13, 7)
	val rect3 = intArrayOf(11, 11, 15, 13)
	val result1 = Exercise2().checkRectangleIntersect(rect1, rect2)
	val result2 = Exercise2().checkRectangleIntersect(rect1, rect3)
	val result3 = Exercise2().checkRectangleIntersect(rect2, rect3)
	println(result1)
	println(result2)
	println(result3)
}