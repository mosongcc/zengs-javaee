GraphQL-Java
=========================

```
query{
    users(id:1,name:"jmas"){
        id,
        name,
        blogs(date:20150515){
            title,
            content,
            comments(id:#id){
                id,
                userName,
                content,
            }
        },
        
    }
}

```



