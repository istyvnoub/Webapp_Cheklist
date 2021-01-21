package checklist

class BootStrap {

    def init = { servletContext ->

        Tasklist.withNewTransaction { status->

            /*Task tasklist1= new Task(name:"test",date_of_last_work_through: new Date(),description:  "testlist",state: Task.Status.done_but_not_sucessful).save(failonErrr:true);
            Task tasklist2=new Task(name:"test2",date_of_last_work_through: new Date(),description:  "testlist2",state: Task.Status.done_but_not_sucessful).save(failonErr:true);


            def task1=new Task(taskName: "Just do it",date_of_last_work_through: new Date(),description: "follow ur dream" ,state: Task.Status.not_done_and_to_do,task: tasklist1).save(failonError:true);
            def task2=new Task(taskName: "Just do it",date_of_last_work_through: new Date(),description: "follow ur dream" ,state: Task.Status.not_done_and_to_do,task: tasklist1).save(failonError:true);
            def task3=new Task(taskName: "Just do it testlist2",date_of_last_work_through: new Date(),description: "follow ur dream" ,state: Task.Status.not_done_and_to_do,task: tasklist2).save(failonError:true);

           def task4=new Task(taskName: "Just do testlist4",date_of_last_work_through: new Date(),description: "follow ur dream" ,state: Task.Status.not_done_and_to_do,task: tasklist2).save(failonError:true);*/

            def task=new Task(taskName: "test2",date_of_last_work_through: new Date(),description:  "test",state: Task.Status.done_but_not_sucessful).save(failonErr:true);

            def subtask=new Task(taskName: "subtask1",date_of_last_work_throuh: new Date(),description: "follow ur dream" ,state: Task.Status.not_done_and_to_do).save(failonError:true);
            def subtask1=new Task(taskName: "subtask2",date_of_last_work_throuh: new Date(),description: "follow ur dream" ,state: Task.Status.not_done_and_to_do).save(failonError:true);
            def tasklist=new Tasklist(name:"listroot",dateOfLastWorkThrough: new Date(),description: "test",parent: task,tasks: [subtask,subtask1]).save(failonErr:true);

        }





    }
    def destroy = {
    }
}
