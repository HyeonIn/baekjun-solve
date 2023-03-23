function solution(cap, n, deliveries, pickups) {
    var answer = 0;
    let total_d = 0;
    let total_p = 0;
    let end_d = n-1;
    let end_p = n-1;
    for(let i = 0; i < n; i++){
        if (deliveries[i] != 0){
            end_d = i;
            total_d += deliveries[i];
        }  
    }
    
    for(let i = 0; i < n; i++){
        if (pickups[i] != 0){
            end_p = i;
            total_p += pickups[i];
        }  
    }
    while(total_d > 0 || total_p > 0){
        answer += end_d > end_p ? (end_d+1)*2 : (end_p+1)*2;
        let idx_d = end_d;
        let cap_d;
        if(total_d < cap){
            cap_d = total_d;
            total_d = 0;
        }
        else{
            cap_d = cap;
            total_d -= cap;
        }
        while(cap_d >= 0 && idx_d >= 0){
                if (cap_d >= deliveries[idx_d]){
                    cap_d -= deliveries[idx_d];
                    deliveries[idx_d] = 0;
                    idx_d--;
                }
                else{
                    deliveries[idx_d] -= cap_d;
                    cap_d = 0;
                    break;
                }
            
        }
        end_d = idx_d;
        
        let idx_p = end_p;
        let cap_p = cap;
        total_p -= cap;
        while(cap_p >= 0 && idx_p >= 0){
                if (cap_p >= pickups[idx_p]){
                    cap_p -= pickups[idx_p];
                    pickups[idx_p] = 0;
                    idx_p--;
                }
                else{
                    pickups[idx_p] -= cap_p;
                    cap_p = 0;
                    break;  
                }
        }
        end_p = idx_p;
    }    
    
    return answer;
}