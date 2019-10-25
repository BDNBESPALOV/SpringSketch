<#import "parts/common.ftl" as c>
<@c.page>
<div class="form-row">
    <div class="form-group col-md-6" >
    <form method="get" action="/main" class="form-inline">
        <input class="form-control" type="text" name="filter" value= "${filter?ifExists}" placeholder="Текст для поиска">
        <button type="submit" class="btn btn-primary ml-2" >Найти</button>
    </form>
    </div>
</div>
<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Добавить новое сообщение
</a>


<div class="collapse" id="collapseExample">
    <div class="form-group">
        <form method="post" action="add" enctype="multipart/form-data" class="form-inline">
            <input class="form-control" type="text" name="text" placeholder="Введите сообщение">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <input class="form-control" type="text" name="tag" placeholder="Тег">
            <div class="custom-file">
            <input class="custom-file-label" type="file" name="file" >
            <button type="submit" class="btn btn-primary" > Добавить</button>
            </div>
        </form>
    </div>


    <form method="post" action="delete">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="text" name="id" placeholder="id">
        <button type="submit" class="btn btn-primary" > Удалить</button>
    </form>
</div>


<#list messages as message>
    <div>
        <b>${message.id}</b>
        <span>${message.text}</span>
        <i>${message.tag}</i>
        <strong>${message.authorName}</strong>
        <div>
            <#if message.filename??>
            <img src="/img/${message.filename}">
        </#if>
        </div>
    </div>
<#else>
No message
</#list>
</@c.page>