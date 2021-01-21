package checklist

class TaskController {
    TaskService taskService

    def index(){
        def response=taskService.list(params)
        [listtask:response.list,total: response.count]  //this data will be paste in GSP
    }

    def details(Integer id){
        def response=taskService.getById(id)
        if(!response){
            redirect(controller: "task",action: "index")
        }else {
            [task:response]
        }
    }
    def edit(Integer id){
        if (flash.redirectParams) {
            [task: flash.redirectParams]
        } else {

            def response = taskService.getById(id)
            if (!response) {
               // flash.message = AppUtil.infoMessage(g.message(code: "invalid.entity"), false)
                redirect(controller: "Task", action: "index")
            } else {
                [task: response]
            }
        }
    }
    def update() {
        def response = taskService.getById(params.id);
        if (!response){
            //flash.message = AppUtil.infoMessage(g.message(code: "invalid.entity"), false)
            redirect(controller: "task", action: "index")
        }else{
            response = taskService.update(response, params)
            if (!response.isSuccess){
                //flash.redirectParams = response.model
                //flash.message = AppUtil.infoMessage(g.message(code: "unable.to.update"), false)
                redirect(controller: "task", action: "edit")
            }else{
              //  flash.message = AppUtil.infoMessage(g.message(code: "updated"))
                redirect(controller: "task", action: "index")
            }
        }
    }

    def create(){
        [task: flash.redirectParams]
    }
    def save() {
        println "Taskcontroller save "+params;
        def response = taskService.save(params)
        if (!response.isSuccess) {
            flash.redirectParams = response.model
            redirect(controller: "task", action: "create")
        } else {
            redirect(controller: "task", action: "index")
        }

    }
    def delete(Integer id){
        def response=taskService.getById(id)

        if(!response){
            redirect(controller:"task",action:"index")


        }else{
            response = taskService.delete(response)
        }
        redirect(controller: "task",action: "index")
    }
}
