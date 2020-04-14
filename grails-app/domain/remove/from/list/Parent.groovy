package remove.from.list

class Parent {

    List<Child> children

    static hasMany = [children: Child]
    static constraints = {
    }
}
