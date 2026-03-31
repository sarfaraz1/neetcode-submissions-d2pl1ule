class Solution {
       public int lengthOfLastWord(String s) {
        String[] stringList = s.split("\s");
        int i = stringList.length - 1;
        for (; i >= 0; i--) {
            if (stringList[i] != "")
                break;

        }
        return stringList[i].length();

    }
}