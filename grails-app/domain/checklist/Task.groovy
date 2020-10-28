package checklist

import com.webapp.cl.Globalconfig

class Task {
    String text
    Date date_of_last_work_through=new Date()
    String state= Globalconfig.STATUS.NOT_DONE


    //static hasMany = [tasklist:Tasklist]
    static constraints = {
        text blank: false
        date_of_last_work_through nullable: true

        state blank: false

    }

}
