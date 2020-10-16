package checklist

import com.webapp.cl.Globalconfig

class Member {
    String firstName
    String lastName
    String password
    String customerType= Globalconfig.USER_TYPE.REGULAR_MEMBER
    String identityHash
    String email

    Boolean isActivate= true

     Date dateCreated
    Date   lastUpdate

    //static hasMany = [task:Task,tasklist:Tasklist]

    static constraints = {
        firstName blank: false
        lastName blank: false
        email nullable: true
        identityHash nullable: true
    }
    def beforeInsert(){
        this.password=this.password.encodeAsMD5()
    }
    def beforeUpdate(){
        this.password=this.password.encodeAsMD5()
    }
}
