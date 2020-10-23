package checklist

import com.webapp.cl.Globalconfig

class BootStrap {

    def init = { servletContext ->


        new Task(text: "Just do it",date: new Date(),status: Globalconfig.STATUS.NOT_DONE).save()

    }
    def destroy = {
    }
}
