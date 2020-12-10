<%@ page import="checklist.Task" %>
<div class="form-group">
    <label><g:message code="taskName"/> *</label>
    <g:textField name="taskName" class="form-control" value="${task?.taskName}" placeholder="Please Enter your Name of your Task"/>

</div>
<div class="form-group">
    <label><g:message code="description"/> *</label>
    <g:textArea name="description" rows="5" cols="40" class="form-control" value="${task?.description}" placeholder="Please Enter Description of your Task"/>

</div>
<div class="form-group">
    <label><g:message code="status"/> *</label>
    <g:radioGroup name="status"    values="${checklist.Task.Status.values()}" labels="${[' not_done_and_to_do',
                                                                                                                     '        not_done_and_not_to_do',
                                                                                                                     '        done_but_not_sucessful',
                                                                                                                     '        done']}" >
        <span>${it.radio} - ${it.label} </span>
    </g:radioGroup>

</div>
%{--Partial Templating<div class="form-group">
    <label><g:message code="task.list.name"/></label>
    <UIHelper:tasklist value="${task?.tasklist*.id}"/>
</div>--}%