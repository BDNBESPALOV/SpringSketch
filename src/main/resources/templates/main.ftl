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


<div class="collapse <#if message??>show</#if>" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" action="add" enctype="multipart/form-data" >
            <div class="form-group">
                <input class="form-control ${(textError??)?string('is-invalid', '')}" type="text"
                       value="<#if message?? >${message.text} </#if>"
                       name="text" placeholder="Введите сообщение">
                <#if textError??>
                <div class="invalid-feedback">
                    ${textError}
                </div>
            </#if>
            </div>
            <div class="form-group">
                <input class="form-control" type="text" name="tag"
                       value="<#if message?? >${message.tag} </#if>"
                       placeholder="Тег">
                <#if tagError??>
                <div class="invalid-feedback">
                    ${tagError}
                </div>
            </#if>
            </div>
            <div class="custom-file">
                <input  type="file" name="file" id="customFile">
                <label class="custom-file-label" for="customFile" >Choose file(Выберите файл)</label>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit" class="btn btn-primary" > Добавить</button>

        </form>
    </div>


    <form method="post" action="delete">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="text" name="id" placeholder="id">
        <button type="submit" class="btn btn-primary" > Удалить</button>
    </form>
</div>



<div class="card-columns">
    <#list messages as message>
<div class="card my-3" >
    <b>${message.id}</b>
    <#if message.filename??>
    <img src="/img/${message.filename}" class="card-img-top">
    </#if>
    <div class="m-2">
        <span>${message.text}</span>
    </div>
    <i>${message.tag}</i>
    <div class="card-footer text-muted">
        ${message.authorName}
    </div>
</div>
    <#else>
    No message
    </#list>
</div>
</@c.page>