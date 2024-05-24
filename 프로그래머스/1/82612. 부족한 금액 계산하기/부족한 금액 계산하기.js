function solution(price, money, count) {
    
    let cnt = 0;
    for(let i = 1; i<=count; i++) {
        cnt+=i;
    }
    
    return money - cnt*price > 0 ? 0 : Math.abs(money - cnt*price);
}