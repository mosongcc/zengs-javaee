GraphQL-Java
========================

```
Query{
    operation(id:3,name:"hh"){
        id,
        name,
        age
    },
    

}

users:{
    params:{ k :v,k1:v1},
    filed:"uid,name,age,blogs",
    blogs:{
        params:{ id :#uid,k1:v1},
        filed:"id,title,content,commons",
        commons:""
    }
}


```