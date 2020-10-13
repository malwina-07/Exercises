package Zadanie05;

public class Customer {
    private String name;
    private boolean member;
    protected MemberType type;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isMember() {
        return this.member = true;
    }
    public void setTypeOfMember(MemberType type) throws NoMemberSelectedException {
        if(!member) {
            throw new NoMemberSelectedException("\nConnot select a type of member. The Customer is not a member!");
        } else {
            this.type = type;
        }
    }

    public MemberType getType() {
        return type;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public String toString() {
        return String.format("Customer: name= %s, is member = %b, type of member = %s", name, member, type);
    }

}
