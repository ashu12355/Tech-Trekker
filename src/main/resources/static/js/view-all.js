function onPageChange(currentPage , operator) {
    const pageNum = operator == '+' ? currentPage + 1 : currentPage - 1;
    const url = location.href  

if(url.includes('pageNum')){
    url = url.replace(`pageNum=${currentPage}`,`pageNum=${pageNum}`);
} else {
    url += '&pageNum=' +pageNum;
}
location.href = url
}