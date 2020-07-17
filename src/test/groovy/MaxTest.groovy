import spock.lang.Specification
import spock.lang.Unroll

class MaxTest extends Specification {
    @Unroll
    def "Verificar se o máximo entre #a e #b é #c"() {
        expect:
        Math.max(a, b) == c

        where:
        a  | b | c
        1  | 2 | 2
        5  | 2 | 5
        0  | 1 | 1
        -1 | 1 | 1
    }
}