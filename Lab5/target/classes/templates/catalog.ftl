<!DOCTYPE>
<html>
    <body>
       <h1>
           Catalog ${name} contents

</h1>
    <#list items as item>
        ${item.name}
        ${item.id}
        ${item.location}
    </#list>
</body>
</html>