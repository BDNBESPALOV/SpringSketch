<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>

<div>
<@l.logout />
</div>

<div id="container">
    <button class="learn-more">
        <div class="circle">
            <span class="icon arrow"></span>
        </div>
       <a href="http://localhost:8080"><p class="button-text">Home</p></a>
    </button>
</div>


<div>
    <form method="post" action="add">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="text" name="text" placeholder="Введите сообщение">
        <input type="text" name="tag" placeholder="Тег">
        <button type="submit"> Добавить</button>
    </form>

    <form method="post" action="delete">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="text" name="id" placeholder="id">
        <button type="submit"> Удалить</button>
    </form>
</div>

<div>Список сообщений </div>
<form method="post" action="filter">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <input type="text" name="filter">
    <button type="submit">Найти</button>
</form>
<#list messages as message>
    <div>
        <b>${message.id}</b>
        <span>${message.text}</span>
        <i>${message.tag}</i>
        <strong>${message.authorName}</strong>
    </div>
<#else>
No message
</#list>

<@c.page>