function solution(s, skip, index) {
    var answer = '';
    for (let i = 0; i < s.length; i++){
        let count = 0;
        let start = s.charCodeAt(i)+1;
        while(count < index){
            if(start > 122){
                start = 97;
                }
            if(skip.includes(String.fromCharCode(start))){
                start+=1;
                continue;
            }
            start += 1;
            count += 1;
            
        }
        answer += String.fromCharCode(start-1);
            
    }
    return answer;
}