<div class="form-group">
    <label><g:message code="text"/> *</label>
    <g:textField name="text" class="form-control" value="${task?.taskName}" placeholder="Please Enter your Name of your Task"/>

</div>
<div class="form-group">
    <label><g:message code="description"/> *</label>
    <g:textArea name="description" rows="5" cols="40" class="form-control" value="${task?.description}" placeholder="Please Enter Description of your Task"/>

</div>
