import grails.testing.mixin.integration.Integration
import grails.transaction.Rollback
import remove.from.list.Child
import remove.from.list.Parent
import spock.lang.Specification

@Integration
@Rollback
class ChildIntegrationTest extends Specification {
    def "removeFromChild should remove Parent from Child as well"() {
        given:
        Parent parent = new Parent()

        and:
        Child child1 = new Child()
        parent.addToChildren(child1)

        and:
        Child child2 = new Child()
        parent.addToChildren(child2)

        parent.save()

        when:
        parent.removeFromChildren(child1)
        parent.save(flush: true)
        child1.refresh()

        then:
        child1.parent == null
    }
}
