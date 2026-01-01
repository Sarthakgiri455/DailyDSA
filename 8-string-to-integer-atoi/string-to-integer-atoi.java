class Solution {
    public int myAtoi(String s) {
        long maxVal = 0;
        long minVal = 0;
        int pointer = 0; 
        long residual = 0;
        Set<Character>allowedChars = new HashSet<>();
        allowedChars.add('0');
        allowedChars.add('1');
        allowedChars.add('2');
        allowedChars.add('3');
        allowedChars.add('4');
        allowedChars.add('5');
        allowedChars.add('6');
        allowedChars.add('7');
        allowedChars.add('8');
        allowedChars.add('9');
        
        if(s.length() == 0) {
            return 0;
        }
        while(pointer < s.length() && s.charAt(pointer) == ' '){
            pointer = pointer + 1;
        }
        if(pointer >= s.length()) {
            return 0;
        }
        char sign = s.charAt(pointer) == '-' ? '-': '+';
        if(sign == '+') {
            maxVal = (1<<31) - 1;
        }
        else{
            minVal = -(1<<31);
        }
        if(s.charAt(pointer) == '-' || s.charAt(pointer) == '+') {
            pointer = pointer+1;
        } 
        while(pointer < s.length() && s.charAt(pointer) == '0') {
            pointer = pointer+1;
        }
        System.out.println("Current pointer is " + pointer);
        while(pointer < s.length()) {
            if(!allowedChars.contains(s.charAt(pointer))) {
                break;
            }
            else{
                long temp = (residual) * 10 + (int)s.charAt(pointer) - 48;
                System.out.println("Temp is " + temp);
                
                long temporary = (sign == '-') ? (-1*temp) : (temp);
                if(temporary < minVal) {
                    return (int)minVal;
                }
                if(temporary > maxVal) {
                    return (int)maxVal;
                }
                else{
                    residual = temp;
                }
            }
            System.out.println("residual " + residual);

            pointer = pointer + 1;
        }
        System.out.println("Sign is " + sign);
        return (sign == '+')? ((residual > maxVal) ? (int)maxVal : (int)residual) : ((-1 * residual) < minVal) ? (int)minVal : -1 * (int)residual;
    }
}