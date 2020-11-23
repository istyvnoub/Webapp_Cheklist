<div class="form-group">
    <label><g:message code="taskName"/> *</label>
    <g:textField name="taskName" class="form-control" value="${task?.taskName}" placeholder="Please Enter your Name of your Task"/>

</div>
<div class="form-group">
    <label><g:message code="description"/> *</label>
    <g:textArea name="description" rows="5" cols="40" class="form-control" value="${task?.description}" placeholder="Please Enter Description of your Task"/>

</div>
%{--Partial Templating<div class="form-group">
    <label><g:message code="task.list.name"/></label>
    <UIHelper:tasklist value="${task?.tasklist*.id}"/>
</div>--}%