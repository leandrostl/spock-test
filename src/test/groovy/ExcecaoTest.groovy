import static java.util.Collections.emptyList;

import spock.lang.Specification;

class ExcecaoTest extends Specification {

	def "Lançar exceção quando tentar tirar um elemento de uma lista vazia"() {
		given:
		def lista = emptyList()
		
		when:
		lista.pop()
		
		then:
		NoSuchElementException e = thrown()
		e.cause == null
	}
	
	def "Não lançar exceção quando tentar incluir uma chave nula num mapa"() {
		given:
		def mapa = new HashMap()
		
		when:
		mapa.put(null, 1)
		
		then:
		notThrown(NullPointerException)
	}
}