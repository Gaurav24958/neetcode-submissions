class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack<>();
        Stack<Character> tt = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char current = s.charAt(i);

            if(st.isEmpty() && current != '#'){
                st.push(current);
            }else{
                if(current == '#'){
                    if(!st.isEmpty()){
                        st.pop();
                    }else{
                        continue;
                    }
                }else{
                    st.push(current);
                }
            }
        }

        for(int i = 0;i<t.length();i++){
            char current = t.charAt(i);

            if(tt.isEmpty() && current != '#'){
                tt.push(current);
            }else{
                if(current == '#'){
                    if(!tt.isEmpty()){
                        tt.pop();
                    }else{
                        continue;
                    }
                }else{
                    tt.push(current);
                }
            }
        }

        if(st.size() != tt.size()){
            return false;
        }else{
    
            while(!st.isEmpty()){
                if(!st.pop().equals(tt.pop())){
                    return false;
                }
            }
        }

        return true;




    }
}