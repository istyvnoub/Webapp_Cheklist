package checklist

class TaskController {
    TaskService taskService

    def index(){
        def response=taskService.list(params)
        [listtask:response.list,total: response.count]  //this data will be paste in GSP
    }

    def details(Integer id){
        def response=taskService.getbyId(id)
        if(!response){
            redirect(controller: "task",action: "index")
        }else {
            [task:response]
        }
    }

    def create(){
        [task: flash.redirectParams]
    }
    def save() {
        def response = taskService.save(params)
        if (!response.isSuccess) {
            flash.redirectParams = response.model
            redirect(controller: "task", action: "create")
        } else {
            redirect(controller: "task", action: "index")
        }

    }
}
