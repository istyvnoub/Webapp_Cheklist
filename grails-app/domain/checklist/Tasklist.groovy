package checklist

class Tasklist {

    String name
    String description
    Date dateOfLastWorkThrough = new Date()

    static hasMany = [tasks:Task]
   // static mappedBy = [tasks: 'parentTask']

    static constraints = {
         name blank: false
        description blank: false
        dateOfLastWorkThrough nullable: true

    }
    static mapping = {
        version (false)
    }
}
