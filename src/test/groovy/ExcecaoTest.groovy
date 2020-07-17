import spock.lang.Specification

import static java.util.Collections.emptyList

class ExcecaoTest extends Specification {

    def "Lançar exceção quando tentar tirar um elemento de uma lista vazia"() {
        given: 'Uma lista vazia'
        def lista = emptyList()

        when: 'Tentar remover um elemento desta lista'
        lista.pop()

        then: 'Deve lançar exceção do tipo NoSuchElementException'
        def e = thrown(NoSuchElementException)
        and: 'Causa deve ser nula'
        e.cause == null
    }

    def "Não lançar exceção quando tentar incluir uma chave nula num mapa"() {
        given: 'Um hashmap'
        def mapa = new HashMap()

        when: 'Tentar inserir um par chave/valor com chave nula'
        mapa.put(null, 1)

        then: 'Não deve ocorrer qualquer exceção'
        noExceptionThrown()
    }

    def "Groovy == equivale a equals em Java e é nullsafe"() {
        when: 'Comparar null com qualquer objeto'
        def isLeiaNula = "General Leia Organa" == null
        def isHanNulo = null == "Han Solo"
        then: 'Deve retornar false e não gerar exceção de null pointer'
        !isLeiaNula && !isHanNulo
        notThrown(NullPointerException)
    }
}