const solution = (s) => {
    
    const a = s.split("");
    
    const pFilter = a.filter((value) => (value === 'p' || value === 'P'));
    const yFilter = a.filter((value) => (value === 'y' || value === 'Y'));
    
    return pFilter.length === yFilter.length ? true : false

}