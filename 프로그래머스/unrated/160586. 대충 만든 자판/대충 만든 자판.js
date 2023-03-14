function solution(keymap, targets) {
    var answer = [];
    let alpha = [];
    
    for (i = 0; i < 26; i++){
        alpha.push(1000);
    }
    for (i = 0; i < keymap.length; i++){
        for (j = 0; j < keymap[i].length; j++){
            if(alpha[keymap[i].charCodeAt(j)-65] > j+1){
                alpha[keymap[i].charCodeAt(j)-65] = j+1;
            }
        }
    }
    for (i = 0; i < targets.length; i++){
        let tempAnswer = 0;
        for (j = 0; j < targets[i].length; j++){
            if(alpha[targets[i].charCodeAt(j)-65] == 1000){
                tempAnswer = -1;
                break
            }
            else{
                tempAnswer = tempAnswer + alpha[targets[i].charCodeAt(j)-65];    
            }            
        }
        answer.push(tempAnswer)
    }
    return answer;
}