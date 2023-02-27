/**
 * PARAMS
 * cnpj string
 *  * BB exceção
 * 14 dígitos formatados
 * ".",  "/", "-" nos lugares certos
 * **/

class Exercise1 {
	
	// Helper function to format our string:
	private fun cnpjSplitter(cnpj: String): String {
		return cnpj.split(".", "/", " ", "-").joinToString("")
	}

	// Branco do Brasil is the only exception to the length rule, so we check for it before
	private fun checkBB(cnpj: String): Boolean {
		val bbCNPJ = "00000000" 
		return cnpj == bbCNPJ
	}

	// Then, we can check for length equality
	private fun checkNumberLength(cnpj: String): Boolean {
		val length = cnpj.length
		return length == 14
	}

	// Checks for the right formatting (.'s and /'s and -'s)
	private fun checkValidFormatting(cnpj: String): Boolean {
		if (cnpj == "00.000.000") return true
		return (cnpj[2] == '.' && cnpj[6] == '.' && cnpj[10] == '/' && cnpj[15] == '-')
	}

	// Only numbers are valid, we check them
	private fun checkIsNumber(cnpj: String): Boolean {
		val regex = "^\\d+\$".toRegex()
		return regex.matches(cnpj)
	}

	// Algo logic from https://www.geradorcnpj.com/algoritmo_do_cnpj.htm
	private fun String.getDigits(): String {
		val numbers = map { it.toString().toInt() }
		val firstDigit = numbers.getFirstDigit()
		val secondDigit = numbers.getSecondDigit(firstDigit)
		return "$firstDigit$secondDigit"
	}

	private fun List<Int>.getFirstDigit(): Int {
		val firstTwelveDigits = this
		val weights = (5 downTo 2) + (9 downTo 2)
		val sum = firstTwelveDigits.withIndex().sumOf { (index, element) -> weights[index] * element }
		val remainder = sum % 11
		return if (remainder < 2) 0 else 11 - remainder
	}

	private fun List<Int>.getSecondDigit(firstDigit: Int): Int {
		val firstThirteenDigits = this + firstDigit
		val weights = (6 downTo 2) + (9 downTo 2)
		val sum = firstThirteenDigits.withIndex().sumOf { (index, element) -> weights[index] * element }
		val remainder = sum % 11
		return if (remainder < 2) 0 else 11 - remainder
	}

	private fun hasValidDigits(cnpj: String): Boolean {
		// Invalid conditions
		return if (cnpj.length < 13 || (cnpj == "00000000000000")) false
		else {
			val firstTwelve = cnpj.substring(0..11)
			val inputDigits = cnpj.substring(12..13)
			firstTwelve.getDigits() == inputDigits
		}
	}

	fun isValidUnformatted(cnpj: String): Boolean {
		val splitCnpj = cnpjSplitter(cnpj)

		// Condition check
		val cond1 = checkBB(splitCnpj)
		val cond2 = checkNumberLength(splitCnpj)
		val cond3 = checkIsNumber(splitCnpj)
		val cond4 = hasValidDigits(splitCnpj)

		// BB is strictly equal
		if (cond1) return true
		// Proceed only if the right length
		else if (cond2) {
			if (cond3 && cond4) return true
		}
		return false
	}

	// Checks format before doing the normal routine calculations
	fun isValidFormatted(cnpj: String): Boolean {
		val format = checkValidFormatting(cnpj)
		return if (!format) false
		else isValidUnformatted(cnpj)
	}
} 




