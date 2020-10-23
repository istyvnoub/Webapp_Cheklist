package checklist

import com.webapp.cl.Globalconfig

class Task {
    String text
    Date date
    String status= Globalconfig.STATUS.NOT_DONE


    //static hasMany = [tasklist:Tasklist]
    static constraints = {
        text blank: false
        date max: new Date()
        status blank: false

    }

}
