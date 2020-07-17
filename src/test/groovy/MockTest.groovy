import groovy.sql.Sql
import groovy.transform.EqualsAndHashCode
import spock.lang.Specification

class MockTest extends Specification {

    @EqualsAndHashCode
    class Carta {
        Integer id
        String nome
    }

    class MagicRepository {
        Sql sql

        MagicRepository() {
            sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")
            sql.execute '''
              CREATE TABLE carta (
                id INTEGER PRIMARY KEY AUTO_INCREMENT, 
                nome VARCHAR(64)
              )'''
        }

        Carta addCarta(nome) {
            sql.execute "INSERT INTO carta(nome) VALUES ${nome}"
            findByNome(nome)
        }

        Carta findById(Integer id) {
            mapCarta sql.firstRow("select * from carta where id = ${id}")
        }

        Carta findByNome(String nome) {
            mapCarta sql.firstRow("select * from carta where nome = ${nome}")
        }

        private Carta mapCarta(retorno) {
            new Carta().tap {
                id = retorno.ID
                nome = retorno.NOME
            }
        }
    }

    class MagicService {
        MagicRepository repository

        Carta findById(Integer id) { repository.findById(id) }
    }

    def 'Stub permite apenas definir comportamento de métodos'() {
        given: 'Repository é apenas um stub'
        def carta = new Carta(nome: 'Mana Crypt')
        def stubRepository = Stub(MagicRepository) {
            findById(_ as Integer) >> { Integer id -> carta.tap { id: id } }
        }
        def service = new MagicService(repository: stubRepository)

        expect: 'O carta encontrada deve ser a carta do stub'
        service.findById(1) == carta.tap { id: 1 }
    }

    def "Spy permite saber quantas interações ocorreram e o retorno do método espiado"() {
        given:
        def esperada1 = new Carta(id: 1, nome: 'Black Lotus')
        def esperada2 = new Carta(id: 2, nome: 'Mana Crypt')

        def spyRepository = Spy(MagicRepository) {
            findById(2) >> esperada2
        }
        spyRepository.addCarta("Black Lotus")
        spyRepository.addCarta("Mox Pearl")

        def service = new MagicService(repository: spyRepository)

        when:
        def carta1 = service.findById(1)
        then:
        carta1 == esperada1
        spyRepository.findById(1) == esperada1
        1 * spyRepository.findById(1)

        when:
        def carta2 = service.findById(2)
        then:
        carta2 == esperada2
        spyRepository.findById(2) == esperada2
    }

    def "Mock pode tanto ver a quantidade de interações \
        quanto redefinir comportamento do método"() {
        given: 'Repositório será chamado três vezes'

        def esperada1 = new Carta(id: 1, nome: 'Mox Pearl')
        def esperada2 = new Carta(id: 2, nome: 'Mox Emerald')
        def mockRepository = Mock(MagicRepository) {
            2 * findById(1) >>> [esperada1, esperada2]
            1 * findById(2) >> esperada2
        }

        def service = new MagicService(repository: mockRepository)
        when:
        def carta1 = service.findById(1)
        def carta2 = service.findById(1)
        def carta3 = service.findById(2)
        then:
        carta1 == esperada1
        carta2 == esperada2
        carta3 == esperada2
    }
}

