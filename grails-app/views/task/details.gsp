%{--Include Main Layout--}%
<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message code="task" args="['Details']"/>
    </div>
    <div class="card-body">
        <g:if test="${task}">
            <table class="table">
                <tr>
                    <th class="text-right"><g:message code="task.list.name"/></th><td class="text-left">${task.parent}</td>
                </tr>
                <tr>
                    <th class="text-right"><g:message code="taskName"/></th><td class="text-left">${task.taskName}</td>
                </tr>
                <tr>
                    <th class="text-right"><g:message code="description"/></th><td class="text-left">${task.description}</td>
                </tr>
                <tr>
                    <th class="text-right"><g:message code="status"/></th><td class="text-left">${task.state}</td>
                </tr>
                <tr>
                    <th class="text-right"><g:message code="date"/></th><td class="text-left">${task.date_of_last_work_through}</td>
                </tr>
            </table>
        </g:if>
        <div class="form-action-panel">
            <g:link controller="task" action="index" class="btn btn-primary"><g:message code="cancel"/></g:link>
        </div>
    </div>
</div>