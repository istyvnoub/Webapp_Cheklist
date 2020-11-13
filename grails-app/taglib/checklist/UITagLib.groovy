package checklist


class UITagLib {
   //    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    static namespace = "UIHelper"
    TasklistService tasklistservice

    def leftNavigation = { attrs, body ->
        List navigations = [
                [controller: "Tasklist", action: "index",name:"task.list"]

        ]

        navigations.each { menu->
            out << '<li class="list-group-item">'
            out<<g.link(controller:menu.controller,action: menu.action){
                g.message(code: menu.name ,arg :[''])
            }
            out << '</li>'
        }


    }
    def tasklist={ attrs, body ->
        String name = attrs.name ?: "tasklist"
        out << g.select(class:"form-control", multiple: "multiple", optionValue: "name", optionKey: "id", value: attrs.value, name: name, from: tasklistservice.getGroupList())
    }
}
