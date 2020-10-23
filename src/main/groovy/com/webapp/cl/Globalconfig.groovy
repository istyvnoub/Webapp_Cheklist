package com.webapp.cl

class Globalconfig {

    public static final def USER_TYPE =[
            ADMINISTRATOR: "ADMINISTRATOR",
            REGULAR_MEMBER: "REGULAR_MEMBER",
    ]
    public static Integer itemsPerpage(){
        return 5
    }
    public static final def STATUS=[
            NOT_DONE:"NOT_DONE",
            IN_PROGRESS:"IN_PROGRESS",
            DONE:"DONE"
    ]
}
