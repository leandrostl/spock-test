import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class WithTest extends Specification {

    @Shared
            mulheresImportantes = [
                    "Ada Lovelace",
                    "Grace Hopper",
                    "Margaret Hamilton",
                    "Katie Bouman",
                    "Barbara Liskov"
            ]

    static class PessoasImportanteDaTI {
        String nome
        String sexo
        String descricao
    }


    def "Verificar se #pessoa.nome é uma mulher importante das ciências da computação"() {
        expect:
        with(pessoa) {
            nome in mulheresImportantes
            sexo == 'F'
        }

        where:
        pessoa << [
                new PessoasImportanteDaTI(
                        nome: "Ada Lovelace",
                        sexo: 'F',
                        descricao: "Escreveu o primeiro algoritmo\
					para ser processado por uma máquina. "),
                new PessoasImportanteDaTI(
                        nome: "Grace Hopper",
                        sexo: 'F',
                        descricao: "Criou uma linguagem que foi a \
					base para o COBOL."),
                new PessoasImportanteDaTI(
                        nome: "Katie Bouman",
                        sexo: 'F',
                        descricao: "Criou algotimos para processar \
					a primeira imagem de um buraco negro."),
                new PessoasImportanteDaTI(
                        nome: "Barbara Liskov",
                        sexo: 'F',
                        descricao: "Criou o Princípio da Substituição de Liskov, \
					foi a primeira mulher a obter um PhD em Ciência da Computação \
					nos Estados Unidos e inventou o Tipo Abstrato de Dado."),
                new PessoasImportanteDaTI(
                        nome: "Margaret Hamilton",
                        sexo: 'F',
                        descricao: "Desenvolveu o programa de voo usado no projeto Apollo 11."),
                new PessoasImportanteDaTI(
                        nome: "Dennis Ritchie",
                        sexo: 'M',
                        descricao: "Criou a linguagem de programação C."),
        ]
    }
}