<meta name="layout" content="main"/>


<div class="card">
    <div class="card-header">
        <g:message code="task" args="['List']"/>

        %{--Actions--}%

    </div>
    <div class="card-body">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <g:sortableColumn property="date" title="${g.message(code: "date")}"/>
                <g:sortableColumn property="text" title="${g.message(code: "text")}"/>
                <g:sortableColumn property="status" title="${g.message(code: "status")}"/>
                <th class="action-row"><g:message code="action"/></th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${listtask}" var="info">
                <tr>
                    <td>${info?.date_of_last_work_through}</td>
                    <td>${info?.text}</td>
                    <td>${info?.state}</td>

                    %{--Table Actions --}%
                    <td>
                        <div class="btn-group">
                            <g:link controller="task" action="details" class="btn btn-secondary" id="${info.id}"><i class="fas fa-eye"></i></g:link>
                            <g:link controller="task" action="edit" class="btn btn-secondary" id="${info.id}"><i class="fas fa-edit"></i></g:link>
                            <g:link controller="task" action="delete" id="${info.id}" class="btn btn-secondary delete-confirmation"><i class="fas fa-trash"></i></g:link>
                        </div>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
        %{--Pagination Area--}%
        <div class="paginate">
            <g:paginate total="${total ?: 0}" />
        </div>
    </div>
</div>
