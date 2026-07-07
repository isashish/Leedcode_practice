class Solution {
    public long sumAndMultiply(int n) {
        if(n == 0){
            return 0;
        }
        else {
            String str = String.valueOf(n);

            char[] arr = str.toCharArray();

            StringBuilder result = new StringBuilder();
            long sum = 0;

            for(char s : arr){
                if(s != '0'){
                    result.append(s);
                    sum += s - '0';
                }
            }
            long num = Long.parseLong(result.toString());
            return num*sum;
        }
    }
}