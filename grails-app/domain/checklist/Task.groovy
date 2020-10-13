package checklist

class Task {

    Integer id
    String name
    Member member
    String image

    static hasMany = [tasklist:Tasklist]
    static constraints = {
        image(nullable: true,blank:true)

    }
}
