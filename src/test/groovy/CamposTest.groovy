import spock.lang.Shared
import spock.lang.Specification;

class CamposTest extends Specification {
	def normal = 5
	@Shared shared = 3
	
	def "Se alterar o valor do campo, deve ser verificável"() {
		given: 'Valor dos campos foram alterados'
		normal = 6
		shared = 4
		
		expect: 'O novo valor seja observado no resultado'
		normal == 6
		shared == 4
	}
	
	def "Sem qualquer alteração, mantem o valor do campo alterado anteriormente"() {
		given: 'Não há novas alterações nos campos'
		expect: 'Campo normal deve ter o valor antigo'
		normal == 5
		and: 'Campo shared deve ter o valor definido no método anterior'
		shared == 4
	}
}