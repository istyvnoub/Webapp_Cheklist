package checklist

import com.webapp.cl.AppUtil
import com.webapp.cl.Globalconfig
import grails.web.servlet.mvc.GrailsParameterMap


class TaskService {

    def save(GrailsParameterMap params){
        Task task= new Task(params)
        def response= AppUtil.saveResponse(false,task)
        if(task.validate()){
            task.save(flush:true)
            if(!task.hasErrors()){
                response.isSuccess=true
            }
        }else{
            task.errors.allErrors.each {
                println(it)
            }
        }
        return response
    }

    def update(Task task, GrailsParameterMap params){
        task.properties=params
        def response=AppUtil.saveResponse(false,task)
        if(task.validate()){
            task.save(flush:true)
            if(!task.hasErrors()){
                response.isSuccess=true
            }
        }
        return response
    }
    def getbyId(Serializable id){ //To get Member by Id
        return Task.get(id)
    }
    def list(GrailsParameterMap params){
        params.max= params.max ?: Globalconfig.itemsPerpage()
        List<Task> listtask = Task.createCriteria().list(params){
            if (params?.colName && params?.colValue) {
                like(params.colName, "%" + params.colValue + "%")
            }
            if (!params.sort) {
                order("id", "desc")
            }
        }
        return [list:listtask,count:Task.count()]
    }

    def delete(Task task){
        task.delete(flush: true)

        return true
    }


}
