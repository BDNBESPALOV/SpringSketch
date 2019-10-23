<#import "parts/common.ftl" as c>
<@c.page>
User editor
<form action="/user" method="post">
    <input type="text" value="${user.username}" name="userName">
    <#list roles as role>
    <div>
       <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked","")}>${role}</label>
    </div>
    <#list>
    <input type="text" value="${user.id}" name="userID">
    <input type="text" value="${_csrf.token}" name="_csfr">
    <button type="submit">Save</button>
</form>
</@c.page>