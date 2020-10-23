package checklist

import com.webapp.cl.AppUtil
import com.webapp.cl.Globalconfig
import grails.web.servlet.mvc.GrailsParameterMap
import org.hibernate.engine.spi.ManagedEntity
import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader


class MemberService {

    def save(GrailsParameterMap params){
        Member member= new Member(params)
        def response= AppUtil.saveResponse(false,member)
        if(member.validate()){
            member.save(flush:true)
            if(!member.hasErrors()){
                response.isSuccess=true
            }
        }
        return response
    }

    def update(Member member, GrailsParameterMap params){
        member.properties=params
        def response=AppUtil.saveResponse(false,member)
        if(member.validate()){
            member.save(flush:true)
            if(!member.hasErrors()){
                response.isSuccess=true
            }
        }
        return response
    }
    def getbyId(Serializable id){ //To get Member by Id
        return Member.get(id)
    }
    def list(GrailsParameterMap params){
        params.max= params.max ?: Globalconfig.itemsPerpage()
        List<Member> memberList = Member.createCriteria().list(params){
            if (params?.colName && params?.colValue) {
                like(params.colName, "%" + params.colValue + "%")
            }
            if (!params.sort) {
                order("id", "desc")
            }
        }
        return [list:memberList,count:Member.count()]
    }

    def delete(Member member){
        member.delete(flush: true)

        return true
    }
}
