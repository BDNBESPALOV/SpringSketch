<#import "parts/common.ftl" as c>
<@c.page>
List of users
<button type="submit"> <a href="/main">Main</a> </button>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Role</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list users as user >
    <tr>
        <td>${user.username}</td>
        <td><#list user.roles as role>${role} <#sep>, </#list></td>
        <td><a href="/user/${user.id}">edit</a> </td>
    </tr>
    </#list>
    </tbody>
</table>
</@c.page>