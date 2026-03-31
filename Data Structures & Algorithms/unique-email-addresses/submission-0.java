class Solution {
 public static int numUniqueEmails(String[] emails) {
        HashSet<String> localNamesSet = new HashSet<>();
        int count = 0;
        for (String email : emails) {
            String beforeAt = email.split("@")[0];
            String afterAt = email.split("@")[1];
            String withoutPlus = beforeAt.split("\\+")[0];
            String[] stringsWithoutDots = withoutPlus.split("\\.");
            StringBuilder sb = new StringBuilder();
            for (String stringWithoutDots : stringsWithoutDots) {
                sb.append(stringWithoutDots);

            }
            String processedEmail = sb + "@" + afterAt;
            if (!localNamesSet.contains(processedEmail)) {
                count++;
                localNamesSet.add(processedEmail);
            }
        }
        return count;
    }
}