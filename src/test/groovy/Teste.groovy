import spock.lang.Shared
import spock.lang.Specification;

class Teste extends Specification {
	def campo = 5
	@Shared campo2 = 3

	def "o maior valor entre dois números"() {
		expect:
		Math.max(a, b) == c

		where:
		a | b | c
		1 | 2 | 2
		5 | 2 | 5
		0 | 1 | 1
		-1 | 1 | 1
	}
	
	def "alterando o valor do campo"() {
		campo = 6
		campo2 = 4
		
		expect:
		campo2 == 4
		campo == 6
	}
	
	def "mantem o valor do campo inalterado"() {
		expect:
		campo2 == 4
		campo == 5
	}
}