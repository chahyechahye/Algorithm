const solution = (s) => {
    let a = s.split(' ').map(Number).sort((a,b) => a-b);
    return `${a[0]} ${a[a.length-1]}`
}