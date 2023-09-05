public class Solution {
    public String solution(String new_id) {
        String answer = "";

        // 1.case
        new_id = new_id.toLowerCase();

        // 2. 알파벳, 숫자, -, _, ' 인 것들만 모으기
        for(int i = 0; i < new_id.length(); i++){
            char ch = new_id.charAt(i);
            if (Character.isAlphabetic(ch) || Character.isDigit(ch) ||
                    ch == '-' || ch == '_' || ch == '.') {
                answer = answer + ch;
            }
        }

        // 3. 연속된 ..를 .로 반환
        while (answer.indexOf("..") != -1) {
            answer = answer.replace("..", ".");
        }

        // 4. 처음과 끝에 .이 있으면 제거 (Startswith도 써보자)
        if (!answer.isEmpty() && answer.charAt(0) == '.') {
            answer = answer.substring(1);
        }
        if (!answer.isEmpty() && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }

        // 5. 빈 문자열이면 a를 대입
        if (answer.isEmpty()) {
            answer = answer + "a";
        }

        //6-1. 16개 이상이면 15개로 줄임
        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
            //6-2. 마지막이 '.'로 끝나면, '.' 제거
            if (answer.charAt(answer.length() - 1) == '.') {
                answer = answer.substring(0, 14); //14 대신 length() - 1
            }
        }

        // 7. 문자열 길이가 2 이하이면 마지막 문자를 3이 될 때까지 붙이기
        while (answer.length() < 3) {
            answer = answer + answer.charAt(answer.length() - 1);
        }

        return answer;
    }


    public static void main(String args[]) {
        Solution sol = new Solution();
        System.out.println(sol.solution("...!@BaT#*..y.abcdefghijklm)"));
    }
}