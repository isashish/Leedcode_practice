class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> result = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        for(String op : operations){
            if(isInteger(op)){
                result.push(Integer.parseInt(op));
            }
            else if(op.equals("+")){
                int sum = 0;
                for(int i = 0; i < 2; i++){
                    if(!result.isEmpty()){
                        int x = result.pop();
                        temp.push(x);
                        sum += x;
                    }    
                }
                while(!temp.isEmpty()){
                    result.push(temp.pop());
                }
                result.push(sum);
            }
            else if(op.equals("D")){
                if(!result.isEmpty()){
                    int last = result.peek();
                    result.push(2*last);
                }
            }
            else if(op.equals("C")){
                if(!result.isEmpty()){
                    result.pop();
                }
            }
        }

        int scoreSum = 0;
        while(!result.isEmpty()){
            scoreSum += result.pop();
        }
        return scoreSum;
    }

    private boolean isInteger(String x){
        String regex = "-?\\d+";
        return x.matches(regex);
    }
}