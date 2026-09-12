package week5.assignment_problems;

public class LibraryMemberBean {
    private String membershipId;
    private boolean membershipIdSet;
    private String name;
    private boolean premiumMember;
    private String securityAnswerHash;

    public LibraryMemberBean() {}

    public String getMembershipId() { return membershipId; }

    public void setMembershipId(String id) {
        if (!membershipIdSet) {
            this.membershipId = id;
            this.membershipIdSet = true;
        }
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isPremiumMember() { return premiumMember; }
    public void setPremiumMember(boolean premium) { this.premiumMember = premium; }

    public void setSecurityAnswer(String answer) {
        this.securityAnswerHash = String.valueOf(answer.hashCode()); // one-way, no getter anywhere
    }

    public static void main(String[] args) {
        LibraryMemberBean m = new LibraryMemberBean();
        m.setMembershipId("LIB-8841");
        m.setName("Priya Nair");
        m.setPremiumMember(true);
        System.out.println(m.getMembershipId()); // LIB-8841

        m.setMembershipId("FAKE-0000"); // ignored
        System.out.println(m.getMembershipId()); // LIB-8841
        System.out.println(m.isPremiumMember()); // true

        m.setSecurityAnswer("BlueMountain"); // no observable output
    }
}