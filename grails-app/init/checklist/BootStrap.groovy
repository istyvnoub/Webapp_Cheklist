package checklist

import com.webapp.cl.Globalconfig

class BootStrap {

    def init = { servletContext ->


        def task1=new Task(taskName: "Just do it",date_of_last_work_through: new Date(),description: "follow ur dream" ,state: Task.Status.not_done_and_to_do).save(failonError:true);

        Tasklist.withNewTransaction { status->
            Tasklist tasklist= new Tasklist(name:"test",description: "testlist",tasks: task1).save(failonErrr:true);

        }


    }
    def destroy = {
    }
}
