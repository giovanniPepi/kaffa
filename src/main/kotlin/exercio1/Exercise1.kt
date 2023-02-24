/**
 * PARAMS
 * cnpj string
 *  * BB exceção
 * 14 dígitos formatados
 * ".",  "/", "-" nos lugares certos
 * **/
class Exercise1 () {
		// Helper function to format our string:
		private fun cnpjSplitter(cnpj: String): String {
			val split = cnpj.split(".", "/", " ", "-").joinToString("");
			// println("split: " + split);
			return split;
		}

		// Branco do Brasil is the only exception to the length rule, so we check for it before
		private fun checkBB(cnpj: String): Boolean {
			val bbCNPJ = "00000000";
			//println("isBB? " + (cnpj == bbCNPJ));
			return cnpj == bbCNPJ;
		}

		// Then, we can check for length equality
		private fun checkNumberLength(cnpj: String): Boolean {
			val length = cnpj.length;
			// println("isLength? " + (cnpj.length == 14));
			return length == 14;
		}

		// Checks for the right formatting (.'s and /'s and -'s)
		private fun checkValidFormatting(cnpj: String): Boolean {
			if (cnpj == "00.000.000") return true;
			// println("is formatting valid? " + (cnpj[2] == '.' && cnpj[6] == '.' && cnpj[10] == '/' && cnpj[15] == '-'));
			return (cnpj[2] == '.' && cnpj[6] == '.' && cnpj[10] == '/' && cnpj[15] == '-');
		}

		// Only numbers are valid, we check them
		private fun checkIsNumber(cnpj: String): Boolean {
			val regex = "^\\d+\$".toRegex();
			// println("is number?" + regex.matches(cnpj));
			return regex.matches(cnpj);
		}

		private fun isValidUnformatted(cnpj: String): Boolean {
			val splitCnpj = cnpjSplitter(cnpj);

			// Condition check
			val cond1 = checkBB(splitCnpj);
			val cond2 = checkNumberLength(splitCnpj);
			val cond3 = checkIsNumber(splitCnpj);

			// println("Checks: " + cond1 + cond2 + cond3);

			// BB is strictly equal
			if (cond1) return true;

			// Only accepts 14 digits length and numbers
			else if (cond2 && cond3) return true;

			// else return false;
			return false;
		}

		private fun isValidFormatted(cnpj: String): Boolean {
			val format = checkValidFormatting(cnpj);
			return if (!format) false;
			else isValidUnformatted(cnpj);
		}

		fun run() {
			// Raw testing area
			println("formatted: ")
			println("00000000 " + isValidFormatted("00000000"));
			println("00.000.000 " + isValidFormatted("00.000.000"));
			println("5454000 " + isValidFormatted("5454000"));
			println("joao3873487 " + isValidFormatted("joao3873487"));
			println("2925.2872 " + isValidFormatted(("2925.2872")));
			println("0000000000000 " + isValidFormatted(("0000000000000")));
			println("00.000.000/0000-00 " + isValidFormatted("00.000.000/0000-00"));
			println("08.730.563/0001-47" + isValidFormatted("08.730.563/0001-47"));
			println("08730563000147" + isValidFormatted("08730563000147"));


			println("unformatted: ");
			println("00000000 " + isValidUnformatted("00000000"));
			println("00.000.000 " + isValidUnformatted("00.000.000"));
			println("5454000 " + isValidUnformatted("5454000"));
			println("joao3873487 " + isValidUnformatted("joao3873487"));
			println("2925.2872 " + isValidUnformatted(("2925.2872")));
			println("0000000000000 " + isValidUnformatted(("0000000000000")));
			println("00.000.000/0000-00 " + isValidUnformatted("00.000.000/0000-00"));
			println("08.730.563/0001-47" + isValidUnformatted("08.730.563/0001-47"));
			println("08730563000147" + isValidUnformatted("08730563000147"));

		}


	};



