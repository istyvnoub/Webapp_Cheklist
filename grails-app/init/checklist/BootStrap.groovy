package checklist

import com.webapp.cl.Globalconfig

class BootStrap {

    def init = { servletContext ->

        Tasklist.withNewTransaction { status->
            Tasklist tasklist1= new Tasklist(name:"test",description: "testlist").save(failonErrr:true);
            Tasklist tasklist2=new Tasklist(name:"test2",description: "testlist2").save(failonErr:true);


            def task1=new Task(taskName: "Just do it",date_of_last_work_through: new Date(),description: "follow ur dream" ,state: Task.Status.not_done_and_to_do,tasklist: tasklist1).save(failonError:true);
            def task2=new Task(taskName: "Just do it",date_of_last_work_through: new Date(),description: "follow ur dream" ,state: Task.Status.not_done_and_to_do,tasklist: tasklist1).save(failonError:true);
            def task3=new Task(taskName: "Just do it testlist2",date_of_last_work_through: new Date(),description: "follow ur dream" ,state: Task.Status.not_done_and_to_do,tasklist: tasklist2).save(failonError:true);
            def task4=new Task(taskName: "Just do testlist4",date_of_last_work_through: new Date(),description: "follow ur dream" ,state: Task.Status.not_done_and_to_do,tasklist: tasklist2).save(failonError:true);
        }





    }
    def destroy = {
    }
}
