<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message code="task.list" args="['Details']"/>
    </div>
    <div class="card-body">
        <g:if test="${grouptask}">
            <table class="table">
                <tr>
                    <th class="text-right">Name</th><td class="text-left">${grouptask.taskName}</td>
                    <th class="text-right">Description</th><td class="text-left">${grouptask.description}</td>
                </tr>
            </table>
        </g:if>
        <div class="form-action-panel">
            <g:link controller="tasklist" action="index" class="btn btn-primary"><g:message code="cancel"/></g:link>
        </div>
    </div>
</div>