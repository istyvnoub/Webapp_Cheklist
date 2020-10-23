<meta name="layout" content="main"/>


<div class="card">
    <div class="card-header">
        <g:message code="member" args="['List']"/>

        %{--Actions--}%

     </div>
<div class="card-body">
    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <g:sortableColumn property="firstName" title="${g.message(code: "first.name")}"/>
            <g:sortableColumn property="lastName" title="${g.message(code: "last.name")}"/>
            <g:sortableColumn property="email" title="${g.message(code: "email")}"/>
            <th class="action-row"><g:message code="action"/></th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${memberList}" var="info">
            <tr>
                <td>${info?.firstName}</td>
                <td>${info?.lastName}</td>
                <td>${info?.email}</td>

                %{--Table Actions --}%
                <td>
                    <div class="btn-group">
                        <g:link controller="member" action="details" class="btn btn-secondary" id="${info.id}"><i class="fas fa-eye"></i></g:link>
                        <g:link controller="member" action="edit" class="btn btn-secondary" id="${info.id}"><i class="fas fa-edit"></i></g:link>
                        <g:link controller="member" action="delete" id="${info.id}" class="btn btn-secondary delete-confirmation"><i class="fas fa-trash"></i></g:link>
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
