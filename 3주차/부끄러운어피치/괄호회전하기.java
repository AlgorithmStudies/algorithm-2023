import java.util.*;
class 괄호회전하기 {
    public int solution(String s) {
        int answer = 0;
        String str=s;
        //() [] {} 로 이루어진 괄호기호가 무작위로 배치
        //괄호 기호를 첫 입력과 똑같이 될때까지 한 문자씩 회전시킵니다
        for(int i=0;i<s.length();i++){
            char temp=str.charAt(0);
            //첫번째 문자를  맨 뒤로 보내기
            str=str.substring(1)+temp;
            if(isCorrect(str)){
                answer++;
            }
        }

        return answer;
    }
//회전시키는 도중 올바른 괄호문자열이 있으면 갯수 체크
    public boolean isCorrect (String str){
        Stack<Character> s = new Stack<>();

        char[] arr = str.toCharArray();

        for(char data:arr){
            if(s.isEmpty()){
                s.push(data);
            }
            // '(' 와 ')'  '['와 ']' 만나면 제거
            else if(s.peek()=='['&&data==']'){
                s.pop();
            }
            else if(s.peek()=='('&&data==')'){
                s.pop();
            }
            else if(s.peek()=='{'&&data=='}'){
                s.pop();
            }
            else{
                s.push(data);
            }
        }

        if(s.isEmpty()){
            return true;
        }

        return false;
    }


}

