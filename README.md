# remove-from-list

Sample project to show weird behaviour when trying to remove a Domain from a hasMany List

```groovy
   def "removeFromChild should remove Parent from Child as well"() {
        given:
        Parent parent = new Parent()

        and:
        Child child = new Child()
        parent.addToChildren(child)

        when:
        parent.save()

        then:
        child.parent == parent

        when:
        parent.removeFromChildren(child)
        parent.save(flush: true, failOnError: true)
        child.refresh()

        then:
        child.parent == null // <-- fails, parent is still set to the old parent
    }
```
