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

REQ:
{
    "appid":"2323",
    "sig":"123123ewerwefwfwefwef",
    "biz":{
        "users":[{
            params:{ k :v,k1:v1},
            filed:"uid,name,age,blogs",
            blogs:{
                params:{ id :#uid,k1:v1},
                filed:"id,title,content,commons",
                commons:""
            }
        }]
    }
}
{
    "appid":"2323",
    "sig":"123123ewerwefwfwefwef",
    "biz":{
        "users":[{
            "params":{ "k":"v"},
            "filed":"uid,name,age,blogs"
        }]
    }
}


RES:
{
    "appid":"2323",
    "sig":"asdfasfasdfasfasdfasdf",
    "errno":0,
    "error":"ok"
    "data":{
        "users":{
            uid:""
            name:"",
            age:""
            blogs:{
            
            }
        },
        blogs:{
        
        }
    
    }
    
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