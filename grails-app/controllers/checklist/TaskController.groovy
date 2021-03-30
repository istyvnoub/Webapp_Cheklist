package checklist

class TaskController {
    TaskService taskService

    /**
    *this method will be collected a list of Task and pasted into the gsp
    * @return list of Task and number of existing Task
    */
    def index(){
        def response=taskService.list(params)
        [listtask:response.list,total: response.count]  //this data will be paste in GSP
    }

    /**
     * retrieve a Task using their id
     * @param id
     * @return if its dont exist redirect to controller Task
     */

    def details(Integer id){
        def response=taskService.getById(id)
        if(!response){
            redirect(controller: "task",action: "index")
        }else {
            [task:response]
        }
    }
    /**
     *
     * @param id of Task to edit
     * @return if the Task exit return the ediited Task
     */
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
    /**
     * Update a task with corresponding ID
     * @return redirect to Task(index) when Tasḱ doesnt exist or update
     */
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
    /**
     * The save the Task
     * @return
     */
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
