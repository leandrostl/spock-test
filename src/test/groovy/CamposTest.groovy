import spock.lang.Shared
import spock.lang.Specification;

class CamposTest extends Specification {
	def campo = 5
	@Shared campo2 = 3
	
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