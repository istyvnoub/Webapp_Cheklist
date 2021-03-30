package checklist




class MemberController {
    MemberService memberService
/**
 *this method will be collected and pasted into the gsp
 * @return list of member and number of existing response
 */
    def index(){
        def response=memberService.list(params)
        [response :response.list,total: response.count]  //this data will be paste in GSP
    }
/**
 * retrieve a member using their id
 * @param id
 * @return if its dont exist redirect to controller member
 */
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
    /**
     * Redirect to member->action when member has been saved or to member->create when not
     * @return
     */
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
