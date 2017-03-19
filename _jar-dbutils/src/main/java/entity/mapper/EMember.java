package entity.mapper;

/**
 *
 */
public enum EMember {

    tableName("Member","ZE_MEMBER","","会员表"),

    id("id","ID","NUMBER","id"),
    name("name","MEMBER_NAME","CHAR","会员名称"),
    age("age","AGE","","年龄");


    public static String s(int i){
        return "";
    }

    private String attribute;
    private String column;
    private String type;
    private String description;

    EMember(String attribute, String column,String type,String description){
        this.attribute = attribute;
        this.column = column;
        this.type = type;
        this.description = description;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
