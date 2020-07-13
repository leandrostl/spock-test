import spock.lang.Shared
import spock.lang.Specification;

class MaxTest extends Specification {
	def "Verificar o maior valor entre dois números"() {
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