const fileInput = document.getElementById("banner")
const bannerPreview = document.querySelector('.banner-preview')

fileInput.addEventListener('change',onFileChange);

function onFileChange(event) {
    const files = event.target.files;
    if(files.length > 0){
        const file  = event.target.files[0]
        const url = URL.createObjectURL(file);
        
        bannerPreview.innerHTML = `<img src = "${url}">`;
} else {
    event.preventDefault()
}
}