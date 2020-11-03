package checklist

class TasklistController {
    TasklistService tasklistService

    def index(){
        def response=tasklistService.list(params)
        [grouptask:response.list,total: response.count]  //this data will be paste in GSP
    }

    def details(Integer id){
        def response=tasklistService.getbyId(id)
        if(!response){
            redirect(controller: "task",action: "index")
        }else {
            [grouptask: response]
        }
    }

    def create(){
        [grouptask: flash.redirectParams]
    }
    def save() {
        def response = tasklistService.save(params)
        if (!response.isSuccess) {
            flash.redirectParams = response.model
            redirect(controller: "tasklist", action: "create")
        } else {
            redirect(controller: "tasklist", action: "index")
        }

    }
}
