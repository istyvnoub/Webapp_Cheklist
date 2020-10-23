package checklist




class MemberController {
    MemberService memberService

    def index(){
        def response=memberService.list(params)
        [response :response.list,total: response.count]  //this data will be paste in GSP
    }

    def details(Integer id){
        def response=memberService.getbyId(id)
        if(!response){
            redirect(controller: "member",action: "index")
        }else {
            [member:response]
        }
    }

    def create(){
        [member: flash.redirectParams]
    }
    def save() {
        def response = memberService.save(params)
        if (!response.isSuccess) {
            flash.redirectParams = response.model
            redirect(controller: "member", action: "create")
        } else {
            redirect(controller: "member", action: "index")
        }

    }
}
