class Solution {
      int count = 0;

    public int countSeniors(String[] details) {
        for (String detail : details) {
            int tens = Integer.parseInt(Character.toString(detail.charAt(11)));
            int ones = Integer.parseInt(Character.toString(detail.charAt(12)));
            int number = tens * 10 + ones;
        
            if (number > 60)
                count++;


        }
        return count;
    }
}