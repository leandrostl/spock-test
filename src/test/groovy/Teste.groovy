import spock.lang.Specification

class Teste extends Specification {
	
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
	
}