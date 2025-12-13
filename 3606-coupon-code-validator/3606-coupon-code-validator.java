class Solution {
    public boolean isValid(String s){
        if(s == null || s.isEmpty()) return false;

        for (char c : s.toCharArray()){
            if(!Character.isLetterOrDigit(c) && c != '_'){
                return false;
            }
        }
        return true;
    }

    public boolean check(String str){
        return str.equals("electronics") || str.equals("grocery") || str.equals("pharmacy") || str.equals("restaurant");
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String[]> list = new ArrayList<>();

        for(int i = 0; i < code.length; i++) {
            if(isActive[i] && isValid(code[i]) && check(businessLine[i])) { list.add(new String[] { businessLine[i], code[i] });
            }
        }

        Collections.sort(list, (a, b) -> {
            int compare = a[0].compareTo(b[0]);
            if (compare != 0) return compare;
            return a[1].compareTo(b[1]);
        });

        List<String> result = new ArrayList<>();
        for (String[] pair : list)
            result.add(pair[1]);


        return result;
        
        
    }
}