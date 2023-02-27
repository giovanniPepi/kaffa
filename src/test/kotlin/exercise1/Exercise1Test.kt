package exercise1

import Exercise1
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Exercise1Test {

	private val exerciseOne = Exercise1()

	@Test
	fun `should return true for valid masked cnpj`() {
		assertTrue(exerciseOne.isValidFormatted("08.730.563/0001-47"))
	}

	@Test
	fun `should return true for valid unmasked cnpj` () {
		assertTrue(exerciseOne.isValidUnformatted("45010290000192"))
	}

	@Test
	fun `should return false for valid masked cnpj`(){
		assertFalse(exerciseOne.isValidFormatted("46.578.621/1186-24"))
	}

	@Test
	fun `should return false for valid unmasked cnpj`(){
		assertFalse(exerciseOne.isValidUnformatted("joao3873487"))
	}

	@Test

	fun `should return true for BB masked`(){
		assertTrue(exerciseOne.isValidFormatted("00.000.000"))
	}

	@Test
	fun `should return true for BB unmasked`(){
		assertTrue(exerciseOne.isValidUnformatted("00000000 "))
	}

	@Test
	fun `should return false for invalid lengths` () {
		assertFalse(exerciseOne.isValidUnformatted("0000000000000000000"))
		assertFalse(exerciseOne.isValidUnformatted("11111111"))
	}
}