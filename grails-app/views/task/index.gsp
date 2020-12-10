<meta name="layout" content="main"/>


<div class="card">
    <div class="card-header">
        <g:message code="task" args="['List']"/>

        %{--Actions--}%
        <span class="float-right">

            <div class="btn-group">
                <g:form controller="task" action="index" method="GET">
                    <div class="input-group" id="search-area">
                        <g:select name="colName" class="form-control" from="[name:'Text']" value="${params?.colName}" optionKey="key" optionValue="value"/>
                        <g:textField name="colValue" class="form-control" value="${params?.colValue}"/>
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="submit">Search</button>
                        </span>
                    </div>
                </g:form>
            </div>

            <div class="btn-group">
                <g:link controller="task" action="create" class="btn btn-success"><g:message code="create"/></g:link>
                <g:link controller="task" action="index" class="btn btn-primary"><g:message code="reload"/></g:link>
            </div>
        </span>

    </div>
    <div class="card-body">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <g:sortableColumn property="date" title="${g.message(code: "date")}"/>
                <g:sortableColumn property="text" title="${g.message(code: "text")}"/>
                <g:sortableColumn property="description" title="${g.message(code: "description")}"/>
                <g:sortableColumn property="status" title="${g.message(code: "status")}"/>
                <th class="action-row"><g:message code="action"/></th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${listtask}" var="info">
                <tr>
                    <td>${info?.date_of_last_work_through}</td>
                    <td>${info?.taskName}</td>
                    <td>${info?.description}</td>
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
