<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message code="task.list" args="['List Of']"/>
        <span class="float-right">
            <div class="btn-group">
                <g:link controller="tasklist" action="create" class="btn btn-success"><g:message code="create"/></g:link>
                <g:link controller="tasklist" action="index" class="btn btn-primary"><g:message code="reload"/></g:link>
            </div>
        </span>
    </div>
    <div class="card-body">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <g:sortableColumn property="name" title="${g.message(code: "name")}"/>
                <g:sortableColumn property="description" title="${g.message(code: "task.list.description")}"/>
                <th class="action-row"><g:message code="action"/></th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${grouptask}" var="group">
                <tr>
                 <td><g:link controller="task" action="index"> ${group?.name} </g:link></td>
                    <td>${group?.description}</td>
                    <td>
                        <div class="btn-group">
                            <g:link controller="tasklist" action="details" class="btn btn-secondary" id="${group.id}"><i class="fas fa-eye"></i></g:link>
                            <g:link controller="tasklist" action="edit" class="btn btn-secondary" id="${group.id}"><i class="fas fa-edit"></i></g:link>
                            <g:link controller="tasklist" action="delete" id="${group.id}" class="btn btn-secondary delete-confirmation"><i class="fas fa-trash"></i></g:link>
                        </div>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
        <div class="paginate">
            <g:paginate total="${total ?: 0}" />
        </div>
    </div>
</div>