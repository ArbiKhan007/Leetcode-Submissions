class Solution {
    List<String> res=new ArrayList<> ();
    public List<String> letterCombinations(String digits) {
        List<String> keypad=new ArrayList<> (Arrays.asList(
            "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        ));

        combinatBuilder(digits, 0, keypad, new StringBuilder());
        return res;
    }

    public void combinatBuilder(String digits, int idx, List<String> keypad, StringBuilder sb){
        if(idx>=digits.length()){
            if(sb.length()!=0) res.add(sb.toString());
            return;
        }

        int digit=digits.charAt(idx)-'0';
        for(int i=0;i<keypad.get(digit).length();i++){
            sb.append(keypad.get(digit).charAt(i));
            combinatBuilder(digits, idx+1, keypad, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}