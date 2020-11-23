package checklist

import com.webapp.cl.Globalconfig

class Task {
    String taskName
    Date date_of_last_work_through=new Date()
    String description
    Status state

    static belongsTo = [tasklist:Tasklist]
    enum Status{
        not_done_and_to_do,
        not_done_and_not_to_do,
        done_but_not_sucessful,
        done


    }


    //static hasMany = [tasklist:Tasklist]
    static constraints = {
        taskName blank: false
        date_of_last_work_through nullable: true
        description blank: false
        state (blank: false,nullable:true)
        tasklist nullable: true

    }
   static mapping = {
       version(false)

   }
}
