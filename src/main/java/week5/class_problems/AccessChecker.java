package week5.class_problems;

public class AccessChecker {
    static String classifyAccess(String fieldModifier, String accessorContext) {
        switch (fieldModifier) {
            case "public":
                return "ALLOWED";
            case "protected":
                if (accessorContext.equals("SAME_CLASS")
                        || accessorContext.equals("SAME_PACKAGE")
                        || accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {
                    return "ALLOWED";
                }
                return "DENIED"; // includes SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE
            case "default":
                if (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) {
                    return "ALLOWED";
                }
                return "DENIED";
            case "private":
                if (accessorContext.equals("SAME_CLASS")) {
                    return "ALLOWED";
                }
                return "DENIED";
            default:
                throw new IllegalArgumentException("Unknown fieldModifier: " + fieldModifier);
        }
    }

    static String summarizeBatch(String[][] attempts) {
        int allowedCount = 0, deniedCount = 0;
        for (String[] attempt : attempts) {
            if (classifyAccess(attempt[0], attempt[1]).equals("ALLOWED")) allowedCount++;
            else deniedCount++;
        }
        return "Allowed: " + allowedCount + " | Denied: " + deniedCount;
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));
        String[][] batch = {
                {"default", "SAME_PACKAGE"},
                {"default", "DIFFERENT_PACKAGE"},
                {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(summarizeBatch(batch));
        System.out.println(classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
        System.out.println(classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
    }
}