package checklist

class Member {

    Integer Id
    String FirstName
    String lastName
    String email
    String password
    String memtyp


    static hasMany = [task:Task,tasklist:Tasklist]

    static constraints = {
        email (email:true,nullable: false,unique: true ,blank: false)
        password(blank: false)
        lastName(nullable: true)

    }
}
