import spock.lang.Shared
import spock.lang.Specification;

class CamposTest extends Specification {
	def campo = 5
	@Shared campo2 = 3
	
	def "Se alterar o valor do campo, deve ser verificável"() {
		campo = 6
		campo2 = 4
		
		expect:
		campo == 6
		campo2 == 4
	}
	
	def "Sem qualquer alteração, mantem o valor do campo alterado anteriormente"() {
		expect:
		campo == 5
		campo2 == 4
	}
}