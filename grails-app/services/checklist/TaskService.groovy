package checklist

import com.webapp.cl.AppUtil
import com.webapp.cl.Globalconfig
import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

@Transactional
class TaskService {
    def serviceMethod() {

    }
    /**
     *Save Member with their parameter.But first they must respect the constraints created in the domain.
     * @param params
     * @return
     */

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
   def getById(Serializable id){
        return Task.get(id);
    }
/**
 * update the list.But first they must respect the constraints created in the domain.
 * @param tasklist corresponding
 * @param params corresponding of the Tasklist
 * @return
 */

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
    /*def getbyId(Serializable id){ //To get Member by Id
        return Task.get(id)
    }*/

    /**
     * list of member
     * @param params parameter of the corresponding member
     * @return list of Member
     */
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

    /**
     * delete Tasklist
     * @param tasklist
     * @return
     */

    def delete(Task task){
        task.delete(flush: true)

        return true
    }


}
