package checklist

class Tasklist {

    Integer id
    String name
    Member member

    static belongsTo = Task


    static constraints = {
        name(blank:false,nullable: false)
        member(nullable: true)
    }
}
