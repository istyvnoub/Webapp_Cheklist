package com.webapp.cl

class AppUtil {
    static saveResponse(Boolean isSuccess,def model){
        return [isSuccess: isSuccess, model: model ]
    }

}
