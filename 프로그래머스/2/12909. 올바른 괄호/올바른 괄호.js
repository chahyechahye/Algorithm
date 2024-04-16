const solution = (s) => {
    
    let cnt = 0;
    
    for(let i = 0; i<s.length; i++) {
        if(s[i] === '(') {
            cnt++;
        } else {
            cnt--;
        }
        if(cnt === -1) {
            return false;
        }
    }
    
    return cnt === 0 ?  true:false;
}