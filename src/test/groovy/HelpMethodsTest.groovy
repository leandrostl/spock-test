import static java.util.Collections.emptyList;

import spock.lang.Specification;

class HelpMethodsTest extends Specification {

	def "Verificar se email obedece padrão"() {
		def email = "leandro@leandro.com.br"
		
		expect:
		"é um email válido"(email)
	}
	
	def "é um email válido"(email) {
		email.contains('@') &&
		email.endsWith(".com.br")
	}
}