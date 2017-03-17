package zengs.main.entity.mapper;

public enum Member {

    name("name","MEMBER_NAME","会员名称"),
    age("age","AGE","年龄");



    private String attribute;
    private String column;
    private String description;

    Member(String attribute, String column, String description){
        this.attribute = attribute;
        this.column = column;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
