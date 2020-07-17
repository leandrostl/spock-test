import spock.lang.Specification

class HelpMethodsTest extends Specification {

    def "Verificar se email obedece padrão"() {
        expect: 'Meu email fake seja válido!'
        "é um email válido"("leandro@leandro.com.br")
    }

    static def "é um email válido"(email) {
        email.contains('@') && email.endsWith(".com.br")
    }
}