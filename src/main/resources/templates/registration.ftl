<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
        Add new user
<!--<#if message??>-->
<!--${message}-->
<!--</#if>-->
${message?ifExists}
<@l.login "/registration" />
        </@c.page>